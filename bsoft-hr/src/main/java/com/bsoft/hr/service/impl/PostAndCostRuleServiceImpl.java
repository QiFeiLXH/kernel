package com.bsoft.hr.service.impl;

import com.bsoft.common.dao.primary.HumanDicDao;
import com.bsoft.common.dao.primary.PublicDicDao;
import com.bsoft.common.dao.primary.SystemDicDao;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.PostAndCostRuleQueryCnd;
import com.bsoft.hr.dao.primary.PostAndCostRuleDao;
import com.bsoft.hr.dto.PostAndCostRuleDTO;
import com.bsoft.hr.entity.primary.PostAndCostRuleDO;
import com.bsoft.hr.manager.PostAndCostRuleManager;
import com.bsoft.hr.service.PostAndCostRuleService;
import com.bsoft.person.dto.HumanDicDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostAndCostRuleServiceImpl implements PostAndCostRuleService {
    @Autowired
    private PublicDicDao publicDicDao;

    @Autowired
    private HumanDicDao humanDicDao;

    @Autowired
    private SystemDicDao systemDicDao;

    @Autowired
    private IGenerator iGenerator;

    @Autowired
    private PostAndCostRuleManager postAndCostRuleManager;

    @Autowired
    private PostAndCostRuleDao postAndCostRuleDao;

    @Override
    public List<PostAndCostRuleDTO> getPostAndCostRuleInfoList() {
        return this.setNames(postAndCostRuleManager.getPostAndCostRuleInfoList());
    }

    @Override
    public void updatePostAndCostRule(PostAndCostRuleDTO postAndCostRuleDTO) {
        PostAndCostRuleDO convert = iGenerator.convert(postAndCostRuleDTO, PostAndCostRuleDO.class);
        postAndCostRuleManager.updatePostAndCostRule(convert);
    }

    @Override
    public boolean deletePostAndCostRule(Integer id) {
        return postAndCostRuleManager.deletePostAndCostRule(id);
    }

    @Override
    public List<HumanDicDTO> getPostList() {
        List<HumanDicDO> postList = humanDicDao.findAllByTypeAndIdNotOrderByIdAsc(2,0);
        return  iGenerator.convert(postList,HumanDicDTO.class);
    }

    @Override
    public List<SystemDicDTO> getCostList() {
        List<SystemDicDO> costList = systemDicDao.findByTypeAndIdIsGreaterThan(9001,0);
        return  iGenerator.convert(costList,SystemDicDTO.class);
    }

    @Override
    public List<PublicDicDTO> getFinanceList() {
        List<PublicDicDO> allByTypeAndFlag = publicDicDao.findByType(3012);
        List<PublicDicDO> newallByTypeAndFlag = new ArrayList<>();
        for(PublicDicDO publicDicDO:allByTypeAndFlag){
            if(publicDicDO.getPersonflag()==0&&publicDicDO.getId()!=0){
                newallByTypeAndFlag.add(publicDicDO);
            }
        }
        return  iGenerator.convert(newallByTypeAndFlag,PublicDicDTO.class);
    }


    public List<PostAndCostRuleDTO> setNames(List<PostAndCostRuleDO>PostAndCostRuleList){
        List<HumanDicDO> humanDicDOList = humanDicDao.findAllByTypeAndIdNotOrderByIdAsc(2,0);
        //查询岗位公共表是否有新增的岗位
        List<Integer> diffPostIdList = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(humanDicDOList.size());
        for (HumanDicDO humanDicDO:humanDicDOList) {
            map.put(humanDicDO.getId(),1);
        }
        if(PostAndCostRuleList.size()!=0){
            for(PostAndCostRuleDO postAndCostRuleDO:PostAndCostRuleList){
                if(map.get(postAndCostRuleDO.getPostType())!=null){
                    map.put(postAndCostRuleDO.getPostType(),2);
                }
            }
        }
        //存入公共表中新增的岗位大类，将其新增进岗位费用默认规则表中
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                diffPostIdList.add(entry.getKey());
            }
        }
        for(Integer postType:diffPostIdList){
            PostAndCostRuleDO postAndCostRuleDO= new PostAndCostRuleDO();
            postAndCostRuleDO.setPostType(postType);
            postAndCostRuleDao.save(postAndCostRuleDO);
        }

        List<PostAndCostRuleDO> NewPostAndCostRuleList = postAndCostRuleDao.findAll();
        List<PostAndCostRuleDTO> convert = iGenerator.convert(NewPostAndCostRuleList, PostAndCostRuleDTO.class);
        /** 将postName插入DTO返回*/
        for (PostAndCostRuleDTO postAndCostRuleDTO:convert) {
            for (HumanDicDO humanDicDO:humanDicDOList) {
                if(humanDicDO.getId().equals(postAndCostRuleDTO.getPostType())){
                    postAndCostRuleDTO.setPostName(humanDicDO.getName());
                }
            }
        }

        List<SystemDicDO> costList = systemDicDao.findByTypeAndIdIsGreaterThan(9001,0);
        /** 将costName插入DTO返回*/
        for (PostAndCostRuleDTO postAndCostRuleDTO:convert) {
            for (SystemDicDO systemDicDO:costList) {
                if(systemDicDO.getId().equals(postAndCostRuleDTO.getCostType())){
                    postAndCostRuleDTO.setCostName(systemDicDO.getName());
                }
            }
        }

        /** 将financialName插入DTO返回*/
        List<PublicDicDO> allByTypeAndFlag = publicDicDao.findByType(3012);
        List<PublicDicDO> newallByTypeAndFlag = new ArrayList<>();
        for(PublicDicDO publicDicDO:allByTypeAndFlag){
            if(publicDicDO.getPersonflag()==0&&publicDicDO.getId()!=0){
                newallByTypeAndFlag.add(publicDicDO);
            }
        }
        for (PostAndCostRuleDTO postAndCostRuleDTO:convert) {
            for (PublicDicDO publicDicDO:newallByTypeAndFlag) {
                if(publicDicDO.getId().equals(postAndCostRuleDTO.getFinancialType())){
                    postAndCostRuleDTO.setFinancialName(publicDicDO.getName());
                }
            }
        }
        return convert;
    }
}
