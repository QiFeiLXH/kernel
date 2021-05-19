package com.bsoft.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.work.condition.MeetPersonQueryCnd;
import com.bsoft.work.entity.primary.MeetPersonDO;

import java.util.List;

public interface MeetPersonManager {
    void saveMeetPerson(MeetPersonDO meetPersonDO);

    void deleteMeetPerson(Integer id);

    Result<MeetPersonDO> getMeetPersons(MeetPersonQueryCnd meetPersonQueryCnd);

    /**
     * 导入会议人员名单
     * @param personId
     * @param saveDOList
     * @param errorDOList
     */
    void importMeetPersonData(String personId, List<MeetPersonDO> saveDOList, List<MeetPersonDO> errorDOList);

    /**
     * 导出错误数据
     * @param personId 操作人工号
     * @return 错误数据列表
     */
    List<MeetPersonDO> exportErrorData(String personId);

    /**
     * 根据会议id获取参会人员
     * @param meetId
     * @return
     */
    List<MeetPersonDO> getMeetPersons(Integer meetId);

    /**
     * 判断该人员是否已存在对应会议中
     * @return
     */
    Boolean personExitsMeet(MeetPersonDO meetPersonDO);

    /**
     * 获取参会人员的手机号码
     * @return
     */
    List<String> getMeetPersonMobileNo(Integer id);
}
