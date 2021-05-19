package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.NewEntryPersonInfoQueryCnd;
import com.bsoft.hr.dto.NewEntryPersonInfoDTO;
import com.bsoft.hr.dto.NewEntryPersonInfoQueryCndDTO;
import com.bsoft.hr.dto.PersonCompanyDTO;
import com.bsoft.hr.entity.primary.NewEntryPersonInfoDO;
import com.bsoft.hr.entity.primary.PersonCompanyDO;
import com.bsoft.hr.manager.NewEntryPersonInfoManager;
import com.bsoft.hr.service.NewEntryPersonInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class NewEntryPersonInfoServiceImpl implements NewEntryPersonInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewEntryPersonInfoServiceImpl.class);

    @Autowired
    private NewEntryPersonInfoManager newEntryPersonInfoManager;
    @Override
    public Result<NewEntryPersonInfoDTO> getPersonInfoList(String personId,NewEntryPersonInfoQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        NewEntryPersonInfoQueryCnd queryCnd = GeneratorUtil.instance().convert(cnd,NewEntryPersonInfoQueryCnd.class);
        Page<NewEntryPersonInfoDO> page =  newEntryPersonInfoManager.getPersonInfoList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号：{} 查询获取每月入职员工信息成功-带分页，耗时：{}",new Object[]{personId,times});
        return ResultUtils.parseResult(page,NewEntryPersonInfoDTO.class);
    }

    @Override
    public List<NewEntryPersonInfoDTO> getAllPersonInfoList(String personId, NewEntryPersonInfoQueryCndDTO cnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        NewEntryPersonInfoQueryCnd queryCnd = GeneratorUtil.instance().convert(cnd,NewEntryPersonInfoQueryCnd.class);
        List<NewEntryPersonInfoDO> list =  newEntryPersonInfoManager.getAllPersonInfoList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号：{} 查询获取每月入职员工信息成功-不带分页，耗时：{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(list,NewEntryPersonInfoDTO.class);
    }

    @Override
    public void updateSalary(String personId, String updatePersonId, Double probationSalary, Double regularSalary, Double paymentBase,Integer place) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        newEntryPersonInfoManager.updateSalary(updatePersonId,probationSalary,regularSalary,paymentBase,place);
        long times = timeConsumer.end();
        LOGGER.info("工号：{} 更新员工:{}试用期薪资，转正薪资成功，耗时：{}",new Object[]{personId,updatePersonId,times});
    }

    @Override
    public List<PersonCompanyDTO> getAllCompany(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonCompanyDO> list = newEntryPersonInfoManager.getAllCompany();
        long times = timeConsumer.end();
        LOGGER.info("工号：{} 获取所属公司列表，耗时：{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(list,PersonCompanyDTO.class);
    }
}
