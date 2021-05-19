package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.manager.PGradeAndTGradeManager;
import com.bsoft.project.report.repository.primary.PGradeAndTGradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-06 17:48
 * @Version 1.0
 * @Description
 */
@Component
public class PGradeAndTGradeManagerImpl implements PGradeAndTGradeManager {
    private final static Logger logger = LoggerFactory.getLogger(PGradeAndTGradeManagerImpl.class);
    @Autowired
    private PGradeAndTGradeRepository repository;
    @Override
    public List<String> findAllTGrade() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<String> returnList = repository.findAllTGrade();
        long times = timeConsumer.end();
        logger.info("方法名:{}获取全部T等级:{}",new Object[]{"findAllTGrade",times});
        return returnList;

    }

    @Override
    public List<String> findAllPGrade() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<String> returnList = repository.findAllPGrade();
        long times = timeConsumer.end();
        logger.info("方法名:{}获取全部P等级:{}",new Object[]{"findAllPGrade",times});
        return returnList;
    }
}
