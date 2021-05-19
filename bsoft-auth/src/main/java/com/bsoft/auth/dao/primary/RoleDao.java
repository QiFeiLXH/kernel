package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao extends JpaRepository<RoleDO,Integer>, JpaSpecificationExecutor<RoleDO> {

}
