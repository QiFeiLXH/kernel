package com.bsoft.person.manager.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.person.dao.primary.CertificateDao;
import com.bsoft.person.dao.primary.EducationDao;
import com.bsoft.person.dao.primary.EducationViewDao;
import com.bsoft.person.dao.primary.EmployDao;
import com.bsoft.person.dto.CertificateDTO;
import com.bsoft.person.dto.EducationDTO;
import com.bsoft.person.entity.primary.CertificateDO;
import com.bsoft.person.entity.primary.EducationDO;
import com.bsoft.person.entity.primary.EducationViewDO;
import com.bsoft.person.manager.EducationManager;
import com.bsoft.person.manager.EmployManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/7/1
 * @Description:
 */
@Component
public class EducationManagerImpl implements EducationManager {

    @Autowired
    private EducationDao educationDao;

    @Autowired
    private EducationViewDao educationViewDao;

    @Autowired
    private EmployManager employManager;

    @Autowired
    private CertificateDao certificateDao;

    @Autowired
    private GeneratorUtil generatorUtil;

    @Autowired
    private KeyGenerator keyGenerator;

    @Override
    @Transactional
    public void deleteEducation(Integer id) {
        EducationDO educationDO = educationDao.getOne(id);
        Integer zpid = educationDO.getZpid();
        educationDao.deleteById(id);
        certificateDao.deleteAllByEducationId(id);
        updateEducationLevel(zpid);
    }

    @Override
    public List<EducationViewDO> getEducationList(Integer recruitmentId) {
        return educationViewDao.findAllByZpidOrderByEndDateDesc(recruitmentId);
    }

    @Override
    public EducationDO getEducation(Integer id) {
        return educationDao.getOne(id);
    }


    @Override
    @Transactional
    public void saveEducation(List<EducationDTO> educationDTOS) {
        for (EducationDTO educationDTO : educationDTOS){
            List<CertificateDTO> certificateDTOS = educationDTO.getOthers();
            EducationDO educationDO = generatorUtil.convert(educationDTO,EducationDO.class);
            if (educationDO.getId() == null){
                educationDO.setId(keyGenerator.increaseEducationInfo());
            }
            ValidateUtil.check(educationDO);
            EducationDO educationDO1 = educationDao.save(educationDO);
            Integer id = educationDO1.getId();
            if (certificateDTOS.size()>0){
                List<CertificateDO> certificateDOS = generatorUtil.convert(certificateDTOS,CertificateDO.class);
                for (CertificateDO certificateDO:certificateDOS){
                    if (certificateDO.getCertificateID() != null){
                        certificateDO.setEducationId(id);
                    }
                }
                ValidateUtil.check(certificateDOS);
                certificateDao.saveAll(certificateDOS);
            }
        }
        updateEducationLevel(educationDTOS.get(0).getZpid());
    }

    @Override
    public List<CertificateDO> getCertificate(Integer educationId) {
        return certificateDao.findAllByEducationId(educationId);
    }

    @Override
    @Transactional
    public void deleteCertificate(Integer id) {
        certificateDao.deleteById(id);
    }

    @Override
    public List<EducationViewDO> getEducationsWithPersonId(String personId) {
        return educationViewDao.findByPersonId(personId);
    }

    private void updateEducationLevel(Integer zpid){
        List<EducationDO> list = educationDao.findAllByZpidOrderByEndDateDesc(zpid);
        Integer educationLevel = 0;
        if (list.size()>0){
            educationLevel = list.get(0).getEducation();
            employManager.updateEducation(educationLevel,zpid);
        }
    }
}
