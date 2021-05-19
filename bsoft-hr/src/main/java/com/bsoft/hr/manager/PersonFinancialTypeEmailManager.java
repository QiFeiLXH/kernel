package com.bsoft.hr.manager;

public interface PersonFinancialTypeEmailManager {
     /**
      * 发送提醒邮件给抄送人和接收人
      * 发送部门内未维护财务类别的人员给抄送人与接收人。
      */
     void sendRemindEmailToDeptFinancial ();
}
