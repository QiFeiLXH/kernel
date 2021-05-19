package com.bsoft.person.timer;

import com.bsoft.person.entity.primary.CloudshoolRestypeBackupDO;
import com.bsoft.person.manager.CloudschoolRestypeManager;
import com.bsoft.person.manager.CloudschoolSynManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;

/**
 * 云学堂同步用户定时任务
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class CloudschoolSynchronizationJob implements Job {
    @Autowired
    private CloudschoolSynManager cloudschoolSynManager;
    @Autowired
    private CloudschoolRestypeManager cloudschoolRestypeManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        //同步岗位
        cloudschoolRestypeManager.SyncRestype();
        //切勿打乱同步顺序，同步用户
        try {
            cloudschoolSynManager.SyncSavePersonnel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cloudschoolSynManager.SyncTransferPersonnel();
        cloudschoolSynManager.SyncQuitPersonnel();
    }
}
