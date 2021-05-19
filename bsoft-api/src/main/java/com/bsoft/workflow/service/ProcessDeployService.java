package com.bsoft.workflow.service;

import com.bsoft.common.result.Result;
import com.bsoft.workflow.dto.ProcessDeployDTO;
import com.bsoft.workflow.dto.ProcessDeployQueryCndDTO;
import com.bsoft.workflow.dto.ProcessFileDTO;

public interface ProcessDeployService {
    /**
     * 获取流程部署信息列表
     * @param cnd
     * @return
     */
    Result<ProcessDeployDTO> getProcessDeployList(ProcessDeployQueryCndDTO cnd,String personId);

    /**
     * 保存流程部署信息
     * @param processDeployDTO
     */
    void saveProcess(ProcessDeployDTO processDeployDTO, String personId);

    /**
     * 上传流程文件至文件服务器
     * @param fileDTO
     * @return
     */
    Integer saveProcessFile(ProcessFileDTO fileDTO, String personId);

    /**
     * 部署流程至流程服务器
     * @param id
     */
    void deployProcess(Integer id,String personId);

}
