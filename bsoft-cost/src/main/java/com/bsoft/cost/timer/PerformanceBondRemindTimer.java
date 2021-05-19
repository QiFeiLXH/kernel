package com.bsoft.cost.timer;

import com.bsoft.cost.manager.BondManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-04-09 18:50
 * @Version 1.0
 * @Description 保证金未冲账邮件提醒
 */
@Component
public class PerformanceBondRemindTimer implements Runnable {
    @Autowired
    private BondManager bondManager;
    @Override
    public void run() {
        bondManager.sendPerformanceBondRemindMessage();
    }
}
