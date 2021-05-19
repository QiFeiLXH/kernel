package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonCostLimitDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 10:39
 * @Description:
 */
@Repository
public interface PersonCostLimitDao extends JpaRepository<PersonCostLimitDO,String>, JpaSpecificationExecutor<PersonCostLimitDO> {
    List<PersonCostLimitDO> findAllByPersonidAndCosttypeAndSourceid(String personId,Integer Costtype,Integer Sourceid);

    List<PersonCostLimitDO> findAllByPersonidAndCosttypeAndExecudate(String personId, Integer CostType, Date Execudate);
}
