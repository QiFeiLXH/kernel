package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.ExpertDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertDao extends JpaRepository<ExpertDO,Integer>, JpaSpecificationExecutor<ExpertDO> {
    List<ExpertDO> findByType(Integer type);

    List<ExpertDO> findByExpertId(String expertId);
}
