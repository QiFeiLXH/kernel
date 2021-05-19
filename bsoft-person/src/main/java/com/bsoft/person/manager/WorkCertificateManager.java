package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.WorkCertificateDO;
import com.bsoft.person.entity.primary.WorkCertificateNumViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WorkCertificateManager {
    WorkCertificateDO saveWorkCertificate(WorkCertificateDO workCertificate);

    List<WorkCertificateDO> saveWorkCertificates(List<WorkCertificateDO> workCertificates);

    List<WorkCertificateDO> getWorkCertificates(String personId);

    Page<WorkCertificateNumViewDO> getCertificateNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize);

    Page<WorkCertificateDO> getPersonalCertificateList(String personId, Integer pageNo, Integer pageSize);
}
