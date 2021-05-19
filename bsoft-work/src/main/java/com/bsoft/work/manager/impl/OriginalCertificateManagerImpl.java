package com.bsoft.work.manager.impl;

import com.bsoft.work.condition.OriginalCertificateQueryCnd;
import com.bsoft.work.entity.primary.OriginalCertificateDO;
import com.bsoft.work.manager.OriginalCertificateManager;
import com.bsoft.work.repository.primary.OriginalCertificateRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
@Component
public class OriginalCertificateManagerImpl implements OriginalCertificateManager {

    @Autowired
    private OriginalCertificateRepository originalCertificateRepository;

    @Override
    public String getCurrentId() {
        return originalCertificateRepository.getCurrentId();
    }

    @Override
    public OriginalCertificateDO getById(String id) {
        return originalCertificateRepository.getById(id);
    }

    @Override
    public OriginalCertificateDO getByName(String name) {
        return originalCertificateRepository.getByName(name);
    }

    @Override
    public PageInfo<OriginalCertificateDO> listByLimits(OriginalCertificateQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<OriginalCertificateDO> originalCertificateDOList = originalCertificateRepository.listByLimits(queryCnd);
        PageInfo<OriginalCertificateDO> pageInfo = new PageInfo<>(originalCertificateDOList);
        return pageInfo;
    }

    @Override
    @Transactional
    public void save(OriginalCertificateDO originalCertificateDO) {
        originalCertificateRepository.save(originalCertificateDO);
    }

    @Override
    @Transactional
    public void update(OriginalCertificateDO originalCertificateDO) {
        originalCertificateRepository.update(originalCertificateDO);
    }
}
