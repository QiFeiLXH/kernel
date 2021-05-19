package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.KnowledgeDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeDao extends JpaRepository<KnowledgeDO,Integer>, JpaSpecificationExecutor<KnowledgeDO> {
    List<KnowledgeDO> findByPersonId(String personId);

    Page<KnowledgeDO> findAllByPersonId(String personId, Pageable pageable);

}
