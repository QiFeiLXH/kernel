package com.bsoft.common.dozer;

import org.dozer.DozerConverter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2019/12/11
 * @Description:
 */
public class LocalDateToDateDozerConverter extends DozerConverter<LocalDate, Date> {

    public LocalDateToDateDozerConverter() {
        super(LocalDate.class, Date.class);
    }

    @Override
    public Date convertTo(LocalDate localDate, Date date) {
        Date convertToDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return convertToDate;
    }

    @Override
    public LocalDate convertFrom(Date date, LocalDate localDate) {
        LocalDate dateTime = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return dateTime;
    }
}
