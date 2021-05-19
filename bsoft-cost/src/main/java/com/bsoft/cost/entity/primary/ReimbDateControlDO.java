package com.bsoft.cost.entity.primary;

import com.bsoft.cost.key.ReimbDateControKey;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:11
 * @Description: 报销时间控制DO
 */
@Entity
@IdClass(ReimbDateControKey.class)
@Table(name = "bsoftmis.BX_SJKZ")
public class ReimbDateControlDO {
    private Integer year;
    private Date M1;
    private Date M2;
    private Date M3;
    private Date M4;
    private Date M5;
    private Date M6;
    private Date M7;
    private Date M8;
    private Date M9;
    private Date M10;
    private Date M11;
    private Date M12;
    private Date yearDate;
    private Integer flag;
    private Date annualEntry;

    @Id
    @Column(name = "kznf")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getM1() {
        return M1;
    }

    public void setM1(Date m1) {
        M1 = m1;
    }

    public Date getM2() {
        return M2;
    }

    public void setM2(Date m2) {
        M2 = m2;
    }

    public Date getM3() {
        return M3;
    }

    public void setM3(Date m3) {
        M3 = m3;
    }

    public Date getM4() {
        return M4;
    }

    public void setM4(Date m4) {
        M4 = m4;
    }

    public Date getM5() {
        return M5;
    }

    public void setM5(Date m5) {
        M5 = m5;
    }

    public Date getM6() {
        return M6;
    }

    public void setM6(Date m6) {
        M6 = m6;
    }

    public Date getM7() {
        return M7;
    }

    public void setM7(Date m7) {
        M7 = m7;
    }

    public Date getM8() {
        return M8;
    }

    public void setM8(Date m8) {
        M8 = m8;
    }

    public Date getM9() {
        return M9;
    }

    public void setM9(Date m9) {
        M9 = m9;
    }

    public Date getM10() {
        return M10;
    }

    public void setM10(Date m10) {
        M10 = m10;
    }

    public Date getM11() {
        return M11;
    }

    public void setM11(Date m11) {
        M11 = m11;
    }

    public Date getM12() {
        return M12;
    }

    public void setM12(Date m12) {
        M12 = m12;
    }

    @Column(name = "ndsj")
    public Date getYearDate() {
        return yearDate;
    }

    public void setYearDate(Date yearDate) {
        this.yearDate = yearDate;
    }

    @Id
    @Column(name = "jtbz")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "ndlr")
    public Date getAnnualEntry() {
        return annualEntry;
    }

    public void setAnnualEntry(Date annualEntry) {
        this.annualEntry = annualEntry;
    }
}
