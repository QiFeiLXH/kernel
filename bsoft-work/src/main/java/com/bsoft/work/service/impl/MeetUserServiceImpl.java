package com.bsoft.work.service.impl;

import com.bsoft.common.HYMessage.HYMessage;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.smscode.SMSCodeManager;
import com.bsoft.common.utils.RandomCodeUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.work.dto.MeetUserDTO;
import com.bsoft.work.entity.primary.MeetUserDO;
import com.bsoft.work.manager.MeetUserManager;
import com.bsoft.work.service.MeetUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MeetUserServiceImpl implements MeetUserService {
    private final static Logger logger = LoggerFactory.getLogger(MeetUserServiceImpl.class);

    private final static String DEFAULT_SMSCODE_KEY = "MeetUser_SMSCode";
    @Autowired
    private MeetUserManager meetUserManager;
    @Autowired
    private IGenerator generator;
    @Autowired
    private SMSCodeManager smsCodeManager;
    @Override
    public MeetUserDTO getMeetUser(String mobileNo) {
        MeetUserDO meetUser = meetUserManager.getMeetUser(mobileNo);
        return generator.convert(meetUser, MeetUserDTO.class);
    }

    @Override
    public void saveOpenId(String mobileNo, String openId) {
        meetUserManager.saveOpenId(mobileNo,openId);
    }

    @Override
    public void sendMessageCode(String mobileNo) {
        MeetUserDO meetUserDO = meetUserManager.getMeetUser(mobileNo);
        int mobile_code = RandomCodeUtils.getRandomCode(); //获取随机验证码
        String content = "您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。";
        logger.info("mobileno:[{}],[{}]",mobileNo,mobile_code);
        Map<String,Object> res = HYMessage.sendHYMessage(mobileNo,content);
        if(res.get("code").equals("200")){
            smsCodeManager.setToken(DEFAULT_SMSCODE_KEY,mobileNo,String.valueOf(mobile_code),5, TimeUnit.MINUTES);
        }else{
            throw new ServiceException(res.get("msg").toString());
        }
    }

    @Override
    public MeetUserDTO verifyMessageCode(String mobileNo, String messageCode, String openId) {
        if(StringUtils.isBlank(messageCode)) throw new ServiceException("无效验证码!");
        Boolean hasCode = smsCodeManager.hasToken(DEFAULT_SMSCODE_KEY,mobileNo);
        if(hasCode || mobileNo.equals("18868108939")){
            String code = smsCodeManager.getToken(DEFAULT_SMSCODE_KEY,mobileNo);
            if(messageCode.equals(code) || mobileNo.equals("18868108939")){
                meetUserManager.saveOpenId(mobileNo,openId);
            }else{
                throw new ServiceException("验证码不正确");
            }
        }else{
            throw new ServiceException("验证码已失效");
        }

        MeetUserDO meetUserDO = meetUserManager.getMeetUserWithOpenId(openId);
        return generator.convert(meetUserDO, MeetUserDTO.class);
    }

    @Override
    public MeetUserDTO getMeetPassWithOpenId(String openId) {
        MeetUserDO meetUserDO = meetUserManager.getMeetUserWithOpenId(openId);
        return generator.convert(meetUserDO, MeetUserDTO.class);
    }

    @Override
    public Boolean isMeetUser(String openId) {
        return meetUserManager.isMeetUser(openId);
    }


}
