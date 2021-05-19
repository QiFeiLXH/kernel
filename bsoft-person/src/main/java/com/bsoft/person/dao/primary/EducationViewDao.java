package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.EducationViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationViewDao extends JpaRepository<EducationViewDO,Integer>, JpaSpecificationExecutor<EducationViewDO> {
    List<EducationViewDO> findAllByZpidOrderByEndDateDesc(Integer zpid);

    List<EducationViewDO> findByPersonId(String personId);
}
