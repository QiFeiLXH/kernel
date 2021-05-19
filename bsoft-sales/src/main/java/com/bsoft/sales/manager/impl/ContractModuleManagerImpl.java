package com.bsoft.sales.manager.impl;

import com.bsoft.auth.manager.UserPermissionManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.contract.manager.ContractManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.sales.condition.ContractModuleQueryCnd;
import com.bsoft.sales.condition.SalesContractAuditCnd;
import com.bsoft.sales.condition.SalesContractCheckQueryCnd;
import com.bsoft.sales.condition.SalesContractQueryCnd;
import com.bsoft.sales.dao.primary.*;
import com.bsoft.sales.entity.primary.*;
import com.bsoft.sales.manager.ContractModuleManager;
import com.bsoft.sales.repository.primary.ContractModuleProductRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Collections2;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:53
 * @Description
 */
@Service
public class ContractModuleManagerImpl implements ContractModuleManager {
    @Autowired
    private ContractProductViewDao contractProductViewDao;
    @Autowired
    private ContractModuleViewDao contractModuleViewDao;
    @Autowired
    private ContractModuleProductDao contractModuleProductDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private ContractModuleProductRepository contractModuleProductRepository;
    @Autowired
    private SalesContractViewDao salesContractViewDao;
    @Autowired
    private ContractManager contractManager;
    @Autowired
    private SalesContractModuleViewDao salesContractModuleViewDao;
    @Autowired
    private UserPermissionManager userPermissionManager;
    @Autowired
    private SalesContractModuleCheckViewDao salesContractModuleCheckViewDao;

