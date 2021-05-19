package com.bsoft.system.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.manager.TimerTaskStartManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.system.condition.TimeTaskQueryCnd;
import com.bsoft.system.dto.TimeTaskDTO;
import com.bsoft.system.dto.TimeTaskQueryCndDTO;
import com.bsoft.system.entity.primary.TimeTaskDO;
import com.bsoft.system.manager.TimeTaskManager;
import com.bsoft.system.service.TimeTaskService;
import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.Service;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-06-29 16:25
 * @Version 1.0
 * @Description
 */
@Service
public class TimeTaskServiceImpl implements TimeTaskService {
    private static final Logger logger = LoggerFactory.getLogger(TimeTaskServiceImpl.class);
    @Autowired
    private TimeTaskManager timeTaskManager;
    @Autowired
    private TimerTaskStartManager timerTaskStartManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<TimeTaskDTO> getTaskList(TimeTaskQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TimeTaskQueryCnd queryCnd = generatorUtil.convert(cnd, TimeTaskQueryCnd.class);
        Page<TimeTaskDO> taskDOS;
        try {
            taskDOS =  timeTaskManager.getTaskList(queryCnd);
        }catch (Exception e){
            logger.info("获取定时任务列表失败");
            throw new ServiceException("获取定时任务列表失败");
        }
        long times = timeConsumer.end();
        logger.info("获取定时任务列表成功耗时:{}",times);
        return ResultUtils.parseResult(taskDOS, TimeTaskDTO.class);
    }

    @Override
    public void saveTask(TimeTaskDTO task) {
        if(!timerTaskStartManager.isAllowStart()){
            logger.info("非指定服务器，无法对定时器进行操作");
//            throw new ServiceException("非指定服务器，无法对定时器进行操作");
            return;
        }
        TimeConsumer timeConsumer = TimeConsumer.start();
        TimeTaskDO timeTaskDO = generatorUtil.convert(task, TimeTaskDO.class);
        try {
            timeTaskDO = timeTaskManager.save(timeTaskDO);
        } catch (SchedulerException e) {
            logger.info("保存/修改id为:{}定时任务失败",timeTaskDO.getId());
            throw new ServiceException("保存定时器出错");
        }
        long times = timeConsumer.end();
        logger.info("保存/修改id为:{}定时任务成功耗时:{}", timeTaskDO.getId(),times);
    }

    @Override
    public void remove(TimeTaskDTO task) {
        if(!timerTaskStartManager.isAllowStart()){
            logger.info("非指定服务器，无法对定时器进行操作");
//            throw new ServiceException("非指定服务器，无法对定时器进行操作");
//            throw new RuntimeException("非指定服务器，无法对定时器进行操作");
            return;
        }
        if(task.getId() == null){
            logger.info("删除指定定时器失败，无ID");
            throw new ServiceException("删除指定定时器失败，无ID");
        }
        TimeConsumer timeConsumer = TimeConsumer.start();
        TimeTaskDO timeTaskDO = generatorUtil.convert(task, TimeTaskDO.class);
        try {
            timeTaskManager.remove(timeTaskDO);
        } catch (Exception e) {
            logger.info("删除id为:{}定时任务失败",task.getId());
            throw new ServiceException("删除定时器出错");
        }
        long times = timeConsumer.end();
        logger.info("删除id为:{}定时任务成功耗时:{}", timeTaskDO.getId(),times);
    }

    @Override
    public void removeBatch(List<TimeTaskDTO> timeTaskDTOList) {

    }

    @Override
    public void changeStatus(Integer jobId, String jobStatus) {
        logger.info("改变定时器状态："+jobStatus);
        if(!timerTaskStartManager.isAllowStart()){
            logger.info("非指定服务器，无法对定时器进行操作");
//            throw new ServiceException("非指定服务器，无法对定时器进行操作");
//            throw new RuntimeException("非指定服务器，无法对定时器进行操作");
            return;
        }
        TimeConsumer timeConsumer = TimeConsumer.start();
        try {
            timeTaskManager.changeStatus(jobId,jobStatus);
        } catch (SchedulerException e) {
            logger.info("禁用/启用id为:{}定时任务失败",jobId);
            throw new ServiceException("更新定时器状态出错");
        }
        long times = timeConsumer.end();
        logger.info("禁用/启用id为:{}定时任务成功耗时:{}",jobId,times);
    }

    @Override
    public TimeTaskDTO getById(Integer id) {

        TimeConsumer timeConsumer = TimeConsumer.start();
        if(id == null){
            logger.info("获取id为:{}定时任务失败",id);
            throw new ServiceException("获取指定定时器失败，无ID！");
        }
        TimeTaskDTO timeTaskDTO;
        try {
            timeTaskDTO = timeTaskManager.get(id);
        } catch (Exception e) {
            logger.info("获取id为:{}定时任务失败",id);
            throw new ServiceException("未找到指定定时器！");
        }
        long times = timeConsumer.end();
        logger.info("获取id为:{}定时任务成功耗时:{}",id,times);
        return generatorUtil.convert(timeTaskDTO, TimeTaskDTO.class);
    }
}
