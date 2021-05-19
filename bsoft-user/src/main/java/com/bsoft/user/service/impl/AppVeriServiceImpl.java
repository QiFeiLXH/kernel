package com.bsoft.user.service.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.user.manager.AppVeriManager;
import com.bsoft.user.service.AppVeriService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xucl
 * @DateTime: 2020/7/23 14:16
 * @Description: App登录验证
 */
@Service
public class AppVeriServiceImpl implements AppVeriService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppVeriServiceImpl.class);

    @Autowired
    private AppVeriManager appVeriManager;

    @Override
    public void setVeriInfo(String uuid, String mapString, long timeout, TimeUnit unit) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        appVeriManager.setVeriInfo(uuid,mapString,timeout,unit);
        long times = timeConsumer.end();
        LOGGER.info("设置[{}]App登录验证错误信息[{}]，耗时[{}]！",uuid,mapString,times);
    }

    @Override
    public String getVeriInfo(String uuid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        String s = appVeriManager.getVeriInfo(uuid);
        long times = timeConsumer.end();
        LOGGER.info("获取[{}]App登录验证错误信息，耗时[{}]！",uuid,times);
        return s;
    }

    @Override
    public void removeVeriInfo(String uuid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        appVeriManager.removeVeriInfo(uuid);
        long times = timeConsumer.end();
        LOGGER.info("删除[{}]App登录错误信息耗时[{}]！",uuid,times);
    }

    @Override
    public Boolean hasVeriInfo(String uuid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Boolean flag = appVeriManager.hasVeriInfo(uuid);
        long times = timeConsumer.end();
        LOGGER.info("判断是否有[{}]的App登录错误信息，耗时[{}]!",uuid,times);
        return flag;

    }

    @Override
    public void setVerifyCode(String uuid, String code, long timeout, TimeUnit unit) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        appVeriManager.setVerifyCode(uuid,code,timeout,unit);
        long times = timeConsumer.end();
        LOGGER.info("设置用户[{}]验证码[{}]耗时[{}]",uuid,code,times);
    }

    @Override
    public String getVerifyCode(String uuid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        String code = appVeriManager.getVerifyCode(uuid);
        long times = timeConsumer.end();
        LOGGER.info("获取用户[{}]验证码耗时[{}]",uuid,times);
        return code;
    }
}
