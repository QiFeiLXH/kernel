package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.AnnualVacationPersonInfoDO;

import java.util.List;

public interface AnnualVacationPersonInfoManager {

    List<AnnualVacationPersonInfoDO> getNeedCreateAnnualPerson(List<Integer> types);

    public List<AnnualVacationPersonInfoDO> getNeedDeleteAnnualPerson(List<Integer> types);
}
