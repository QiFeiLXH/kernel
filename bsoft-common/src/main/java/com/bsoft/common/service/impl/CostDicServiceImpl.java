package com.bsoft.common.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.CostDicDTO;
import com.bsoft.common.entity.primary.CostDicDO;
import com.bsoft.common.manager.CostDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.service.CostDicService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
@Service
public class CostDicServiceImpl implements CostDicService {

    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private CostDicManager costDicManager;

    @Override
    public List<CostDicDTO> getCostDicList(Integer type, Integer logout) {
        List<CostDicDO> resultDOList = costDicManager.getCostDicList(type, logout);
        return iGenerator.convert(resultDOList, CostDicDTO.class);
    }


    @Override
    public List<CostDicDTO> getCostDicList(Integer type,Integer subType, Integer logout, String inputContent) {
        List<CostDicDO> result = costDicManager.getCostDicList(type, subType, logout, inputContent);
        return iGenerator.convert(result, CostDicDTO.class);
    }
}
