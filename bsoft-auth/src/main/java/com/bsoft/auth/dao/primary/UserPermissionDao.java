package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.UserPermissionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPermissionDao extends JpaRepository<UserPermissionDO,Integer>, JpaSpecificationExecutor<UserPermissionDO> {
    public List<UserPermissionDO> findByPersonIdAndFlagAndType(String personId,Integer flag,Integer type);
}
