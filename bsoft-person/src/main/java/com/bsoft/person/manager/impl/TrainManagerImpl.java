package com.bsoft.person.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.auth.manager.SalesPermissionManager;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.person.condition.PersonalTrainQueryCnd;
import com.bsoft.person.condition.TrainKnowledgeQueryCnd;
import com.bsoft.person.dao.primary.*;
import com.bsoft.person.entity.primary.*;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.person.manager.TrainManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TrainManagerImpl implements TrainManager {
    private static final String DEFAULT_ERROR_DATA_TOKEN = "ErrorDataToken";
    @Autowired
    private TrainLearnDao trainLearnDao;
    @Autowired
    private TrainLearnViewDao trainLearnViewDao;
    @Autowired
    private TrainShareDao trainShareDao;
    @Autowired
    private TrainShareViewDao trainShareViewDao;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private PersonalTrainViewDao personalTrainViewDao;
    @Autowired
    private SalesPermissionManager salesPermissionManager;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public List<TrainDO> getTrainWithPersonId(String personId) {
        return trainDao.findByPersonId(personId);
    }

    @Override
    public Page<TrainLearnViewDO> getKnowledgeLearnList(TrainKnowledgeQueryCnd cnd) {
        Sort sort = Sort.by("registrationDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<TrainLearnViewDO> pages = trainLearnViewDao.findAll(new Specification<TrainLearnViewDO>() {
            @Override
            public Predicate toPredicate(Root<TrainLearnViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), cnd.getDeptId()));
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                predicates.add(criteriaBuilder.between(root.get("registrationDate"),cnd.getStartDate(),cnd.getEndDate()));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public ImportResultDO saveKnowledgeLearn(String personId, List<TrainLearnViewDO> knowledgeLearnViewDOS, List<TrainLearnViewDO> errorLearnViewDO) {
        List<PersonDO> persons = personManager.getPerson();
        Map<String, Object> data = this.doJudgeKnowledgeLearnData(knowledgeLearnViewDOS, persons);
        List<TrainLearnDO> saveData = (List<TrainLearnDO>)data.get("saveData");
        List<TrainLearnViewDO> errorData = (List<TrainLearnViewDO>)data.get("errorData");
        errorData.addAll(errorLearnViewDO);
        trainLearnDao.saveAll(saveData);
        this.cacheErrorData(personId, "learn", errorData);
        ImportResultDO result = new ImportResultDO();
        result.setSuccessCount(saveData.size());
        result.setFailCount(errorData.size());
        return result;
    }

    @Override
    public Page<TrainShareViewDO> getKnowledgeShareList(TrainKnowledgeQueryCnd cnd) {
        Sort sort = Sort.by("registrationDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<TrainShareViewDO> pages = trainShareViewDao.findAll(new Specification<TrainShareViewDO>() {
            @Override
            public Predicate toPredicate(Root<TrainShareViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), cnd.getDeptId()));
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                predicates.add(criteriaBuilder.between(root.get("registrationDate"),cnd.getStartDate(),cnd.getEndDate()));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public ImportResultDO saveKnowledgeShare(String personId, List<TrainShareViewDO> knowledgeShareViewDOS, List<TrainShareViewDO> errorShareViewDOS) {
        List<PersonDO> persons = personManager.getPerson();
        Map<String, Object> data = this.doJudgeKnowledgeShareData(knowledgeShareViewDOS, persons);
        List<TrainShareDO> saveData = (List<TrainShareDO>)data.get("saveData");
        List<TrainShareViewDO> errorData = (List<TrainShareViewDO>)data.get("errorData");
        errorData.addAll(errorShareViewDOS);
        trainShareDao.saveAll(saveData);
        // 缓存错误数据
        this.cacheErrorData(personId, "share", errorData);
        ImportResultDO result = new ImportResultDO();
        result.setSuccessCount(saveData.size());
        result.setFailCount(errorData.size());
        return result;
    }

    @Override
    public List<TrainLearnViewDO> getImportLearnErrorRecords(String personId) {
        String errorDataString = redisTemplate.opsForValue().get(getKey(personId, "learn"));
        List<TrainLearnViewDO> errorData = (List<TrainLearnViewDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    @Override
    public List<TrainShareViewDO> getImportShareErrorRecords(String personId) {
        String errorDataString = redisTemplate.opsForValue().get(getKey(personId, "share"));
        List<TrainShareViewDO> errorData = (List<TrainShareViewDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    @Override
    @Transactional
    public void deleteBatchLearnList(List<Integer> deletes) {
        trainLearnDao.deleteAllByIdIn(deletes);
    }

    @Override
    @Transactional
    public void deleteBatchShareList(List<Integer> deletes) {
        trainShareDao.deleteAllByIdIn(deletes);
    }

    @Override
    public Page<PersonalTrainViewDO> getPersonalTrainList(PersonalTrainQueryCnd cnd) {
        Sort sort = null;
        if (cnd.getSortFlag() == 1) {
            sort = Sort.by("totalTeachingHours").descending() // 授课课时
                    .and(Sort.by("personId").descending());
        }
        if (cnd.getSortFlag() == 2) {
            sort = Sort.by("totalTrainingHours").descending() // 参训课时
                    .and(Sort.by("personId").descending());
        }
        // 查询个人部门权限
        List<String> deptIds = salesPermissionManager.getUserDeptPermission(cnd.getPersonId());
        if (deptIds.isEmpty()){
            deptIds.add("");
        }
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<PersonalTrainViewDO> pages = personalTrainViewDao.findAll(new Specification<PersonalTrainViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonalTrainViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                predicates.add(criteriaBuilder.equal(root.get("year"),cnd.getYear()));
                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"),cnd.getDeptId()));
                }
                if (!cnd.getAllPermission()) {
                    // 部门权限
                    predicates.add(criteriaBuilder.or(root.get("deptId").as(String.class).in(deptIds)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    /** 云学堂知识学习导入数据的校验 */
    private Map<String, Object> doJudgeKnowledgeLearnData(List<TrainLearnViewDO> knowledgeLearnViewDOS, List<PersonDO> vaildPersons) {
        Map<String, PersonDO> persons = vaildPersons.stream().collect(Collectors.toMap(PersonDO::getPersonId, personDO -> personDO));

        List<TrainLearnViewDO> needSaveData = new ArrayList<>();
        List<TrainLearnViewDO> errorData = new ArrayList<>();
        knowledgeLearnViewDOS.forEach(trainLearnViewDO -> {
            if (this.checkLearn(trainLearnViewDO, persons)) {
                // 部门赋值
                trainLearnViewDO.setDeptId(persons.get(trainLearnViewDO.getPersonId()).getDeptId());
                // 若学习进度未达100%，则不设置完成时间
                 if (trainLearnViewDO.getLearningRate() != 1) {
                     trainLearnViewDO.setEndDate(null);
                 }
                needSaveData.add(trainLearnViewDO);
            } else {
                errorData.add(trainLearnViewDO);
            }
        });
        List<TrainLearnDO> trainLearnDOS = iGenerator.convert(needSaveData, TrainLearnDO.class);
        Map<String, Object> data = new HashMap<>();
        data.put("saveData", trainLearnDOS);
        data.put("errorData", errorData);
        return data;
    }

    private String getKey(String personId, String key){
        return new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append(key).append(":").append(personId).toString();
    }

    private void cacheErrorData(String personId, String key,List data){
        // 先删除redis数据
        redisTemplate.delete(getKey(personId, key));
        // 再重新缓存数据
        redisTemplate.opsForValue().set(getKey(personId, key),JSONObject.toJSONString(data));
    }

    /** 云学堂知识学习导入数据的校验 */
    private Map<String, Object> doJudgeKnowledgeShareData(List<TrainShareViewDO> knowledgeShareViewDOS, List<PersonDO> vaildPersons) {
        Map<String, PersonDO> persons = vaildPersons.stream().collect(Collectors.toMap(PersonDO::getPersonId, personDO -> personDO));
        List<TrainShareViewDO> needSaveData = new ArrayList<>();
        List<TrainShareViewDO> errorData = new ArrayList<>();
        knowledgeShareViewDOS.forEach(trainShareViewDO -> {
            if (this.checkShare(trainShareViewDO, persons)) {
                // 部门赋值
                trainShareViewDO.setDeptId(persons.get(trainShareViewDO.getPersonId()).getDeptId());
                needSaveData.add(trainShareViewDO);
            } else {
                errorData.add(trainShareViewDO);
            }
        });
        //转换需要保存的bean
        List<TrainShareDO> trainShareDOS = iGenerator.convert(needSaveData, TrainShareDO.class);
        Map<String, Object> data = new HashMap<>();
        data.put("saveData", trainShareDOS);
        data.put("errorData", errorData);
        return data;
    }

    private Boolean checkLearn(TrainLearnViewDO trainLearnViewDO, Map<String, PersonDO> persons){
        // 判断工号是否有效
        if (persons.get(trainLearnViewDO.getPersonId()) == null) {
            return false;
        }
        // 判断工号与姓名是否匹配
//        if (StringUtils.isNotBlank(trainLearnViewDO.getPersonId()) && !persons.get(trainLearnViewDO.getPersonId()).getPersonName().equals(trainLearnViewDO.getPersonName())) {
//            return false;
//        }
        // 判断学习进度是否有效
        if (trainLearnViewDO.getLearningRate() < 0 || trainLearnViewDO.getLearningRate() > 1)  {
            return false;
        }
        // 判断学习时长是否有效
        if (trainLearnViewDO.getLearningTime() < 0)  {
            return false;
        }
        // 判断获得学分是否有效
        if (trainLearnViewDO.getEarnedCredits() < 0)  {
            return false;
        }
        // 判断知识名称长度是否过长
        if (StringUtils.isBlank(trainLearnViewDO.getKnowledgeName()) || (StringUtils.isNotBlank(trainLearnViewDO.getKnowledgeName()) && trainLearnViewDO.getKnowledgeName().length() > 60)) {
            return false;
        }
        return true;
    }

    private Boolean checkShare(TrainShareViewDO trainShareViewDO, Map<String, PersonDO> persons){
        // 判断工号是否有效
        if (persons.get(trainShareViewDO.getPersonId()) == null) {
            return false;
        }
        // 判断工号与姓名是否匹配
//        if (StringUtils.isNotBlank(trainShareViewDO.getPersonId()) && !persons.get(trainShareViewDO.getPersonId()).getPersonName().equals(trainShareViewDO.getPersonName())) {
//            return false;
//        }
        // 判断知识名称长度是否过长
        if (StringUtils.isBlank(trainShareViewDO.getKnowledgeName()) || (StringUtils.isNotBlank(trainShareViewDO.getKnowledgeName()) && trainShareViewDO.getKnowledgeName().length() > 60)) {
            return false;
        }
        return true;
    }

}
