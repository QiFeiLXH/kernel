package com.bsoft.common.key;

import java.io.Serializable;

/**
 * @Auther: hy
 * @Date: 2020/7/20
 * @Description:
 */
public class HumanDicKey implements Serializable {
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
