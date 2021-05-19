package com.bsoft.cost.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.cost.dto.CostTypeDeptViewDTO;
import com.bsoft.cost.dto.DeptCostTypeViewDTO;
import com.bsoft.cost.entity.primary.CostTypeDeptViewDO;
import com.bsoft.cost.entity.primary.DeptCostTypeViewDO;
import com.bsoft.cost.manager.DeptCostTypeManager;
import com.bsoft.cost.service.DeptCostTypeService;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 9:54
 * @Description:
 */
@Service
public class DeptCostTypeServiceImpl implements DeptCostTypeService {
    private static final Logger logger = LoggerFactory.getLogger(DeptCostTypeServiceImpl.class);
    @Autowired
    private DeptCostTypeManager deptCostTypeManager;
    @Autowired
    GeneratorUtil generatorUtil;

    @Override
    public List<CostTypeDeptViewDTO> findDeptList(Integer year,Integer flag, Integer bmlb, Integer zxbz,String deptId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        String dept = StringUtils.isBlank(deptId) ? null:deptId;
        List<CostTypeDeptViewDO> list = deptCostTypeManager.findDeptList(year,flag, bmlb, zxbz,dept);
        List<CostTypeDeptViewDTO> dtoList = null;
        if (StringUtils.isNotBlank(deptId)){//按照部门过滤
            if (list.isEmpty()){
                return null;
            }
            String parentBm = list.get(0).getParentBm() != null ? list.get(0).getParentBm() : list.get(0).getBmdm();
            List<CostTypeDeptViewDO> costTypeDeptViewDOS = deptCostTypeManager.findDeptListByDept(year,flag, bmlb, zxbz,parentBm);
            dtoList = generatorUtil.convert(costTypeDeptViewDOS,CostTypeDeptViewDTO.class);
        }else{
            dtoList = generatorUtil.convert(list,CostTypeDeptViewDTO.class);
        }
        Collection<CostTypeDeptViewDTO> root = Collections2.filter(dtoList, x -> x.getIsParent() == 1 || x.getParentBm() == null);
        List<CostTypeDeptViewDTO> rootList = new ArrayList<>(root);
        generToTree(rootList,dtoList);
        long time = timeConsumer.end();
        logger.info("部门费用类别维护查询部门树耗时:[{}]",time);
        return rootList;
    }

    private void generToTree(List<CostTypeDeptViewDTO> parent, List<CostTypeDeptViewDTO> all){
        for (CostTypeDeptViewDTO costTypeDeptViewDTO:parent){
            Collection<CostTypeDeptViewDTO> child = Collections2.filter(all, x -> x.getParentBm() != null && x.getParentBm().equals(costTypeDeptViewDTO.getBmdm()));
            if (child.size() > 0){
                List<CostTypeDeptViewDTO> childList = new ArrayList<>(child);
                costTypeDeptViewDTO.setChildren(childList);
                generToTree(childList,all);
            }
        }
    }

    @Override
    public DeptCostTypeViewDTO getDeptCostType(Integer year, String deptNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        DeptCostTypeViewDO viewDO = deptCostTypeManager.getDeptCostType(year,deptNo);
        DeptCostTypeViewDTO viewDTO = generatorUtil.convert(viewDO,DeptCostTypeViewDTO.class);
        long time = timeConsumer.end();
        logger.info("部门费用类别维护查询部门树耗时:[{}]",time);
        return viewDTO;
    }

    @Override
    public void saveCostType(DeptCostTypeViewDTO dto) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        DeptCostTypeViewDO viewDO = generatorUtil.convert(dto,DeptCostTypeViewDO.class);
        deptCostTypeManager.saveCostType(viewDO);
        long time = timeConsumer.end();
        logger.info("保存部门费用类别维护耗时:[{}]",time);
    }

    @Override
    public boolean checkAnnualGener(Integer year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        boolean status = deptCostTypeManager.checkAnnualGener(year);
        long time = timeConsumer.end();
        logger.info("部门费用类别验证是否可年度生成耗时:[{}]",time);
        return status;
    }

    @Override
    public void annualGener(Integer year,String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        deptCostTypeManager.annualGener(year,personId);
        long time = timeConsumer.end();
        logger.info("部门费用类别年度生成耗时:[{}]",time);
    }
}
