package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.work.condition.MeetQueryCnd;
import com.bsoft.work.dto.MeetDTO;
import com.bsoft.work.dto.MeetQueryCndDTO;
import com.bsoft.work.dto.MeetViewDTO;
import com.bsoft.work.entity.primary.MeetDO;
import com.bsoft.work.entity.primary.MeetViewDO;
import com.bsoft.work.manager.MeetManager;
import com.bsoft.work.service.MeetService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @Author zhanglf
 * @Date 2020-12-21 15:07
 * @Version 1.0
 */
@Service
public class MeetServiceImpl implements MeetService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeetServiceImpl.class);
    @Autowired
    private MeetManager meetManager;

    @Override
    public void saveMeet(String personId,MeetDTO meetDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MeetDO meet = GeneratorUtil.instance().convert(meetDTO,MeetDO.class);
        meetManager.saveMeet(meet);
        long times = timeConsumer.end();
        LOGGER.info("工号:{},保存会议信息成功，耗时:{}",new Object[]{personId,times});
    }

    @Override
    public Result<MeetViewDTO> getMeetList(String personId, MeetQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MeetQueryCnd meetQueryCnd = GeneratorUtil.instance().convert(cnd,MeetQueryCnd.class);
        Result<MeetViewDO> result = meetManager.getMeetList(meetQueryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号:{},获取会议列表成功，耗时:{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(result,MeetViewDTO.class);
    }

    @Override
    public void grantProve(String personId,Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        meetManager.grantProve(id);
        long times = timeConsumer.end();
        LOGGER.info("工号:{},发放参会证成功，耗时:{}",new Object[]{personId,times});
    }

    @Override
    public MeetDTO getMeetInfo(String personId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MeetDO meetDO = meetManager.getMeetInfo(id);
        long times = timeConsumer.end();
        LOGGER.info("工号:{},获取会议信息成功，耗时:{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(meetDO,MeetDTO.class);
    }
}
