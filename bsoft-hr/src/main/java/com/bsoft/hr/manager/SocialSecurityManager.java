package com.bsoft.hr.manager;

import com.bsoft.hr.condition.PersonSocialPlaceQueryCnd;
import com.bsoft.hr.entity.primary.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 17:34
 * @Description
 */
public interface SocialSecurityManager {
    Page<CompanySocialMeeterViewDO> getCompanySocialMeeterList(String inputContent, List<Integer> socialCompanyFlag, Integer pageNo, Integer pageSize);

    void saveCompanySocialMeeter(CompanySocialMeeterDO companySocialMeeterDO);

    void generateLackSocialCompanys();

    Page<PersonSocialPlaceViewDO> getPersonalSocialPlaceList(PersonSocialPlaceQueryCnd cnd);

    Page<SocialAdjustmentRecordViewDO> getPersonalSocialAdjustmentRecordList(String personId, Integer pageNo, Integer pageSize);

    void savePersonalSocialPlaces(List<SocialAdjustmentRecordDO> recordDOS, String personId);
}
