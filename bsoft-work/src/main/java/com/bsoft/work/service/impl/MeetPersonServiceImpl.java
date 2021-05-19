package com.bsoft.work.service.impl;


import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.work.condition.MeetPersonQueryCnd;
import com.bsoft.work.dto.MeetPersonDTO;
import com.bsoft.work.dto.MeetPersonQueryCndDTO;
import com.bsoft.work.entity.primary.MeetPersonDO;
import com.bsoft.work.manager.MeetPersonManager;
import com.bsoft.work.manager.MeetUserManager;
import com.bsoft.work.service.MeetPersonService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:17
 * @Version 1.0
 */
@Service
public class MeetPersonServiceImpl implements MeetPersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeetPersonServiceImpl.class);

    @Autowired
    private MeetPersonManager meetPersonManager;
    @Autowired
    private MeetUserManager meetUserManager;
    @Override
    public void saveMeetPerson(String personId, MeetPersonDTO meetPerson) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MeetPersonDO meetPersonDO = GeneratorUtil.instance().convert(meetPerson,MeetPersonDO.class);
        meetPersonManager.saveMeetPerson(meetPersonDO);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，保存会议人员姓名{}，手机号{}成功，耗时：{}",new Object[]{personId,meetPerson.getPersonName(),meetPerson.getMobileNo(),times});
    }

    @Override
    public void deleteMeetPerson(String personId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        meetPersonManager.deleteMeetPerson(id);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，删除对应会议人员成功，耗时：{}",new Object[]{personId,times});
    }

    @Override
    public Result<MeetPersonDTO> getMeetPersons(String personId, MeetPersonQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MeetPersonQueryCnd meetPersonQueryCnd = GeneratorUtil.instance().convert(cnd,MeetPersonQueryCnd.class);
        Result<MeetPersonDO> result = meetPersonManager.getMeetPersons(meetPersonQueryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取对应会议人员列表成功，耗时：{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(result,MeetPersonDTO.class);
    }

    @Override
    public void importMeetPersonData(String personId, List<MeetPersonDTO> saveDTOList, List<MeetPersonDTO> errorDTOList) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<MeetPersonDO> saveDOList = GeneratorUtil.instance().convert(saveDTOList,MeetPersonDO.class);
        List<MeetPersonDO> errorDOList = GeneratorUtil.instance().convert(errorDTOList,MeetPersonDO.class);
        meetPersonManager.importMeetPersonData(personId,saveDOList,errorDOList);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，导入会议人员列表成功，耗时：{}",new Object[]{personId,times});
    }

    @Override
    public List<MeetPersonDTO> exportErrorData(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<MeetPersonDO> list = meetPersonManager.exportErrorData(personId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，导出错误数据列表成功，耗时：{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(list,MeetPersonDTO.class);
    }

    @Override
    public String havePersonExits(String personId, MeetPersonDTO meetPerson) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MeetPersonDO meetPersonDO = GeneratorUtil.instance().convert(meetPerson,MeetPersonDO.class);
        String exitsName = meetUserManager.havePersonExits(meetPersonDO);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取人员信息手机号:{},姓名:{}，耗时：{}",new Object[]{personId,meetPerson.getMobileNo(),exitsName,times});
        return exitsName;
    }

    @Override
    public List<MeetPersonDTO> getMeetPersons(String personId, Integer meetId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<MeetPersonDO> list = meetPersonManager.getMeetPersons(meetId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取对应参会人员列表成功，耗时：{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(list,MeetPersonDTO.class);
    }

    @Override
    public Boolean personExitsMeet(String personId,MeetPersonDTO meetPerson) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MeetPersonDO meetPersonDO = GeneratorUtil.instance().convert(meetPerson,MeetPersonDO.class);
        Boolean exits = meetPersonManager.personExitsMeet(meetPersonDO);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，判断：{}是否存在于会议：{}，耗时：{}",new Object[]{personId,meetPerson.getMobileNo(),exits,times});
        return exits;
    }
}
