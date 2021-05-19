package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.person.dto.WorkCertificateDTO;
import com.bsoft.person.dto.WorkCertificateNumDTO;
import com.bsoft.person.entity.primary.WorkCertificateDO;
import com.bsoft.person.entity.primary.WorkCertificateNumViewDO;
import com.bsoft.person.manager.WorkCertificateManager;
import com.bsoft.person.service.WorkCertificateService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class WorkCertificateServiceImpl implements WorkCertificateService {
    private final static Logger LOGGER = LoggerFactory.getLogger(WorkCertificateServiceImpl.class);

    @Autowired
    private WorkCertificateManager workCertificateManager;
    @Autowired
    private IGenerator generator;
    @Override
    public List<WorkCertificateDTO> getCertificate(String personId) {
        List<WorkCertificateDO> result = workCertificateManager.getWorkCertificates(personId);
        return generator.convert(result,WorkCertificateDTO.class);
    }

    @Override
    public Result<WorkCertificateNumDTO> getCertificateNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<WorkCertificateNumViewDO> pages = workCertificateManager.getCertificateNumList(deptId, inputContent, pageNo, pageSize);
        long times = timeConsumer.end();
        LOGGER.info("部门id:{},查询条件：{}，获取证书数量列表耗时:{}", deptId, inputContent,times);
        return ResultUtils.parseResult(pages, WorkCertificateNumDTO.class);
    }

    @Override
    public Result<WorkCertificateDTO> getPersonalCertificateList(String personId, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<WorkCertificateDO> pages = workCertificateManager.getPersonalCertificateList(personId, pageNo, pageSize);
        long times = timeConsumer.end();
        LOGGER.info("工号:{},获取个人证书列表耗时:{}", personId, times);
        return ResultUtils.parseResult(pages, WorkCertificateDTO.class);
    }
}
