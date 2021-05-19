package com.bsoft.work.entity.primary;

import javax.persistence.*;

/**
 * @Author Xuhui Lin
 * @Date 2021/5/17 9:16
 * @Description
 */
@Entity
@Table(name = "pol_manager_group")
public class ManagerGroupDO {
    @Id
    @SequenceGenerator(name="seq_pol_manager_group",allocationSize=1,sequenceName="seq_pol_manager_group")
    @GeneratedValue(generator="seq_pol_manager_group",strategy=GenerationType.SEQUENCE)
    /**
     * 委员会id
     */
    private Integer councilId;
    /**
     * 委员会名称
     */
    private String councilName;
    /**
     *  类别 1决策类  2提案类
     */
    private Integer type;
    /**
     * 总数
     */
    private Integer total;

    /**
     *  是否注销 0未注销 1已注销
     */
    private Integer isCancel;

    /**
     * 组员数量
     */
    @Transient
    private Integer memberNum;


    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCouncilId() {
        return councilId;
    }

    public void setCouncilId(Integer councilId) {
        this.councilId = councilId;
    }

    public String getCouncilName() {
        return councilName;
    }

    public void setCouncilName(String councilName) {
        this.councilName = councilName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }
}
