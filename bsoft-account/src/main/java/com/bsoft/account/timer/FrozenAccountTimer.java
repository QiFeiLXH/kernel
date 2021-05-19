package com.bsoft.account.timer;

import com.bsoft.account.manager.AccountFrozenInfoManager;
import com.bsoft.account.manager.AccountFrozenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-04-24 15:21
 * @Version 1.0
 * @Description
 */
@Component
public class FrozenAccountTimer implements  Runnable{
    private static final Logger logger = LoggerFactory.getLogger(FrozenAccountTimer.class);
    @Autowired
    private AccountFrozenManager accountFrozenManager;

    @Override
    public void run() {
        logger.info("开始处理冻结信息");
        accountFrozenManager.process();
        logger.info("处理冻结信息完毕--------------保存冻结信息");
        accountFrozenManager.doSave();
        logger.info("保存冻结信息完毕");
    }
}
