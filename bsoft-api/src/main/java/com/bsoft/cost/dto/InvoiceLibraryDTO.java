package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

public class InvoiceLibraryDTO implements Serializable {
    private Integer id;
    private Integer source;
    private String sourceText;
    private Integer companyNo;
    private String abbreviation;
    private String taxno;
    private String invoiceType;
    private String invoiceTypeText;
    private String invoiceCode;
    private String invoiceNumber;
    private Double amount;
    private Date invoiceDate;
    private String expensePerson;
    private String expensePersonText;
    private Date registratDate;
    private String unitName;
    private String unitTaxno;
    private Integer invoiceFileId;
    private String pinYinCode;
    /** 凭证号 */
    private String voucher;

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

    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
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

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTypeText() {
        return invoiceTypeText;
    }

    public void setInvoiceTypeText(String invoiceTypeText) {
        this.invoiceTypeText = invoiceTypeText;
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

    public String getExpensePersonText() {
        return expensePersonText;
    }

    public void setExpensePersonText(String expensePersonText) {
        this.expensePersonText = expensePersonText;
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

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}
