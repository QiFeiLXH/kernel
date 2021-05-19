package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.FamilyPersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyPersonDao extends JpaRepository<FamilyPersonDO,Integer>, JpaSpecificationExecutor<FamilyPersonDO> {
    void deleteAllByZpid(Integer recruitmentInfoId);
}
