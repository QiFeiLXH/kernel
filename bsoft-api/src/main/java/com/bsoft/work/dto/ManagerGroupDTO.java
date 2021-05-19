package com.bsoft.work.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/10 17:44
 */
public class ManagerGroupDTO implements Serializable {
    /**
     * 1提案类,2决策类
     */
    private String key;

    /**
     *  类别 1决策类  2提案类
     */
    private Integer type;

    /**
     * 委员会id
     */
    private Integer councilId;
    /**
     * 名称
     */
    private String councilName;
    /**
     * 子节点
     */
    private List<?> children;
    /**
     * 数据量
     */
    private Integer total;

    /**
     *  是否注销 0未注销 1已注销
     */
    private Integer isCancel;

    /**
     * 组员数量
     */
    private Integer memberNum;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCouncilName() {
        return councilName;
    }

    public void setCouncilName(String councilName) {
        this.councilName = councilName;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCouncilId() {
        return councilId;
    }

    public void setCouncilId(Integer councilId) {
        this.councilId = councilId;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }
}
