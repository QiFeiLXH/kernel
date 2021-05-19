package com.bsoft.person.key;

import java.io.Serializable;

public class TrainKey implements Serializable {
    private String personId;
    private String year;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
