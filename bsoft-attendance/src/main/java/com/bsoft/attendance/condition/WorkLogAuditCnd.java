package com.bsoft.attendance.condition;

/**
 * @Author zhanglf
 * @Date 2020-03-18 13:24
 * @Version 1.0
 * @Description
 */
public class WorkLogAuditCnd {
    private String projectId;
    private String userName;
    private String projectName;
    private String groupName;
    private Integer listFlag;
    private String loginUser;
    private String startDate;
    private String endDate;
    private Integer flag; //1.结构化日志待修改   2.支持结算日志待修改  3.待审核日志

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public Integer getListFlag() {
        return listFlag;
    }

    public void setListFlag(Integer listFlag) {
        this.listFlag = listFlag;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
