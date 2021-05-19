package com.bsoft.project.report.repository.primary;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.repository
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-19 10:14
 * @Description: 报销费用-动态行转动态列存储过程调用
 */
@Mapper
@Repository
public interface RowsToColsProcedureRepository {
    /**
     *功能描述 调用报销费用-项目级 行转列存储过程并生成可查询视图
     * @author Xuhui Lin
     * @date 2019/12/20
     * @param params
     * @return void
     */
    void callProjectLevelProcedure(HashMap<String,Object> params);

    /**
     *功能描述 调用报销费用-合同级 行转列存储过程并生成可查询视图
     * @author Xuhui Lin
     * @date 2019/12/20
     * @param params
     * @return void
     */
    void callContractLevelProcedure(HashMap<String,Object> params);
}
