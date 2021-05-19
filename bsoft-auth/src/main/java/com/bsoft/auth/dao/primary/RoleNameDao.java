package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.RoleNameDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleNameDao extends JpaRepository<RoleNameDO,Integer>, JpaSpecificationExecutor<RoleNameDO> {
    List<RoleNameDO> findByStatus(Integer status);
}
