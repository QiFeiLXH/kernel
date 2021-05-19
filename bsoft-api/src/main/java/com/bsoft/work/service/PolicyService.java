package com.bsoft.work.service;

import com.bsoft.common.result.Result;
import com.bsoft.work.dto.PolicyDTO;
import com.bsoft.work.dto.PolicyQueryCndDTO;


import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 17:21
 */
public interface PolicyService {

   /**
    *
    * @param policyQueryCndDto
    * @return
    */
   Result<PolicyDTO> selectByQueryCnd(PolicyQueryCndDTO policyQueryCndDto);


   /**
    * 查询阅读状态
    * @param policyQueryCndDto
    * @return
    */
   List<PolicyDTO> selectReadByQueryCnd(PolicyQueryCndDTO policyQueryCndDto);
   /**
   * @author zy
   * @description 统计个人未读提案数
   * @param personId 工号
   */
   Integer countPersonalNoRead(String personId);
}
