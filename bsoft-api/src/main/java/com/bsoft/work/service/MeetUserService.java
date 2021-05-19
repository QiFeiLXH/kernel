package com.bsoft.work.service;

import com.bsoft.work.dto.MeetUserDTO;

public interface MeetUserService {
    MeetUserDTO getMeetUser(String mobileNo);

    void saveOpenId(String mobileNo,String openId);

    void sendMessageCode(String mobileNo);

    MeetUserDTO verifyMessageCode(String mobileNo, String messageCode, String openId);

    MeetUserDTO getMeetPassWithOpenId(String openId);

    Boolean isMeetUser(String openId);
}
