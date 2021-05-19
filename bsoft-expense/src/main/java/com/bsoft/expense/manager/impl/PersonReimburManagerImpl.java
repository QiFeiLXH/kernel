package com.bsoft.expense.manager.impl;

import com.bsoft.expense.dao.primary.PersonReimburDao;
import com.bsoft.expense.manager.PersonReimburManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:45
 * @Description:
 */
@Component
public class PersonReimburManagerImpl implements PersonReimburManager {
    @Autowired
    private PersonReimburDao personReimburDao;
    @Override
    public void updateDept(String personid, String dept, Date hsrq) {
        personReimburDao.updateDept(personid,dept,hsrq);
    }
}
