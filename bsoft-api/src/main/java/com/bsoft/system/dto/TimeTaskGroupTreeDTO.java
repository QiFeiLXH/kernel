package com.bsoft.system.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 10:14
 * @Version 1.0
 * @Description
 */
public class TimeTaskGroupTreeDTO implements Serializable {
    private Integer key;
    private String value;
    private String title;
    private Integer parentId;
    private List<TimeTaskGroupTreeDTO> children = new ArrayList<>();

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<TimeTaskGroupTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TimeTaskGroupTreeDTO> children) {
        this.children = children;
    }
}
