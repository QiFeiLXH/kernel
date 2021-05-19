package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.EmploySubmissionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface EmploySubmissionDao extends JpaRepository<EmploySubmissionDO,Integer>, JpaSpecificationExecutor<EmploySubmissionDO> {

    EmploySubmissionDO findByRecruitmentId(Integer recruitmentId);
}
