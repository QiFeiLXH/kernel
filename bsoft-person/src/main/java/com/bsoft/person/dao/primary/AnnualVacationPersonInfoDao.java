package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.AnnualVacationPersonInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnualVacationPersonInfoDao extends JpaRepository<AnnualVacationPersonInfoDO,Integer>, JpaSpecificationExecutor<AnnualVacationPersonInfoDO> {

    List<AnnualVacationPersonInfoDO> findAllByTypeIn(List<Integer> types);

}
