package com.bsoft.work.dto;


import java.io.Serializable;

/**
 * @Author Lkh
 * @Date 2021/4/7 14:08
 * @Description
 */

public class CompanySealDTO implements Serializable {
    /**印章ID*/
    private  Integer  id ;
    /**公司ID*/
    private  Integer  companyId;
    /**公司名称*/
    private  String   companyName;
    /**公司简拼*/
    private  String   pinyin;
    /**印章是否在公司：1存在,0不在*/
    private  Integer  sealCompanyFlag;
    /**是否为公章：1是,0否*/
    private  Integer  officialSealFlag;
    /**公章保管人Id*/
    private  String  officialSealCustodianId;
    /**公章保管人姓名*/
    private  String  officialSealCustodianName;
    /**是否为合同章：1是,0否*/
    private  Integer  contractSealFlag;
    /**合同章保管人Id*/
    private  String  contractSealCustodianId;
    /**合同章保管人姓名*/
    private   String contractSealCustodianName;
    /**公司类别:1子公司，2分公司，3其他*/
    private  Integer  companyType;
    /** 页码*/
    private Integer pageNo;
    /** 每页条数*/
    private Integer pageSize;

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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
