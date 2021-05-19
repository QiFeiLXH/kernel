package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.WorkLogVerifyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkLogVerifyDao extends JpaRepository<WorkLogVerifyDO,Integer>, JpaSpecificationExecutor<WorkLogVerifyDO> {

}
