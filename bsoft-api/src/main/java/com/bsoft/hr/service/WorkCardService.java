package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.WorkCardDTO;
import com.bsoft.hr.dto.WorkCardDateCountDTO;
import com.bsoft.hr.dto.WorkCardQueryCndDTO;

import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/15 17:40
 * @Description
 */
public interface WorkCardService {
    /**
     * 获取日期及数量列表
     * @param
     * @return
     */
    List<WorkCardDateCountDTO> getDateList();

    /**
     * 获取员工工牌列表
     * @param cndDTO
     * @return
     */
    Result<WorkCardDTO> getWorkCardList(WorkCardQueryCndDTO cndDTO);

    /**
     * 获取员工工牌制作列表
     * @param cndDTO
     * @return
     */
    Result<WorkCardDTO> getWorkCardMakeList(WorkCardQueryCndDTO cndDTO);

    /**
     * 获取员工工牌门禁开通列表
     * @param cndDTO
     * @return
     */
    Result<WorkCardDTO> getWorkCardOpenAccessList(WorkCardQueryCndDTO cndDTO);

    /**
     * 获取员工工牌待核实数量
     * @param
     * @return
     */
    Integer getWorkCardVerifyCount(WorkCardQueryCndDTO cndDTO);

    /**
     * 获取员工工牌待领取数量
     * @param
     * @return
     */
    Integer getWorkCardReceiveCount(WorkCardQueryCndDTO cndDTO);

    /**
     * 获取员工工牌待制作数量
     * @param
     * @return
     */
    Integer getWorkCardMakeCount(WorkCardQueryCndDTO cndDTO);

    /**
     * 获取员工工牌门禁待开通数量
     * @param
     * @return
     */
    Integer getWorkCardOpenAccessCount(WorkCardQueryCndDTO cndDTO);


    /**
     * 获取员工类别对应的饭卡充值金额
     * @param personType 员工类别
     * @param startDate 报道日期
     * @return
     */
    Double getPersonWorkCardAmount(Integer personType, Date startDate);

    /**
     * 核实工牌
     * @param workCardDTO
     * @return
     */
    void verifyWorkCard(WorkCardDTO workCardDTO);

    /**
     * 工牌权限开通
     * @param workCardDTO
     * @return
     */
    void openAccessWorkCard(WorkCardDTO workCardDTO);

    /**
     * 工牌制作
     * @param workCardDTO
     * @return
     */
    void makeWorkCard(WorkCardDTO workCardDTO);

    /**
     * 工牌领取
     * @param personId 工号
     * @return
     */
    void receiveWorkCard(String personId);

    /**
     * 门户工牌信息核实待办数量
     * @param personId 工号
     * @return
     */
    Integer getPortalWorkCardVerifyNeedDoCount(String personId);

    /**
     * 门户工牌信息制作待办数量
     * @param personId 工号
     * @return
     */
    Integer getPortalWorkCardMakeNeedDoCount(String personId);

    /**
     * 门户工牌信息门禁权限开通待办数量
     * @param personId 工号
     * @return
     */
    Integer getPortalWorkCardOpenNeedDoCount(String personId);

    /**
     * 门户工牌信息领取待办数量
     * @param personId 工号
     * @return
     */
    Integer getPortalWorkCardReceiveNeedDoCount(String personId);

    /**
     * 批量领取工牌
     * @param personIds 待领取的工号列表
     * @return
     */
    void batchReceiveWorkCard(List<String> personIds);

    /**
     * 查找待制作工牌人员信息
     * @param personIds 待制作的工号列表
     * @return
     */
    List<WorkCardDTO> getWorkCardNeedMakingList(List<String> personIds);
}
