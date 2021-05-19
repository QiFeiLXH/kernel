package com.bsoft.person.dto;

import java.io.Serializable;

/**
 * @Auther: hy
 * @Date: 2020/5/22
 * @Description:
 */
public class CommunicationSubsidyDTO implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
