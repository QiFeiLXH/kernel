package com.bsoft.cost.service;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.FinanceCostQueryCndDTO;
import com.bsoft.cost.dto.FinanceCostViewDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-26 10:34
 * @Version 1.0
 * @Description
 */
public interface FinanceCostService {
    /**
     * 财务--财务项目需求信息
     * @param financeCostQueryCndDTO
     * @return
     */
    Result<FinanceCostViewDTO> getFinanceCostList(FinanceCostQueryCndDTO financeCostQueryCndDTO);

    /**
     * 财务--财务项目需求信息--下载信息
     * @param financeCostQueryCndDTO
     * @return
     */
    List<FinanceCostViewDTO> getFinanceCostDownload(FinanceCostQueryCndDTO financeCostQueryCndDTO);
}
