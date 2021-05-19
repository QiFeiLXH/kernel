package com.bsoft.work.manager.impl;

import com.bsoft.exception.ServiceException;
import com.bsoft.work.dao.primary.MeetUserDao;
import com.bsoft.work.entity.primary.MeetPersonDO;
import com.bsoft.work.entity.primary.MeetUserDO;
import com.bsoft.work.manager.MeetUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class MeetUserManagerImpl implements MeetUserManager {
    @Autowired
    private MeetUserDao meetUserDao;

    @Override
    public MeetUserDO getMeetUser(String mobileNo) {
        Optional<MeetUserDO> meetUser = meetUserDao.findById(mobileNo);
        meetUser.orElseThrow(()->new ServiceException("无对应参会证"));
        return meetUser.get();
    }

    @Override
    public void saveOpenId(String mobileNo, String openId) {
        Optional<MeetUserDO> meetUserOp = meetUserDao.findById(mobileNo);
        meetUserOp.orElseThrow(()->new ServiceException("无对应参会证"));
        MeetUserDO meetUser = meetUserOp.get();
        meetUser.setOpenId(openId);
        meetUser.setBindDate(new Date());
        meetUserDao.save(meetUser);
    }

    @Override
    public MeetUserDO getMeetUserWithOpenId(String openId) {
        List<MeetUserDO> result = meetUserDao.findByOpenId(openId);
        if(!result.isEmpty()){
            return result.get(0);
        }else{
            throw new ServiceException("无该openId用户");
        }

    }

    @Override
    public void savePersonName(String mobileNo, String personName) {
        MeetUserDO meetUserDO = meetUserDao.findById(mobileNo).orElse(null);
        if(meetUserDO == null){
            meetUserDO = new MeetUserDO();
            meetUserDO.setMobileNo(mobileNo);
            meetUserDO.setPersonName(personName);
        }else{
            meetUserDO.setPersonName(personName);
        }
        meetUserDao.save(meetUserDO);
    }

    @Override
    public String havePersonExits(MeetPersonDO meetPerson) {
        String mobileNo = meetPerson.getMobileNo();
        MeetUserDO meetUserDO = meetUserDao.findById(mobileNo).orElse(null);
        if(meetUserDO == null){
            return null;
        }else{
            String exitsName = meetUserDO.getPersonName();
            return exitsName;
        }
    }

    @Override
    public void deleteUser(String mobileNo) {
        Optional<MeetUserDO> meetUserOp = meetUserDao.findById(mobileNo);
        meetUserOp.orElseThrow(()->new ServiceException("无对应参会证"));
        meetUserDao.deleteById(mobileNo);
    }

    @Override
    public Boolean isMeetUser(String openId) {
        List<MeetUserDO> list = meetUserDao.findByOpenId(openId);
        if(list.isEmpty()) return false;
        return true;
    }
}
