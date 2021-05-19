package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.ResidentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentDao extends JpaRepository<ResidentDO,Integer>, JpaSpecificationExecutor<ResidentDO> {
    void deleteAllByRecruitmentId(Integer recruitmentId);
}
