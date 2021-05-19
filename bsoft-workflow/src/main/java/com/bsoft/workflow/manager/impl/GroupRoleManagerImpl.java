package com.bsoft.workflow.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.workflow.condition.GroupRoleQueryCnd;
import com.bsoft.workflow.dao.primary.GroupRoleDao;
import com.bsoft.workflow.entity.primary.GroupRoleDO;
import com.bsoft.workflow.manager.GroupRoleManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
@Component
public class GroupRoleManagerImpl implements GroupRoleManager {

    @Autowired
    private GroupRoleDao groupRoleDao;
    @Autowired
    private PersonManager personManager;

    @Override
    public Result<GroupRoleDO> getGroupRoleList(GroupRoleQueryCnd queryCnd) {
        Sort sort = Sort.by("id");
        Pageable pageable = PageRequest.of(queryCnd.getPageNo() - 1, queryCnd.getPageSize(), sort);
        Page<GroupRoleDO> page = groupRoleDao.findAll(new Specification<GroupRoleDO>() {
            @Override
            public Predicate toPredicate(Root<GroupRoleDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(queryCnd.getInputContent())) {
                    predicates.add(criteriaBuilder.like(root.get("groupName"), "%" + queryCnd.getInputContent() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        Result<GroupRoleDO> result = ResultUtils.parseResult(page, GroupRoleDO.class);
        this.setUsersName(result.getItems());
        return result;
    }

    @Override
    public GroupRoleDO getGroupRole(Integer id) {
        return groupRoleDao.findById(id).get();
    }

    @Override
    public void saveGroupRole(GroupRoleDO saveDO) {
        if (saveDO.getId() == null) { // 新增
            groupRoleDao.save(saveDO);
        } else { // 修改
            GroupRoleDO findDO = groupRoleDao.findById(saveDO.getId()).get();
            findDO.setUsers(saveDO.getUsers());
            findDO.setGroupName(saveDO.getGroupName());
            groupRoleDao.save(findDO);
        }
    }

    @Override
    public void deleteGroupRole(Integer id) {
        groupRoleDao.deleteById(id);
    }

    private void setUsersName(List<GroupRoleDO> list) {
        List<String> peronIdList = new ArrayList<>();
        list.forEach(item -> {
            String users = item.getUsers();
            if(StringUtils.isNotBlank(users)){
                if(users.indexOf(",") > -1) {
                    List<String> idList = Arrays.asList(users.split(","));
                    peronIdList.addAll(idList);
                } else {
                    peronIdList.add(users);
                }
            }
        });
        List<PersonDO> personList = personManager.getPersonList(peronIdList);
        Map<String, String> personMap = personList.stream().collect(Collectors.toMap(PersonDO::getPersonId, PersonDO::getPersonName));
        list.forEach(item -> {
            String users = item.getUsers();
            if(StringUtils.isNotBlank(users)){
                String usersName = "";
                if(users.indexOf(",") > -1) {
                    StringBuilder sb = new StringBuilder("");
                    List<String> idList = Arrays.asList(users.split(","));
                    for(String id: idList) {
                        sb.append(personMap.get(id)).append(",");
                    }
                    usersName = sb.toString();
                    usersName = usersName.substring(0, usersName.length() - 1);
                } else {
                    usersName = personMap.get(users);
                }
                item.setUsersName(usersName);
            }
        });
    }
}
