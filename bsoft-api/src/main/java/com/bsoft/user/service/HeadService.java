package com.bsoft.user.service;

public interface HeadService {
    /**
     * @Description: 根据工号设置头像
     * @param userId 用户工号
     * @param data 头像信息
     * @param fileName 文件名称
     * @param menuId 菜单ID
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public void setHead(String userId,byte[] data,String fileName,Integer menuId);

    /**
     * @Description: 根据工号获得头像
     * @param userId 用户工号
     * @return  byte[] 头像信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public byte[] getHead(String userId);
}
