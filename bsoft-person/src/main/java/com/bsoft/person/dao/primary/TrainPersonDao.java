package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.TrainPersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainPersonDao extends JpaRepository<TrainPersonDO,Integer>, JpaSpecificationExecutor<TrainPersonDO> {

}
