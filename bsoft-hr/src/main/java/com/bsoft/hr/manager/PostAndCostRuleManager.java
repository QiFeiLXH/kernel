package com.bsoft.hr.manager;

import com.bsoft.hr.condition.PostAndCostRuleQueryCnd;
import com.bsoft.hr.dto.PostAndCostRuleDTO;
import com.bsoft.hr.entity.primary.PostAndCostRuleDO;

import java.util.List;

public interface PostAndCostRuleManager {

    /**
     * 获取岗位费用默认规则列表
     * @param
     * @return
     */
    List<PostAndCostRuleDO> getPostAndCostRuleInfoList();


    /**
     * 修改岗位费用默认规则（hr）
     * @param postAndCostRuleDO
     */
    void updatePostAndCostRule( PostAndCostRuleDO postAndCostRuleDO);

    /**
     * 删除岗位费用默认规则（hr）
     * @param id
     */
    boolean deletePostAndCostRule( Integer id);
}
