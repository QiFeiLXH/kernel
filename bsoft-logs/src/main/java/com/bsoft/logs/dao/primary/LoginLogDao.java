package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.LoginLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogDao extends JpaRepository<LoginLogDO,Integer>, JpaSpecificationExecutor<LoginLogDO> {

}
