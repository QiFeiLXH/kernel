package com.bsoft.user.manager.impl;

import com.bsoft.exception.ServiceException;
import com.bsoft.user.condition.UnbindQueryCnd;
import com.bsoft.user.dao.primary.PersonContactDao;
import com.bsoft.user.dao.primary.UnbindDao;
import com.bsoft.user.dao.primary.UnbindViewDao;
import com.bsoft.user.dao.primary.UserDao;
import com.bsoft.user.entity.primary.PersonContactDO;
import com.bsoft.user.entity.primary.UnbindDO;
import com.bsoft.user.entity.primary.UnbindViewDO;
import com.bsoft.user.entity.primary.UserDO;
import com.bsoft.user.manager.UnbindManager;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UnbindManagerImpl implements UnbindManager {
    @Autowired
    private UnbindDao unbindDao;
    @Autowired
    private UnbindViewDao unbindViewDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PersonContactDao personContactDao;

    @Override
    public void saveAll(List<UnbindDO> unbinds) {
        unbindDao.saveAll(unbinds);
    }

    @Override
    public UnbindDO saveUnbind(UnbindDO unbindDO) {
        PersonContactDO personContactDO = personContactDao.getAllByPersonid(unbindDO.getPersonId());
        unbindDO.setAppbindDate(personContactDO.getAppbindDate());
        return unbindDao.save(unbindDO);
    }

    @Override
    public UnbindDO getUnbind(String personId) {
        List<UnbindDO> list = unbindDao.findByPersonIdAndAuditflag(personId,0);
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public UnbindDO getUnbind(Integer id) {
        Optional<UnbindDO> unbindDO = unbindDao.findById(id);
        UnbindDO unbind = unbindDO.orElseThrow(()->new ServiceException("没有该解绑信息!"));
        return unbind;
    }

    @Override
    public void unBindApp(String personId) {
        Optional<UserDO> userOp = userDao.findById(personId);
        UserDO user = userOp.orElseThrow(()->new ServiceException("解绑用户不存在!"));
        user.setAppdevice("");
        userDao.save(user);
    }

    @Override
    public Page<UnbindViewDO> getUnbind(String personId, Integer auditFlag, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<UnbindViewDO> result = unbindViewDao.findAll(new Specification<UnbindViewDO>() {
            @Override
            public Predicate toPredicate(Root<UnbindViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate3 = null;
                Predicate predicate1 = null;
                if(auditFlag.equals(10)){
                    predicate1 = criteriaBuilder.in(root.get("auditflag")).value(1).value(2).value(0);
                }else if(auditFlag.equals(9)){
                    predicate1 = criteriaBuilder.in(root.get("auditflag")).value(1).value(2);
                }else{
                    predicate1 = criteriaBuilder.equal(root.get("auditflag"),auditFlag);
                }
                if(StringUtils.isNotBlank(personId)){
                    Predicate predicate2 = criteriaBuilder.equal(root.get("personId"),personId);
                    predicate3 = criteriaBuilder.and(predicate1,predicate2);
                }else{
                    predicate3 = predicate1;
                }
                return predicate3;
            }
        },pageable);
        return result;
    }

    @Override
    public UnbindViewDO getUnbindView(Integer id) {
        Optional<UnbindViewDO> unbindOp = unbindViewDao.findById(id);
        UnbindViewDO unbind = unbindOp.orElseThrow(()->new ServiceException("没有该解绑信息!"));
        return unbind;
    }

    @Override
    public Page<UnbindViewDO> getUnbindList(UnbindQueryCnd queryCnd) {
        Sort sort = Sort.by("applyDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(queryCnd.getPageNo()-1,queryCnd.getPageSize(),sort);
        Page<UnbindViewDO> pages = unbindViewDao.findAll(new Specification<UnbindViewDO>() {
            @Override
            public Predicate toPredicate(Root<UnbindViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Integer auditFlag = queryCnd.getAuditFlag();
                if (auditFlag == 9){//已审核
                    predicates.add(criteriaBuilder.in(root.get("auditflag")).value(1).value(2));
                }else{
                    predicates.add(criteriaBuilder.equal(root.get("auditflag"),auditFlag));
                }
                if(queryCnd.getStartDate() != null && queryCnd.getEndDate() != null){
                    predicates.add(criteriaBuilder.between(root.get("applyDate"),queryCnd.getStartDate(),queryCnd.getEndDate()));
                }
                String inpitContent =  queryCnd.getInputContent();
                if (inpitContent != null){
                    Predicate c1 = criteriaBuilder.like(root.get("personName"), "%" + inpitContent + "%");
                    Predicate c2 = criteriaBuilder.equal(root.get("personId"),  inpitContent);
                    Predicate c3 = criteriaBuilder.like(root.get("pinyinCode"), "%" + inpitContent.toLowerCase() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }
}
