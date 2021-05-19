package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.FinancialSubjectDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.repository
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-19 10:14
 * @Description: 报销费用-费用科目获取
 */
@Mapper
@Repository
public interface FinancialSubjectRepository {
    List<FinancialSubjectDO> findCostSubject();
}
