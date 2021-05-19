package com.bsoft.sales.report.service;

import com.bsoft.sales.report.dto.DynamicClueDTO;
import com.bsoft.sales.report.dto.DynamicContractDTO;
import com.bsoft.sales.report.dto.DynamicReviewDTO;
import com.bsoft.sales.report.dto.DynamicTenderDTO;

import java.util.List;

public interface DynamicDetailService {
    /**
     * @Description: 获取线索详情
     * @param dynamicId 销售动态ID
     * @return List<DynamicClueDTO> 线索详情列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<DynamicClueDTO> getDynamicClue(Integer dynamicId);

    /**
     * @Description: 获取合同详情
     * @param dynamicId 销售动态ID
     * @return List<DynamicContractDTO> 合同详情列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<DynamicContractDTO> getDynamicContract(Integer dynamicId);

    /**
     * @Description: 获取合同评审详情
     * @param dynamicId 销售动态ID
     * @return List<DynamicReviewDTO> 合同详情详情列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<DynamicReviewDTO> getDynamicReview(Integer dynamicId);

    /**
     * @Description: 获取投标详情
     * @param dynamicId 销售动态ID
     * @return List<DynamicTenderDTO> 投标详情列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<DynamicTenderDTO> getDynamicTender(Integer dynamicId);
}
