package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonQuitSyncDO;
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
public interface PersonQuitSyncDao extends JpaRepository<PersonQuitSyncDO,String>, JpaSpecificationExecutor<PersonQuitSyncDO> {

}
