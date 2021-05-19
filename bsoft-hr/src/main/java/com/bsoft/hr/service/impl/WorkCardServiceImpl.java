package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.WorkCardQueryCnd;
import com.bsoft.hr.dto.WorkCardDTO;
import com.bsoft.hr.dto.WorkCardDateCountDTO;
import com.bsoft.hr.dto.WorkCardQueryCndDTO;
import com.bsoft.hr.entity.primary.WorkCardDO;
import com.bsoft.hr.entity.primary.WorkCardDateCountViewDO;
import com.bsoft.hr.entity.primary.WorkCardViewDO;
import com.bsoft.hr.manager.WorkCardManager;
import com.bsoft.hr.service.WorkCardService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/17 14:54
 * @Description
 */
@Service
public class WorkCardServiceImpl implements WorkCardService {
    private final static Logger LOGGER = LoggerFactory.getLogger(WorkCardServiceImpl.class);

    @Autowired
    private WorkCardManager workCardManager;
    @Autowired
    private IGenerator iGenerator;


    @Override
    public List<WorkCardDateCountDTO> getDateList() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<WorkCardDateCountViewDO> list = workCardManager.getDateList();
        long times = timeConsumer.end();
        LOGGER.info("查询日期及数量耗时:{}", times);
        return iGenerator.convert(list, WorkCardDateCountDTO.class);
    }

    @Override
    public Result<WorkCardDTO> getWorkCardList(WorkCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardQueryCnd cnd = iGenerator.convert(cndDTO, WorkCardQueryCnd.class);
        PageInfo<WorkCardViewDO> pageInfo = workCardManager.getWorkCardList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("员工工牌列表耗时:{}",  times);
        return ResultUtils.parseResult(pageInfo, WorkCardDTO.class);
    }

    @Override
    public Result<WorkCardDTO> getWorkCardMakeList(WorkCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardQueryCnd cnd = iGenerator.convert(cndDTO, WorkCardQueryCnd.class);
        Page<WorkCardViewDO> pages = workCardManager.getWorkCardMakeList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("员工工牌制作列表耗时:{}",  times);
        return ResultUtils.parseResult(pages, WorkCardDTO.class);
    }

    @Override
    public Result<WorkCardDTO> getWorkCardOpenAccessList(WorkCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardQueryCnd cnd = iGenerator.convert(cndDTO, WorkCardQueryCnd.class);
        Page<WorkCardViewDO> pages = workCardManager.getWorkCardOpenAccessList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("员工工牌门禁开通列表耗时:{}",  times);
        return ResultUtils.parseResult(pages, WorkCardDTO.class);
    }

    @Override
    public Integer getWorkCardVerifyCount(WorkCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardQueryCnd cnd = iGenerator.convert(cndDTO, WorkCardQueryCnd.class);
        Integer count = workCardManager.getWorkCardVerifyCount(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取员工工牌待核实数量耗时:{}", times);
        return count;
    }

    @Override
    public Integer getWorkCardReceiveCount(WorkCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardQueryCnd cnd = iGenerator.convert(cndDTO, WorkCardQueryCnd.class);
        Integer count = workCardManager.getWorkCardReceiveCount(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取员工工牌待领取数量耗时:{}", times);
        return count;
    }

    @Override
    public Integer getWorkCardMakeCount(WorkCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardQueryCnd cnd = iGenerator.convert(cndDTO, WorkCardQueryCnd.class);
        Integer count = workCardManager.getWorkCardMakeCount(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取员工工牌待制作数量耗时:{}", times);
        return count;
    }

    @Override
    public Integer getWorkCardOpenAccessCount(WorkCardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardQueryCnd cnd = iGenerator.convert(cndDTO, WorkCardQueryCnd.class);
        Integer count = workCardManager.getWorkCardOpenAccessCount(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取员工工牌门禁待开通数量耗时:{}", times);
        return count;
    }

    @Override
    public Double getPersonWorkCardAmount(Integer personType, Date startDate) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Double amount = workCardManager.getPersonWorkCardAmount(personType,startDate);
        long times = timeConsumer.end();
        LOGGER.info("获取员工类别：{}，报道日期：{}的工牌充值金额耗时:{}", personType, startDate,times);
        return amount;
    }

    @Override
    public void verifyWorkCard(WorkCardDTO workCardDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardDO workCardDO = iGenerator.convert(workCardDTO, WorkCardDO.class);
        workCardManager.verifyWorkCard(workCardDO);
        long times = timeConsumer.end();
        LOGGER.info("核实工号：{}的工牌耗时:{}", workCardDTO.getPersonId(), times);
    }

    @Override
    public void openAccessWorkCard(WorkCardDTO workCardDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardDO workCardDO = iGenerator.convert(workCardDTO, WorkCardDO.class);
        workCardManager.openAccessWorkCard(workCardDO);
        long times = timeConsumer.end();
        LOGGER.info("开通权限工号：{}的工牌耗时:{}", workCardDTO.getPersonId(), times);
    }

    @Override
    public void makeWorkCard(WorkCardDTO workCardDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkCardDO workCardDO = iGenerator.convert(workCardDTO, WorkCardDO.class);
        workCardManager.makeWorkCard(workCardDO);
        long times = timeConsumer.end();
        LOGGER.info("制作工号：{}的工牌耗时:{}", workCardDTO.getPersonId(), times);
    }

    @Override
    public void receiveWorkCard(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        workCardManager.receiveWorkCard(personId);
        long times = timeConsumer.end();
        LOGGER.info("领取工号：{}的工牌耗时:{}", personId, times);
    }

    @Override
    public Integer getPortalWorkCardVerifyNeedDoCount(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = workCardManager.getPortalWorkCardVerifyNeedDoCount(personId);
        long times = timeConsumer.end();
        LOGGER.info("获取工号：{}的门户工牌待核实耗时:{}", personId, times);
        return count;
    }

    @Override
    public Integer getPortalWorkCardMakeNeedDoCount(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = workCardManager.getPortalWorkCardMakeNeedDoCount(personId);
        long times = timeConsumer.end();
        LOGGER.info("获取工号：{}的门户工牌待制作耗时:{}", personId, times);
        return count;
    }

    @Override
    public Integer getPortalWorkCardOpenNeedDoCount(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = workCardManager.getPortalWorkCardOpenNeedDoCount(personId);
        long times = timeConsumer.end();
        LOGGER.info("获取工号：{}的门户工牌门禁权限待开通耗时:{}", personId, times);
        return count;
    }

    @Override
    public Integer getPortalWorkCardReceiveNeedDoCount(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = workCardManager.getPortalWorkCardReceiveNeedDoCount(personId);
        long times = timeConsumer.end();
        LOGGER.info("获取工号：{}的门户工牌待领取耗时:{}", personId, times);
        return count;
    }

    @Override
    public void batchReceiveWorkCard(List<String> personIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        workCardManager.batchReceiveWorkCard(personIds);
        long times = timeConsumer.end();
        LOGGER.info("批量领取工号为：{}的工牌耗时:{}", personIds, times);
    }

    @Override
    public List<WorkCardDTO> getWorkCardNeedMakingList(List<String> personIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<WorkCardViewDO> list = workCardManager.getWorkCardNeedMakingList(personIds);
        long times = timeConsumer.end();
        LOGGER.info("查询待下载制作工号为：{}的工牌耗时:{}", personIds, times);
        return iGenerator.convert(list, WorkCardDTO.class);
    }

}
