package com.bsoft.work.manager;

import com.bsoft.work.entity.primary.MeetPersonDO;
import com.bsoft.work.entity.primary.MeetUserDO;

public interface MeetUserManager {
    MeetUserDO getMeetUser(String mobileNo);

    void saveOpenId(String mobileNo,String openId);

    MeetUserDO getMeetUserWithOpenId(String openId);

    void savePersonName(String mobile,String personName);

    /**
     * 判断对应手机号是否已存在用户表中 已使用
     */
    String havePersonExits(MeetPersonDO meetPerson);

    void deleteUser(String mobileNo);

    Boolean isMeetUser(String openId);
}
