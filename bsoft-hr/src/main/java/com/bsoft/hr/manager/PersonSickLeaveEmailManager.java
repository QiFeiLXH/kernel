package com.bsoft.hr.manager;

public interface PersonSickLeaveEmailManager {
     /**
      * 筛选出病假以及长病假超过6个月的人
      * 定时发送邮件给人力资源部。
      */
     void PersonSickLeaveEmail ();
}
