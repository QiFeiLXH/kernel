package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.CompanySocialMeeterViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySocialMeeterViewDao extends JpaRepository<CompanySocialMeeterViewDO, Integer>, JpaSpecificationExecutor<CompanySocialMeeterViewDO> {

}

