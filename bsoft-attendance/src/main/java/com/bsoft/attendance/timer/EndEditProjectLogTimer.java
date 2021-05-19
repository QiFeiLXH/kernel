package com.bsoft.attendance.timer;

import com.bsoft.attendance.manager.ProjectLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-03-19 10:24
 * @Version 1.0
 * @Description
 */
@Component
public class EndEditProjectLogTimer implements Runnable{
    @Autowired
    private ProjectLogManager projectLogManager;

    @Override
    public void run(){
        projectLogManager.endEditProjectLog();
    }
}
