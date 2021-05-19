package com.bsoft.dept.dao.primary;

import com.bsoft.dept.entity.primary.CloudschoolDeptSyncBackupDO;
import com.bsoft.dept.entity.primary.CloudschoolDeptSyncDO;
import com.bsoft.dept.entity.primary.DeptDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CloudschoolDeptSyncDao extends JpaRepository<CloudschoolDeptSyncDO,String>, JpaSpecificationExecutor<CloudschoolDeptSyncDO> {
    List<CloudschoolDeptSyncDO> findByParentDeptIn(List<String> parentDeptList);

    @Modifying
    @Query(value = "select d from CloudschoolDeptSyncDO d where d.createDate = :createDate and d.logout = 0 order by d.sortBy desc")
    List<CloudschoolDeptSyncDO> findByCreateDate(@Param(value = "createDate") Date date);


    @Modifying
    @Query(value = "select d from CloudschoolDeptSyncDO d where d.endDate = :endDate and d.logout = 1 order by d.sortBy desc")
    List<CloudschoolDeptSyncDO> findByEndDate(@Param(value = "endDate") Date endDate);

    @Query(value = "select d from CloudschoolDeptSyncDO d where  d.logout = :logout order by d.sortBy desc")
    List<CloudschoolDeptSyncDO> findByLogout(@Param(value = "logout") Integer logout);
}
