package com.bsoft.work.repository.primary;

import com.bsoft.work.condition.OriginalCertificateQueryCnd;
import com.bsoft.work.entity.primary.OriginalCertificateDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
@Mapper
@Repository
public interface OriginalCertificateRepository {
    String getCurrentId();
    OriginalCertificateDO getById(@Param("id") String id);
    OriginalCertificateDO getByName(@Param("name") String name);
    List<OriginalCertificateDO> listByLimits(@Param("queryCnd") OriginalCertificateQueryCnd queryCnd);
    void save(@Param("saveDO") OriginalCertificateDO originalCertificateDO);
    void update(@Param("updateDO") OriginalCertificateDO originalCertificateDO);
}
