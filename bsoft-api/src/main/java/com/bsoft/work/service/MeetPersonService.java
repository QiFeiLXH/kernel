package com.bsoft.work.service;

import com.bsoft.common.result.Result;
import com.bsoft.work.dto.MeetPersonDTO;
import com.bsoft.work.dto.MeetPersonQueryCndDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:15
 * @Version 1.0
 */
public interface MeetPersonService {
    void saveMeetPerson(String personId, MeetPersonDTO meetPerson);

    void deleteMeetPerson(String personId,Integer id);

    Result<MeetPersonDTO> getMeetPersons(String personId,MeetPersonQueryCndDTO meetPersonQueryCnd);

    /**
     * 导入会议人员名单
     * @param personId
     * @param saveDTOList
     * @param errorDTOList
     */
    void importMeetPersonData(String personId, List<MeetPersonDTO> saveDTOList, List<MeetPersonDTO> errorDTOList);

    /**
     * 导出错误数据
     * @param personId
     * @return
     */
    public List<MeetPersonDTO> exportErrorData(String personId);

    /**
     * 判断对应手机号是否已存在用户表中 已使用
     */
    String havePersonExits(String personId,MeetPersonDTO meetPerson);

    /**
     * 根据会议id获取参会人员
     * @return
     */
    List<MeetPersonDTO> getMeetPersons(String personId,Integer meetId);

    /**
     * 判断该人员是否已存在对应会议中
     * @return
     */
    Boolean personExitsMeet(String personId,MeetPersonDTO meetPerson);
}
