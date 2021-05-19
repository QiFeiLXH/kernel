package com.bsoft.user.dao.primary;

import com.bsoft.user.entity.primary.UnbindDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnbindDao extends JpaRepository<UnbindDO,Integer>, JpaSpecificationExecutor<UnbindDO> {
    public List<UnbindDO> findByPersonIdAndAuditflag(String personId,Integer flag);
}
