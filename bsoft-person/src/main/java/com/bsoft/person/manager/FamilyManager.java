package com.bsoft.person.manager;

import com.bsoft.person.dto.FamilyPersonDTO;
import com.bsoft.person.entity.primary.FamilyPersonDO;
import com.bsoft.person.entity.primary.FamilyPersonViewDO;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/6/30
 * @Description:
 */
public interface FamilyManager {

    void deleteFamilyWithTransaction(Integer id);

    void deleteFamily(Integer id);

    void saveFamily(List<FamilyPersonDTO> familyList);

    FamilyPersonDO saveFamily(FamilyPersonDO family);

    List<FamilyPersonViewDO> getFamily(Integer recruitmentId);
}
