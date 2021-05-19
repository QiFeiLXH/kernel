package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.AuthMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthMenuDao  extends JpaRepository<AuthMenuDO,Integer>, JpaSpecificationExecutor<AuthMenuDO> {
    public List<AuthMenuDO> findByPubFlagAndAndSystem(Integer pubFlag, Integer system);
}
