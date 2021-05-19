package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonTransferSyncViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonTransferSyncViewDao extends JpaRepository<PersonTransferSyncViewDO,String>, JpaSpecificationExecutor<PersonTransferSyncViewDO> {
    @Modifying
    @Query(value = "select u from PersonTransferSyncViewDO u where u.transferDate =:transferDate")
    List<PersonTransferSyncViewDO> findTransferDateSync(@Param(value = "transferDate") Date transferDate);
}
