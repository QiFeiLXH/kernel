package com.bsoft.cost.timer;

import com.bsoft.cost.manager.BankChargesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-04-09 18:50
 * @Version 1.0
 * @Description 对公费用邮件提醒定时器
 */
@Component
public class PublicExpenseRemindTimer implements Runnable {
    @Autowired
    private BankChargesManager bankChargesManager;
    @Override
    public void run() {
        bankChargesManager.sendPublicFeRemindMessage();
    }
}
