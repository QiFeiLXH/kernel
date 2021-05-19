package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.BirthDayDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthDayDao extends JpaRepository<BirthDayDO,String>, JpaSpecificationExecutor<BirthDayDO> {

}
