package com.bsoft.sales.manager.impl;

import com.bsoft.auth.manager.MenuAuthorityManager;
import com.bsoft.auth.manager.UserPermissionManager;
import com.bsoft.common.constant.ProjectContractEnum;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.entity.primary.ModifyRecordDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.KeyGeneratorManager;
import com.bsoft.common.manager.ModifyRecordManager;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.cost.entity.primary.*;
import com.bsoft.cost.manager.CostRecordManager;
import com.bsoft.cost.manager.DeptReimbDateControlManager;
import com.bsoft.cost.manager.InvoiceLibraryManager;
import com.bsoft.cost.manager.ReimbDateControlManager;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.project.entity.primary.ProjectDeptChangeDO;
import com.bsoft.project.entity.primary.ProjectLookDO;
import com.bsoft.project.manager.ProjectDeptChangeManager;
import com.bsoft.project.manager.ProjectManager;
import com.bsoft.sales.condition.OwnPurchaseContractQueryCnd;
import com.bsoft.sales.condition.PurContractPayQueryCnd;
import com.bsoft.sales.condition.PurchaseContractQueryCnd;
import com.bsoft.sales.dao.primary.*;
import com.bsoft.sales.entity.primary.*;
import com.bsoft.sales.manager.PurchaseContractManager;
import com.bsoft.sales.repository.primary.PurchaseContractRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 11:18
 * @Description: ????????????Manager?????????
 */
@Component
public class PurchaseContractManagerImpl implements PurchaseContractManager {
    @Autowired
    private PurchaseContractViewDao purchaseContractViewDao;
    @Autowired
    private PurContractPayViewDao purContractPayViewDao;
    @Autowired
    private PurContractPayDao purContractPayDao;
    @Autowired
    private PurchaseContractPaymentDao purchaseContractPaymentDao;
    @Autowired
    private PurchaseContractPaymentViewDao purchaseContractPaymentViewDao;
    @Autowired
    private CostRecordManager costRecordManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private DeptReimbDateControlManager deptReimbDateControlManager;
    @Autowired
    private ReimbDateControlManager reimbDateControlManager;
    @Autowired
    private ProjectDeptChangeManager projectDeptChangeManager;
    @Autowired
    private InvoiceLibraryManager invoiceLibraryManager;
    @Autowired
    private ProjectManager projectManager;
    @Autowired
    private KeyGeneratorManager keyGeneratorManager;
    @Autowired
    private PurchaseContractDao purchaseContractDao;
    @Autowired
    private OwnPurchaseContractViewDao ownPurchaseContractViewDao;
    @Autowired
    private UserPermissionManager userPermissionManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private OwnPurchaseCostPaymentViewDao ownPurchaseCostPaymentViewDao;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private PurchaseContractProgressDao purchaseContractProgressDao;
    @Autowired
    private OwnPurchaseContractProgressViewDao ownPurchaseContractProgressViewDao;
    @Autowired
    private MenuAuthorityManager menuAuthorityManager;
    @Autowired
    private PurchaseContractRepository purchaseContractRepository;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private ModifyRecordManager modifyRecordManager;

