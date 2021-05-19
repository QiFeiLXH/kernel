package com.bsoft.project.report.service;

import com.bsoft.project.report.dto.FinancialSubjectDTO;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.service
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 17:38
 * @Description:
 */
public interface FinancialSubjectService {
    /**
     *功能描述 获取报销费用-费用科目
     * @author Xuhui Lin
     * @date 2019/12/20
     * @param
     * @return java.util.List<com.bsoft.project.report.dto.FinancialSubjectDTO>
     */
    public List<FinancialSubjectDTO> findCostSubject();
}
