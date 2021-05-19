package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.ClueEmailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClueEmailDao extends JpaRepository<ClueEmailDO,Integer>, JpaSpecificationExecutor<ClueEmailDO> {

    List<ClueEmailDO> findAllByType(Integer type);
}
