package com.bsoft.auth.manager.impl;

import com.bsoft.auth.dao.primary.DeptRoleDao;
import com.bsoft.auth.dao.primary.RoleNameDao;
import com.bsoft.auth.entity.primary.DeptRoleDO;
import com.bsoft.auth.entity.primary.RoleMaintainBaseDO;
import com.bsoft.auth.entity.primary.RoleNameDO;
import com.bsoft.auth.manager.RoleMaintainManager;
import com.bsoft.auth.repository.primary.RoleMaintainRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.*;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description:
 */
@Component
public class RoleMaintainManagerImpl implements RoleMaintainManager {

    @Autowired
    private RoleNameDao roleNameDao;

    @Autowired
    private DeptRoleDao deptRoleDao;

    @Autowired
    private RoleMaintainRepository roleMaintainRepository;

    @Override
    @Transactional
    public RoleNameDO saveRole(RoleNameDO roleDO) {
        return roleNameDao.save(roleDO);
    }

    @Override
    @Transactional
    public List<RoleNameDO> saveRoles(List<RoleNameDO> roles) {
        return roleNameDao.saveAll(roles);
    }

    @Override
    public List<RoleNameDO> getRoles(Integer status,String content) {
        Sort sort = Sort.by("sourceType").descending().and(Sort.by("sort").ascending());
        List<RoleNameDO> list = roleNameDao.findAll(new Specification<RoleNameDO>() {
            @Override
            public Predicate toPredicate(Root<RoleNameDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isBlank(content)) {
                    predicates.add(criteriaBuilder.like(root.get("roleName"), "%" + content + "%"));
                }
                if (status == 0 || status == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), status));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },sort);
        return list;
    }

    @Override
    @Transactional
    public DeptRoleDO saveDeptRole(DeptRoleDO deptRoleDO) {
        return deptRoleDao.save(deptRoleDO);
    }

    @Override
    public List<RoleMaintainBaseDO> getRoleMaintainBase(String dept) {
        return roleMaintainRepository.getRoleMaintains(dept);
    }

    @Override
    @Transactional
    public void saveDeptRoles(List<DeptRoleDO> deptRoles) {
        List<DeptRoleDO> deletes = new ArrayList<>();
        List<DeptRoleDO> saves = new ArrayList<>();
        deptRoles.forEach(deptRoleDO -> {
            Integer roleId = deptRoleDO.getRoleId();
            String dept = deptRoleDO.getDept();
            List<DeptRoleDO> deptRoleDOS = deptRoleDao.findDeptRoleDOSByDeptAndRoleId(dept,roleId);
            deletes.addAll(deptRoleDOS);
            String userIds = deptRoleDO.getUserId();
            List<String> userIdList = Arrays.asList(userIds.split(","));
            userIdList.forEach(userId -> {
                DeptRoleDO deptRole = new DeptRoleDO();
                deptRole.setDept(dept);
                deptRole.setRoleId(roleId);
                if(StringUtils.isNotBlank(userId)){
                    deptRole.setUserId(userId);
                    saves.add(deptRole);
                }
            });
        });
        deptRoleDao.deleteAll(deletes);
        deptRoleDao.saveAll(saves);
    }

    @Override
    public List<Map<String, Object>> getDeptRoleDetails() {
        List<RoleNameDO> roles = roleNameDao.findByStatus(0);
        roles.sort(Comparator.comparing(RoleNameDO::getSort));
        return roleMaintainRepository.selectDeptRoles(roles);
    }

    @Override
    public DeptRoleDO getDeptRole(String dept, Integer roleId) {
        return deptRoleDao.findByDeptAndRoleId(dept,roleId);
    }

    @Override
    public List<String> getManagerDept(String personId, Integer roleId) {
        return deptRoleDao.getManagerDept(personId,roleId);
    }

    @Override
    public List<DeptRoleDO> findDeptRoles(String dept, Integer roleId) {
        return deptRoleDao.findDeptRoleDOSByDeptAndRoleId(dept,roleId);
    }

}
