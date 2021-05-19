package com.bsoft.common.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:21
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
