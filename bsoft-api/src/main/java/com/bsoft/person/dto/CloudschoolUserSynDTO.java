package com.bsoft.person.dto;

public class CloudschoolUserSynDTO {

    /**
     * 用户ID(同步必传)
     */
    private String id;

    /**
     * 用户名(同步必传)
     */
    private String userName;

    /**
     * 中文姓名(同步必传)
     */
    private String cnName;

    /**
     * 工号
     */
    private String userNo;


    /**
     * 部门编号
     */
    private String orgOuCode;

    /**
     * 部门名称
     */
    private String orgOuName;

    /**
     * 岗位编号
     */
    private String postionNo;

    /**
     * 岗位名
     */
    private String postionName;

    /**
     * 电子邮件
     */
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getOrgOuCode() {
        return orgOuCode;
    }

    public void setOrgOuCode(String orgOuCode) {
        this.orgOuCode = orgOuCode;
    }

    public String getOrgOuName() {
        return orgOuName;
    }

    public void setOrgOuName(String orgOuName) {
        this.orgOuName = orgOuName;
    }

    public String getPostionNo() {
        return postionNo;
    }

    public void setPostionNo(String postionNo) {
        this.postionNo = postionNo;
    }

    public String getPostionName() {
        return postionName;
    }

    public void setPostionName(String postionName) {
        this.postionName = postionName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CloudschoolUserSynDTO other = (CloudschoolUserSynDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
