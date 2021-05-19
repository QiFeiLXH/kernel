package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/16 9:51
 * @Description
 */
public class WorkCardQueryCndDTO implements Serializable {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 输入内容 */
    private String inputContent;
    /** 是否充值 */
    private List<Integer> recharge;
    /** 单选选择 */
    private Integer flag;
    /** 日期 */
    private String dateStr;


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

    public List<Integer> getRecharge() {
        return recharge;
    }

    public void setRecharge(List<Integer> recharge) {
        this.recharge = recharge;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
