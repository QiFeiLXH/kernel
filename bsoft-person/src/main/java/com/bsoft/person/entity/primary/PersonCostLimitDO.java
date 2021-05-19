package com.bsoft.person.entity.primary;

import com.bsoft.person.key.PersonCostLimitKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 10:30
 * @Description:
 */
@Entity
@IdClass(PersonCostLimitKey.class)
@Table(name = "bsoftmis.PERSON_COSTLIMIT")
public class PersonCostLimitDO {
    @Id
    private String personid;
    @Id
    private Integer costtype;//补贴类型
    private Double costlimit;//补贴金额
    @Id
    private Date execudate;//执行日期
    private String costdesc;//备注信息
    private String adduser;//修改人员
    private Date adddate;//修改日期
    private Integer costlevel;//补贴级别
    private Date enddate;//结束日期
    private Integer sourceflag;//记录来源
    private Integer sourceid;//关联ID号
    private String orgid;//所在部门
    private Double excesscost;//超额金额

    public Integer getSourceid() {
        return sourceid;
    }

    public void setSourceid(Integer sourceid) {
        this.sourceid = sourceid;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public Integer getCosttype() {
        return costtype;
    }

    public void setCosttype(Integer costtype) {
        this.costtype = costtype;
    }

    public Double getCostlimit() {
        return costlimit;
    }

    public void setCostlimit(Double costlimit) {
        this.costlimit = costlimit;
    }

    public Date getExecudate() {
        return execudate;
    }

    public void setExecudate(Date execudate) {
        this.execudate = execudate;
    }

    public String getCostdesc() {
        return costdesc;
    }

    public void setCostdesc(String costdesc) {
        this.costdesc = costdesc;
    }

    public String getAdduser() {
        return adduser;
    }

    public void setAdduser(String adduser) {
        this.adduser = adduser;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public Integer getCostlevel() {
        return costlevel;
    }

    public void setCostlevel(Integer costlevel) {
        this.costlevel = costlevel;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getSourceflag() {
        return sourceflag;
    }

    public void setSourceflag(Integer sourceflag) {
        this.sourceflag = sourceflag;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public Double getExcesscost() {
        return excesscost;
    }

    public void setExcesscost(Double excesscost) {
        this.excesscost = excesscost;
    }
}
