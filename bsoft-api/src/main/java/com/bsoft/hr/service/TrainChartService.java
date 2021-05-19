package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.TrainChartDTO;
import com.bsoft.hr.dto.TrainChartCndDTO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/5 13:28
 */
public interface TrainChartService {

    /**
     * 获取培训情况统计
     * @param cndDTO
     * @return
     */
    Result<TrainChartDTO> getTrainChartList(TrainChartCndDTO cndDTO);
}
