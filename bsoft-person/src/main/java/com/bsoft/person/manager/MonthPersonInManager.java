package com.bsoft.person.manager;

import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:29
 * @Description:
 */
public interface MonthPersonInManager {
    //人员调动更新人员统计信息
    void updateLastPersonInfo(String dept,Integer deptType,Integer jobCategory,String post,String personId,Date startdate);
}
