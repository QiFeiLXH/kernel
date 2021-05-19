package com.bsoft.dept.dao.primary;

import com.bsoft.dept.entity.primary.CloudschoolDeptSyncBackupDO;
import com.bsoft.dept.entity.primary.CloudschoolDeptSyncDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CloudschoolDeptSyncBackupDao extends JpaRepository<CloudschoolDeptSyncBackupDO,String>, JpaSpecificationExecutor<CloudschoolDeptSyncBackupDO> {
    List<CloudschoolDeptSyncDO> findByParentDeptIn(List<String> parentDeptList);

    @Query(value = "select d from CloudschoolDeptSyncBackupDO d where  d.logout = :logout order by d.sortBy desc")
    List<CloudschoolDeptSyncBackupDO> findByLogout(@Param(value = "logout") Integer logout);

//    @Modifying
//    @Query(value="insert into  bsoftmis.t_dep_sync_backup  select BMDM,BMMC,ZXBZ,BMLB,PARENTBM,SORTBY   from BSOFTMIS.t_dep")
//    void  updateDeptBackup();
}
