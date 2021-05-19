package com.bsoft.workflow.manager;

import com.bsoft.workflow.condition.ProcessDeployQueryCnd;
import com.bsoft.workflow.entity.primary.ProcessDeployDO;
import com.bsoft.workflow.entity.primary.ProcessFileDO;
import org.springframework.data.domain.Page;

public interface ProcessDeployManager {

    Page<ProcessDeployDO> getProcessDeployList(ProcessDeployQueryCnd cnd);

    void saveProcess(ProcessDeployDO processDeployDO);

    Integer saveProcessFile(ProcessFileDO fileDO);

    void deployProcess(Integer id);

}
