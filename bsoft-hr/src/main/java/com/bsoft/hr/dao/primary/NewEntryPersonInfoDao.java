package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.NewEntryPersonInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NewEntryPersonInfoDao extends JpaRepository<NewEntryPersonInfoDO, String>, JpaSpecificationExecutor<NewEntryPersonInfoDO> {
}
