package com.bsoft.auth.entity.primary;

import javax.persistence.*;

@Entity
@Table(name = "bsoftmis.t_xmqx")
public class ProjectPermissionDO {
    private Integer id;
    private String personId;
    private String value;
    private Integer type;
    private Integer flag;

    @Id
    @SequenceGenerator(name="BSOFTMIS.SEQ_T_XMQX",allocationSize=1,sequenceName="BSOFTMIS.SEQ_T_XMQX")
    @GeneratedValue(generator="BSOFTMIS.SEQ_T_XMQX",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "loginid")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "glqx")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "lx")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "flag")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
