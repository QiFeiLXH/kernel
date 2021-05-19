package com.bsoft.workflow.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.workflow.condition.ProcessDeployQueryCnd;
import com.bsoft.workflow.dto.ProcessDeployDTO;
import com.bsoft.workflow.dto.ProcessDeployQueryCndDTO;
import com.bsoft.workflow.dto.ProcessFileDTO;
import com.bsoft.workflow.entity.primary.ProcessDeployDO;
import com.bsoft.workflow.entity.primary.ProcessFileDO;
import com.bsoft.workflow.manager.ProcessDeployManager;
import com.bsoft.workflow.service.ProcessDeployService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Service
public class ProcessDeployServiceImpl implements ProcessDeployService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessDeployServiceImpl.class);
    @Autowired
    private ProcessDeployManager processDeployManager;
    @Override
    public Result<ProcessDeployDTO> getProcessDeployList(ProcessDeployQueryCndDTO cnd,String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProcessDeployQueryCnd queryCnd = GeneratorUtil.instance().convert(cnd,ProcessDeployQueryCnd.class);
        Page<ProcessDeployDO> processDeployDOPage = processDeployManager.getProcessDeployList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号:{} 获取流程部署信息列表耗时:{}",new Object[]{personId,times});
        return ResultUtils.parseResult(processDeployDOPage,ProcessDeployDTO.class);
    }

    @Override
    public void saveProcess(ProcessDeployDTO processDeployDTO,String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProcessDeployDO processDeployDO = GeneratorUtil.instance().convert(processDeployDTO,ProcessDeployDO.class);
        processDeployManager.saveProcess(processDeployDO);
        long times = timeConsumer.end();
        LOGGER.info("工号:{} 保存流程部署信息耗时:{}",new Object[]{personId,times});

    }

    @Override
    public Integer saveProcessFile(ProcessFileDTO fileDTO, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProcessFileDO fileDO = GeneratorUtil.instance().convert(fileDTO,ProcessFileDO.class);
        Integer fileId = processDeployManager.saveProcessFile(fileDO);
        long times = timeConsumer.end();
        LOGGER.info("工号:{} 上传流程文件耗时:{}",new Object[]{personId,times});
        return fileId;
    }

    @Override
    public void deployProcess(Integer id,String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        processDeployManager.deployProcess(id);
        long times = timeConsumer.end();
        LOGGER.info("工号:{} 部署流程至流程服务器耗时:{}",new Object[]{personId,times});
    }
}
