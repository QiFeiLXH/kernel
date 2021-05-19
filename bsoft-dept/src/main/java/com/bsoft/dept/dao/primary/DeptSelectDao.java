package com.bsoft.dept.dao.primary;

import com.bsoft.dept.entity.primary.DeptSelectDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptSelectDao extends JpaRepository<DeptSelectDO,String>, JpaSpecificationExecutor<DeptSelectDO> {
    List<DeptSelectDO> findAllByLogout(Integer logout);

    @Query("select a from DeptSelectDO a where a.logout = 0 and a.parentFlag = 1 order by a.sortBy")
    List<DeptSelectDO> getAllValidParentDeptList();
}
