package com.bsoft.common.dozer;/*
 * @author  hy
 * @date  2020/2/13 20:41
 * @description
 */

import org.dozer.DozerConverter;

import java.time.LocalDate;
import java.util.Date;

public class DateToDateDozerConverter extends DozerConverter<Date, Date> {
    public DateToDateDozerConverter() {
        super(Date.class, Date.class);;
    }

    @Override
    public Date convertTo(Date date, Date date2) {
        return date2;
    }

    @Override
    public Date convertFrom(Date date, Date date2) {
        return date;
    }
}
