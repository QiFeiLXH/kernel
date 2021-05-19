package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonWorkedYearsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/6 17:44
 * @Description:
 */
@Repository
public interface PersonWorkedYearsDao extends JpaRepository<PersonWorkedYearsDO,Integer>, JpaSpecificationExecutor<PersonWorkedYearsDO> {

    List<PersonWorkedYearsDO> findAllByZpid(Integer zpid);
}
