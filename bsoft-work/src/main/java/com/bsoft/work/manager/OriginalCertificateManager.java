package com.bsoft.work.manager;

import com.bsoft.work.condition.OriginalCertificateQueryCnd;
import com.bsoft.work.entity.primary.OriginalCertificateDO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
public interface OriginalCertificateManager {
    String getCurrentId();
    OriginalCertificateDO getById(String id);
    OriginalCertificateDO getByName(String name);
    PageInfo<OriginalCertificateDO> listByLimits(OriginalCertificateQueryCnd queryCnd);
    void save(OriginalCertificateDO originalCertificateDO);
    void update(OriginalCertificateDO originalCertificateDO);
}
