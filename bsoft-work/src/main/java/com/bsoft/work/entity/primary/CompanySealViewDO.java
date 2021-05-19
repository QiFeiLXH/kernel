package com.bsoft.work.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Lkh
 * @Date 2021/1/27 14:08
 * @Description
 */
@Entity
@Table(name="work_company_seal_view")
public class CompanySealViewDO {
    /**印章ID*/
    private  Integer  id ;
    /**公司ID*/
    private  Integer  companyId;
    /**公司名称*/
    private  String   companyName;
    /**公司简拼*/
    private  String   pinyin;
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
    /**公司类别:0 分公司,1 子公司,2 其他*/
    private  Integer  companyType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
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



    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
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
