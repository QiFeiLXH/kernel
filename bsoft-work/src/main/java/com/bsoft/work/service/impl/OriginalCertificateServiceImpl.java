package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.work.condition.OriginalCertificateQueryCnd;
import com.bsoft.work.dto.OriginalCertificateDTO;
import com.bsoft.work.dto.OriginalCertificateQueryCndDTO;
import com.bsoft.work.entity.primary.OriginalCertificateDO;
import com.bsoft.work.manager.OriginalCertificateManager;
import com.bsoft.work.service.OriginalCertificateService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
@Service
public class OriginalCertificateServiceImpl implements OriginalCertificateService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OriginalCertificateServiceImpl.class);

    @Autowired
    private OriginalCertificateManager originalCertificateManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public OriginalCertificateDTO getByName(String userId, String name) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OriginalCertificateDO certDO = originalCertificateManager.getByName(name);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]根据名字获取证书原件信息耗时[{}]", userId, times);
        return iGenerator.convert(certDO, OriginalCertificateDTO.class);
    }

    @Override
    public Result<OriginalCertificateDTO> listByLimits(String userId, OriginalCertificateQueryCndDTO queryCndDTO) {
        OriginalCertificateQueryCnd queryCnd = iGenerator.convert(queryCndDTO, OriginalCertificateQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<OriginalCertificateDO> pageInfo = originalCertificateManager.listByLimits(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取证书原件列表耗时[{}]", userId, times);
        return ResultUtils.parseResult(pageInfo, OriginalCertificateDTO.class);
    }

    @Override
    public void save(String userId, OriginalCertificateDTO originalCertificateDTO) {
        OriginalCertificateDO saveDO = iGenerator.convert(originalCertificateDTO, OriginalCertificateDO.class);
        saveDO.setId(originalCertificateManager.getCurrentId());
        TimeConsumer timeConsumer = TimeConsumer.start();
        originalCertificateManager.save(saveDO);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]保存证书原件信息耗时[{}]", userId, times);
    }

    @Override
    public void update(String userId, OriginalCertificateDTO originalCertificateDTO) {
        OriginalCertificateDO updateDO = originalCertificateManager.getById(originalCertificateDTO.getId());
        updateDO.setName(originalCertificateDTO.getName());
        updateDO.setType(originalCertificateDTO.getType());
        updateDO.setLogoff(originalCertificateDTO.getLogoff());
        updateDO.setArchivist(originalCertificateDTO.getArchivist());
        TimeConsumer timeConsumer = TimeConsumer.start();
        originalCertificateManager.update(updateDO);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]修改证书原件信息耗时[{}]", userId, times);
    }

    @Override
    public List<PublicDicDTO> listCertType(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicDicDO> dicDOList= publicDicManager.getPublicDic(16);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取证书类别耗时[{}]", userId, times);
        return iGenerator.convert(dicDOList, PublicDicDTO.class);
    }

}
