package com.bsoft.hr.service;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.PostAndCostRuleDTO;
import com.bsoft.person.dto.HumanDicDTO;

import java.util.List;

public interface PostAndCostRuleService {

    /**
     * 获取岗位费用默认规则列表
     * @param
     * @return
     */
    List<PostAndCostRuleDTO> getPostAndCostRuleInfoList();

    /**
     * 修改岗位费用默认规则（hr）
     * @param postAndCostRuleDTO
     */
    void updatePostAndCostRule( PostAndCostRuleDTO postAndCostRuleDTO);


    /**
     * 删除岗位费用默认规则（hr）
     * @param id
     */
    boolean deletePostAndCostRule( Integer id);

    /**
     * 查询公共表所有岗位大类（common）
     * @param
     */
    List<HumanDicDTO> getPostList();

    /**
     * 查询公共表所有费用类别（common）
     * @param
     */
    List<SystemDicDTO> getCostList();

    /**
     * 查询公共表所有财务类别（common）
     * @param
     */
    List<PublicDicDTO> getFinanceList();
}
