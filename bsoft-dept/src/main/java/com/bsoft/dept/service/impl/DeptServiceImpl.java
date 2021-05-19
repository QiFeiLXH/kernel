package com.bsoft.dept.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.dept.dto.DeptDTO;
import com.bsoft.dept.dto.DeptSelectDTO;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.entity.primary.DeptSelectDO;
import com.bsoft.dept.entity.primary.DeptWithPersonDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.dept.service.DeptService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.dept.service.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-21
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {
    private static final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);
    @Autowired
    private IGenerator generator;
    @Autowired
    private DeptManager deptManager;

    @Override
    public List<DeptSelectDTO> findDeptSelectList(String logout) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<DeptSelectDO> deptList = deptManager.getDeptSelectList(logout);
        long times = timeConsumer.end();
        List<DeptSelectDTO> depts = generator.convert(deptList, DeptSelectDTO.class);
        logger.info("获取部门结构树列表耗时:{}",times);
        return depts;
    }

    @Override
    public List<DeptSelectDTO> listDeptForSelect(String logout, String deptType) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<DeptSelectDO> deptList = deptManager.getDeptSelectList(logout, deptType);
        long times = timeConsumer.end();
        List<DeptSelectDTO> depts = generator.convert(deptList, DeptSelectDTO.class);
        logger.info("获取部门选择器组件部门树耗时:{}",times);
        return depts;
    }

    @Override
    public List<DeptSelectDTO> listDeptForSelectWithPerson(String logout, String deptType, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<DeptSelectDO> deptList = deptManager.getDeptSelectListWithPerson(logout, deptType,personId);
        long times = timeConsumer.end();
        List<DeptSelectDTO> depts = generator.convert(deptList, DeptSelectDTO.class);
        logger.info("获取根据人员权限获取部门选择器组件部门树耗时:{}",times);
        return depts;
    }

    @Override
    public List<DeptDTO> getValidDept() {
        List<DeptDO> result = deptManager.getValidDept();
        return generator.convert(result,DeptDTO.class);
    }

    @Override
    public List<DeptDTO> getDeptWithPerson() {
        List<DeptWithPersonDO> result = deptManager.getDeptWithPerson();
        return generator.convert(result,DeptDTO.class);
    }

    @Override
    public List<DeptDTO> getAllDept() {
        List<DeptDO> allDept = deptManager.getAllDept();
        return generator.convert(allDept,DeptDTO.class);
    }

    @Override
    public List<DeptDTO> getDeptList(List<String> nameList) {
        List<DeptDO> deptList = deptManager.getDeptList(nameList);
        return generator.convert(deptList, DeptDTO.class);
    }

    @Override
    public List<DeptDTO> getValidDeptListWithRegionDeptIds(List<String> deptIds) {
        List<DeptDO> depts = deptManager.getValidDeptListWithRegionDeptIds(deptIds);
        return generator.convert(depts, DeptDTO.class);
    }

    @Override
    public List<DeptDTO> getAllValidRegionAndSubDeptList() {
        List<DeptDO> depts = deptManager.getAllValidRegionAndSubDeptList();
        return generator.convert(depts, DeptDTO.class);
    }

    @Override
    public List<DeptSelectDTO> getAllValidParentDeptList() {
        List<DeptSelectDO> depts = deptManager.getAllValidParentDeptList();
        return generator.convert(depts, DeptSelectDTO.class);
    }

}
