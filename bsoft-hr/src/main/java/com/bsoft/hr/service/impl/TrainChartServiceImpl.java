package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.TrainChartViewCnd;
import com.bsoft.hr.dto.TrainChartDTO;
import com.bsoft.hr.dto.TrainChartCndDTO;
import com.bsoft.hr.entity.primary.TrainChartViewDO;
import com.bsoft.hr.manager.TrainChartManager;
import com.bsoft.hr.service.TrainChartService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/5 13:31
 */

@Service
public class TrainChartServiceImpl implements TrainChartService {

    private static final Logger logger = LoggerFactory.getLogger(TrainChartServiceImpl.class);

    @Autowired
    private TrainChartManager trainChartManager;
    @Autowired
    private IGenerator iGenerator;

    /**
     * 获取培训情况统计
     * @param cndDTO
     * @return
     */
    @Override
    public Result<TrainChartDTO> getTrainChartList(TrainChartCndDTO cndDTO) {
        TrainChartViewCnd cnd = iGenerator.convert(cndDTO, TrainChartViewCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<TrainChartViewDO> pages = trainChartManager.getTrainChartList(cnd);
        Long times = timeConsumer.end();
        logger.info("获取培训情况统计耗时[{}]", times);
        return ResultUtils.parseResult(pages, TrainChartDTO.class);
    }
}
