package com.bsoft.sales.report.timer;

import com.bsoft.sales.report.processor.SalesDynamicProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SalesDynamicTimer {
    private static final Logger logger = LoggerFactory.getLogger(SalesDynamicTimer.class);

    @Autowired
    private SalesDynamicProcessor salesDynamicProcessor;

//    @Scheduled(cron="* 0/10 * * * ?")
    public void process(){
        salesDynamicProcessor.process();
        salesDynamicProcessor.doSave();
    }
}
