package com.bsoft.project.report.timer;

import com.bsoft.common.lock.RedisLocker;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.entity.primary.ManpowerCostPDO;
import com.bsoft.project.report.manager.ManpowerCostPManager;
import com.bsoft.project.report.processor.ManpowerCostPProcessor;
import com.bsoft.project.report.processor.ManpowerCostTProcessor;
import com.bsoft.project.report.processor.ReimbursementBonusProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Auther: hy
 * @Date: 2019/12/11
 * @Description:
 */
@Component
public class HistoryDataTimer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HistoryDataTimer.class);

    @Autowired
    private ManpowerCostPProcessor manpowerCostPProcessor;

    @Autowired
    private ManpowerCostTProcessor manpowerCostTProcessor;

    @Autowired
    private ReimbursementBonusProcessor reimbursementBonusProcessor;

    @Autowired
    private ManpowerCostPManager manpowerCostPManager;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ServerDateManager serverDateManager;

    @Autowired
    private RedisLocker redisLocker;

    private static final String ENGINEERING_LOCK_KEY = "EngineeringService:lastDate";

    private static final String ENGINEERING_LOCK = "EngineeringService:lock";

    //@Scheduled(cron = "0 0 * * * ?")
    //@Scheduled(fixedRate = 240000)
//    @Scheduled(cron = "0 24 * * * ?")
    public void process() {

        TimeConsumer timeConsumer = TimeConsumer.start();

        String requestId = redisLocker.getRequestId();

        redisLocker.lock(ENGINEERING_LOCK, requestId);

        ManpowerCostPDO pdo = manpowerCostPManager.findNewest();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
        String nowDate = serverDateManager.getServerDate().toLocalDate().format(dtf) + "-01";
        try {
            if (pdo != null) {
                LocalDate lastDate = pdo.getMonth();
                String cacheDate = redisTemplate.opsForValue().get(ENGINEERING_LOCK_KEY);
                if (!(redisTemplate.hasKey(ENGINEERING_LOCK_KEY) && lastDate.toString().equals(cacheDate))) {
                    this.saveOrUpdateData(nowDate);
                }
            } else {
                this.saveOrUpdateData(nowDate);
            }

        } finally {
            redisLocker.releaseLock(ENGINEERING_LOCK, requestId);
        }

        LOGGER.info("工程服务历史数据总体用时：{}", timeConsumer.end());
    }

    private void saveOrUpdateData(String nowDate) {
        manpowerCostPProcessor.process();
        manpowerCostTProcessor.process();
        reimbursementBonusProcessor.process();

        manpowerCostTProcessor.saveOrUpdateData();
        manpowerCostPProcessor.saveOrUpdateData();
        reimbursementBonusProcessor.saveOrUpdateData();
        redisTemplate.opsForValue().set(ENGINEERING_LOCK_KEY, nowDate);
    }

}
