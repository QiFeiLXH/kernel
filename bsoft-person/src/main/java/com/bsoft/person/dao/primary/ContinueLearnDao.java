package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.ContinueLearnDO;
import com.bsoft.person.entity.primary.KnowledgeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContinueLearnDao extends JpaRepository<ContinueLearnDO,Integer>, JpaSpecificationExecutor<ContinueLearnDO> {
    List<ContinueLearnDO> findByPersonId(String personId);
}
