package com.bsoft.cost.repository.primary;

import com.bsoft.cost.entity.primary.CostTypeDeptViewDO;
import com.bsoft.cost.entity.primary.DeptCostTypeDO;
import com.bsoft.cost.entity.primary.DeptCostTypeViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/3 17:32
 * @Description:
 */

@Mapper
@Repository
public interface DeptCostTypeRepository {

    List<CostTypeDeptViewDO> findDeptList(@Param("year") Integer year,@Param("flag") Integer flag,@Param("bmlb") Integer bmlb, @Param("zxbz") Integer zxbz,@Param("deptId") String deptId);

    List<CostTypeDeptViewDO> findDeptListByDeptId(@Param("year") Integer year,@Param("flag") Integer flag,@Param("bmlb") Integer bmlb, @Param("zxbz") Integer zxbz,@Param("parentBm") String parentBm);

    DeptCostTypeViewDO getDeptCostType(@Param("year") Integer year,@Param("deptNo") String deptNo);

    void annualGener(@Param("list") List<DeptCostTypeDO> list);
}
