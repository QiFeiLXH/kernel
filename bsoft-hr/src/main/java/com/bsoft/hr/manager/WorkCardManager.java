package com.bsoft.hr.manager;

import com.bsoft.hr.condition.WorkCardQueryCnd;
import com.bsoft.hr.entity.primary.WorkCardDO;
import com.bsoft.hr.entity.primary.WorkCardDateCountViewDO;
import com.bsoft.hr.entity.primary.WorkCardViewDO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/15 17:38
 * @Description
 */
public interface WorkCardManager {
    List<WorkCardDateCountViewDO> getDateList();

    PageInfo<WorkCardViewDO> getWorkCardList(WorkCardQueryCnd cnd);

    Double getPersonWorkCardAmount(Integer personType, Date startDate);

    void verifyWorkCard(WorkCardDO workCardDO);

    void makeWorkCard(WorkCardDO workCardDO);

    void openAccessWorkCard(WorkCardDO workCardDO);

    void receiveWorkCard(String personId);

    Page<WorkCardViewDO> getWorkCardMakeList(WorkCardQueryCnd cnd);

    Page<WorkCardViewDO> getWorkCardOpenAccessList(WorkCardQueryCnd cnd);

    Integer getWorkCardVerifyCount(WorkCardQueryCnd cnd);

    Integer getWorkCardReceiveCount(WorkCardQueryCnd cnd);

    Integer getWorkCardMakeCount(WorkCardQueryCnd cnd);

    Integer getWorkCardOpenAccessCount(WorkCardQueryCnd cnd);

    Integer getPortalWorkCardVerifyNeedDoCount(String personId);

    Integer getPortalWorkCardMakeNeedDoCount(String personId);

    Integer getPortalWorkCardOpenNeedDoCount(String personId);

    Integer getPortalWorkCardReceiveNeedDoCount(String personId);

    void batchReceiveWorkCard(List<String> personIds);

    List<WorkCardViewDO> getWorkCardNeedMakingList(List<String> personIds);
}

