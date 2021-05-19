package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.TrainDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainDao extends JpaRepository<TrainDO,String>, JpaSpecificationExecutor<TrainDO> {
    List<TrainDO> findByPersonId(String personId);
}
