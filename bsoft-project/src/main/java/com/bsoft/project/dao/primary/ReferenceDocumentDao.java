package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDO;
import com.bsoft.project.entity.primary.ReferenceDocumentDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceDocumentDao extends JpaRepository<ReferenceDocumentDO,Integer>, JpaSpecificationExecutor<ReferenceDocumentDO> {

    List<ReferenceDocumentDO> findAllBySubmitRole(Integer submitRole);
}
