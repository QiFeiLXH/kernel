package com.bsoft.hr.timer;

import com.bsoft.common.manager.PrimaryKeyManager;
import com.bsoft.hr.entity.primary.WorkVacationDO;
import com.bsoft.hr.entity.primary.WorkVacationDetailDO;
import com.bsoft.hr.manager.AnnualVacationManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-08-18 15:12
 * @Version 1.0
 * @Description 年假定时生成任务
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class AnnualVacationJob implements Job {
    @Autowired
    private AnnualVacationManager annualVacationManager;
    @Autowired
    private PrimaryKeyManager primaryKeyManager;

    @Override
    public void execute(JobExecutionContext arg0){
        List<WorkVacationDO> workVacations = annualVacationManager.getWorkVacations();
        List<WorkVacationDetailDO> workVacationDetails = annualVacationManager.getWorkVacationDetails(workVacations);
        Integer workVacationKey = primaryKeyManager.increaseWithSize("HR_WORK_VACATION",workVacations.size());
        Integer workVacationDetailKey = primaryKeyManager.increaseWithSize("HR_WORK_VACATION_DETAIL",workVacationDetails.size());
        workVacations = annualVacationManager.getWorkVacations(workVacations,workVacationKey,workVacationDetailKey);
        List<WorkVacationDO> workVacationsDelete = annualVacationManager.getWorkVacationsNeedDelete();
        List<WorkVacationDetailDO> workVacationDetailsDelete = annualVacationManager.getWorkVacationDetailsNeedDelete(workVacationsDelete);
        annualVacationManager.save(workVacations,workVacationsDelete,workVacationDetailsDelete);
    }
}
