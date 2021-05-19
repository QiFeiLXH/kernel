package com.bsoft.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.work.condition.MeetQueryCnd;
import com.bsoft.work.entity.primary.MeetDO;
import com.bsoft.work.entity.primary.MeetViewDO;

public interface MeetManager {
    void saveMeet(MeetDO meetDO);

    /**
     * 根据查询条件获取会议列表
     * @param cnd
     * @return
     */
    Result<MeetViewDO> getMeetList(MeetQueryCnd cnd);

    /**
     * 会议发放参会证
     */
    void grantProve(Integer id);

    /**
     * 根据id获取会议信息
     */
    MeetDO getMeetInfo(Integer id);
}
