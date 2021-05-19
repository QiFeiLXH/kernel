package com.bsoft.common.manager;

import com.bsoft.common.condition.SystemDicSelectQueryCnd;
import com.bsoft.common.entity.primary.SystemDicDO;

import java.util.List;
import java.util.Map;

public interface SystemDicManager {
    Map<String,String> getDic(Integer type);

    List<SystemDicDO> getSystemDic(Integer type);

    SystemDicDO getValue(Integer type,String key);

    /**
     * 获取字典选择器列表
     * @param queryCnd 查询参数
     */
    List<SystemDicDO> getSystemDicSelectList(SystemDicSelectQueryCnd queryCnd);
}
