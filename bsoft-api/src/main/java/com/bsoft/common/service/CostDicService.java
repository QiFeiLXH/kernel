package com.bsoft.common.service;

import com.bsoft.common.dto.CostDicDTO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
public interface CostDicService {
    /**
     * 根据类别获取字典
     * @param type 类别列表
     * @return
     */
    List<CostDicDTO> getCostDicList(Integer type, Integer logout);

    /**
     * 给定分类下根据名字或拼音码模糊查询字典
     * @param type 类别
     * @param inputContent 输入内容
     * @return
     */
    List<CostDicDTO> getCostDicList(Integer type, Integer subType, Integer logout, String inputContent);


}
