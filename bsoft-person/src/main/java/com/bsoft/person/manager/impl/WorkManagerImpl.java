package com.bsoft.person.manager.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.exception.ServiceException;
import com.bsoft.person.dao.primary.EducationDao;
import com.bsoft.person.dao.primary.EmployDao;
import com.bsoft.person.dao.primary.PersonWorkedYearsDao;
import com.bsoft.person.dao.primary.WorkDao;
import com.bsoft.person.dto.WorkDTO;
import com.bsoft.person.entity.primary.EducationDO;
import com.bsoft.person.entity.primary.PersonWorkedYearsDO;
import com.bsoft.person.entity.primary.WorkDO;
import com.bsoft.person.manager.EducationManager;
import com.bsoft.person.manager.WorkManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: hy
 * @Date: 2020/7/1
 * @Description:
 */
@Component
public class WorkManagerImpl implements WorkManager {

    @Autowired
    private WorkDao workDao;

    @Autowired
    private EmployDao employDao;

    @Autowired
    private GeneratorUtil generatorUtil;

    @Autowired
    private KeyGenerator keyGenerator;

    @Autowired
    private EducationDao educationDao;
    @Autowired
    private PersonWorkedYearsDao personWorkedYearsDao;

    @Override
    public void deleteWork(Integer id) {
        Integer zpid = workDao.getById(id).getZpid();
        workDao.deleteById(id);
        computeWorkAge(zpid);
    }

    @Override
    public void saveWork(List<WorkDTO> list) {
        if(list.size() <= 0) {
            return;
        }
        List<WorkDO> workDOS = generatorUtil.convert(list,WorkDO.class);
        for (WorkDO workDO : workDOS){
            if (workDO.getId() == null){
                workDO.setId(keyGenerator.increaseWorkInfo());
            }
        }
        ValidateUtil.check(workDOS);
        workDao.saveAll(workDOS);
        computeWorkAge(workDOS.get(0).getZpid());
    }

    @Override
    public void saveWorkWithNoTransaction(List<WorkDO> list) {
        for (WorkDO workDO : list){
            if (workDO.getId() == null){
                workDO.setId(keyGenerator.increaseWorkInfo());
            }
        }
        ValidateUtil.check(list);
        workDao.saveAll(list);
        computeWorkAge(list.get(0).getZpid());
    }

    //计算工龄
    private void computeWorkAge(Integer zpid){
        List<PersonWorkedYearsDO> personWorkedYearsDOS = personWorkedYearsDao.findAllByZpid(zpid);
        if (personWorkedYearsDOS.size() > 0){
            employDao.updateWorkAge(zpid,personWorkedYearsDOS.get(0).getWorkedYears());
        }else{
            employDao.updateWorkAge(zpid,0.00);
        }
    }

    @Override
    public List<WorkDO> getWorkList(Integer recruitmentId) {
        return workDao.findAllByZpidOrderByEndDateDesc(recruitmentId);
    }

    @Override
    public List<WorkDO> getWorkList(Integer recruitmentId, Integer isInternship) {
        return workDao.findAllByZpidAndIsInternshipIsNotOrderByEndDateDesc(recruitmentId,isInternship);
    }

    @Override
    public WorkDO getWork(Integer id) {
        return workDao.getById(id);
    }

    @Override
    public List<WorkDO> getWorksWithPersonId(String personId) {
        return workDao.findByPersonId(personId);
    }
}
