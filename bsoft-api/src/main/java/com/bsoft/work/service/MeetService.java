package com.bsoft.work.service;

import com.bsoft.common.result.Result;
import com.bsoft.work.dto.MeetDTO;
import com.bsoft.work.dto.MeetQueryCndDTO;
import com.bsoft.work.dto.MeetViewDTO;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:05
 * @Version 1.0
 */
public interface MeetService {
    void saveMeet(String personId,MeetDTO meetDTO);

    /**
     * 根据查询条件获取会议列表
     * @param cnd
     * @return
     */
    Result<MeetViewDTO> getMeetList(String personId, MeetQueryCndDTO cnd);

    /**
     * 会议发放参会证
     */
    void grantProve(String personId,Integer id);

    /**
     * 根据id获取会议信息
     * @param personId
     * @param id
     * @return
     */
    MeetDTO getMeetInfo(String personId,Integer id);
}
