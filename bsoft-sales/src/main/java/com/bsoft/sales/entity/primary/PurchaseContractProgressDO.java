package com.bsoft.sales.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/11 8:44
 * @Description 采购合同进度
 */
@Entity
@Table(name="cg_htxx_progress")
public class PurchaseContractProgressDO {
    private Integer id;
    private Integer purchaseContractId;
    private Date confirmDate;
    private Double progress;
    private String registerPersonId;
    private Date registerDate;

    @Id
    @SequenceGenerator(name="SEQ_CG_HTXX_PROGRESS",allocationSize=1,sequenceName="SEQ_CG_HTXX_PROGRESS")
    @GeneratedValue(generator="SEQ_CG_HTXX_PROGRESS",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="htid")
    public Integer getPurchaseContractId() {
        return purchaseContractId;
    }

    public void setPurchaseContractId(Integer purchaseContractId) {
        this.purchaseContractId = purchaseContractId;
    }

    @Column(name="qrrq")
    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    @Column(name="djr")
    public String getRegisterPersonId() {
        return registerPersonId;
    }

    public void setRegisterPersonId(String registerPersonId) {
        this.registerPersonId = registerPersonId;
    }

    @Column(name="djrq")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
