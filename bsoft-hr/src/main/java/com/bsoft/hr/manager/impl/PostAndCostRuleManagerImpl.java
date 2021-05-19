package com.bsoft.hr.manager.impl;

import com.bsoft.common.dao.primary.HumanDicDao;
import com.bsoft.common.dao.primary.PublicDicDao;
import com.bsoft.common.dao.primary.SystemDicDao;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.hr.condition.PostAndCostRuleQueryCnd;
import com.bsoft.hr.dao.primary.PostAndCostRuleDao;
import com.bsoft.hr.dto.PostAndCostRuleDTO;
import com.bsoft.hr.entity.primary.PostAndCostRuleDO;
import com.bsoft.hr.manager.PostAndCostRuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class PostAndCostRuleManagerImpl implements PostAndCostRuleManager {

    @Autowired
    private HumanDicDao humanDicDao;

    @Autowired
    private SystemDicDao systemDicDao;

    @Autowired
    private PublicDicDao publicDicDao;

    @Autowired
    private PostAndCostRuleDao postAndCostRuleDao;

    @Autowired
    private IGenerator iGenerator;


    @Override
    @Transactional
    public List<PostAndCostRuleDO> getPostAndCostRuleInfoList() {
        return postAndCostRuleDao.findAll();

    }

    @Override
    public void updatePostAndCostRule(PostAndCostRuleDO postAndCostRuleDO) {
        Integer id = postAndCostRuleDO.getId();
        Integer costType = postAndCostRuleDO.getCostType();
        Integer financialType = postAndCostRuleDO.getFinancialType();
        postAndCostRuleDao.updatePostAndCostRule(id,costType,financialType);
    }

    @Override
    public boolean deletePostAndCostRule(Integer id) {
        boolean flag = false;
        Integer postId = postAndCostRuleDao.getByIdFindPostType(id);
        HumanDicDO humanDicDaoById = humanDicDao.findByTypeAndId(2,postId);
        if(postId!=null&&humanDicDaoById==null){
            postAndCostRuleDao.deleteById(id);
            flag = true;
        }
        return flag;
    }
}
