package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonTransferDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 10:41
 * @Description:
 */
@Repository
public interface PersonTransferDao extends JpaRepository<PersonTransferDO,String>, JpaSpecificationExecutor<PersonTransferDO> {
}
