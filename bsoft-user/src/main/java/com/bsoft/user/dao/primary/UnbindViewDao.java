package com.bsoft.user.dao.primary;

import com.bsoft.user.entity.primary.UnbindViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnbindViewDao extends JpaRepository<UnbindViewDO,Integer>, JpaSpecificationExecutor<UnbindViewDO> {
    public List<UnbindViewDO> findByPersonIdAndAuditflag(String personId, Integer flag);
}
