package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.LastManagerRankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LastManagerRankDao extends JpaRepository<LastManagerRankDO,Integer>, JpaSpecificationExecutor<LastManagerRankDO> {
    public LastManagerRankDO findByPersonId(String personId);
}
