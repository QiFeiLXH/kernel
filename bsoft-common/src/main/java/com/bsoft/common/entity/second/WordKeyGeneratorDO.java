package com.bsoft.common.entity.second;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gy_identity")
public class WordKeyGeneratorDO {
    @Id
    @Column(name = "tname")
    private String tableName;
    @Column(name = "tvalue")
    private Integer tableId;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
}
