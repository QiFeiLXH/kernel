package com.bsoft.common.manager;

import com.bsoft.common.condition.HumanDicSelectQueryCnd;
import com.bsoft.common.entity.primary.HumanDicDO;

import java.util.List;
import java.util.Map;

public interface HumanDicManager {
    public List<HumanDicDO> getRestypeDic();
    public HumanDicDO getRestypeDic(Integer id);
    public List<HumanDicDO> getPersonDic(Integer type);
    public List<HumanDicDO> getTypePersonDic(Integer type);
    public HumanDicDO getValue(Integer type, Integer key);
    HumanDicDO getValue(Integer type, String name);
    HumanDicDO saveHumanDic(Integer type,String name);
    public Map<String,String> getDic(Integer type);

    /**
     * 获取字典选择器列表
     * @param queryCnd 查询参数
     */
    List<HumanDicDO> getHumanDicSelectList(HumanDicSelectQueryCnd queryCnd);
}
