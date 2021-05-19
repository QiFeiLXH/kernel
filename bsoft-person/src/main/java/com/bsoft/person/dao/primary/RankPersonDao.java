package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.RankPersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface RankPersonDao extends JpaRepository<RankPersonDO,String>, JpaSpecificationExecutor<RankPersonDO> {

}