    @Override
    public Page<ContractProducViewDO> getContractProductList(ContractModuleQueryCnd cnd) {
        Sort sort = Sort.by("deptId").ascending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<ContractProducViewDO> pages = contractProductViewDao.findAll(new Specification<ContractProducViewDO>() {
            @Override
            public Predicate toPredicate(Root<ContractProducViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("contractNo"), cnd.getContractNo()));
                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), cnd.getDeptId()));
                }
                if (StringUtils.isNotBlank(cnd.getProductName())) {
                    Predicate c1 = criteriaBuilder.like(root.get("productName"),"%" + cnd.getProductName() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("moduleNames"),"%" + cnd.getProductName() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                if (cnd.getRelationFlag() == null || cnd.getRelationFlag().isEmpty()) {
                    predicates.add(criteriaBuilder.isNull(root.get("relationFlag")));
                } else if (cnd.getRelationFlag().size() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("relationFlag"), cnd.getRelationFlag().get(0)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    public List<ContractModuleViewDO> getContractModuleList(ContractModuleQueryCnd cnd) {
        Sort sort = Sort.by("id").ascending();
        List<ContractModuleViewDO> list = contractModuleViewDao.findAll(new Specification<ContractModuleViewDO>() {
            @Override
            public Predicate toPredicate(Root<ContractModuleViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("contractNo"), cnd.getContractNo()));
                if (StringUtils.isNotBlank(cnd.getModuleName())) {
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + cnd.getModuleName() + "%"));
                }
                if (cnd.getModuleRelationFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("count"), 0));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },sort);
        return list;
    }

    @Override
    @Transactional
    public void saveContractProductModuleRelation(List<ContractModuleProductDO> saveList, List<ContractModuleProductDO> deleteList, String contractId, String personId) {
        if (saveList != null && !saveList.isEmpty()) {
            Date serverDate = serverDateManager.getServerDate();
            saveList.forEach(relationDO -> {
                relationDO.setRegister(personId);
                relationDO.setRegisterDate(serverDate);
            });
            // 保存
            contractModuleProductDao.saveAll(saveList);
        }
        if (deleteList != null && !deleteList.isEmpty()) {
            // 删除
            deleteList.forEach(relation -> {
                contractModuleProductDao.deleteByProductIdAndModuleId(relation.getProductId(), relation.getModuleId());
            });
        }
        contractModuleProductDao.flush();
        // 更新金额
        contractModuleProductRepository.updateAmountByContractId(contractId);
    }

    @Override
    public Page<SalesContractViewDO> getContractList(SalesContractQueryCnd cnd) {
        Sort sort = Sort.by("saleArea").ascending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);

        List<String> deptIds = userPermissionManager.getModuleRelationPermission(cnd.getPersonId());
        Page<SalesContractViewDO> pages = salesContractViewDao.findAll(new Specification<SalesContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesContractViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (cnd.getStartDate() != null && cnd.getEndDate() != null) {
                    predicates.add(criteriaBuilder.between(root.get("signDate"), cnd.getStartDate(), cnd.getEndDate()));
                }

                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("contractNo"),"%" + cnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractName"),"%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("merchandiserName"),"%" + cnd.getInputContent() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("merchandiser"),"%" + cnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3,c4,c5));
                }
                if (cnd.getRelationFlag() == null || cnd.getRelationFlag().isEmpty()) {
                    predicates.add(criteriaBuilder.isNull(root.get("committed")));
                } else {
                    predicates.add(criteriaBuilder.or(root.get("committed").as(Integer.class).in(cnd.getRelationFlag())));
                }
                if (!cnd.getAllPermission()) {
                    Predicate c1 = criteriaBuilder.equal(root.get("merchandiser"), cnd.getPersonId());// 登录人是跟单人
                    Predicate c2 = criteriaBuilder.equal(root.get("signer"), cnd.getPersonId());// 登录人是申请人
                    Predicate c3 = criteriaBuilder.or(root.get("saleArea").as(String.class).in(deptIds));// 登录人的合同销售区域权限
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    @Transactional
    public Integer commitContractProductModuleRelation(List<ContractModuleProductDO> saveList, List<ContractModuleProductDO> deleteList, String contractId, String personId, Integer completeFlag) {
        if (saveList != null && !saveList.isEmpty()) {
            Date serverDate = serverDateManager.getServerDate();
            saveList.forEach(relationDO -> {
                relationDO.setRegister(personId);
                relationDO.setRegisterDate(serverDate);
            });
            // 保存
            contractModuleProductDao.saveAll(saveList);
        }
        if (deleteList != null && !deleteList.isEmpty()) {
            // 删除
            deleteList.forEach(relation -> {
                contractModuleProductDao.deleteByProductIdAndModuleId(relation.getProductId(), relation.getModuleId());
            });
        }
        contractModuleProductDao.flush();
        Boolean existProducts = this.existsUnrelatedProducts(contractId);
        Boolean existModules = this.existsUnrelatedContractModules(contractId);
        if (existModules || existProducts) {
            return 0;
        } else {
            // 更新金额
            contractModuleProductRepository.updateAmountByContractId(contractId);
            // 更新合同的提交标志
            contractManager.updateCommitted(1,contractId);
            // 更新模块金额
            if (completeFlag != null && completeFlag == 2) {
                contractModuleProductRepository.updateModuleAmountByContractId(contractId);
            }
            return 1;
        }


    }

    @Override
    public List<Integer> getSalesContractModuleCount(SalesContractQueryCnd cnd) {
        String contractId = cnd.getContractId();
        String inputContent = cnd.getInputContent();
        List<Integer> relationFlag = cnd.getRelationFlag();
        if (StringUtils.isBlank(contractId)) {
            throw new ServiceException("合同编号不能为空！");
        }

        return contractModuleProductRepository.getSalesContractModuleCount(contractId, inputContent, relationFlag);
    }

    @Override
    public List<SalesContractModuleViewDO> getSalesContractModuleList(SalesContractQueryCnd cnd) {
        return contractModuleProductRepository.getSalesContractModuleList(cnd);
    }

    @Override
    public List<SalesContractAreaViewDO> getSalesContractAreaList(SalesContractAuditCnd cnd) {
        List<SalesContractAreaViewDO> list = null;

        if (cnd.getAllPermission()) {
            list = contractModuleProductRepository.getSalesContractAreaListWithAll();
        } else {
            list = contractModuleProductRepository.getSalesContractAreaListWithPersonId(cnd.getPersonId());
        }
        List<SalesContractAreaViewDO> newList = new ArrayList<>(list);
        Collection<SalesContractAreaViewDO> roots = Collections2.filter(list, x -> x.getParentDeptId() == null);
        for (SalesContractAreaViewDO dept : roots) {
            newList.remove(dept);
            this.toDeptTree(dept, list, newList);
        }
        List<SalesContractAreaViewDO> parentTree = roots.stream().collect(Collectors.toList());
        for (SalesContractAreaViewDO dept : newList) {
            parentTree.add(dept);
        }
        List<SalesContractAreaViewDO> sortedTree = parentTree.stream().sorted(Comparator.comparing(SalesContractAreaViewDO::getSortby)).collect(Collectors.toList());

        return sortedTree;
    }

    @Override
    public Page<SalesContractViewDO> getSalesContractAuditList(SalesContractAuditCnd cnd) {
        List<String> deptIds = new ArrayList<>();
        if (StringUtils.isBlank(cnd.getDeptId())) {
            // 根据工号与是否有全部权限查询该工号可以查看的部门
            List<SalesContractAreaViewDO> list = null;

            if (cnd.getAllPermission()) {
                list = contractModuleProductRepository.getSalesContractAreaListWithAll();
            } else {
                list = contractModuleProductRepository.getSalesContractAreaListWithPersonId(cnd.getPersonId());
            }
            if (CollectionUtils.isNotEmpty(list)) {
                List<String> deptList = list.stream().map(SalesContractAreaViewDO::getDeptId).collect(Collectors.toList());
                deptIds.addAll(deptList);
            }
        }
        Sort sort = Sort.by("saleArea").ascending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<SalesContractViewDO> pages = salesContractViewDao.findAll(new Specification<SalesContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesContractViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("saleArea"), cnd.getDeptId()));
                } else {
                    predicates.add(criteriaBuilder.or(root.get("saleArea").as(String.class).in(deptIds)));
                }


                if (cnd.getStartDate() != null && cnd.getEndDate() != null) {
                    predicates.add(criteriaBuilder.between(root.get("signDate"), cnd.getStartDate(), cnd.getEndDate()));
                }

                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("contractNo"),"%" + cnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractName"),"%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("merchandiserName"),"%" + cnd.getInputContent() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("merchandiser"),"%" + cnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3,c4,c5));
                }
                if (cnd.getRelationFlag() == null || cnd.getRelationFlag().isEmpty()) {
                    predicates.add(criteriaBuilder.isNull(root.get("committed")));
                } else {
                    predicates.add(criteriaBuilder.or(root.get("committed").as(Integer.class).in(cnd.getRelationFlag())));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    @Transactional
    public void auditSalesContract(String contractId) {
        contractManager.updateCommitted(2,contractId);
    }

    @Override
    @Transactional
    public void returnSalesContract(String contractId, String backReason) {
        contractManager.returnContract(contractId, backReason);
    }

    @Override
    public PageInfo<SalesContractCheckViewDO> getSalesCheckContractList(SalesContractCheckQueryCnd cnd) {
        List<SalesContractCheckViewDO> list = new ArrayList<>();
        PageHelper.startPage(cnd.getPageNo(), cnd.getPageSize());

        if (cnd.getAllPermission()) {
            list = contractModuleProductRepository.getSalesCheckContractListWithAll(cnd);
        } else {
            list = contractModuleProductRepository.getSalesCheckContractListWithPersonId(cnd);
        }
        PageInfo<SalesContractCheckViewDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Page<SalesContractModuleCheckViewDO> getSalesCheckContractModuleList(Integer pageNo, Integer pageSize, String contractId) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        Page<SalesContractModuleCheckViewDO> pages = salesContractModuleCheckViewDao.findAllByContractId(contractId,pageable);
        return pages;
    }

    @Override
    @Transactional
    public void checkSalesContract(String contractId, String personId) {
        contractManager.checkSalesContract(contractId, personId);
    }

    @Override
    public Integer getUncheckedCount(String personId, Boolean allPermission) {
        Integer count = 0;
        if (allPermission) {
            count = contractModuleProductRepository.getUncheckedCountWithAll();
        } else {
            count = contractModuleProductRepository.getUncheckedCountWithPersonId(personId);
        }
        return count;
    }

    public Boolean existsUnrelatedProducts(String contractId) {
        List<ContractProducViewDO> list = contractProductViewDao.findAllUnrelatedProductByContractId(contractId);
        return CollectionUtils.isNotEmpty(list);
    }

    public Boolean existsUnrelatedContractModules(String contractId) {
        List<ContractModuleViewDO> list = contractModuleViewDao.findAllUnrelatedModuleByContractId(contractId);
        return CollectionUtils.isNotEmpty(list);
    }

    private void toDeptTree(SalesContractAreaViewDO dept, List<SalesContractAreaViewDO> result, List<SalesContractAreaViewDO> newList) {
        String deptId = dept.getDeptId();
        List<SalesContractAreaViewDO> childrens = Collections2.filter(result, x -> x.getParentDeptId() != null && x.getParentDeptId().equals(deptId)).stream().collect(Collectors.toList());
        List<SalesContractAreaViewDO> sortedChildrens = childrens.stream().sorted(Comparator.comparing(SalesContractAreaViewDO::getSortby)).collect(Collectors.toList());

        dept.setChildren(sortedChildrens);
        for (SalesContractAreaViewDO children : childrens) {
            newList.remove(children);
            toDeptTree(children, result, newList);
        }


    }
}
