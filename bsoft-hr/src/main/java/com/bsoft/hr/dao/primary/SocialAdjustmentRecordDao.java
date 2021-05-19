package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.SocialAdjustmentRecordDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialAdjustmentRecordDao extends JpaRepository<SocialAdjustmentRecordDO, Integer>, JpaSpecificationExecutor<SocialAdjustmentRecordDO> {
    
}

