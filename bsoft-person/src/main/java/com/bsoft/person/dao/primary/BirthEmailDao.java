package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.BirthEmailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthEmailDao  extends JpaRepository<BirthEmailDO,Integer>, JpaSpecificationExecutor<BirthEmailDO> {
}
