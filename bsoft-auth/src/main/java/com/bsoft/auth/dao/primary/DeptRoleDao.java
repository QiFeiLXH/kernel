package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.DeptRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRoleDao extends JpaRepository<DeptRoleDO,Integer>, JpaSpecificationExecutor<DeptRoleDO> {
    DeptRoleDO findByDeptAndRoleId(String dept,Integer roleId);

    @Query("select a.dept from DeptRoleDO a where a.userId = :personId and a.roleId = :roleId")
    List<String> getManagerDept(@Param("personId") String personId, @Param("roleId") Integer roleId);

    List<DeptRoleDO> findDeptRoleDOSByDeptAndRoleId(@Param("dept") String dept, @Param("roleId") Integer roleId);

}
