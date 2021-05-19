package com.bsoft.dept.repository.primary;

import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.entity.primary.DeptSelectViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/25 13:28
 * @Description:
 */
@Mapper
@Repository
public interface DeptSelectRepository {

    List<DeptSelectViewDO> getDeptSelectList(@Param("logout") String logout, @Param("deptType") String deptType, @Param("personId") String personId);

    List<DeptDO> getAllValidRegionAndSubDeptList();
}
