package com.bsoft.work.manager.impl;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.dao.primary.ManagerGroupDao;

import com.bsoft.work.dto.ManagerGroupDTO;
import com.bsoft.work.entity.primary.ManagerGroupDO;
import com.bsoft.work.manager.ManagerGroupManager;
import com.bsoft.work.repository.primary.ManagerGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Huang GH
 * @date 2021/5/10 10:58
 */
@Component
public class ManagerGroupManagerImpl implements ManagerGroupManager {

    @Autowired
    private ManagerGroupRepository managerGroupRepository;

    @Autowired
    private ManagerGroupDao managerGroupDao;


    @Override
    public List<ManagerGroupDTO> findByType(PolicyQueryCnd policyQueryCnd) {
        List<ManagerGroupDO> byType = managerGroupRepository.findAllByCnd(policyQueryCnd);


        ManagerGroupDTO one = getDtoByType(1, byType, "parent1", "提案类");
        ManagerGroupDTO two = getDtoByType(2, byType, "parent2", "决策类");
        List<ManagerGroupDTO> resList=new ArrayList<>();
        resList.add(one);
        resList.add(two);
        return resList;

    }

    public ManagerGroupDTO getDtoByType(Integer type,List<ManagerGroupDO> list,String key,String name){
        List<ManagerGroupDO> typeOne = list.stream().filter(item -> type.equals(item.getType())).collect(Collectors.toList());
        Integer total=0;
        for (ManagerGroupDO managerGroupDO: typeOne) {
            if (managerGroupDO.getTotal()!=null){
                total=total+managerGroupDO.getTotal();
            }
        }
        ManagerGroupDTO oneDto=new ManagerGroupDTO();
        oneDto.setKey(key);
        oneDto.setCouncilName(name);
        oneDto.setChildren(typeOne);
        oneDto.setTotal(total);
        return oneDto;
    }

    @Override
    public List<ManagerGroupDO> findList(String councilName, Integer isCancel) {
        return managerGroupRepository.findList(councilName,isCancel);
    }

    @Override
    public void cancelManagerGroup(Integer councilId, Integer isCancel) {
        managerGroupDao.cancelManagerGroup(councilId,isCancel);
    }

    @Override
    public void saveManagerGroups(List<ManagerGroupDO> managerGroupList) {
        managerGroupDao.saveAll(managerGroupList);
    }
}
