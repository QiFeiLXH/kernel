package com.bsoft.sales.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.sales.report.dto.SalesDynamicDTO;

public interface SalesDynamicService {
    /**
     * @Description: 分页获取销售动态列表
     * @param personId 员工工号
     * @param page 页码，起始页从0开始
     * @param size 条数，一页显示的条数
     * @return Result<SalesDynamicDTO> 销售动态列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<SalesDynamicDTO> getSalesDynamic(String personId,Integer page,Integer size);
    /**
     * @Description: 分页获取销售动态列表
     * @param personId 员工工号
     * @param page 页码，起始页从0开始，默认一页10条数据
     * @return Result<SalesDynamicDTO> 销售动态列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<SalesDynamicDTO> getSalesDynamic(String personId,Integer page);
}
