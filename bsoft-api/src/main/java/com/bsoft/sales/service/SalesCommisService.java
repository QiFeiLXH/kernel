package com.bsoft.sales.service;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.sales.dto.SalesCommisImportDTO;
import com.bsoft.sales.dto.SalesCommisQueryCndDTO;
import com.bsoft.sales.dto.SalesCommisViewDTO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 13:44
 * @Description: 销售提成
 */
public interface SalesCommisService {
    /**
     * 查询销售提成列表
     * @param cndDTO
     * @return
     */
    Result<SalesCommisViewDTO> getSalesCommis(SalesCommisQueryCndDTO cndDTO);

    /**
     * 删除销售提成信息
     * @param ids
     */
    void deleteSalesCommis(List<Integer> ids);

    /**
     * 审核生成提奖
     * @param ids
     * @param personId
     */
    void aduitSalesCommis(List<Integer> ids,String personId);

    /**
     * 导入销售提成信息
     * @param list
     * @param personId
     * @return
     */
    ImportResultDTO importSalesCommis(List<SalesCommisImportDTO> list, String personId);

    /**
     * 获取导入失败数据
     * @param personId 操作人
     * @return
     */
    List<SalesCommisImportDTO> getImportError(String personId);
}
