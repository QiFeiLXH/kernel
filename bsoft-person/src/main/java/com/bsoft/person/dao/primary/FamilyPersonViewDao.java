package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.FamilyPersonViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyPersonViewDao extends JpaRepository<FamilyPersonViewDO,Integer>, JpaSpecificationExecutor<FamilyPersonViewDO> {
    public List<FamilyPersonViewDO> findAllByZpid(Integer zpid);
}
