package com.bsoft.work.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.work.condition.MeetPersonQueryCnd;
import com.bsoft.work.dao.primary.MeetPersonDao;
import com.bsoft.work.entity.primary.MeetPersonDO;
import com.bsoft.work.manager.MeetPersonManager;
import com.bsoft.work.manager.MeetUserManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class MeetPersonManagerImpl implements MeetPersonManager {
    private static final String DEFAULT_ERROR_DATA_TOKEN = "ErrorDataToken";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private MeetUserManager meetUserManager;
    @Autowired
    private MeetPersonDao meetPersonDao;

    @Override
    @Transactional
    public void saveMeetPerson(MeetPersonDO meetPersonDO) {
        String mobileNo = meetPersonDO.getMobileNo();
        String personName = meetPersonDO.getPersonName();
        if(StringUtils.isNotBlank(mobileNo) && StringUtils.isNotBlank(personName)){
            meetUserManager.savePersonName(mobileNo,personName);
        }else{
            throw new ServiceException("手机号，姓名不可为空");
        }
        if(meetPersonDO.getId() == null){
            List<MeetPersonDO> list = meetPersonDao.findByMeetIdAndMobileNo(meetPersonDO.getMeetId(),meetPersonDO.getMobileNo());
            if(list.size() > 0){
                throw new ServiceException("该人员已在此会议中");
            }
            meetPersonDao.save(meetPersonDO);
        }else{//判断修改前手机号 是否参加于会议 没有参加任意会议则删除用户表数据
            Optional<MeetPersonDO> meetPersonOp = meetPersonDao.findById(meetPersonDO.getId());
            meetPersonOp.orElseThrow(()->new ServiceException("无参会人员"));
            MeetPersonDO meetPerson = meetPersonOp.get();
            String oldMobileNo = meetPerson.getMobileNo();
            meetPersonDao.save(meetPersonDO);
            List<MeetPersonDO> list = meetPersonDao.findByMobileNo(oldMobileNo);
            if(list.size() <= 0){
                meetUserManager.deleteUser(oldMobileNo);
            }
        }
    }

    @Override
    @Transactional
    public void deleteMeetPerson(Integer id) {
        Optional<MeetPersonDO> meetPersonOp = meetPersonDao.findById(id);
        meetPersonOp.orElseThrow(()->new ServiceException("无参会人员"));
        MeetPersonDO meetPerson = meetPersonOp.get();
        String mobileNo = meetPerson.getMobileNo();
        meetPersonDao.deleteById(id);
        List<MeetPersonDO> list = meetPersonDao.findByMobileNo(mobileNo);
        if(list.size() <= 0){
            meetUserManager.deleteUser(mobileNo);
        }

    }

    @Override
    public Result<MeetPersonDO> getMeetPersons(MeetPersonQueryCnd cnd) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<MeetPersonDO> page = meetPersonDao.findAll((Specification<MeetPersonDO>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(cnd.getMeetId() != null){
                predicates.add(criteriaBuilder.equal(root.get("meetId"),cnd.getMeetId()));
            }
            if (StringUtils.isNotBlank(cnd.getInput())){
                Predicate c1 = criteriaBuilder.like(root.get("mobileNo"),"%"+cnd.getInput()+"%");
                Predicate c2 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInput()+"%");
                predicates.add(criteriaBuilder.or(c1,c2));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        },pageable);
        Result<MeetPersonDO> result = ResultUtils.parseResult(page);
        return result;
    }

    @Override
    @Transactional
    public void importMeetPersonData(String personId, List<MeetPersonDO> saveDOList, List<MeetPersonDO> errorDOList) {
        for(MeetPersonDO meetPersonDO : saveDOList){
            String mobileNo = meetPersonDO.getMobileNo();
            String personName = meetPersonDO.getPersonName();
            if(StringUtils.isNotBlank(mobileNo) && StringUtils.isNotBlank(personName)){
                meetUserManager.savePersonName(mobileNo,personName);
            }
        }
        meetPersonDao.saveAll(saveDOList);
        this.saveErrorData(personId, errorDOList);
    }

    @Override
    public List<MeetPersonDO> exportErrorData(String personId) {
        StringBuilder keySB = new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append("meetPerson").append(":").append(personId);
        String errorDataString = redisTemplate.opsForValue().get(keySB.toString());
        List<MeetPersonDO> errorData = (List<MeetPersonDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    @Override
    public List<MeetPersonDO> getMeetPersons(Integer meetId) {
        List<MeetPersonDO> list = meetPersonDao.findByMeetId(meetId);
        return list;
    }

    @Override
    public Boolean personExitsMeet(MeetPersonDO meetPersonDO) {
        List<MeetPersonDO> list = meetPersonDao.findByMeetIdAndMobileNo(meetPersonDO.getMeetId(),meetPersonDO.getMobileNo());
        if(list.size() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<String> getMeetPersonMobileNo(Integer id) {
        return meetPersonDao.getMeetPersonMobileNo(id);
    }

    /**
     * 缓存导入的错误数据
     */
    private void saveErrorData(String personId, List<MeetPersonDO> errorList) {
        StringBuilder keySB = new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append("meetPerson").append(":").append(personId);
        // 先删除redis数据
        redisTemplate.delete(keySB.toString());
        // 再重新缓存数据,并设置30min的过期时间
        redisTemplate.opsForValue().set(keySB.toString(), JSONObject.toJSONString(errorList), 30, TimeUnit.MINUTES);
    }
}
