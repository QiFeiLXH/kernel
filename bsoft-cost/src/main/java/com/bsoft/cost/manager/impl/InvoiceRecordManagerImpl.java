package com.bsoft.cost.manager.impl;

import com.bsoft.cost.condition.InvoiceRecordQueryCnd;
import com.bsoft.cost.dao.primary.InvoiceContentViewDao;
import com.bsoft.cost.dao.primary.InvoiceRecordViewDao;
import com.bsoft.cost.entity.primary.InvoiceContentViewDO;
import com.bsoft.cost.entity.primary.InvoiceRecordViewDO;
import com.bsoft.cost.manager.InvoiceRecordManager;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 10:22
 * @Description
 */
@Service
public class InvoiceRecordManagerImpl implements InvoiceRecordManager {
    @Autowired
    private InvoiceRecordViewDao invoiceRecordViewDao;
    @Autowired
    private InvoiceContentViewDao invoiceContentViewDao;

    @Override
    public Page<InvoiceRecordViewDO> getInvoiceRecordList(InvoiceRecordQueryCnd cnd) {
        Sort sort = Sort.by("invoiceDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<InvoiceRecordViewDO> pages = invoiceRecordViewDao.findAll(new Specification<InvoiceRecordViewDO>() {
            @Override
            public Predicate toPredicate(Root<InvoiceRecordViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("applyDeptId"),cnd.getDeptId()));
                }
                if (cnd.getStartDate() != null && cnd.getEndDate() != null){
                    predicates.add(criteriaBuilder.between(root.get("invoiceDate"),cnd.getStartDate(),cnd.getEndDate()));
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())){
                    Predicate c1 = criteriaBuilder.like(root.get("lshid"), "%" + cnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractNo"), "%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("customerName"), "%" + cnd.getInputContent() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("customerSimpleCode"), "%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("customerSimpleCode"), "%" + cnd.getInputContent().toUpperCase() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4, c5));
                }
                if (cnd.getInvoiceFlag() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("invoiceFlag"),cnd.getInvoiceFlag()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);

        return pages;
    }

    @Override
    public List<InvoiceContentViewDO> getInvoiceContentList(Integer invoiceRecordId) {
        List<InvoiceContentViewDO> list = invoiceContentViewDao.findAllByInvoiceRecordIdOrderByIdDesc(invoiceRecordId);
        return list;
    }
}
