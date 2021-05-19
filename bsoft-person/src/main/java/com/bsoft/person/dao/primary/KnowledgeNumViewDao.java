package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.KnowledgeNumViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeNumViewDao extends JpaRepository<KnowledgeNumViewDO,String>, JpaSpecificationExecutor<KnowledgeNumViewDO> {
}
