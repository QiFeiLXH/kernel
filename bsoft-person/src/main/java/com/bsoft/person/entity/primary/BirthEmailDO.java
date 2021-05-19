package com.bsoft.person.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 生日邮箱收件人维护
 */
@Entity
@Table(name = "bsoftmis.PERSON_BIRTHEMAIL_VIEW")
public class BirthEmailDO {
    private Integer id;
    private String personId;
    private String email;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
