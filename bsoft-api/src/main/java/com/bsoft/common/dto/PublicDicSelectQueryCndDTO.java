package com.bsoft.common.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2021/2/5
 * @description 公用代码字典选择器查询参数
 */
public class PublicDicSelectQueryCndDTO implements Serializable {
    private Integer type;
    private Integer flag;
    private String inputContent;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }
}
