package com.bsoft.sales.service;

import com.bsoft.common.result.Result;
import com.bsoft.sales.dto.OriginalAcceptanceDTO;
import com.bsoft.sales.dto.OriginalAcceptanceQueryCndDTO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 15:57
 * @Description: 合同原件接收、归档Service
 */
public interface OriginalAcceptanceService {
    /**
     * 查询合同原件待审核列表
     * @param cndDTO
     * @return
     */
    Result<OriginalAcceptanceDTO> getOriginalAcceptance(OriginalAcceptanceQueryCndDTO cndDTO);

    /**
     * 合同原件审核操作
     * @param wordDTOS
     * @param userId
     * @param status
     */
    void auditOriginalAcceptance(List<OriginalAcceptanceDTO> wordDTOS,String userId,Integer status);
}
