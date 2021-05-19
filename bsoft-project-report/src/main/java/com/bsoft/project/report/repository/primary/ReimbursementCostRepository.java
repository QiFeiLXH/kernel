package com.bsoft.project.report.repository.primary;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.repository
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-18 09:15
 * @Description: 报销费用-项目级-全部
 */
@Mapper
@Repository
public interface ReimbursementCostRepository {
    List<Map<String,String>> findReimburseProAllTotal();
    List<Map<String,String>> findReimburseProAllYear();
    List<Map<String,String>> findReimburseProAllMonth();
    List<Map<String,String>> findReimburseProDepTotal();
    List<Map<String,String>> findReimburseProDepYear();
    List<Map<String,String>> findReimburseProDepMonth();
    List<Map<String,String>> findReimburseConAllTotal();
    List<Map<String,String>> findReimburseConAllYear();
    List<Map<String,String>> findReimburseConAllMonth();
    List<Map<String,String>> findReimburseConDepTotal();
    List<Map<String,String>> findReimburseConDepYear();
    List<Map<String,String>> findReimburseConDepMonth();
}
