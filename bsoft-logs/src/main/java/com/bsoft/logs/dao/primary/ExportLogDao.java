package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.ExportLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportLogDao extends JpaRepository<ExportLogDO,Integer>, JpaSpecificationExecutor<ExportLogDO> {

}
