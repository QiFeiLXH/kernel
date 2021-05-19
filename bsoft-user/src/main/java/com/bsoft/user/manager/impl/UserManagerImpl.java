package com.bsoft.user.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.exception.ServiceException;
import com.bsoft.user.condition.UserBoundQueryCnd;
import com.bsoft.user.dao.primary.AppBoundDao;
import com.bsoft.user.dao.primary.PersonContactDao;
import com.bsoft.user.dao.primary.UserDao;
import com.bsoft.user.entity.primary.AppBoundDO;
import com.bsoft.user.entity.primary.PersonContactDO;
import com.bsoft.user.entity.primary.UnbindDO;
import com.bsoft.user.entity.primary.UserDO;
import com.bsoft.user.manager.BinderManager;
import com.bsoft.user.manager.UnbindManager;
import com.bsoft.user.manager.UserManager;
import com.bsoft.user.service.AppTokenService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BinderManager binderManager;
    @Autowired
    private AppBoundDao appBoundDao;
    @Autowired
    private PersonContactDao personContactDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private UnbindManager unbindManager;
    @Reference
    ServerDateService serverDateService;
    @Reference
    AppTokenService appTokenService;
    @Override
    @Transactional
    public void saveUser(UserDO userDO) {
        userDao.save(userDO);
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public UserDO getUser(String userId) {
        Optional<UserDO> userDO = userDao.findById(userId);
        UserDO user = userDO.orElseThrow(()-> new ServiceException("找不到该用户"));
        return user;
    }

    @Override
    public List<UserDO> getAllUser() {
        List<UserDO> users = userDao.findAll();
        return users;
    }

    @Override
    public List<UserDO> getValidUser() {
        Specification specification = new Specification<UserDO>() {
            @Override
            public Predicate toPredicate(Root<UserDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("status"), 1);
            }
        };

        List<UserDO> users = userDao.findAll(specification);
        return users;
    }

    @Override
    public Boolean validatePassword(String userId, String password) {
        Optional<UserDO> user = userDao.findById(userId);
        if (user.isEmpty()){
            return false;
        }
        if (user.get().getStatus() == 0){
            return false;
        }
        if (user.isPresent() && !StringUtils.isBlank(password)) {
            return user.get().getPassword().equals(password);
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean validatePassword(String userId, String password, String deviceId,String model) {
        if(validatePassword(userId,password) && binderManager.validateDevice(userId,deviceId)){
            if(!binderManager.isBindApp(userId)){
                binderManager.bindApp(userId,deviceId);
                PersonContactDO personContactDO = personContactDao.getAllByPersonid(userId);
                personContactDO.setPhoneModel(model);
                Date currentDate = serverDateService.getServerDateTime();
                personContactDO.setAppbindDate(currentDate);
                personContactDao.save(personContactDO);
            }
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean validatePassword(String userId, String password, String deviceId, String model, String phoneSystem, String address, String latitude, String longitude) {
        if(validatePassword(userId,password) && binderManager.validateDevice(userId,deviceId)){
            if(!binderManager.isBindApp(userId)){
                binderManager.bindApp(userId,deviceId);
                PersonContactDO personContactDO = personContactDao.getAllByPersonid(userId);
                personContactDO.setPhoneModel(model);
                Date currentDate = serverDateService.getServerDateTime();
                personContactDO.setAppbindDate(currentDate);
                personContactDO.setAppMobileSystem(phoneSystem);
                personContactDO.setAppRegistPlace(address);
                personContactDO.setAppRegistLatitude(latitude);
                personContactDO.setAppRegistLongitude(longitude);
                personContactDao.save(personContactDO);
            }
            return true;
        }
        return false;
    }

    @Override
    public Page<AppBoundDO> getAppBindList(UserBoundQueryCnd queryCnd) {
        Sort sort = Sort.by("appbindDate").descending();
        Pageable pageable = PageRequest.of(queryCnd.getPageNo()-1,queryCnd.getPageSize(),sort);
        Page<AppBoundDO> pages = appBoundDao.findAll(new Specification<AppBoundDO>() {
            @Override
            public Predicate toPredicate(Root<AppBoundDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                String inpitContent =  queryCnd.getInputContent();
                if (inpitContent != null){
                    Predicate c1 = criteriaBuilder.like(root.get("personName"), "%" + inpitContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinYinCode"), "%" + inpitContent.toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.equal(root.get("personId"), inpitContent);
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if(queryCnd.getLogoff() != null){
                    predicates.add(criteriaBuilder.equal(root.get("logoff"),queryCnd.getLogoff()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public void batchUnBound(List<String> ids,String unbinder) {
        List<UserDO> userDOS = userDao.getAllByIdIn(ids);
        List<PersonContactDO> personContactDOS = personContactDao.getAllByPersonidIn(ids);
        userDao.batchUnBound(ids);
        personContactDao.batchUnBound(ids);
        Date now = serverDateManager.getServerDateTime();
        List<UnbindDO> unbindDOS = new ArrayList<>();
        for (String personId:ids){
            //解绑，删除token缓存
            appTokenService.removeToken(personId);
            //管理员解绑同时记录解绑信息
            UnbindDO unbindDO = initUnbindSave(userDOS,personContactDOS,personId,unbinder,now);
            unbindDOS.add(unbindDO);
        }
        unbindManager.saveAll(unbindDOS);
    }

    public UnbindDO initUnbindSave(List<UserDO> userDOS,List<PersonContactDO> personContactDOS,String personId,String unbinder,Date now){
        UnbindDO unbindDO = new UnbindDO();
        unbindDO.setPersonId(personId);
        unbindDO.setReason("管理员解绑");
        unbindDO.setAuditflag(1);
        unbindDO.setAuditter(unbinder);
        unbindDO.setAuditDate(now);
        unbindDO.setApplyDate(now);
        userDOS.forEach(userDO -> {
            if(userDO.getId().equals(personId)){
                unbindDO.setAppDevice(userDO.getAppdevice());
            }
        });
        personContactDOS.forEach(personContactDO -> {
            unbindDO.setPhoneModel(personContactDO.getPhoneModel());
            unbindDO.setAppbindDate(personContactDO.getAppbindDate());
        });
        return unbindDO;
    }
}
