package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.PrimaryKeyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryKeyDao extends JpaRepository<PrimaryKeyDO,String>, JpaSpecificationExecutor<PrimaryKeyDO> {

}
