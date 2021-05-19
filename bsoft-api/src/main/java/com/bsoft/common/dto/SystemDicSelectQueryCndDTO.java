package com.bsoft.common.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2021/2/5
 * @description 系统代码字典选择器查询参数
 */
public class SystemDicSelectQueryCndDTO implements Serializable {
    private Integer type;
    private String inputContent;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }
}
