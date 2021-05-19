package com.bsoft.common.dozer;

import org.dozer.DozerConverter;

import java.time.LocalDate;

/**
 * @Auther: hy
 * @Date: 2019/12/11
 * @Description:
 */
public class LocalDateToLocalDateDozerConverter extends DozerConverter<LocalDate, LocalDate> {

    public LocalDateToLocalDateDozerConverter() {
        super(LocalDate.class, LocalDate.class);
    }

    @Override
    public LocalDate convertTo(LocalDate localDate, LocalDate localDate2) {
        return localDate2;
    }

    @Override
    public LocalDate convertFrom(LocalDate localDate, LocalDate localDate2) {
        return localDate;
    }
}
