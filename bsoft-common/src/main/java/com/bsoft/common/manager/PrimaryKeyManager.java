package com.bsoft.common.manager;

public interface PrimaryKeyManager {
    public Integer increase(String table);

    public Integer increaseWithSize(String table,Integer size);
}
