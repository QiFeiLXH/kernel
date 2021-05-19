package com.bsoft.user.service.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.user.entity.primary.UserDO;
import com.bsoft.user.manager.HeadManager;
import com.bsoft.user.manager.UserManager;
import com.bsoft.user.service.HeadService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service(protocol = {"hessian","dubbo"})
public class HeadServiceImpl implements HeadService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeadServiceImpl.class);
    @Autowired
    private HeadManager headManager;
    @Autowired
    private UserManager userManager;
    @Override
    public void setHead(String userId,byte[] data,String fileName,Integer menuId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer headKey = headManager.writeHead(data,fileName,menuId);
        UserDO userDO = userManager.getUser(userId);
        userDO.setHead(headKey);
        userManager.saveUser(userDO);
        long times = timeConsumer.end();
        LOGGER.info("App用户[{}]设置头像，耗时[{}]",userId,times);
    }

    @Override
    public byte[] getHead(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        UserDO userDO = userManager.getUser(userId);
        Integer headKey;
        if (userDO.getHead() == null){
            headKey = 3353;
        } else {
            headKey = userDO.getHead();

        }
        byte[] data = headManager.readHead(headKey);
        long times = timeConsumer.end();
        LOGGER.info("获取[{}]头像，耗时[{}]",userId,times);
        return data;
    }
}
