package com.bsoft.common.manager.impl;

import com.bsoft.common.condition.ModifyRecordQueryCnd;
import com.bsoft.common.dao.primary.ModifyRecordDao;
import com.bsoft.common.dao.primary.ModifyRecordViewDao;
import com.bsoft.common.entity.primary.ModifyRecordDO;
import com.bsoft.common.entity.primary.ModifyRecordViewDO;
import com.bsoft.common.manager.ModifyRecordManager;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 9:35
 * @Description
 */
@Service
public class ModifyRecordManagerImpl implements ModifyRecordManager {
    @Autowired
    private ModifyRecordDao modifyRecordDao;
    @Autowired
    private ModifyRecordViewDao modifyRecordViewDao;

    @Override
    @Transactional
    public void saveAttendanceModifyRecords(List<ModifyRecordDO> recordDOS) {
        modifyRecordDao.saveAll(recordDOS);
    }

    @Override
    @Transactional
    public Integer saveModifyRecord(ModifyRecordDO recordDO) {
        modifyRecordDao.saveAndFlush(recordDO);
        return recordDO.getId();
    }

    @Override
    public Page<ModifyRecordViewDO> getModifyRecordList(ModifyRecordQueryCnd cnd) {
        Sort sort = Sort.by("modifyDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<ModifyRecordViewDO> pages = modifyRecordViewDao.findAll(new Specification<ModifyRecordViewDO>() {
            @Override
            public Predicate toPredicate(Root<ModifyRecordViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("modifyPersonId"),cnd.getModifyPersonId())); // 修改人
                predicates.add(criteriaBuilder.equal(root.get("modifyDetail"),cnd.getModifyDetail())); // 修改明细
                predicates.add(criteriaBuilder.equal(root.get("mainId"),cnd.getMainId())); // 主表id
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public void deleteModifyRecord(Integer ModifyId) {
        modifyRecordDao.deleteById(ModifyId);
    }


}
