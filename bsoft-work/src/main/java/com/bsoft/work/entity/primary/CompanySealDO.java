package com.bsoft.work.entity.primary;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Lkh
 * @Date 2021/1/27 14:08
 * @Description
 */
@Entity
@Table(name="work_company_seal")
public class CompanySealDO implements Serializable {
    /**印章ID*/
    @Id
    @SequenceGenerator(name="SEQ_WORK_COMPANY_SEAL",allocationSize=1,sequenceName="SEQ_WORK_COMPANY_SEAL")
    @GeneratedValue(generator="SEQ_WORK_COMPANY_SEAL",strategy=GenerationType.SEQUENCE)
    private  Integer  id ;
    /**公司ID*/
    private  Integer  companyId;
    /**印章是否在公司：0存在,1不在*/
    private  Integer  sealCompanyFlag;
    /**是否为公章：0是,1否*/
    private  Integer  officialSealFlag;
    /**公章保管人Id*/
    private  String  officialSealCustodianId;
    /**公章保管人姓名*/
    private  String  officialSealCustodianName;
    /**是否为合同章：0是,1否*/
    private  Integer  contractSealFlag;
    /**合同章保管人Id*/
    private  String  contractSealCustodianId;
    /**合同章保管人姓名*/
    private   String contractSealCustodianName;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getSealCompanyFlag() {
        return sealCompanyFlag;
    }

    public void setSealCompanyFlag(Integer sealCompanyFlag) {
        this.sealCompanyFlag = sealCompanyFlag;
    }

    public Integer getOfficialSealFlag() {
        return officialSealFlag;
    }

    public void setOfficialSealFlag(Integer officialSealFlag) {
        this.officialSealFlag = officialSealFlag;
    }



    public Integer getContractSealFlag() {
        return contractSealFlag;
    }

    public void setContractSealFlag(Integer contractSealFlag) {
        this.contractSealFlag = contractSealFlag;
    }





    public String getOfficialSealCustodianId() {
        return officialSealCustodianId;
    }

    public void setOfficialSealCustodianId(String officialSealCustodianId) {
        this.officialSealCustodianId = officialSealCustodianId;
    }

    public String getOfficialSealCustodianName() {
        return officialSealCustodianName;
    }

    public void setOfficialSealCustodianName(String officialSealCustodianName) {
        this.officialSealCustodianName = officialSealCustodianName;
    }

    public String getContractSealCustodianId() {
        return contractSealCustodianId;
    }

    public void setContractSealCustodianId(String contractSealCustodianId) {
        this.contractSealCustodianId = contractSealCustodianId;
    }

    public String getContractSealCustodianName() {
        return contractSealCustodianName;
    }

    public void setContractSealCustodianName(String contractSealCustodianName) {
        this.contractSealCustodianName = contractSealCustodianName;
    }
}
