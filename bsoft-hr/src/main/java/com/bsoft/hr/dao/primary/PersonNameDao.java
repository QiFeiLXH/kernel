package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.PersonNameDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 根据工号查员工姓名
 */
@Repository
public interface PersonNameDao extends JpaRepository<PersonNameDO, String>, JpaSpecificationExecutor<PersonNameDO> {
}
