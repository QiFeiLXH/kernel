package com.bsoft.cost.manager.impl;

import com.bsoft.common.key.KeyGenerator;
import com.bsoft.cost.condition.InvoiceLibraryQueryCnd;
import com.bsoft.cost.dao.primary.InvoiceLibDao;
import com.bsoft.cost.dao.primary.InvoiceLibraryDao;
import com.bsoft.cost.entity.primary.InvoiceLibDO;
import com.bsoft.cost.entity.primary.InvoiceLibraryDO;
import com.bsoft.cost.manager.InvoiceLibraryManager;
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
import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceLibraryManagerImpl implements InvoiceLibraryManager {
    @Autowired
    InvoiceLibraryDao invoiceLibraryDao;
    @Autowired
    private InvoiceLibDao invoiceLibDao;
    @Autowired
    private KeyGenerator keyGenerator;
    @Override
    public Page<InvoiceLibraryDO> getInvoiceLibraryList(InvoiceLibraryQueryCnd queryCnd) {
        Sort sort = Sort.by("invoiceDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(queryCnd.getPageNo()-1,queryCnd.getPageSize(),sort);
        Page<InvoiceLibraryDO> pages = invoiceLibraryDao.findAll(new Specification<InvoiceLibraryDO>() {
            @Override
            public Predicate toPredicate(Root<InvoiceLibraryDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Integer companyId = queryCnd.getCompanyId();
                if (companyId != null){
                    predicates.add(criteriaBuilder.equal(root.get("companyNo"),companyId));
                }
                List<Integer> types = queryCnd.getType();
                if (types != null){
                    CriteriaBuilder.In<Integer> in = criteriaBuilder.in(root.get("source"));
                    for (Integer type : types) {
                        in.value(type);
                    }
                    predicates.add(in);
                }
                if(queryCnd.getStartDate() != null && queryCnd.getEndDate() != null){
                    predicates.add(criteriaBuilder.between(root.get("invoiceDate"),queryCnd.getStartDate(),queryCnd.getEndDate()));
                }
                String inpitContent =  queryCnd.getInputContent();
                if (inpitContent != null){
                    Predicate c1 = criteriaBuilder.like(root.get("invoiceCode"), "%" + inpitContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("invoiceNumber"), "%" + inpitContent + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("pinYinCode"), "%" + inpitContent.toLowerCase() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("expensePersonText"), "%" + inpitContent + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public List<InvoiceLibraryDO> findByIdAndInvocie(Integer id, String invoiceCode, String invoiceNumber) {
        return invoiceLibraryDao.findByIdAndInvocie(id,invoiceCode,invoiceNumber);
    }

    @Override
    public List<InvoiceLibraryDO> findByInvocie(String invoiceCode, String invoiceNumber) {
        return invoiceLibraryDao.findByInvocie(invoiceCode,invoiceNumber);
    }

    @Override
    public InvoiceLibDO getInvoiceLib(Integer id) {
        return invoiceLibDao.getOne(id);
    }

    @Override
    public InvoiceLibDO saveInvoiceLib(InvoiceLibDO invoiceLibDO) {
        if (invoiceLibDO.getId() == null){
            invoiceLibDO.setId(keyGenerator.increaseInvoiceLib());
        }
        return invoiceLibDao.save(invoiceLibDO);
    }

    @Override
    public void deleteInvoiceLib(Integer id) {
        invoiceLibDao.deleteById(id);
    }
}
