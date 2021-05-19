package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.ClockInModeQueryCnd;
import com.bsoft.hr.dto.ClockInModeDeptInfoDTO;
import com.bsoft.hr.dto.ClockInModePersonalInfoDTO;
import com.bsoft.hr.dto.ClockInModeQueryCndDTO;
import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.ClockInModeDeptSaveDO;
import com.bsoft.hr.entity.primary.ClockInModePersonalInfoDO;
import com.bsoft.hr.entity.primary.ClockInModePersonalSaveDO;
import com.bsoft.hr.manager.ClockInModeManager;
import com.bsoft.hr.service.ClockInModeService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 打卡方式维护
 */
@Service
public class ClockInModeServiceImpl implements ClockInModeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClockInModeServiceImpl.class);

    @Autowired
    private ClockInModeManager clockInModeManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<ClockInModeDeptInfoDTO> listDeptInfoWithPage(String userId, ClockInModeQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ClockInModeQueryCnd queryCnd = iGenerator.convert(queryCndDTO, ClockInModeQueryCnd.class);
        Page<ClockInModeDeptInfoDO> page = clockInModeManager.listDeptInfoWithPage(queryCnd);
        Result<ClockInModeDeptInfoDTO> result = ResultUtils.parseResult(page, ClockInModeDeptInfoDTO.class);
        List<ClockInModeDeptInfoDO> children = clockInModeManager.listChildDeptInfo(page.getContent());
        if (children.size() > 0) {
            result.getItems().addAll(iGenerator.convert(children, ClockInModeDeptInfoDTO.class));
        }
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取部门打卡方式信息耗时[{}]", userId, times);
        return result;
    }

    @Override
    public Result<ClockInModePersonalInfoDTO> listPersonalInfoWithPage(String userId, ClockInModeQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ClockInModeQueryCnd queryCnd = iGenerator.convert(queryCndDTO, ClockInModeQueryCnd.class);
        Page<ClockInModePersonalInfoDO> page = clockInModeManager.listPersonalInfoWithPage(queryCnd);
        Result<ClockInModePersonalInfoDTO> result = ResultUtils.parseResult(page, ClockInModePersonalInfoDTO.class);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取个人打卡方式信息耗时[{}]", userId, times);
        return result;
    }

    @Override
    public void setDept(String userId, List<ClockInModeDeptInfoDTO> deptInfoDTOList) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ClockInModeDeptInfoDO> deptInfoDOList = iGenerator.convert(deptInfoDTOList, ClockInModeDeptInfoDO.class);
        List<ClockInModeDeptSaveDO> deptSaveDOList = clockInModeManager.processDeptSaveDOList(deptInfoDOList);
        List<ClockInModePersonalSaveDO> personalSaveDOList = clockInModeManager.processNeedChangePersonList(deptInfoDOList);
        clockInModeManager.setDept(deptSaveDOList, personalSaveDOList);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]设置部门打卡方式耗时[{}]", userId, times);
    }

    @Override
    public void setPersonal(String userId, List<ClockInModePersonalInfoDTO> personalInfoDTOList) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ClockInModePersonalInfoDO> personalInfoDOList = iGenerator.convert(personalInfoDTOList, ClockInModePersonalInfoDO.class);
        List<ClockInModePersonalSaveDO> personalSaveDOList = clockInModeManager.processPersonalSaveDOList(personalInfoDOList);
        clockInModeManager.setPersonal(personalSaveDOList);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]设置个人打卡方式耗时[{}]", userId, times);
    }
}
