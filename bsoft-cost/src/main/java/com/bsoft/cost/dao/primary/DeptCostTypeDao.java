package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.DeptCostTypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 16:29
 * @Description:
 */
@Repository
public interface DeptCostTypeDao extends JpaRepository<DeptCostTypeDO,Integer>, JpaSpecificationExecutor<DeptCostTypeDO> {

    List<DeptCostTypeDO> findAllByYear(Integer year);

    void deleteAllByYearAndDeptIn(Integer year,List<String> depts);

    @Query("select a from DeptCostTypeDO a,DeptDO  b where a.dept = b.deptId and a.year = :lastYear and b.logout = 0")
    List<DeptCostTypeDO> findLastList(@Param("lastYear") Integer lastYear);

}
