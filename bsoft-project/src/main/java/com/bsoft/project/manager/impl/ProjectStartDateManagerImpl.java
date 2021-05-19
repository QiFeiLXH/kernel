package com.bsoft.project.manager.impl;

import com.bsoft.project.entity.primary.ProjectWorkLogsDO;
import com.bsoft.project.manager.ProjectStartDateManager;
import com.bsoft.project.repository.primary.ProjectStartDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ProjectStartDateManagerImpl implements ProjectStartDateManager {
    @Autowired
    private ProjectStartDateRepository projectStartDateRepository;
    @Override
//    @Scheduled(cron = "0 */1 * * * ?")
    public void insertProjectStartDate() {
            projectStartDateRepository.saveProjectStartDate();
        }
    }


