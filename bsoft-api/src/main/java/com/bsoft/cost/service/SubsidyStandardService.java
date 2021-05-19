package com.bsoft.cost.service;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.SubsidyStandardQueryCndDTO;
import com.bsoft.cost.dto.SubsidyStandardViewDTO;

/**
 * @Author: xucl
 * @DateTime: 2020/11/20 8:59
 * @Description:
 */
public interface SubsidyStandardService {
    /**
     * 分页查询特殊津贴申请列表
     * @param cndDTO
     * @return
     */
    Result<SubsidyStandardViewDTO> findSubsidyStandard(SubsidyStandardQueryCndDTO cndDTO);

    /**
     * 保存、更新特殊津贴
     * @param standardViewDTO
     */
    void saveSubsidyStandard(SubsidyStandardViewDTO standardViewDTO);

}
