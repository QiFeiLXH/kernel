package com.bsoft.person.manager;

import com.bsoft.person.dto.EducationDTO;
import com.bsoft.person.entity.primary.CertificateDO;
import com.bsoft.person.entity.primary.EducationDO;
import com.bsoft.person.entity.primary.EducationViewDO;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/7/1
 * @Description:
 */
public interface EducationManager {

    void deleteEducation(Integer id);

    List<EducationViewDO> getEducationList(Integer recruitmentId);

    EducationDO getEducation(Integer id);

    void saveEducation(List<EducationDTO> list);

    List<CertificateDO> getCertificate(Integer educationId);

    void deleteCertificate(Integer id);

    List<EducationViewDO> getEducationsWithPersonId(String personId);
}
