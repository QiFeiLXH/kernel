package com.bsoft.contract.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: zy
 * @date: 2021/4/29
 * @description 合同拓展表
 */
@Entity
@Table(name = "bsoftmis.pro_contract_ex")
public class ContractExDO {
    @Id
    /** 合同号*/
    private String contractNo;
    /** 终验日期*/
    private Date checkDate;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }
}
