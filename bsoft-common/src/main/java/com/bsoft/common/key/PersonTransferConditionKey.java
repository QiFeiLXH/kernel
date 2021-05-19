package com.bsoft.common.key;

import java.io.Serializable;
import java.util.Date;

public class PersonTransferConditionKey implements Serializable {
    private String personId;
    private Date transferDate;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }
}
