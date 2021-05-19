package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonViewDao extends JpaRepository<PersonViewDO,String>, JpaSpecificationExecutor<PersonViewDO> {

}
