package com.bsoft.system.manager;

import com.bsoft.system.condition.TimeTaskQueryCnd;
import com.bsoft.system.dto.TimeTaskDTO;
import com.bsoft.system.entity.primary.TimeTaskDO;
import org.quartz.SchedulerException;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-06-29 10:36
 * @Version 1.0
 * @Description
 */
public interface TimeTaskManager {
    Page<TimeTaskDO> getTaskList(TimeTaskQueryCnd cnd);

    TimeTaskDTO get(Integer id);

    TimeTaskDO save(TimeTaskDO taskScheduleJob) throws SchedulerException;

    void remove(TimeTaskDO task);

    void removeBatch(List<TimeTaskDO> timeTaskDOList);

    void initSchedule() throws SchedulerException;

    void changeStatus(Integer jobId, String jobStatus) throws SchedulerException;

    void updateCron(Integer jobId) throws SchedulerException;

    void run(TimeTaskDO scheduleJob) throws SchedulerException;
}
