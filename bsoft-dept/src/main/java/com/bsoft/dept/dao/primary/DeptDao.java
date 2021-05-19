package com.bsoft.dept.dao.primary;

import com.bsoft.dept.entity.primary.DeptDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao extends JpaRepository<DeptDO,String>, JpaSpecificationExecutor<DeptDO> {
    List<DeptDO> findByLogout(Integer flag);

    List<DeptDO> findByDeptNameIn(List<String> nameList);

    List<DeptDO> findAllByParentIdAndLogout(String parentDept,Integer logout);

    @Query("select count(a) from DeptDO a where a.firstManager = :personId and a.logout = 0")
    Integer getFirstDepManagerCount(@Param("personId") String personId);

    @Query("select count(a) from DeptDO a where a.depManager = :personId and a.logout = 0")
    Integer getSecondDepManagerCount(@Param("personId") String personId);

    @Query("select count(a) from DeptDO a where a.hr = :personId and a.logout = 0")
    Integer getHrManagerCount(@Param("personId") String personId);

    @Query("select count(a) from DeptDO a where a.leader = :personId and a.logout = 0")
    Integer getLeaderCount(@Param("personId") String personId);

    @Query("select a from DeptDO a where a.logout = 0 and a.parentId in (:deptIds)")
    List<DeptDO> getValidDeptListWithRegionDeptIds(@Param("deptIds")List<String> deptIds);

}
