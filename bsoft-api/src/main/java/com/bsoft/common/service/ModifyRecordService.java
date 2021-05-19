package com.bsoft.common.service;

import com.bsoft.common.dto.ModifyRecordDTO;
import com.bsoft.common.dto.ModifyRecordQueryCndDTO;
import com.bsoft.common.result.Result;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/10 16:50
 * @Description
 */
public interface ModifyRecordService {
    /** 获取修改记录列表
     * @Param: cndDTO 查询条件
     * @return Result<ModifyRecordDTO>
     * @author Xuhui Lin
     */
    Result<ModifyRecordDTO> getModifyRecordList(ModifyRecordQueryCndDTO cndDTO);
}