    @Override
    public Page<PurchaseContractViewDO> getPurchaseContract(PurchaseContractQueryCnd cnd) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<PurchaseContractViewDO> pages = purchaseContractViewDao.findAll(new Specification<PurchaseContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<PurchaseContractViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Integer status = cnd.getStatus();
                predicates.add(criteriaBuilder.equal(root.get("endMark"), status));
                if (!cnd.getQueryAll()) {
                    predicates.add(criteriaBuilder.equal(root.get("signer"), cnd.getSigner()));
                }

                if (cnd.getStartDate() != null && cnd.getEndDate() != null) {
                    predicates.add(criteriaBuilder.between(root.get("applyDate"), cnd.getStartDate(), cnd.getEndDate()));
                }
                String inpitContent = cnd.getInput();
                if (inpitContent != null) {
                    Predicate c1 = criteriaBuilder.like(root.get("oalsh"), "%" + inpitContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractNo"), "%" + inpitContent + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("productName"), "%" + inpitContent + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    public Page<PurContractPayViewDO> getPurContractPay(PurContractPayQueryCnd cnd) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<PurContractPayViewDO> pages = purContractPayViewDao.findAll(new Specification<PurContractPayViewDO>() {
            @Override
            public Predicate toPredicate(Root<PurContractPayViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Integer htid = cnd.getHtid();
                predicates.add(criteriaBuilder.equal(root.get("htid"), htid));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    public PurContractPayViewDO getPurContractPay(Integer id) {
        return purContractPayViewDao.getOne(id);
    }

    @Override
    @Transactional
    public PurContractPayDO savePurContractPay(PurContractPayDO payDO) {
        ValidateUtil.check(payDO);
        if (payDO.getVoucherNo() != null) {
            CostRecordDO costRecord = costRecordManager.getCostRecord(payDO.getVoucherNo());
            costRecord.setBillSymbol(payDO.getTaxFlag());
            costRecord.setBillAmount(payDO.getTaxAmount());
            costRecord.setTaxNo(payDO.getInvoiceNumber());
            costRecord.setInvoiceCode(payDO.getInvoiceCode());
            costRecord.setInvoiceType(payDO.getInvoiceType());
            if (costRecord.getInvoiceID() != null && (payDO.getInvoiceCode() == null || StringUtils.isBlank(payDO.getInvoiceCode())) && (payDO.getInvoiceNumber() == null || StringUtils.isBlank(payDO.getInvoiceNumber()))) {
                invoiceLibraryManager.deleteInvoiceLib(costRecord.getInvoiceID());
                costRecord.setInvoiceID(null);
            } else {
                if ((costRecord.getInvoiceCode() != null && StringUtils.isNotBlank(costRecord.getInvoiceCode())) && (costRecord.getTaxNo() != null && StringUtils.isNotBlank(costRecord.getTaxNo()))) {
                    InvoiceLibDO invoiceLibDO = saveInvoiceInfo(costRecord);//?????????????????????
                    costRecord.setInvoiceID(invoiceLibDO.getId());
                }
            }
            costRecordManager.saveCostRecord(costRecord);
        }
        PurContractPayDO payDO1 = purContractPayDao.save(payDO);
        return payDO1;
    }

    @Override
    @Transactional
    public void savePurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentDO> contractPaymentDOS, List<Integer> ids, String contractNo) {
        Integer purchaseContractId = contractDO.getPurchaseContractId();
        // ???????????????????????????
        if (purchaseContractId == null) {
            // ??????id
            purchaseContractId = keyGeneratorManager.nextKey("CG_HTXX");
            // ?????????????????????
            String purchaseContractNo = getPurchaseContractNo(contractNo);
            contractDO.setPurchaseContractId(purchaseContractId);
            contractDO.setPurchaseContractNo(purchaseContractNo);
            contractDO.setType(1);// ??????  ????????????
            contractDO.setFlag(2);// ??????  ????????????
            contractDO.setHasContract(0);// ??????0
            contractDO.setSinglePurchase(0); // ??????0
            // ??????
            purchaseContractDao.save(contractDO);
        } else {
            // ??????
            purchaseContractDao.updatePurchaseContract(contractDO);
        }
        if (!contractPaymentDOS.isEmpty()) {
            contractPaymentDOS.forEach(payment -> {
                payment.setContractId(contractDO.getPurchaseContractId());
            });
            purchaseContractPaymentDao.saveAll(contractPaymentDOS);
        }
        if (!ids.isEmpty()) {
            purchaseContractPaymentDao.deleteAllByIdIn(ids);
        }
    }

    @Override
    public List<PurchaseContractPaymentViewDO> getPurchaseContractPaymentList(Integer purchaseContractId) {
        return purchaseContractPaymentViewDao.findAllByContractIdOrderByPaymentAccountAsc(purchaseContractId);
    }

    @Override
    @Transactional
    public Integer savePaymentApplication(PurContractPayViewDO payViewDO) {
        Integer key = saveCost(payViewDO);
        PurContractPayDO payDO = generatorUtil.convert(payViewDO, PurContractPayDO.class);
        payDO.setVoucherNo(key);
        purContractPayDao.save(payDO);
        return key;
    }


    @Override
    public Page<OwnPurchaseContractViewDO> getOwnPurchaseContract(OwnPurchaseContractQueryCnd cnd) {
        Sort sort = Sort.by("registerDate").descending().and(Sort.by("purchaseContractId").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        List<String> deptIds = userPermissionManager.getUserDeptPermission(cnd.getPersonId());
        if (deptIds.isEmpty()) {
            deptIds.add("");
        }
        Page<OwnPurchaseContractViewDO> pages = ownPurchaseContractViewDao.findAll(new Specification<OwnPurchaseContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<OwnPurchaseContractViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("endMark"), cnd.getEndMark()));
                if (cnd.getSignYear() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("signYear"), cnd.getSignYear()));
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("purchaseContractNo"), "%" + cnd.getInputContent().toUpperCase() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractName"), "%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("productName"), "%" + cnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                // ????????????
                predicates.add(criteriaBuilder.or(root.get("signDept").as(String.class).in(deptIds)));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    @Transactional
    public Integer saveOwnPurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentDO> contractPaymentDOS, List<Integer> ids, String personId) {
        Integer purchaseContractId = contractDO.getPurchaseContractId();
        Date serverDate = serverDateManager.getServerDate();
        // ???????????????????????????
        if (purchaseContractId == null) {
            // ??????id
            purchaseContractId = keyGeneratorManager.nextKey("CG_HTXX");
            contractDO.setPurchaseContractId(purchaseContractId);
            contractDO.setType(2);// ??????  ????????????
            contractDO.setSinglePurchase(0); // ??????0
            contractDO.setEndMark(0); // ??????0 ?????????
            contractDO.setRegisterPersonId(personId);
            contractDO.setRegisterDate(serverDate);
            contractDO.setAlterFlag(0);
            // ??????
            purchaseContractDao.save(contractDO);
        } else {
            if (contractDO.getFinalCostAmount() != null) {
                contractDO.setStatus(2);
            }
            // ????????????
            purchaseContractDao.updateOwnPurchaseContract(contractDO);
        }

        if (!contractPaymentDOS.isEmpty()) {
            contractPaymentDOS.forEach(payment -> {
                payment.setContractId(contractDO.getPurchaseContractId());
            });
            purchaseContractPaymentDao.saveAll(contractPaymentDOS);
        }
        if (!ids.isEmpty()) {
            purchaseContractPaymentDao.deleteAllByIdIn(ids);
        }
        return purchaseContractId;
    }

    @Override
    public Integer getOwnUnfinishedCount(Integer signYear, String inputContent, String userId) {
        String sighYearStr = signYear == null ? "" : signYear.toString();
        return purchaseContractRepository.getOwnUnfinishedCountByYearAndContent(sighYearStr, inputContent, userId);
    }

    @Override
    @Transactional
    public void deleteOwnPurchaseContractCount(Integer purchaseContractId) {
        purchaseContractDao.deleteById(purchaseContractId);
        purchaseContractPaymentDao.deleteAllByContractId(purchaseContractId);
    }

    @Override
    public Page<OwnPurchaseContractViewDO> getOwnPurchaseContractAuditList(OwnPurchaseContractQueryCnd cnd) {
        Sort sort = Sort.by("registerDate").descending().and(Sort.by("purchaseContractId").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<OwnPurchaseContractViewDO> pages = ownPurchaseContractViewDao.findAll(new Specification<OwnPurchaseContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<OwnPurchaseContractViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cnd.getSignYear() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("signYear"), cnd.getSignYear()));
                }
                if (cnd.getAuditStatus() == 0) { // ????????????????????????
                    Predicate c1 = criteriaBuilder.equal(root.get("status"), 0);
                    Predicate c2 = criteriaBuilder.equal(root.get("status"), 2);
                    Predicate c3 = criteriaBuilder.equal(root.get("alterFlag"), 1);
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                if (cnd.getAuditStatus() == 1) { // ????????????????????????
                    Predicate c1 = criteriaBuilder.equal(root.get("status"), 1);
                    Predicate c2 = criteriaBuilder.equal(root.get("status"), 3);
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("purchaseContractNo"), "%" + cnd.getInputContent().toUpperCase() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractName"), "%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("productName"), "%" + cnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    public Integer getOwnUnreviewedCount(Integer signYear, String inputContent) {
        String sighYearStr = signYear == null ? "" : signYear.toString();
        return purchaseContractRepository.getOwnUnreviewedCountByYearAndContent(sighYearStr, inputContent);
    }

    @Override
    @Transactional
    public void auditOwnPurchaseContract(Integer contractId, Integer oldStatus, String personId) {
        java.sql.Date serverDate = serverDateManager.getServerDate();
        // ??????????????????
        if (oldStatus == 0) {
            purchaseContractDao.updateStatusAndAuditterAndAuditDate(contractId, serverDate, personId, 1);
        }
        // ????????????????????????????????????
        if (oldStatus == 2) {
            purchaseContractDao.updateStatusAndEndMarkAuditterAndAuditDate(contractId, 3, 1, serverDate, personId);
        }
    }

    @Override
    public Page<OwnPurchaseCostPaymentViewDO> getOwnPurchaseCostPaymentList(String purchaseContractNo, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("applyDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<OwnPurchaseCostPaymentViewDO> pages = ownPurchaseCostPaymentViewDao.findAllByPurchaseContractNo(purchaseContractNo, pageable);
        return pages;
    }

    @Override
    public PageInfo<OwnPurchaseContractViewDO> getOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCnd cnd) {
        PageHelper.startPage(cnd.getPageNo(), cnd.getPageSize());
        List<OwnPurchaseContractViewDO> list = purchaseContractRepository.getOwnPurchaseContractWithProgressList(cnd);
        PageInfo<OwnPurchaseContractViewDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<OwnPurchaseContractViewDO> getAllOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCnd cnd) {
        List<OwnPurchaseContractViewDO> list = purchaseContractRepository.getOwnPurchaseContractWithProgressList(cnd);
        return list;
    }

    @Override
    public List<OwnPurchaseContractProgressViewDO> getOwnPurchaseContractProgressList(Integer purchaseContractId) {
        Sort sort = Sort.by("confirmDate").descending().and(Sort.by("id").descending());
        return ownPurchaseContractProgressViewDao.findAllByPurchaseContractId(purchaseContractId, sort);
    }

    @Override
    public String getOwnPurchaseContractNo(Integer hasContract, Integer classification, String signDate) {
        String secodnCode = "";
        String firstCode = ProjectContractEnum.BSOFT.getName();

        String purchaseContractNo = "";
        if (hasContract == 0) {
            secodnCode = "WHT";
        } else {
            List<PublicDicDO> publicDics = publicDicManager.getPublicDic(1510);
            Map<Integer, String> dicMap = publicDics.stream().collect(Collectors.toMap(PublicDicDO::getId, PublicDicDO::getProduct));
            secodnCode = dicMap.get(classification);
        }
        StringBuffer contractNo = new StringBuffer().append(firstCode).append("-").append(secodnCode).append("-").append(signDate).append("-");
        Integer count = purchaseContractRepository.getContractNumberBySimilarContractNo(contractNo.toString() + "%");
        DecimalFormat df = new DecimalFormat("000");
        return contractNo.append(purchaseContractNo).append(df.format(count + 1)).toString();
    }

    @Override
    public Page<OwnPurchaseContractViewDO> getOwnPurchaseContractSelectList(String inputContent, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("registerDate").descending().and(Sort.by("purchaseContractId").descending());
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<OwnPurchaseContractViewDO> page = ownPurchaseContractViewDao.findAll(new Specification<OwnPurchaseContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<OwnPurchaseContractViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("purchaseContractNo"), "%" + inputContent.toUpperCase() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractName"), "%" + inputContent + "%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                // ????????????
                predicates.add(criteriaBuilder.greaterThan(root.get("status"), 0));
                // ????????????
                predicates.add(criteriaBuilder.equal(root.get("hasContract"), 1));
                // ????????????100???
//                predicates.add(criteriaBuilder.equal(root.get("endMark"),0));
                Predicate c1 = criteriaBuilder.lessThan(root.get("progress"), 1);
                Predicate c2 = criteriaBuilder.isNull(root.get("progress"));
                predicates.add(criteriaBuilder.or(c1, c2));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return page;
    }

    @Override
    public Page<OwnPurchaseContractViewDO> getOwnPurchaseContractSearchList(Integer purchaseContractId, String inputContent, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("registerDate").descending().and(Sort.by("purchaseContractId").descending());
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<OwnPurchaseContractViewDO> pages = ownPurchaseContractViewDao.findAll(new Specification<OwnPurchaseContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<OwnPurchaseContractViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("purchaseContractNo"), "%" + inputContent.toUpperCase() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractName"), "%" + inputContent + "%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                // ????????????
                predicates.add(criteriaBuilder.greaterThan(root.get("status"), 0));
                if (purchaseContractId != null) {
                    predicates.add(criteriaBuilder.notEqual(root.get("purchaseContractId"), purchaseContractId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    @Transactional
    public Integer savePurchaseContractProgress(PurchaseContractProgressDO progress) {
        java.sql.Date serverDate = serverDateManager.getServerDate();
        progress.setRegisterDate(serverDate);
        purchaseContractProgressDao.save(progress);
        // ????????????????????????????????????
        purchaseContractDao.updatePurchaseContractProgress(progress.getPurchaseContractId(), progress.getProgress(), progress.getConfirmDate());
        return progress.getId();
    }

    @Override
    @Transactional
    public Integer updatePurchaseContractProgress(PurchaseContractProgressDO progress) {
        purchaseContractProgressDao.updateProgress(progress);
        // ????????????????????????????????????
        purchaseContractDao.updatePurchaseContractProgress(progress.getPurchaseContractId(), progress.getProgress(), progress.getConfirmDate());
        return progress.getId();
    }

    @Override
    public OwnPurchaseContractViewDO getOwnPurchaseContract(Integer purchaseContractId) {
        Optional<OwnPurchaseContractViewDO> optional = ownPurchaseContractViewDao.findById(purchaseContractId);
        return optional.get();
    }

    @Override
    public List<OwnPurchaseContractViewDO> getAllOwnPurchaseContractList(OwnPurchaseContractQueryCnd cnd) {
        Sort sort = Sort.by("registerDate").descending().and(Sort.by("purchaseContractId").descending());
        List<String> deptIds = userPermissionManager.getUserDeptPermission(cnd.getPersonId());
        List<OwnPurchaseContractViewDO> list = ownPurchaseContractViewDao.findAll(new Specification<OwnPurchaseContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<OwnPurchaseContractViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("endMark"), cnd.getEndMark()));
                predicates.add(criteriaBuilder.equal(root.get("signYear"), cnd.getSignYear()));
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("purchaseContractNo"), "%" + cnd.getInputContent().toUpperCase() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractName"), "%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("productName"), "%" + cnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                // ????????????
                predicates.add(criteriaBuilder.or(root.get("signDept").as(String.class).in(deptIds)));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, sort);
        return list;
    }

    @Override
    public PageInfo<OwnPurchaseContractViewDO> getOwnPurchaseContractInfoList(OwnPurchaseContractQueryCnd cnd) {
        PageHelper.startPage(cnd.getPageNo(), cnd.getPageSize());
        List<OwnPurchaseContractViewDO> list = purchaseContractRepository.getOwnPurchaseContractList(cnd);
        PageInfo<OwnPurchaseContractViewDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<OwnPurchaseContractViewDO> getAllOwnPurchaseContractInfoList(OwnPurchaseContractQueryCnd cnd) {
        List<OwnPurchaseContractViewDO> list = purchaseContractRepository.getOwnPurchaseContractList(cnd);
        return list;
    }

    @Override
    public Integer getPortalPurchaseContractAuditNeedDoCount(String personId) {
        //  ????????????????????????????????????
        boolean hasPermission = menuAuthorityManager.checkPrivateMenuPermission(personId, "ownpurchaseaudit");
        int count = 0;
        if (hasPermission) {
            count = ownPurchaseContractViewDao.getOwnUnreviewedCount();
        }
        return count;
    }

    @Override
    public boolean existPurchaseContract(String purchaseContractNo) {
        Optional<PurchaseContractDO> contractDO = purchaseContractDao.findByPurchaseContractNo(purchaseContractNo);
        return contractDO.isPresent();
    }

    @Override
    @Transactional
    public void disagreeOwnPurchaseContract(Integer contractId, Integer oldStatus) {
        Integer newSatus = null;
        if (oldStatus == 0) {
            newSatus = -1;
        }
        if (oldStatus == 2) {
            newSatus = 1;
        }
        purchaseContractDao.updateStatus(contractId, newSatus);
    }

    @Override
    public Integer getOwnPurchaseContractSuplementCount(Integer purchaseContractId) {
        return purchaseContractDao.getPurchaseContractSupplementCount(purchaseContractId);
    }

    @Override
    @Transactional
    public void alterOwnPurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentViewDO> contractPaymentViewDOS, String personId) {
        Date serverDateTime = serverDateManager.getServerDateTime();
        String modifyContent = this.getModifyContent(contractDO, contractPaymentViewDOS, personId, serverDateTime);
        ModifyRecordDO modifyRecordDO = new ModifyRecordDO();
        modifyRecordDO.setModifyPersonId(personId);
        modifyRecordDO.setModifyContent(modifyContent);
        modifyRecordDO.setModifyDetail(14);
        modifyRecordDO.setMainId(contractDO.getPurchaseContractId().toString());
        modifyRecordDO.setModifyDate(serverDateTime);
        modifyRecordDO.setModifyType("??????");

        List<PurchaseContractPaymentDO> paymentDOS = generatorUtil.convert(contractPaymentViewDOS, PurchaseContractPaymentDO.class);

        // ??????????????????
        Integer modifyId = modifyRecordManager.saveModifyRecord(modifyRecordDO); // ??????????????????
        // ?????????????????????????????????????????????
        Double alterAmount = null;
        if (!contractDO.getTotalAmount().equals(contractDO.getAlterAmount())) {
            alterAmount = contractDO.getAlterAmount();
        }
        purchaseContractDao.updateAlterAmountAndAlterFlagAndModifyId(alterAmount, 1, contractDO.getPurchaseContractId(), modifyId);
        // ???????????????????????????
        if (!paymentDOS.isEmpty()) {
            purchaseContractPaymentDao.saveAll(paymentDOS);
        }
    }

    @Override
    @Transactional
    public void auditAlterOwnPurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentDO> contractPaymentDOS,String personId) {
        java.sql.Date serverDate = serverDateManager.getServerDate();
        contractDO.setAuditDate(serverDate);
        contractDO.setAuditter(personId);
        contractDO.setTotalAmount(contractDO.getAlterAmount());
        contractDO.setAlterFlag(0);
        contractDO.setAlterAmount(null);
        purchaseContractDao.updateAuditAlterPurchaseContract(contractDO);
        contractPaymentDOS.forEach(payment -> {
            payment.setPayment(payment.getAlterPayment());
            payment.setAlterPayment(null);
            payment.setAlterType(null);
        });
        purchaseContractPaymentDao.saveAll(contractPaymentDOS);

    }

    @Override
    @Transactional
    public void disagreeAlterOwnPurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentDO> contractPaymentDOS) {
        purchaseContractDao.updateAlterAmountAndAlterFlagAndModifyId(null, 0, contractDO.getPurchaseContractId(), null);
        contractPaymentDOS.forEach(payment -> {
            payment.setAlterPayment(null);
        });

        // ??????????????????????????????
        List<Integer> ids = contractPaymentDOS.stream().filter(payment -> payment.getAlterType() != null && payment.getAlterType() == 1).map(PurchaseContractPaymentDO::getId).collect(Collectors.toList());
        // ?????????????????????????????????
        List<PurchaseContractPaymentDO> modifyPayments = contractPaymentDOS.stream().filter(payment -> payment.getAlterType() != null && payment.getAlterType() == 2).collect(Collectors.toList());

        if (!modifyPayments.isEmpty()) {
            modifyPayments.forEach(payment -> {
                payment.setAlterType(null); // ??????????????????
                payment.setAlterPayment(null); // ??????????????????
            });
            purchaseContractPaymentDao.saveAll(modifyPayments);
        }
        if (!ids.isEmpty()) {
            purchaseContractPaymentDao.deleteAllByIdIn(ids);
        }

        // ??????????????????
        modifyRecordManager.deleteModifyRecord(contractDO.getModifyId());
    }

    @Override
    public List<PurchaseContractPaymentViewDO> getOwnPurchaseContractPaymentList(Integer purchaseContractId, Integer alterFlag) {
        Sort sort = Sort.by("paymentAccount").ascending();
        List<PurchaseContractPaymentViewDO> list = purchaseContractPaymentViewDao.findAll(new Specification<PurchaseContractPaymentViewDO>() {
            @Override
            public Predicate toPredicate(Root<PurchaseContractPaymentViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("contractId"), purchaseContractId));

                if (alterFlag == 0) {
                    Predicate c1 = criteriaBuilder.equal(root.get("alterType"), 2);
                    Predicate c2 = criteriaBuilder.isNull(root.get("alterType"));
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, sort);
        return list;
    }

    public String getPurchaseContractNo(String contractNo) {
        // ???????????????????????????
        Integer count = purchaseContractViewDao.getCountByContractNo(contractNo);
        // ????????????????????? eg: CG01-XXXXX
        DecimalFormat df = new DecimalFormat("00");
        String purchaseContractNo = new StringBuilder("CG").append(df.format(count + 1)).append("-").append(contractNo).toString();
        return purchaseContractNo;
    }


    //????????????????????????
    public Integer saveCost(PurContractPayViewDO payViewDO) {
        Calendar calendar = Calendar.getInstance();
        Date hsrq = payViewDO.getApplyDate();
        calendar.setTime(hsrq);
        Integer year = calendar.get(Calendar.YEAR);
        String hsbm = payViewDO.getAccountDept();
        DeptDO deptDO = deptManager.getDept(hsbm);
        if (deptDO.getLogoutDate() != null) {
            if (deptDO.getEstDate().after(hsrq) || deptDO.getLogoutDate().before(hsrq)) {
                throw new ServiceException("???????????????'" + deptDO.getDeptName() + "'???????????????!");
            }
        } else {
            if (deptDO.getEstDate().after(hsrq)) {
                throw new ServiceException("???????????????'" + deptDO.getDeptName() + "'???????????????!");
            }
        }
        List<DeptReimbDateControlDO> list = deptReimbDateControlManager.getControlDate(hsbm, year);
        if (list.size() <= 0) {
            List<ReimbDateControlDO> reimbDateControlDOS = reimbDateControlManager.getReimbDateControlByYear(year);
            if (reimbDateControlDOS.size() > 0) {
                Date ndkz = reimbDateControlDOS.get(0).getYearDate() != null ? reimbDateControlDOS.get(0).getYearDate() : null;
                if (ndkz != null && ndkz.after(new Date())) {
                    SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd");
                    throw new ServiceException(year + "????????????" + f.format(ndkz) + "????????????");
                }
            } else {
                throw new ServiceException(year + "??????????????????????????????????????????");
            }
        }
        CostRecordDO costRecordDO = new CostRecordDO();
        if (payViewDO.getVoucherNo() != null) {
            costRecordDO.setId(payViewDO.getVoucherNo());
        }
        costRecordDO.setApplicant(payViewDO.getApplyer());
        costRecordDO.setProjectId(payViewDO.getProjectid());
        costRecordDO.setApplyAmount(payViewDO.getApplyAmount());
        costRecordDO.setAuditAmount(payViewDO.getApplyAmount());
        costRecordDO.setBelonger(payViewDO.getBelonger());
        costRecordDO.setImpersonal(1);
        costRecordDO.setApplyDept(payViewDO.getAccountDept());
        List<ProjectDeptChangeDO> projectDeptChangeList = projectDeptChangeManager.getProjectDeptChangeList(payViewDO.getProjectid());
        if (projectDeptChangeList.size() > 0) {
            ProjectDeptChangeDO deptChangeDO = projectDeptChangeManager.getProjectDeptByPreDate(payViewDO.getProjectid(), hsrq);
            if (deptChangeDO != null) {
                costRecordDO.setApplyDept(deptChangeDO.getPreDept());
            } else {
                ProjectDeptChangeDO deptChangeDO1 = projectDeptChangeManager.getFirstProjectChange(payViewDO.getProjectid());
                if (hsrq.before(deptChangeDO1.getPreEnd())) {
                    costRecordDO.setApplyDept(deptChangeDO1.getPreDept());
                } else {
                    ProjectDeptChangeDO deptChangeDO2 = projectDeptChangeManager.getNewProjectChange(payViewDO.getProjectid());
                    if (deptChangeDO2.getCancelFlag() == 1) {
                        throw new ServiceException("??????????????????, ???????????????????????????????????????!");
                    } else {
                        costRecordDO.setApplyDept(deptChangeDO2.getPreDept());
                    }
                }
            }
        } else {
            ProjectLookDO project = projectManager.getProject(payViewDO.getProjectid());
            costRecordDO.setApplyDept(project.getArea());
        }
        costRecordDO.setApprovedAmount(payViewDO.getApplyAmount());
        if (payViewDO.getNature().equals(1)) {
            costRecordDO.setCategory(5);
            costRecordDO.setCostClass(3);
            costRecordDO.setAccountDetails(9998);
        } else if (payViewDO.getNature().equals(2)) {
            costRecordDO.setCategory(10);
            costRecordDO.setCostClass(1);
            costRecordDO.setAccountDetails(9975);
        }
        costRecordDO.setAccountTime(payViewDO.getApplyDate());
        costRecordDO.setAccountDept(payViewDO.getAccountDept());
        costRecordDO.setContractNo(payViewDO.getContractNo());
        costRecordDO.setContractName(payViewDO.getContractName());
        costRecordDO.setAgentName(payViewDO.getSupplierText());
        if (payViewDO.getPayee() != null) {
            costRecordDO.setPayee(payViewDO.getPayee().toString());//????????????
        }
        costRecordDO.setBillAmount(payViewDO.getTaxAmount());
        costRecordDO.setBillSymbol(payViewDO.getTaxFlag());
        costRecordDO.setInvoiceCode(payViewDO.getInvoiceCode());
        costRecordDO.setInvoiceType(payViewDO.getInvoiceType());
        costRecordDO.setTaxNo(payViewDO.getInvoiceNumber());
        costRecordDO.setAccountCaliber(payViewDO.getAccountcaliber());
        costRecordDO.setRegistrant(payViewDO.getRegistrant());
        costRecordDO.setApplyDate(payViewDO.getRegistrantDate());
        costRecordDO.setCostType(5);//??????????????????????????????????????????
        if (costRecordDO.getInvoiceID() != null && (costRecordDO.getInvoiceCode() == null || StringUtils.isBlank(costRecordDO.getInvoiceCode())) && (costRecordDO.getTaxNo() == null || StringUtils.isBlank(costRecordDO.getTaxNo()))) {
            invoiceLibraryManager.deleteInvoiceLib(costRecordDO.getInvoiceID());
            costRecordDO.setInvoiceID(null);
        } else {
            if ((costRecordDO.getInvoiceCode() != null && StringUtils.isNotBlank(costRecordDO.getInvoiceCode())) && (costRecordDO.getTaxNo() != null && StringUtils.isNotBlank(costRecordDO.getTaxNo()))) {
                InvoiceLibDO invoiceLibDO = saveInvoiceInfo(costRecordDO);//?????????????????????
                costRecordDO.setInvoiceID(invoiceLibDO.getId());
            }
        }
        return costRecordManager.saveCostRecord(costRecordDO);
    }

    public InvoiceLibDO saveInvoiceInfo(CostRecordDO costRecordDO) {
        String invoiceCode = costRecordDO.getInvoiceCode();
        String invoiceNumber = costRecordDO.getTaxNo();
        Integer invoiceId = costRecordDO.getInvoiceID();
        List<InvoiceLibraryDO> libraryDOS = new ArrayList<>();
        InvoiceLibDO libDO = null;
        if (invoiceId == null) {//????????????
            libraryDOS = invoiceLibraryManager.findByInvocie(invoiceCode, invoiceNumber);
            libDO = new InvoiceLibDO();
            libDO.setRegistratDate(new Date());
        } else {//?????????
            libraryDOS = invoiceLibraryManager.findByIdAndInvocie(invoiceId, invoiceCode, invoiceNumber);
            libDO = invoiceLibraryManager.getInvoiceLib(invoiceId);
        }
        if (libraryDOS.size() > 0) {
            throw new ServiceException("??????????????????,????????????");
        }
        libDO.setSource(5);
        libDO.setCompanyNo(55); //?????????
        libDO.setAbbreviation("????????????"); //????????????
//        libDO.setTaxno(); ??????
        libDO.setInvoiceType(costRecordDO.getInvoiceType());
        libDO.setInvoiceCode(costRecordDO.getInvoiceCode());
        libDO.setInvoiceNumber(costRecordDO.getTaxNo());
        libDO.setAmount(costRecordDO.getApplyAmount());
        libDO.setInvoiceDate(costRecordDO.getApplyDate());
        libDO.setExpensePerson(costRecordDO.getApplicant());
        libDO.setRegistratDate(new Date());
        return invoiceLibraryManager.saveInvoiceLib(libDO);
    }

    // ????????????????????????
    private String getModifyContent(PurchaseContractDO contractDO, List<PurchaseContractPaymentViewDO> contractPaymentViewDOS, String personId, Date serverDateTime) {
        StringBuffer sb = new StringBuffer();
        StringBuffer amountSb = new StringBuffer();
        StringBuffer addSb = new StringBuffer();
        StringBuffer updateSb = new StringBuffer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(serverDateTime);
        String personName = personManager.getPerson(personId).getPersonName();
        sb.append(personName).append(" ").append(dateStr).append("\n");

        // ????????????????????????
        Integer purchaseContractId = contractDO.getPurchaseContractId();
        List<PurchaseContractPaymentViewDO> payments = purchaseContractPaymentViewDao.findAllByContractIdOrderByPaymentAccountAsc(purchaseContractId);
        // ????????????????????????????????????????????????
        if (!contractDO.getTotalAmount().equals(contractDO.getAlterAmount())) {
            amountSb.append("?????????????????????").append(contractDO.getTotalAmount()).append("????????????").append(contractDO.getAlterAmount()).append("???\n");
        }
        // ??????????????????????????????
        contractPaymentViewDOS.stream().filter(contractPaymentView -> contractPaymentView.getId() == null).forEach(contractPaymentView -> {
            addSb.append("???????????? ???????????????").append(contractPaymentView.getPaymentAccountText()).append("??? ???????????? ???").append(contractPaymentView.getPayment()).append("??? ???????????? ???").append(contractPaymentView.getRemarks()).append("???\n");
        });
        // ??????????????????????????????
        List<Integer> paymentViewIds = contractPaymentViewDOS.stream().filter(contractPaymentView -> contractPaymentView.getAlterType() != null && contractPaymentView.getAlterType() == 2).map(PurchaseContractPaymentViewDO::getId).collect(Collectors.toList());
        if (!paymentViewIds.isEmpty()) {
            Map<Integer, PurchaseContractPaymentViewDO> paymentViewMap = contractPaymentViewDOS.stream().filter(contractPaymentView -> contractPaymentView.getAlterType() != null && contractPaymentView.getAlterType() == 2).collect(Collectors.toMap(PurchaseContractPaymentViewDO::getId, purchaseContractPaymentViewDO -> purchaseContractPaymentViewDO));
            // ?????????????????????????????????
            Map<Integer, PurchaseContractPaymentViewDO> paymentMap = payments.stream().filter(payment -> paymentViewIds.contains(payment.getId())).collect(Collectors.toMap(PurchaseContractPaymentViewDO::getId, purchaseContractPaymentViewDO -> purchaseContractPaymentViewDO));

            paymentMap.forEach((id, payment) -> {
                updateSb.append("???????????? ");
                PurchaseContractPaymentViewDO paymentView = paymentViewMap.get(id);
                if (paymentView.getPaymentAccount() != payment.getPaymentAccount()) {
                    updateSb.append("??????????????? ???").append(payment.getPaymentAccountText()).append("????????? ???").append(paymentView.getPaymentAccountText()).append("??? ");
                }
                if (!paymentView.getAlterPayment().equals(payment.getPayment())) {
                    updateSb.append("??????????????? ???").append(payment.getPayment()).append("????????? ???").append(paymentView.getAlterPayment()).append("??? ");
                }
                if (!paymentView.getRemarks().equals(payment.getRemarks())) {
                    updateSb.append("??????????????? ???").append(payment.getRemarks()).append("????????? ???").append(paymentView.getRemarks()).append("??? ");
                }
                updateSb.append("\n");
            });
        }


        if (StringUtils.isNotBlank(amountSb.toString())) {
            sb.append(amountSb);
        }
        if (StringUtils.isNotBlank(updateSb.toString())) {
            sb.append(updateSb);
        }
        if (StringUtils.isNotBlank(addSb.toString())) {
            sb.append(addSb);
        }
        return sb.toString();
    }
}