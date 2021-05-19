package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.CertificateDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateDao extends JpaRepository<CertificateDO,Integer>, JpaSpecificationExecutor<CertificateDO> {
    public List<CertificateDO> findAllByEducationId(Integer educationId);

    public void deleteAllByEducationId(Integer educationId);
}
