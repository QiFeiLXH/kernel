package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.DynamicReviewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicReviewDao extends JpaRepository<DynamicReviewDO,Integer>, JpaSpecificationExecutor<DynamicReviewDO> {
    public List<DynamicReviewDO> findByDynamicId(Integer dynamicId);
}
