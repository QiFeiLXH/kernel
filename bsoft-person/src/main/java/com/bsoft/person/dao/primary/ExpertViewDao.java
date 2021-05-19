package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.ExpertDO;
import com.bsoft.person.entity.primary.ExpertViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertViewDao extends JpaRepository<ExpertViewDO,String>, JpaSpecificationExecutor<ExpertViewDO> {

}
