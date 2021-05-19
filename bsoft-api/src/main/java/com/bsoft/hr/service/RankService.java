package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.RankBaseDTO;
import com.bsoft.hr.dto.RankDTO;

import java.util.Date;

public interface RankService {
    Integer saveRankBase(RankBaseDTO rankBase);

    /** 职级情况-职级列表查询
     * @Param: year 年份
     * @Param: deptId 部门代码
     * @Param: inputContent 查询条件
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @return com.bsoft.common.result.Result<RankDTO>
     * @author Xuhui Lin
     */
    Result<RankDTO> getRankList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize);


    Date getNewestRankDate(String personId);
}
