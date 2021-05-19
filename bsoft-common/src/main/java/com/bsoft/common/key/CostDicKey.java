package com.bsoft.common.key;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典Key
 */
public class CostDicKey implements Serializable {
    private Integer type;
    private Integer id;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
