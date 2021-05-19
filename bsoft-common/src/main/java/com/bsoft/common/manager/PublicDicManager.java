package com.bsoft.common.manager;

import com.bsoft.common.condition.PublicDicSelectQueryCnd;
import com.bsoft.common.entity.primary.PublicDicDO;

import java.util.List;
import java.util.Map;

public interface PublicDicManager {
    Map<String,String> getDic(Integer type);

    List<PublicDicDO> getPublicDic(Integer type);

    /**
     * 获取字典选择器列表
     * @param queryCnd 查询参数
     */
    List<PublicDicDO> getPublicDicSelectList(PublicDicSelectQueryCnd queryCnd);

    List<PublicDicDO> getSystemListDic();

    PublicDicDO getValue(Integer type,String key);

    PublicDicDO getValueWithName(Integer type,String name);

    List<PublicDicDO> getPublicDicWithFlag(Integer type, Integer flag);

    void logout(Integer id);

    int selectMaxId();
}
