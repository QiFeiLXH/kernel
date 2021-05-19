package com.bsoft.common.manager;

public interface KeyGeneratorManager {
    public Integer nextKey(String tableName);

    public Integer pubNextKey(String tableName);
}
