package com.bsoft.house.service.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.house.dto.HouseDTO;
import com.bsoft.house.entity.primary.HouseDO;
import com.bsoft.house.entity.primary.HouseViewDO;
import com.bsoft.house.manager.HouseManager;
import com.bsoft.house.manager.HouseViewManager;
import com.bsoft.house.service.HouseService;
import com.bsoft.project.dto.ProjectBaseDTO;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Service
public class HouseServiceImpl implements HouseService {
    private static final Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);
    private static final  Integer DEFAULT_SIZE = 25;

    @Autowired
    private HouseManager houseManager;
    @Autowired
    private HouseViewManager houseViewManager;

    @Override
    public Result<HouseDTO> getHouses(Integer page, Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<HouseDO> housePage =  houseManager.getHouses(page,size);
        long times = timeConsumer.end();
        logger.info("获取房屋列表耗时:{}",times);
        return ResultUtils.parseResult(housePage,HouseDTO.class);
    }

    @Override
    public Result<HouseDTO> getHouses(Integer page) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<HouseDO> housePage = houseManager.getHouses(page,DEFAULT_SIZE);
        long times = timeConsumer.end();
        logger.info("获取房屋列表耗时:{}",times);
        return ResultUtils.parseResult(housePage,HouseDTO.class);
    }

    @Override
    public Result<HouseDTO> searchHouses(String context, Integer page) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<HouseDO> housePage = houseManager.searchHouses(context,page,DEFAULT_SIZE);
        long times = timeConsumer.end();
        logger.info("查找房屋耗时:{}",times);
        return ResultUtils.parseResult(housePage,HouseDTO.class);
    }

    @Override
    public Result<HouseDTO> searchHouseViews(String context,String area,String userId, Integer page, Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<HouseViewDO> pageInfo = houseViewManager.searchHouses(context,area,userId,page,size);
        long times = timeConsumer.end();
        logger.info("工号:{},搜索词:{},查找房屋耗时:{}",userId,context,times);
        return ResultUtils.parseResult(pageInfo, HouseDTO.class);
    }

    @Override
    public Result<HouseDTO> searchHouses(String context, Integer page, Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<HouseDO> housePage = houseManager.searchHouses(context,page,size);
        long times = timeConsumer.end();
        logger.info("查找房屋耗时:{}",times);
        return ResultUtils.parseResult(housePage,HouseDTO.class);
    }
}
