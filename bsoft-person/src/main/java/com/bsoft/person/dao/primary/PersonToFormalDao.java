package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonToFormalDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2021/1/29 17:40
 * @Description:
 */

@Repository
public interface PersonToFormalDao extends JpaRepository<PersonToFormalDO,String>, JpaSpecificationExecutor<PersonToFormalDO> {

}
