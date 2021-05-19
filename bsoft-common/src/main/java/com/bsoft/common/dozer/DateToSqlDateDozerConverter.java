package com.bsoft.common.dozer;/*
 * @author  hy
 * @date  2020/2/13 20:41
 * @description
 */

import org.dozer.DozerConverter;

import java.util.Date;

public class DateToSqlDateDozerConverter extends DozerConverter<Date, java.sql.Date> {
    public DateToSqlDateDozerConverter() {
        super(Date.class, java.sql.Date.class);;
    }


    @Override
    public java.sql.Date convertTo(Date date, java.sql.Date date2) {
        date2 = new java.sql.Date(date.getTime());
        return date2;
    }

    @Override
    public Date convertFrom(java.sql.Date date, Date date2) {
        date2 = new Date(date.getTime());
        return date2;
    }
}
