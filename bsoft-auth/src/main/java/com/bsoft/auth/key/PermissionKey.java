package com.bsoft.auth.key;

import java.io.Serializable;

public class PermissionKey implements Serializable {
    private String personId;
    private String value;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
