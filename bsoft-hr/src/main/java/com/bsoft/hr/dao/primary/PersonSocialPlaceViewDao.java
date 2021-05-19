package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.PersonSocialPlaceViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSocialPlaceViewDao extends JpaRepository<PersonSocialPlaceViewDO, String>, JpaSpecificationExecutor<PersonSocialPlaceViewDO> {

}

