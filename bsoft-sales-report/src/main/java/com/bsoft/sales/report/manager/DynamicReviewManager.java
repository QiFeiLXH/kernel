package com.bsoft.sales.report.manager;

import com.bsoft.sales.report.entity.primary.DynamicReviewDO;
import com.bsoft.sales.report.entity.primary.DynamicReviewViewDO;

import java.util.List;

public interface DynamicReviewManager {
    public DynamicReviewDO saveReview(DynamicReviewDO dynamicReview);
    public List<DynamicReviewDO> getReview(Integer dynamicId);
    public List<DynamicReviewViewDO> getReviewView(Integer dynamicId);
    public List<DynamicReviewDO> saveReview(List<DynamicReviewDO> dynamicReviews);
}
