package com.bsoft.person.dto;

public class CloudschoolRestypeSynDTO {

    /**
     * 岗位编号
     */
    private String pNo;

    /**
     * 一级类别；二级类别；岗位 (最后是岗位)
     */
    private String pNames;

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public String getpNames() {
        return pNames;
    }

    public void setpNames(String pNames) {
        this.pNames = pNames;
    }

    @Override
    public String toString() {
        return "CloudschoolRestypeSynDTO{" +
                "pNo='" + pNo + '\'' +
                ", pNames='" + pNames + '\'' +
                '}';
    }
}
