package com.bsoft.sales.repository.primary;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 17:43
 * @Description
 */
@Mapper
@Repository
public interface CooperationAgreementRepository {
    Integer getSimilarPartnerCount(String context);
}
