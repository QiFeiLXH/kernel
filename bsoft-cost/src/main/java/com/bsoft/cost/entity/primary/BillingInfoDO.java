package com.bsoft.cost.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 19:21
 * @Description: 开票记录表
 */
@Entity
@Table(name = "bsoftmis.t_kpjl")
public class BillingInfoDO {
    private Integer id;
    private String lshid;
    private String invoiceApplyId;
    private String invoicePdfUrl;
    private String invoicePngUrl;
    private Integer invoicePdfId;
    private String fpdm;
    private String fphm;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public String getInvoiceApplyId() {
        return invoiceApplyId;
    }

    public void setInvoiceApplyId(String invoiceApplyId) {
        this.invoiceApplyId = invoiceApplyId;
    }

    public String getInvoicePdfUrl() {
        return invoicePdfUrl;
    }

    public void setInvoicePdfUrl(String invoicePdfUrl) {
        this.invoicePdfUrl = invoicePdfUrl;
    }

    public String getInvoicePngUrl() {
        return invoicePngUrl;
    }

    public void setInvoicePngUrl(String invoicePngUrl) {
        this.invoicePngUrl = invoicePngUrl;
    }

    public Integer getInvoicePdfId() {
        return invoicePdfId;
    }

    public void setInvoicePdfId(Integer invoicePdfId) {
        this.invoicePdfId = invoicePdfId;
    }

    public String getFpdm() {
        return fpdm;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }
}
