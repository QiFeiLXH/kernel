package com.bsoft.work.service;

import com.bsoft.common.result.Result;
import com.bsoft.work.dto.CompanySealDTO;
import com.bsoft.work.dto.CompanySealQueryCnd;

import java.util.List;

public interface CompanySealService {
    /**
     * 查询公司印章列表
     * @param companySealQueryCnd
     * @return
     */
    Result<CompanySealDTO> getCompanySealList(CompanySealQueryCnd companySealQueryCnd);

    /**
     * 保存公司印章
     * @param companySealDTO
     */
    void saveCompanySeal(CompanySealDTO companySealDTO);


    /**
     * 根据ID查找公司印章信息
     * @param id
     */
    CompanySealDTO getCompanySealView(Integer id);
}
