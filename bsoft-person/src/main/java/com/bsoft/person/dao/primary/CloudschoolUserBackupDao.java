package com.bsoft.person.dao.primary;

import com.bsoft.dept.entity.primary.CloudschoolDeptSyncBackupDO;
import com.bsoft.person.entity.primary.CloudschoolUserBackupDO;
import com.bsoft.person.entity.primary.PersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloudschoolUserBackupDao extends JpaRepository<CloudschoolUserBackupDO,String>, JpaSpecificationExecutor<CloudschoolUserBackupDO> {

    @Query(value="select u from CloudschoolUserBackupDO u where u.isValid = :flag")
    List<CloudschoolUserBackupDO> findBackupFlag(@Param(value = "flag") String flag);

//    @Modifying
//    @Query(value=" insert into  bsoftmis.Xtuser_backup()  select XUSLGNAME,XDNO,XUSNAME,ID,FLAG,RESTYPE,EMAIL   from BSOFTMIS.xtuser")
//    void updatUserBackup();
}
