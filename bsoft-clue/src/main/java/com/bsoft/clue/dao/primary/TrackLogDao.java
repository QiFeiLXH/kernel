package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.TrackLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackLogDao extends JpaRepository<TrackLogDO,Integer>, JpaSpecificationExecutor<TrackLogDO> {

}
