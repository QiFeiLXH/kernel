package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.WorkCertificateNumViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkCertificateNumViewDao extends JpaRepository<WorkCertificateNumViewDO,String>, JpaSpecificationExecutor<WorkCertificateNumViewDO> {
}
