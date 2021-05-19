package com.bsoft.project.manager.impl;

import com.bsoft.common.annotation.ManyTransaction;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.key.WordKeyGenerator;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.DateUtils;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.common.utils.WaterMarkUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.project.condition.ProjectStandardWordQueryCnd;
import com.bsoft.project.condition.ProjectWordCountViewQueryCnd;
import com.bsoft.project.dao.primary.*;
import com.bsoft.project.dto.ProjectWordBaseUploadDTO;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.entity.second.ProjectWordDetailDO;
import com.bsoft.project.manager.ProjectWordManager;
import com.bsoft.project.repository.primary.ProjectWordRepository;
import com.bsoft.project.repository.second.ProjectWordDetailRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*
 * @author  hy
 * @date  2020/3/23 15:24
 * @description
 */
@Component
public class ProjectWordManagerImpl implements ProjectWordManager {

    @Autowired
    private ProjectWordViewDao projectWordViewDao;
    @Autowired
    private ProjectWordDetailDao projectWordDetailDao;
    @Autowired
    private ProjectWordDetailViewDao projectWordDetailViewDao;
    @Autowired
    private ReferenceDocumentDao referenceDocumentDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private WordKeyGenerator wordKeyGenerator;
    @Autowired
    private ProjectWordDetailRepository projectWordDetailRepository;
    @Autowired
    private ProjectStandardWordDao projectStandardWordDao;
    @Autowired
    private ProjectWordRepository projectWordRepository;
    @Autowired
    private ProjectDutyMilepostDao projectDutyMilepostDao;
    @Autowired
    private ProjectWordInfoDao projectWordInfoDao;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectWordCountViewDao projectWordCountViewDao;
    @Autowired
    private ContractWordViewDao contractWordViewDao;
    @Autowired
    private ContractWordDetailViewDao contractWordDetailViewDao;

