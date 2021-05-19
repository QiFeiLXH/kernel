package com.bsoft.cost.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 14:11
 * @Description:
 */
@Entity
@Table(name = "FIN_COST_INVOICE")
public class InvoiceLibDO {
    private Integer id;
    private Integer source;
    private Integer companyNo;
    private String abbreviation;
    private String taxno;
    private Integer invoiceType;
    private String invoiceCode;
    private String invoiceNumber;
    private Double amount;
    private Date invoiceDate;
    private String expensePerson;
    private Date registratDate;
    private String unitName;
    private String unitTaxno;
    private Integer invoiceFileId;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(Integer companyNo) {
        this.companyNo = companyNo;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getTaxno() {
        return taxno;
    }

    public void setTaxno(String taxno) {
        this.taxno = taxno;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }


    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getExpensePerson() {
        return expensePerson;
    }

    public void setExpensePerson(String expensePerson) {
        this.expensePerson = expensePerson;
    }

    public Date getRegistratDate() {
        return registratDate;
    }

    public void setRegistratDate(Date registratDate) {
        this.registratDate = registratDate;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitTaxno() {
        return unitTaxno;
    }

    public void setUnitTaxno(String unitTaxno) {
        this.unitTaxno = unitTaxno;
    }

    public Integer getInvoiceFileId() {
        return invoiceFileId;
    }

    public void setInvoiceFileId(Integer invoiceFileId) {
        this.invoiceFileId = invoiceFileId;
    }
}
