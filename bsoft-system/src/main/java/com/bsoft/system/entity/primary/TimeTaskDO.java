package com.bsoft.system.entity.primary;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-06-29 10:30
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name = "PRO_TASK")
public class TimeTaskDO {
    private Integer id;//主键Id
    private String taskName;//任务名称
    private Integer taskType;//任务分组
    private String taskGroup;//任务分组名称
    private String beanClass;//调用类
    private String expression;//执行表达式
    private String status;//任务状态
    private String creater;//创建人
    private Date createTime;//创建时间
    private String updater;//修改人
    private Date updateTime;//修改时间
    private String description;//任务描述
    private String receiver;//接收人
//    @Transient
//    private String receiverName;//接收人
    private String ccPerson;//抄送人
//    @Transient
//    private String ccPersonName;//抄送人
//
//    public String getReceiverName() {
//        return receiverName;
//    }
//
//    public void setReceiverName(String receiverName) {
//        this.receiverName = receiverName;
//    }
//
//    public String getCcPersonName() {
//        return ccPersonName;
//    }
//
//    public void setCcPersonName(String ccPersonName) {
//        this.ccPersonName = ccPersonName;
//    }

    @Id
    @SequenceGenerator(name="SEQ_PRO_TASK",allocationSize=1,sequenceName="SEQ_PRO_TASK")
    @GeneratedValue(generator="SEQ_PRO_TASK",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getCcPerson() {
        return ccPerson;
    }

    public void setCcPerson(String ccPerson) {
        this.ccPerson = ccPerson;
    }
}
