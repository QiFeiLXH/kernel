package com.bsoft.work.service;

import com.bsoft.work.dto.ManagerDTO;

import java.util.List;

/**
 * @Author ding cj
 * @Date 2021/5/14 9:40
 * @Description
 */
public interface ManagerService {

    /**
     * @param personName:姓名
     * @param councilId:委员会Id
     * @return
     */
    List<ManagerDTO> findList(String personName, Integer councilId);

    /**
     *
     * @param id:主键id
     */
    void deleteManager(Integer id);

    /**
     *
     * @param managerList:要保存的记录
     */
    void saveManager(List<ManagerDTO> managerList);
}
