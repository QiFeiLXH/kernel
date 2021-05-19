package com.bsoft.person.manager;

public interface CloudschoolRestypeManager {
    //岗位信息首次同步，将备份表数据全部同步过去，慎用。
    void SyncOneRestype();

    /**
     *
     */
    void SyncRestype();
}
