package com.bsoft.sales.report.manager.impl;

import com.bsoft.sales.report.dao.primary.DynamicReviewDao;
import com.bsoft.sales.report.dao.primary.DynamicReviewViewDao;
import com.bsoft.sales.report.entity.primary.DynamicReviewDO;
import com.bsoft.sales.report.entity.primary.DynamicReviewViewDO;
import com.bsoft.sales.report.manager.DynamicReviewManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DynamicReviewManagerImpl implements DynamicReviewManager {
    @Autowired
    private DynamicReviewDao dynamicReviewDao;
    @Autowired
    private DynamicReviewViewDao dynamicReviewViewDao;
    @Override
    public DynamicReviewDO saveReview(DynamicReviewDO dynamicReview) {
        return dynamicReviewDao.save(dynamicReview);
    }

    @Override
    public List<DynamicReviewDO> getReview(Integer dynamicId) {
        return dynamicReviewDao.findByDynamicId(dynamicId);
    }

    @Override
    public List<DynamicReviewViewDO> getReviewView(Integer dynamicId) {
        return dynamicReviewViewDao.findByDynamicId(dynamicId);
    }

    @Override
    public List<DynamicReviewDO> saveReview(List<DynamicReviewDO> dynamicReviews) {
        return dynamicReviewDao.saveAll(dynamicReviews);
    }
}