    @Override
    public Page<ProjectWordViewDO> getProjectWordViewList(Integer page, Integer size, String contractNo, String projectId,Integer stage) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ProjectWordViewDO> projectPage = projectWordViewDao.findAll(new Specification<ProjectWordViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectWordViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("htbh"),contractNo));
                predicates.add(criteriaBuilder.equal(root.get("stage"),stage));
                predicates.add(criteriaBuilder.notEqual(root.get("submitRole"),1));
                Predicate c1 = criteriaBuilder.equal(root.get("projectId"),projectId);
                Predicate c2 = criteriaBuilder.isNull(root.get("projectId"));
                predicates.add(criteriaBuilder.or(c1,c2));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return projectPage;
    }

    @Override
    public Page<ProjectWordRecordViewDO> getProjectWordDetails(Integer page, Integer size, Integer id, Integer milepostId) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ProjectWordRecordViewDO> projectPage = projectWordDetailViewDao.findAll(new Specification<ProjectWordRecordViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectWordRecordViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Predicate c1 = criteriaBuilder.equal(root.get("fileKey"),id);
                Predicate c2 = criteriaBuilder.equal(root.get("milepostId"),milepostId);
                predicates.add(criteriaBuilder.and(c1,c2));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return projectPage;
    }

    @Override
    @ManyTransaction(value = {"transactionManagerPrimary","secondTransactionMangerMybatis"})
    public void deleteProjectWord(Integer id,String wordAge,Integer detailId) {
        projectWordDetailDao.deleteById(id);
        projectWordDetailRepository.deleteDetailById("WD_WDMX_"+wordAge,detailId);
    }

    @Override
    public Page<ProjectStandardWordDO> getProjectStandardWordList(ProjectStandardWordQueryCnd cnds) {
        Pageable pageable = PageRequest.of(cnds.getPageNo(),cnds.getPageSize());
        Page<ProjectStandardWordDO> projectPage = projectStandardWordDao.findAll(new Specification<ProjectStandardWordDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectStandardWordDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("logoff"),0));
                if (cnds.getStage() != null){
                    Predicate c1 = criteriaBuilder.equal(root.get("stage"),cnds.getStage());
                    Predicate c2 = criteriaBuilder.isNull(root.get("stage"));
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return projectPage;
    }

    @Override
    public ReferenceDocumentDO getReferenceDocument(Integer id) {
        Optional<ReferenceDocumentDO> optional = referenceDocumentDao.findById(id);
        return optional.orElseThrow(()->new ServiceException("无该模板文档"));
    }

    @Override
    public ProjectWordDetailDO findById(String wordAge, Integer id) {
        String tableName = "WD_WDMX_"+wordAge;
        ProjectWordDetailDO dbDetailDO = projectWordDetailRepository.selectDetailById(id,tableName);
        return dbDetailDO;
    }

    @Override
    @ManyTransaction(value = {"transactionManagerSecondary","transactionManagerPrimary","secondTransactionMangerMybatis"})
    public void saveOrUpdateWord(ProjectWordBaseUploadDTO uploadDTO, String wordAge) {
        ProjectWordRecordDO recordDO = new ProjectWordRecordDO();
        ProjectWordDetailDO detailDO = new ProjectWordDetailDO();
        Date now = serverDateManager.getServerDateTime();
        String op = "";
        if(uploadDTO.getId() == null){
            Integer detailId = wordKeyGenerator.increaseDbFileId(wordAge);
            recordDO.setDetailId(detailId);
            detailDO.setId(detailId);
            Integer id = keyGenerator.increaseFileDetail();
            recordDO.setId(id);
            op = "create";
        }else{
            recordDO.setDetailId(uploadDTO.getDetailId());
            detailDO.setId(uploadDTO.getDetailId());
            recordDO.setId(uploadDTO.getId());
            op = "update";
        }
        double fileSize = uploadDTO.getFileBytes().length / 1048576.00;
        recordDO.setFileKey(uploadDTO.getFileKey());
        recordDO.setSubmitter(uploadDTO.getUserId());
        recordDO.setFileSize(fileSize);
        recordDO.setSubmitDate(now);
        recordDO.setFileName(uploadDTO.getOriginalFilename());
        recordDO.setDeptFlag(0);
        recordDO.setRegionFlag(0);
        recordDO.setLeaderFlag(0);
        recordDO.setMilepostId(uploadDTO.getMilepostId());
        projectWordDetailDao.save(recordDO);
        detailDO.setFileKey(uploadDTO.getFileKey());
        detailDO.setFileName(uploadDTO.getOriginalFilename());
        detailDO.setFileSize(fileSize);
        detailDO.setSubmitter(uploadDTO.getUserId());
        detailDO.setSubmitDate(now);
        detailDO.setFile(uploadDTO.getFileBytes());
        detailDO.setFileStatus(0);
        detailDO.setMilepostId(uploadDTO.getMilepostId());
        if ("create".equals(op)) {
            projectWordDetailRepository.saveDetail(detailDO, "WD_WDMX_"+wordAge);
        } else {
            projectWordDetailRepository.updateDetail(detailDO, "WD_WDMX_"+wordAge);
        }
    }

    @ManyTransaction(value = {"transactionManagerPrimary","primaryTransactionMangerMybatis"})
    private void saveDocumentDetail(String contractNo,String projectId){
        List<ReferenceDocumentDO> rList = referenceDocumentDao.findAllBySubmitRole(2);
        List<ProjectWordInfoDO> pList = projectWordInfoDao.findAllByContractIdAndProjectId(contractNo,projectId);
        if(rList.size() > pList.size()){
            List<Integer> all = rList.stream().map(ReferenceDocumentDO::getId).collect(toList());
            List<Integer> part = pList.stream().map(ProjectWordInfoDO::getDocumentId).collect(toList());
            all.removeAll(part);
            for (Integer documentId : all) {
                ProjectWordInfoDO projectWordInfoDO = new ProjectWordInfoDO();
                projectWordInfoDO.setId(keyGenerator.increaseWordInfo());
                projectWordInfoDO.setContractId(contractNo);
                projectWordInfoDO.setDocumentId(documentId);
                projectWordInfoDO.setDocumentCount(0);
                projectWordInfoDO.setProjectId(projectId);
                projectWordInfoDao.save(projectWordInfoDO);
            }
        }
    }

    @ManyTransaction(value = {"transactionManagerPrimary","primaryTransactionMangerMybatis"})
    private void saveDocumentDetail(String contractId){
        List<ReferenceDocumentDO> rList = referenceDocumentDao.findAll();
        List<ProjectDO> projectDOList = projectDao.findByContractId(contractId);
        List<String> projectIdList = projectDOList.stream().map(ProjectDO::getProjectId).distinct().collect(toList());
        projectIdList.forEach(projectId -> {
            List<ProjectWordInfoDO> pList = projectWordInfoDao.findAllByContractIdAndProjectId(contractId, projectId);
            if(rList.size() > pList.size()){
                List<Integer> all = rList.stream().map(ReferenceDocumentDO::getId).collect(toList());
                List<Integer> part = pList.stream().map(ProjectWordInfoDO::getDocumentId).collect(toList());
                all.removeAll(part);
                for (Integer documentId : all) {
                    ProjectWordInfoDO projectWordInfoDO = new ProjectWordInfoDO();
                    projectWordInfoDO.setId(keyGenerator.increaseWordInfo());
                    projectWordInfoDO.setContractId(contractId);
                    projectWordInfoDO.setDocumentId(documentId);
                    projectWordInfoDO.setDocumentCount(0);
                    projectWordInfoDO.setProjectId(projectId);
                    projectWordInfoDao.save(projectWordInfoDO);
                }
            }
        });

    }

    @Override
    public List<Map<String,Object>> getDocumentDisplayList(String contractNo,String projectId) {
        saveDocumentDetail(contractNo,projectId);
        List<StageDocumentDO> stageDocuments = projectWordRepository.selectStageDocuments(contractNo,projectId);
        System.out.println("文档信息表："+stageDocuments.size());
        Date now = serverDateManager.getServerDateTime();
        int year = DateUtils.dateToLocalDate(now).getYear();
        List<ProjectDutyMilepostDO> milepostList = projectDutyMilepostDao.getDutyMilepostWithPlan(contractNo,year);
        return initDocumentDisplayList(stageDocuments,milepostList);
    }

    @Override
    @Transactional
    public List<Map<String,Object>> getDocumentDisplayListWithPlan(String contractNo,String projectId,Integer milepostId) {
        saveDocumentDetail(contractNo,projectId);
        List<StageDocumentDO> stageDocuments = projectWordRepository.selectStageDocuments(contractNo,projectId);
        List<ProjectDutyMilepostDO> milepostList = new ArrayList<>();
        ProjectDutyMilepostDO  dutyMilepostDO = projectDutyMilepostDao.getOne(milepostId);
        milepostList.add(dutyMilepostDO);
        return initDocumentDisplayList(stageDocuments,milepostList);
    }

    private List<Map<String,Object>> initDocumentDisplayList(List<StageDocumentDO> stageDocuments,List<ProjectDutyMilepostDO> milepostList){
        milepostList = milepostList.stream().sorted(Comparator.comparing(ProjectDutyMilepostDO::getId)).collect(toList());
        List<Integer> recordIds = stageDocuments.stream().map(StageDocumentDO::getRecordId).collect(toList());
        List<Integer> milepostIds = milepostList.stream().map(ProjectDutyMilepostDO::getId).collect(toList());
        Map<String,Integer> wordRecordMap = new HashMap<>();
        if(recordIds.size() > 0 && milepostIds.size() > 0){
            List<ProjectWordRecordDO> wordRecordList = projectWordRepository.countGroupByMilepostIdAndDocumentId(recordIds,milepostIds);
            wordRecordMap = wordRecordList.stream().collect(Collectors.toMap(k -> k.getFileKey().toString()+k.getMilepostId().toString(),ProjectWordRecordDO::getWordsNumber,(k1,k2)->k1));
        }
        List<Map<String,Object>> result = new ArrayList<>();
        boolean isUpload = false;
        try {
            for (StageDocumentDO stageDocument : stageDocuments) {
                Map<String,Object> map = bean2map(stageDocument);
                int i = 0;
                for (ProjectDutyMilepostDO projectDutyMilepostDO : milepostList) {
                    String words = projectDutyMilepostDO.getWords();
                    if (!StringUtils.isBlank(words)) {
                        isUpload = Arrays.asList(words.split(",")).contains(stageDocument.getDocumentId().toString());
                    } else {
                        isUpload = false;
                    }
                    String key = stageDocument.getRecordId().toString()+projectDutyMilepostDO.getId().toString();
                    if(isUpload){
                        map.put("milepost"+i,1+","+projectDutyMilepostDO.getId());
                        map.put("wordsNumber" + i, wordRecordMap.getOrDefault(key, 0) + "," + projectDutyMilepostDO.getId()+",1");
                    }else{
                        map.put("milepost"+i,0+","+projectDutyMilepostDO.getId());
                        map.put("wordsNumber" + i, wordRecordMap.getOrDefault(key, 0) + "," + projectDutyMilepostDO.getId()+",0");
                    }
                    i++;
                }
                result.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Integer> countStageDocumentByContractNo(String contractNo) {
        return projectWordRepository.countStageDocumentByContractNo(contractNo);
    }

    @Override
    public List<Integer> getMilepostStageDocumentCount() {
        return projectWordRepository.getMilepostStageDocumentCount();
    }

    @Override
    public List<ContractWordViewDO> getContractWordViewDisplayList(String contractId, String inputContent, Integer isRequired) {
        saveDocumentDetail(contractId);
        return getContractWordViewList(contractId, inputContent, isRequired);
    }

    @Override
    public List<ContractWordViewDO> getContractWordViewList(String contractId, String inputContent, Integer isRequired) {
        Sort sort = Sort.by("fileNo");
        List<ContractWordViewDO> list = contractWordViewDao.findAll(new Specification<ContractWordViewDO>() {
            @Override
            public Predicate toPredicate(Root<ContractWordViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("contractId"), contractId));
                if (StringUtils.isNotBlank(inputContent)) {
                    predicates.add(criteriaBuilder.like(root.get("fileName"), "%" + inputContent + "%"));
                }
                if (isRequired != null) {
                    predicates.add(criteriaBuilder.equal(root.get("isRequired"), isRequired));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, sort);
        return list;
    }

    @Override
    public List<ContractWordDetailViewDO> getContractWordDetailViewList(String contractId, Integer standardWordId) {
        return contractWordDetailViewDao.findAllByContractIdAndStandardWordId(contractId, standardWordId);
    }

    @Override
    public Result<ContractWordDetailViewDO> getContractWordDetailViewList(String contractId, Integer standardWordId, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("projectId").and(Sort.by("detailId"));
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<ContractWordDetailViewDO> page = contractWordDetailViewDao.findAll(new Specification<ContractWordDetailViewDO>() {
            @Override
            public Predicate toPredicate(Root<ContractWordDetailViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("contractId"), contractId));
                predicates.add(criteriaBuilder.equal(root.get("standardWordId"), standardWordId));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return ResultUtils.parseResult(page, ContractWordDetailViewDO.class);
    }

    @Override
    public ProjectWordDetailDO getProjectWordDBDetailDO(String fileYear, Integer dbDetailId, String personId) {
        String tableName = "WD_WDMX_" + fileYear;
        ProjectWordDetailDO dbDetailDO = projectWordDetailRepository.selectDetailById(dbDetailId,tableName);
        byte[] bytes = WaterMarkUtils.setWaterMark(dbDetailDO.getFile(), dbDetailDO.getFileName(), personId);
        dbDetailDO.setFile(bytes);
        return dbDetailDO;
    }
    

    @Override
    public List<ProjectWordRecordViewDO> getProjectWordDetailViewList(Integer wordInfoId) {
        List<ProjectWordRecordViewDO> list = projectWordDetailViewDao.findAll(new Specification<ProjectWordRecordViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectWordRecordViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("fileKey"), wordInfoId));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }

    @Override
    public ProjectWordViewDO getProjectWordView(String contractId, String projectId, Integer standardWordId) {
        return projectWordViewDao.findByHtbhAndProjectIdAndFileId(contractId, projectId, standardWordId);
    }

    @Override
    public Result<ProjectWordCountViewDO> getProjectWordCountViewList(ProjectWordCountViewQueryCnd cnd) {
        Sort sort = Sort.by("contractNo");
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<ProjectWordCountViewDO> page = projectWordCountViewDao.findAll(new Specification<ProjectWordCountViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectWordCountViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cnd.getSignDateStart() != null && cnd.getSignDateEnd() != null) {
                    predicates.add(criteriaBuilder.between(root.get("signDate"), cnd.getSignDateStart(), cnd.getSignDateEnd()));
                }
                if (StringUtils.isNotBlank(cnd.getDept())) {
                    predicates.add(criteriaBuilder.equal(root.get("dept"), cnd.getDept()));
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate p1 = criteriaBuilder.like(root.get("contractNo"), "%" + cnd.getInputContent() + "%");
                    Predicate p2 = criteriaBuilder.like(root.get("contractName"), "%" + cnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(p1, p2));
                }
                if (cnd.getContractNoList() != null && cnd.getContractNoList().size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("contractNo")).value(cnd.getContractNoList()));
                }
                if (cnd.getRequireList() != null && cnd.getRequireList().size() > 0) {
                    List<Predicate> predicateList = new ArrayList<>();
                    Predicate[] predicatesArray = new Predicate[cnd.getRequireList().size()];
                    cnd.getRequireList().forEach(item -> {
                        predicateList.add(criteriaBuilder.greaterThan(root.get(item), 0));
                    });
                    predicateList.toArray(predicatesArray);
                    predicates.add(criteriaBuilder.or(predicatesArray));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return ResultUtils.parseResult(page, ProjectWordCountViewDO.class);
    }


    @Override
    @Transactional
    public List<Map<String, Object>> getMilepostDocumentDisplayList(String contractNo, Integer dutyId) {
        List<StageDocumentDO> stageDocuments = projectWordRepository.findStageStandardDocuments();
        List<ProjectDutyMilepostDO> milepostList = projectDutyMilepostDao.findByContractNoAndDutyIdOrderById(contractNo, dutyId);
        List<Map<String,Object>> result = new ArrayList<>();
        boolean isUpload = false;
        try {
            for (StageDocumentDO stageDocument : stageDocuments) {
                Map<String,Object> map = bean2map(stageDocument);
                for (ProjectDutyMilepostDO projectDutyMilepostDO : milepostList) {
                    String words = projectDutyMilepostDO.getWords();
                    if (!StringUtils.isBlank(words)) {
                        isUpload = Arrays.asList(words.split(",")).contains(stageDocument.getDocumentId().toString());
                    } else {
                        isUpload = false;
                    }
                    map.put("milepost_"+projectDutyMilepostDO.getId(),isUpload);
                }
                result.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private Map<String,Object> bean2map(Object bean) throws Exception{
        Map<String,Object> map = new HashMap<>();
        //获取JavaBean的描述器
        BeanInfo b = Introspector.getBeanInfo(bean.getClass(),Object.class);
        //获取属性描述器
        PropertyDescriptor[] pds = b.getPropertyDescriptors();
        //对属性迭代
        for (PropertyDescriptor pd : pds) {
            //属性名称
            String propertyName = pd.getName();
            //属性值,用getter方法获取
            Method m = pd.getReadMethod();
            Object properValue = m.invoke(bean);//用对象执行getter方法获得属性值

            //把属性名-属性值 存到Map中
            map.put(propertyName, properValue);
        }
        return map;
    }
}
