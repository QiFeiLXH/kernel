package com.bsoft.cost.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.dto.AccountCaliberDTO;
import com.bsoft.cost.entity.primary.AccountCaliberViewDO;
import com.bsoft.cost.manager.AccountCaliberManager;
import com.bsoft.cost.service.AccountCaliberService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 9:59
 * @Description
 */
@Service
public class AccountCaliberServiceImpl implements AccountCaliberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountCaliberServiceImpl.class);

    @Autowired
    private AccountCaliberManager accountCaliberManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<AccountCaliberDTO> getDpetAccountCaliberList(Integer pageNo, Integer pageSize, Integer year, Integer accountCaliber, String deptId,Integer deptType) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<AccountCaliberViewDO> pages = accountCaliberManager.getDpetAccountCaliberList(pageNo,pageSize,year,accountCaliber,deptId,deptType);
        long times = timeConsumer.end();
        LOGGER.info("年份:{}，部门:{},核算口径归属：{}，部门类别：{}，获取部门核算口径归属列表耗时:{}",year,deptId,accountCaliber,deptType,times);
        return ResultUtils.parseResult(pages,AccountCaliberDTO.class);
    }

    @Override
    public void saveYearlyDeptAccountCaliber(Integer year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        accountCaliberManager.saveYearlyDeptAccountCaliber(year);
        long times = timeConsumer.end();
        LOGGER.info("年份：{}，生成年度核算口径归属部门耗时:{}",year,times);
    }

    @Override
    public void saveDeptAccountCaliber(List<Integer> caliberSaves, List<Integer> caliberDeletes, String deptId, Integer year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        accountCaliberManager.saveDeptAccountCaliber(caliberSaves,caliberDeletes,deptId,year);
        long times = timeConsumer.end();
        LOGGER.info("年份：{}，部门id: {},保存部门核算口径归属耗时:{}",year,deptId,times);
    }

    @Override
    public List<AccountCaliberDTO> getAccountCaliberByDeptId(String deptId, Integer year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AccountCaliberViewDO> accountCaliberDTOList = accountCaliberManager.findByDeptIdAndYear(deptId,year);
        long times = timeConsumer.end();
        LOGGER.info("年份:{}，部门:{},获取部门核算口径归属列表耗时:{}",year,deptId,times);
        return iGenerator.convert(accountCaliberDTOList,AccountCaliberDTO.class);
    }
}
