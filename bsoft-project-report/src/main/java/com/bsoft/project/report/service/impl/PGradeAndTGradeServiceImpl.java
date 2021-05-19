package com.bsoft.project.report.service.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.manager.PGradeAndTGradeManager;
import com.bsoft.project.report.service.PGradeAndTGradeService;
import org.apache.dubbo.config.annotation.Service;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-08 10:05
 * @Version 1.0
 * @Description
 */
@Service
public class PGradeAndTGradeServiceImpl implements PGradeAndTGradeService {
    private final static Logger logger = LoggerFactory.getLogger(PGradeAndTGradeServiceImpl.class);
    @Autowired
    private PGradeAndTGradeManager pGradeAndTGradeManager;
    @Override
    public List<String> findAllTGrade() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<String> returnList = pGradeAndTGradeManager.findAllTGrade();
        long times = timeConsumer.end();
        logger.info("获取全部T等级耗时:{}",times);
        return returnList;
    }

    @Override
    public List<String> findAllPGrade() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<String> returnList = pGradeAndTGradeManager.findAllPGrade();
        long times = timeConsumer.end();
        logger.info("获取全部P等级耗时:{}",times);
        return returnList;
    }
}
