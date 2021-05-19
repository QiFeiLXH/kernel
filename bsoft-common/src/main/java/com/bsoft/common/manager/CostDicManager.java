package com.bsoft.common.manager;

import com.bsoft.common.entity.primary.CostDicDO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
public interface CostDicManager {

    /**
     * 根据类别获取字典
     * @param type 类别
     * @param id 识别ID
     * @return
     */
    CostDicDO getCostDic(Integer type, Integer id);

    /**
     * 根据类别获取字典
     * @param type 类别
     * @return
     */
    List<CostDicDO> getCostDicList(Integer type);

    /**
     * 根据类别，注销标志获取字典
     * @param type 类别
     * @param logout 注销标志
     * @return
     */
    List<CostDicDO> getCostDicList(Integer type, Integer logout);


    /**
     * 根据类别，注销标志，名字或拼音码模糊查询字典
     * @param type 类别
     * @param logout 注销标志
     * @param subType 子类
     * @param inputContent 输入内容
     * @return
     */
    List<CostDicDO> getCostDicList(Integer type, Integer subType, Integer logout, String inputContent);

    /**
     * 保存字典信息
     * @param saveDO 字典信息
     */
    void save(CostDicDO saveDO);
}
