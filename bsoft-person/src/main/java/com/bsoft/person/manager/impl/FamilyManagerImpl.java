package com.bsoft.person.manager.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.person.dao.primary.FamilyPersonDao;
import com.bsoft.person.dao.primary.FamilyPersonViewDao;
import com.bsoft.person.dto.FamilyPersonDTO;
import com.bsoft.person.entity.primary.FamilyPersonDO;
import com.bsoft.person.entity.primary.FamilyPersonViewDO;
import com.bsoft.person.manager.FamilyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/6/30
 * @Description:
 */
@Component
public class FamilyManagerImpl implements FamilyManager {

    @Autowired
    private FamilyPersonDao familyPersonDao;

    @Autowired
    private FamilyPersonViewDao familyPersonViewDao;

    @Autowired
    private GeneratorUtil generatorUtil;

    @Autowired
    private KeyGenerator keyGenerator;

    @Override
    public void deleteFamily(Integer id) {
        familyPersonDao.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteFamilyWithTransaction(Integer id) {
        familyPersonDao.deleteById(id);
    }

    @Override
    public void saveFamily(List<FamilyPersonDTO> familyPersonDTOS) {
        List<FamilyPersonDO> familyPersonDOS = generatorUtil.convert(familyPersonDTOS,FamilyPersonDO.class);
        for (FamilyPersonDO familyPersonDO : familyPersonDOS){
            if (familyPersonDO.getId() == null){
                familyPersonDO.setId(keyGenerator.increaseFamilyInfo());
            }
        }
        ValidateUtil.check(familyPersonDOS);
        familyPersonDao.saveAll(familyPersonDOS);
    }

    @Override
    public FamilyPersonDO saveFamily(FamilyPersonDO family) {
        return familyPersonDao.save(family);
    }

    @Override
    public List<FamilyPersonViewDO> getFamily(Integer recruitmentId) {
        return familyPersonViewDao.findAllByZpid(recruitmentId);
    }


}
