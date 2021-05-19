package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.dept.dto.DeptSelectDTO;
import com.bsoft.hr.condition.ClockInModeQueryCnd;
import com.bsoft.hr.condition.DeptMaintainInfoQueryCnd;
import com.bsoft.hr.dto.*;
import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.DeptCostMaintainDO;
import com.bsoft.hr.entity.primary.DeptMaintainInfoDO;
import com.bsoft.hr.entity.primary.PersonDeptMaintainViewDO;
import com.bsoft.hr.manager.ClockInModeManager;
import com.bsoft.hr.manager.DeptCostMaintainManager;
import com.bsoft.hr.service.DeptCostMaintainService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class DeptCostMaintainServiceImpl  implements DeptCostMaintainService {


    @Autowired
    private DeptCostMaintainManager deptCostMaintainManager;

    @Autowired
    private ClockInModeManager clockInModeManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<String> getDeptList() {
        return deptCostMaintainManager.getDeptList();
    }

    @Override
    public boolean updateDeptCost(String userId,DeptCostMaintainDTO deptCostMaintainDTO) {
        //更新同时进行批量删除该部门下所有通过岗位维护财务类别的数据
        DeptCostMaintainDO convert = iGenerator.convert(deptCostMaintainDTO, DeptCostMaintainDO.class);
        return deptCostMaintainManager.updateDeptCost(userId,convert);
    }

    @Override
    public List<String> updatePostCost(String userId,List<DeptCostMaintainDTO> deptCostMaintainDTOList) {
        List<DeptCostMaintainDO> convert = iGenerator.convert(deptCostMaintainDTOList, DeptCostMaintainDO.class);
        return deptCostMaintainManager.updatePostCost( userId,convert);
    }

    @Override
    public List<DeptCostMaintainDTO> selectWithDept(String Dept) {
        return deptCostMaintainManager.selectWithDept(Dept);
    }

    @Override
    public DeptCostMaintainDTO getDeptFinancialType(String Dept) {
        DeptCostMaintainDO deptCostMaintainDO =deptCostMaintainManager.getDeptFinancialType(Dept);
        DeptCostMaintainDTO deptCostMaintainDTO= null;
        if(deptCostMaintainDO!=null) {
            deptCostMaintainDTO = iGenerator.convert(deptCostMaintainDO, DeptCostMaintainDTO.class);
        }
        return deptCostMaintainDTO;
    }

    @Override
    public Result<DeptMaintainInfoDTO> listDeptInfoWithPage(String userId, DeptMaintainInfoQueryCndDTO queryCndDTO) {
//        TimeConsumer timeConsumer = TimeConsumer.start();
        DeptMaintainInfoQueryCnd queryCnd = iGenerator.convert(queryCndDTO, DeptMaintainInfoQueryCnd.class);
        Page<PersonDeptMaintainViewDO> page = deptCostMaintainManager.listDeptInfoWithPage(queryCnd);
        Result<DeptMaintainInfoDTO> result = ResultUtils.parseResult(page, DeptMaintainInfoDTO.class);
        List<PersonDeptMaintainViewDO> children = deptCostMaintainManager.listChildDeptInfo(page.getContent());
        if (children.size() > 0) {
            result.getItems().addAll(iGenerator.convert(children, DeptMaintainInfoDTO.class));
        }
        return result;
    }

    @Override
    public void updateDeptInfoWithPage(String userId, List<DeptMaintainInfoQueryCndDTO> queryCndDTO) {
        List<DeptMaintainInfoDO> convert = iGenerator.convert(queryCndDTO, DeptMaintainInfoDO.class);
        for(DeptMaintainInfoDO deptCostMaintainDO : convert){
            deptCostMaintainManager.updateDeptInfoWithPage(deptCostMaintainDO.getDept(),deptCostMaintainDO.getPersonTypeFlag());
        }
    }

}
