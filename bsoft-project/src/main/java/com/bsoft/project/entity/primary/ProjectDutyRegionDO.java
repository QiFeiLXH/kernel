package com.bsoft.project.entity.primary;

import javax.persistence.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 8:31
 * @Description 项目责任书-项目范围
 */
@Entity
@Table(name="BSOFT_PORTAL.PRO_DUTY_REGION")
public class ProjectDutyRegionDO {
    private Integer id;
    /** 责任书id */
    private Integer dutyId;
    /** 合同编号 */
    private String contractNo;
    /** 权重 */
    private Double weight;

    @Id
    @SequenceGenerator(name="SEQ_PRO_DUTY_REGION",allocationSize=1,sequenceName="SEQ_PRO_DUTY_REGION")
    @GeneratedValue(generator="SEQ_PRO_DUTY_REGION",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
