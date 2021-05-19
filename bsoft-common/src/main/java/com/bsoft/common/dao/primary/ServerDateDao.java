package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.DualDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;

@Repository
public interface ServerDateDao extends JpaRepository<DualDO,String>, JpaSpecificationExecutor<DualDO> {
    @Query("SELECT SYSDATE FROM DualDO")
    public Date getServerDate();
    @Query("SELECT systimestamp FROM DualDO")
    public Timestamp getServerDateTime();
}
