package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.LastSpecialRankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LastSpecialRankDao extends JpaRepository<LastSpecialRankDO,Integer>, JpaSpecificationExecutor<LastSpecialRankDO> {
    public LastSpecialRankDO findByPersonId(String personId);
}
