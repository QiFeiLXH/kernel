package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.LactationDTO;
import com.bsoft.hr.dto.LactationQueryCndDTO;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:16
 * @Description
 */
public interface LactationService {

    /**
     * 获取哺乳假列表
     * @param cndDTO
     * @return
     */
    Result<LactationDTO> getLactationList(LactationQueryCndDTO cndDTO);

    /**
     * 保存，更新哺乳假
     * @param lactationDTO
     * @return
     */
    Integer saveLactation(LactationDTO lactationDTO);
}
