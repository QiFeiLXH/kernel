package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonalTrainViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainViewDao extends JpaRepository<PersonalTrainViewDO,String>, JpaSpecificationExecutor<PersonalTrainViewDO> {

}
