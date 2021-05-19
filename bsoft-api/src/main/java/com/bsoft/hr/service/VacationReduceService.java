package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.VacationReduceDTO;
import com.bsoft.hr.dto.VacationReduceQueryCndDTO;

public interface VacationReduceService {
    /**
     * 获取年假扣除情况列表
     * @param cnd
     * @return
     */
    Result<VacationReduceDTO> getVacationReduceList(String personId,VacationReduceQueryCndDTO cnd);

    /**
     * 保存年假扣除信息
     * @param vacationReduce
     */
    void save(String personId,VacationReduceDTO vacationReduce);

    /**
     * 删除未执行的年假扣除信息
     * @param personId
     * @param vacationReduce
     */
    void delete(String personId,VacationReduceDTO vacationReduce);

    /**
     * 统一扣除年假
     */
    void reduceAnnualVacationUnified(String personId,String year, Integer days ,Integer reduceId);
}
