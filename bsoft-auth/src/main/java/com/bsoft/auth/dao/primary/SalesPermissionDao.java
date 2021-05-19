package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.SalesPermissionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesPermissionDao extends JpaRepository<SalesPermissionDO,Integer>, JpaSpecificationExecutor<SalesPermissionDO> {
    public List<SalesPermissionDO> findByPersonIdAndFlagAndType(String personId,Integer flag,Integer type);

    public List<SalesPermissionDO> findByFlagAndType(Integer flag,Integer type);
}
