package com.bsoft.system.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.system.condition.TimeTaskQueryCnd;
import com.bsoft.system.dao.primary.TimeTaskDao;
import com.bsoft.system.dto.TimeTaskDTO;
import com.bsoft.system.entity.primary.TimeTaskDO;
import com.bsoft.system.enums.JobStatusEnum;
import com.bsoft.system.manager.QuartzManager;
import com.bsoft.system.manager.TimeTaskManager;
import com.bsoft.workflow.entity.primary.GroupRoleDO;
import org.apache.commons.lang3.StringUtils;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhanglf
 * @Date 2020-06-29 10:38
 * @Version 1.0
 * @Description
 */
@Component
public class TimeTaskManagerImpl implements TimeTaskManager {
    private final static Logger logger = LoggerFactory.getLogger(TimeTaskManagerImpl.class);
    @Autowired
    private TimeTaskDao timeTaskDao;
    @Autowired
    private QuartzManager quartzManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Page<TimeTaskDO> getTaskList(TimeTaskQueryCnd cnd) {
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize());
        Page<TimeTaskDO> pages = timeTaskDao.findAll(new Specification<TimeTaskDO>() {
            @Override
            public Predicate toPredicate(Root<TimeTaskDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(cnd.getContext())){
                    Predicate predicate1 = criteriaBuilder.like(root.get("description"),'%'+cnd.getContext()+'%');
                    Predicate predicate2 = criteriaBuilder.like(root.get("taskName"),'%'+cnd.getContext()+'%');
                    Predicate predicate3 = criteriaBuilder.or(predicate1,predicate2);
                    predicates.add(predicate3);
                }
                if(cnd.getTaskType() != null){
                    predicates.add(criteriaBuilder.equal(root.get("taskType"),cnd.getTaskType()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
//        List<TimeTaskDO> content = pages.getContent();
//        List<TimeTaskDTO> convert = iGenerator.convert(content, TimeTaskDTO.class);
//        this.setCcpersonName(pages.getContent());
//        this.setReceiveName(pages.getContent());
        return pages;
    }

    @Override
    public TimeTaskDTO get(Integer id) {
        TimeTaskDO timeTaskDO = timeTaskDao.findById(id).get();
        TimeTaskDTO convert = iGenerator.convert(timeTaskDO, TimeTaskDTO.class);
        this.setReceiveName(convert);
        this.setCcpersonName(convert);
        return convert;
    }

    @Override
    public TimeTaskDO save(TimeTaskDO task) throws SchedulerException {
        if(task.getId() == null){
            task.setCreateTime(serverDateManager.getServerDateTime());
            task = timeTaskDao.save(task);
            if (JobStatusEnum.RUNNING.getCode().equals(task.getStatus())) {
                //判断定时任务是否有调用类和表达式（无调用类或者表达式，则需要手动修改程序定时器）
                if(StringUtils.isNotBlank(task.getBeanClass()) && StringUtils.isNotBlank(task.getExpression())){
                    quartzManager.addJob(task);
                }
            }
        }else{
            TimeTaskDO oldTimeTask = timeTaskDao.findById(task.getId()).get();
            task.setUpdateTime(serverDateManager.getServerDateTime());
            task = timeTaskDao.save(task);
            if (JobStatusEnum.STOP.getCode().equals(task.getStatus())) {
                quartzManager.deleteJob(task);
            } else {
                //判断定时任务是否有调用类和表达式（无调用类或者表达式，则需要手动修改程序定时器
                if(StringUtils.isNotBlank(task.getBeanClass()) && StringUtils.isNotBlank(task.getExpression())){
                    //定时器上一状态为禁用状态才添加定时器，否则重复添加任务会抛出异常
                    if (JobStatusEnum.STOP.getCode().equals(oldTimeTask.getStatus())){
                        quartzManager.addJob(task);
                    }else if(!task.getTaskName().equals(oldTimeTask.getTaskName()) || !task.getTaskGroup().equals(oldTimeTask.getTaskGroup())){
                        //如果任务名成或者任务分组有变化，则去除oldTimeTask，添加新的定时器任务
                        quartzManager.deleteJob(oldTimeTask);
                        quartzManager.addJob(task);
                    }else{ //定时器上一状态为启用状态时，不重复添加任务，更新执行表达式
                        quartzManager.updateJobCron(task);
                    }
                }
            }
        }
        return task;
    }

    @Override
    public void remove(TimeTaskDO task) {
        timeTaskDao.delete(task);
    }

    @Override
    public void removeBatch(List<TimeTaskDO> timeTaskDOS) {
        timeTaskDao.deleteInBatch(timeTaskDOS);
    }

    @Override
    public void initSchedule() {
        // 这里获取任务信息数据
        List<TimeTaskDO> jobList = timeTaskDao.findAll();
        for (TimeTaskDO task : jobList) {
            if (JobStatusEnum.RUNNING.getCode().equals(task.getStatus())) {
                //判断定时任务是否有调用类和表达式（无调用类或者表达式，则需要手动修改程序定时器）
                if(StringUtils.isNotBlank(task.getBeanClass()) && StringUtils.isNotBlank(task.getExpression())){
                    quartzManager.addJob(task);
                }
            }
        }
    }

    @Override
    public void changeStatus(Integer jobId, String jobStatus) throws SchedulerException {
        logger.info("改变定时器状态："+jobStatus);
        TimeTaskDTO taskDTO = get(jobId);
        TimeTaskDO task = iGenerator.convert(taskDTO,TimeTaskDO.class);
        if (task == null) {
            return;
        }
        if (JobStatusEnum.STOP.getCode().equals(jobStatus)) {
            quartzManager.deleteJob(task);
            task.setStatus(JobStatusEnum.STOP.getCode());
        } else {
            task.setStatus(JobStatusEnum.RUNNING.getCode());
            //判断定时任务是否有调用类和表达式（无调用类或者表达式，则需要手动修改程序定时器）
            if(StringUtils.isNotBlank(task.getBeanClass()) && StringUtils.isNotBlank(task.getExpression())){
                quartzManager.addJob(task);
            }
        }
        timeTaskDao.save(task);
    }

    @Override
    public void updateCron(Integer jobId) throws SchedulerException {
        TimeTaskDTO taskDTO = get(jobId);
        TimeTaskDO task = iGenerator.convert(taskDTO,TimeTaskDO.class);
        if (task == null) {
            return;
        }
        if (JobStatusEnum.RUNNING.getCode().equals(task.getStatus())) {
            quartzManager.updateJobCron(task);
        }
        timeTaskDao.save(task);
    }

    @Override
    public void run(TimeTaskDO task) throws SchedulerException {
        quartzManager.runJobNow(task);
    }



    private void setReceiveName(TimeTaskDTO timeTaskDTO) {
        Set<String> personIdSet =new HashSet<>();
            String users = timeTaskDTO.getReceiver();
            if(StringUtils.isNotBlank(users)){
                if(users.indexOf(",") > -1) {
                    List<String> idList = Arrays.asList(users.split(","));
                    personIdSet.addAll(idList);
                } else {
                    personIdSet.add(users);
                }
            }
        List<String> peronIdList = new ArrayList<>(personIdSet);
        List<PersonDO> personList = personManager.getPersonList(peronIdList);
        Map<String, String> personMap = personList.stream().collect(Collectors.toMap(PersonDO::getPersonId, PersonDO::getPersonName));
            String receiver = timeTaskDTO.getReceiver();
            if(StringUtils.isNotBlank(receiver)){
                String usersName = "";
                if(receiver.indexOf(",") > -1) {
                    StringBuilder sb = new StringBuilder("");
                    List<String> idList = Arrays.asList(receiver.split(","));
                    for(String id: idList) {
                        sb.append(personMap.get(id)).append(",");
                    }
                    usersName = sb.toString();
                    usersName = usersName.substring(0, usersName.length() - 1);
                } else {
                    usersName = personMap.get(users);
                }
                timeTaskDTO.setReceiverName(usersName);
            }
    }

    private void setCcpersonName(TimeTaskDTO timeTaskDTO) {
        Set<String> personIdSet =new HashSet<>();
            String users = timeTaskDTO.getCcPerson();
            if(StringUtils.isNotBlank(users)){
                if(users.indexOf(",") > -1) {
                    List<String> idList = Arrays.asList(users.split(","));
                    personIdSet.addAll(idList);
                } else {
                    personIdSet.add(users);
                }
            }
        List<String> peronIdList = new ArrayList<>(personIdSet);
        List<PersonDO> personList = personManager.getPersonList(peronIdList);
        Map<String, String> personMap = personList.stream().collect(Collectors.toMap(PersonDO::getPersonId, PersonDO::getPersonName));
            String ccPerson = timeTaskDTO.getCcPerson();
            if(StringUtils.isNotBlank(users)){
                String usersName = "";
                if(ccPerson.indexOf(",") > -1) {
                    StringBuilder sb = new StringBuilder("");
                    List<String> idList = Arrays.asList(ccPerson.split(","));
                    for(String id: idList) {
                        sb.append(personMap.get(id)).append(",");
                    }
                    usersName = sb.toString();
                    usersName = usersName.substring(0, usersName.length() - 1);
                } else {
                    usersName = personMap.get(users);
                }
                timeTaskDTO.setCcPersonName(usersName);
            }
    }
}
