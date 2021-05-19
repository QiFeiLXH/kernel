package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.DynamicReviewViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicReviewViewDao extends JpaRepository<DynamicReviewViewDO,Integer>, JpaSpecificationExecutor<DynamicReviewViewDO> {
    public List<DynamicReviewViewDO> findByDynamicId(Integer dynamicId);
}
