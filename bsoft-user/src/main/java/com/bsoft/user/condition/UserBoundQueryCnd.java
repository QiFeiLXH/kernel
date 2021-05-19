package com.bsoft.user.condition;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 8:57
 * @Description: 已绑定app用户查询条件
 */
public class UserBoundQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    private String inputContent;
    private Integer logoff;

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

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }
}
