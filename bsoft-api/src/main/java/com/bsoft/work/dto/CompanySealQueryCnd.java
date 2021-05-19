package com.bsoft.work.dto;

import java.io.Serializable;

/**
 * @author: lkh
 * @date: 2020/12/2
 * @description 公司印章情况查询参数
 */
public class CompanySealQueryCnd implements Serializable {
    /**印章ID*/
    private  Integer  id;
    /**公司类别:0 分公司,1 子公司,2查所有*/
    private  Integer  companyType;
    /**公司名称*/
    private  String   companyName;
    /**合同章保管人Id*/
    private  String  contractSealCustodian;
    /**公章保管人Id*/
    private  String  officialSealCustodian;
    /**印章章保管人名称*/
    private  String  CustodianName;
    /** 输入内容*/
    private String inputContent;
    /** 页码*/
    private Integer pageNo;
    /** 每页条数*/
    private Integer pageSize;

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContractSealCustodian() {
        return contractSealCustodian;
    }

    public void setContractSealCustodian(String contractSealCustodian) {
        this.contractSealCustodian = contractSealCustodian;
    }

    public String getOfficialSealCustodian() {
        return officialSealCustodian;
    }

    public void setOfficialSealCustodian(String officialSealCustodian) {
        this.officialSealCustodian = officialSealCustodian;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
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

    public String getCustodianName() {
        return CustodianName;
    }

    public void setCustodianName(String custodianName) {
        CustodianName = custodianName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
