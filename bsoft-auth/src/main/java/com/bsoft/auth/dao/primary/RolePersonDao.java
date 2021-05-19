package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.RolePersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface RolePersonDao extends JpaRepository<RolePersonDO,Integer>, JpaSpecificationExecutor<RolePersonDO> {
    List<RolePersonDO> findByPersonId(String personid);

    List<RolePersonDO> findByRoleId(Integer roleId);

    void deleteAllByPersonIdEquals(String personId);

    void deleteAllByRoleIdEquals(Integer roleId);

    RolePersonDO getByPersonId(String personId);

}
