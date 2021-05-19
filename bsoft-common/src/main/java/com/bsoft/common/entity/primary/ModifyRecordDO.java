package com.bsoft.common.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/9 9:38
 * @Description
 */
@Entity
@Table(name="BSOFTMIS.SJ_XGJL")
public class ModifyRecordDO {
    private Integer id;
    private Integer modifyDetail;
    private String modifyType;
    private String mainId;
    private String modifyContent;
    private String modifyPersonId;
    private Date modifyDate;

    @Id
    @SequenceGenerator(name="BSOFTMIS.SEQ_SJ_XGJL",allocationSize=1,sequenceName="BSOFTMIS.SEQ_SJ_XGJL")
    @GeneratedValue(generator="BSOFTMIS.SEQ_SJ_XGJL",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="xgmk")
    public Integer getModifyDetail() {
        return modifyDetail;
    }

    public void setModifyDetail(Integer modifyDetail) {
        this.modifyDetail = modifyDetail;
    }

    @Column(name="xglx")
    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
    }

    @Column(name="mkid")
    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    @Column(name="xgnr")
    public String getModifyContent() {
        return modifyContent;
    }

    public void setModifyContent(String modifyContent) {
        this.modifyContent = modifyContent;
    }

    @Column(name="xggh")
    public String getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(String modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    @Column(name="xgsj")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
