package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonTurViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 15:34
 * @Description:
 */
@Repository
public interface PersonTurViewDao extends JpaRepository<PersonTurViewDO,Integer>, JpaSpecificationExecutor<PersonTurViewDO> {
}
