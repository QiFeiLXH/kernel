package com.bsoft.user.manager;

public interface HeadManager {
    Integer writeHead(byte[] data,String fileName,Integer menuId);

    byte[] readHead(Integer key);

}
