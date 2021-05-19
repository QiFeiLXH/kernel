package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.WorkCertificateDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkCertificateDao extends JpaRepository<WorkCertificateDO,Integer>, JpaSpecificationExecutor<WorkCertificateDO> {
    List<WorkCertificateDO> findByPersonId(String personId);

    Page<WorkCertificateDO> findAllByPersonId(String personId, Pageable pageable);
}
