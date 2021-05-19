package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.SocialAdjustmentRecordViewDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialAdjustmentRecordViewDao extends JpaRepository<SocialAdjustmentRecordViewDO, Integer>, JpaSpecificationExecutor<SocialAdjustmentRecordViewDO> {
    Page<SocialAdjustmentRecordViewDO> findAllByPersonId(String personId, Pageable pageable);
}

