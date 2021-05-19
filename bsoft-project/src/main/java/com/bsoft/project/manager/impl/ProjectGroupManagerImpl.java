package com.bsoft.project.manager.impl;

import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.dao.primary.*;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.manager.ProjectGroupManager;
import com.bsoft.project.repository.primary.ProjectGroupRepository;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.manager.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06 14:32
 * @Description:
 */
@Component
public class ProjectGroupManagerImpl implements ProjectGroupManager {
    private static final Logger logger = LoggerFactory.getLogger(ProjectGroupManagerImpl.class);
    @Autowired
    private ProjectGroupRepository projectGroupRepository;
    @Autowired
    private ProjectGroupDao projectGroupDao;
    @Autowired
    private ProjectGroupTreeDao projectGroupTreeDao;
    @Autowired
    private ProjectGroupDetailViewDao projectGroupDetailViewDao;
    @Autowired
    private ProjectGroupDetailDao projectGroupDetailDao;
    @Autowired
    private ProjectGroupLeaderSelfViewDao projectGroupLeaderSelfViewDao;
    @Autowired
    private PublicDicManager publicDicManager;


    @Override
    public List<ProjectGroupTreeDO> getProjectGroupsTree(String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupTreeDO> tree = getGroupTree(contractNo);
        long times = timeConsumer.end();
        logger.info("方法名:{}成员管理-项目组获取数据耗时:{}",new Object[]{"getProjectGroupsTree",times});
        return tree;
    }

    @Override
    public List<ProjectGroupTreeDO> getLeaderSelfProjectGroupsTree(String personId, String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupTreeDO> tree = getGroupTree(contractNo);
        List<ProjectGroupTreeDO> leaderTree = new ArrayList<>();
        tree.stream().forEach(group->{
            if(personId.equals(group.getLeaderId())){
                leaderTree.add(group);
            }else{
                List<ProjectGroupTreeDO> leaderGroup = getLeaderGroup(group,personId);
                if(leaderGroup != null){
                    leaderTree.addAll(leaderGroup);
                }
            }
        });
        long times = timeConsumer.end();
        logger.info("方法名:{}组员维护-项目组获取数据耗时:{}",new Object[]{"getLeaderSelfProjectGroupsTree",times});
        return leaderTree;
    }

    @Override
    public Result<ProjectGroupDetailViewDO> getProjectGroupMembers(String contractNo, String inputContent, int pageSize, int pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "leader"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orders));
        Specification<ProjectGroupDetailViewDO> spec = new Specification<ProjectGroupDetailViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectGroupDetailViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("contractNo"),contractNo));
                if(!StringUtils.isBlank(inputContent)){
                    Predicate c1 = criteriaBuilder.like(root.get("personName"),"%"+inputContent+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent.toLowerCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
                return criteriaQuery.getRestriction();
            }
        };
        Page<ProjectGroupDetailViewDO> pageResult = projectGroupDetailViewDao.findAll(spec, pageable);
        Result<ProjectGroupDetailViewDO> result = ResultUtils.parseResult(pageResult);
        long times = timeConsumer.end();
        logger.info("方法名:{}指定条件成员管理-项目组成员获取数据耗时:{}",new Object[]{"getProjectGroupMembers",times});
        return result;
    }

    @Override
    public Result<ProjectGroupDetailViewDO> getProjectLeaderGroupMembers(String contractNo, String personId, String inputContent, int pageSize, int pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<Integer> groupIds = getLeaderGroupId(contractNo,personId);
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "leader"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orders));
        Specification<ProjectGroupDetailViewDO> spec = new Specification<ProjectGroupDetailViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectGroupDetailViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (groupIds.size() > 0) {
                    CriteriaBuilder.In<Integer> in = criteriaBuilder.in(root.get("groupId"));
                    for (Integer groupId : groupIds) {
                        in.value(groupId);

                    }
                    predicates.add(in);
                }

                if(!StringUtils.isBlank(inputContent)){
                    Predicate c1 = criteriaBuilder.like(root.get("personName"),"%"+inputContent+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent.toLowerCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
                return criteriaQuery.getRestriction();
            }
        };
        Page<ProjectGroupDetailViewDO> pageResult = projectGroupDetailViewDao.findAll(spec, pageable);
        Result<ProjectGroupDetailViewDO> result = ResultUtils.parseResult(pageResult);
        long times = timeConsumer.end();
        logger.info("方法名:{}指定条件组员维护-项目组成员获取数据耗时:{}",new Object[]{"getProjectLeaderGroupMembers",times});
        return result;
    }


    @Override
    @Transactional
    public ProjectGroupDO saveProjectGroup(ProjectGroupDO projectGroupDO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectGroupDO group = projectGroupDao.save(projectGroupDO);
        long times = timeConsumer.end();
        logger.info("方法名:{}保存项目组节点数据耗时:{}",new Object[]{"saveProjectGroup",times});
        return group;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveProjectGroups(List<ProjectGroupDO> projectGroupTreeNodes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        projectGroupDao.saveAll(projectGroupTreeNodes);
        long times = timeConsumer.end();
        logger.info("方法名:{}保存多个项目组节点数据耗时:{}",new Object[]{"saveProjectGroups",times});
    }

    @Override
    @Transactional
    public void deleteProjectGroup(Integer groupId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
         projectGroupDao.deleteById(groupId);
        long times = timeConsumer.end();
        logger.info("方法名:{}删除项目组节点数据耗时:{}",new Object[]{"deleteProjectGroupTreeNode",times});
    }

    @Override
    public List<ProjectGroupDO> getProjectChildGroups(String contractNo, Integer parentId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupDO> ProjectGroupDOList = projectGroupDao.findAllByContractNoAndParentIdOrderBySortNo(contractNo, parentId);
        long times = timeConsumer.end();
        logger.info("方法名:{}获取子组数据耗时:{}",new Object[]{"getProjectChildGroups",times});
        return ProjectGroupDOList;
    }

    @Override
    public Integer getProjectChildGroupsCount(String contractNo, Integer parentId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer childrenGroupsCount = projectGroupDao.countByContractNoAndParentId(contractNo, parentId);
        long times = timeConsumer.end();
        logger.info("方法名:{}获取子组数量耗时:{}",new Object[]{"getProjectChildGroupsCount",times});
        return childrenGroupsCount;
    }

    @Override
    @Transactional
    public void saveProjectGroupMembers(List<ProjectGroupDetailDO> projectGroupMembers, List<Integer> deletes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupDetailDO> leaderMembers = projectGroupMembers.stream().filter(leaderMember->leaderMember.getLeader().equals(1)).collect(Collectors.toList());
        leaderMembers.forEach(leaderMember->{
            Integer groupId = leaderMember.getGroupId();
            projectGroupDetailDao.setUnProjectGroupLeader(groupId);
        });
        projectGroupDetailDao.saveAll(projectGroupMembers);
        projectGroupDetailDao.deleteByIdIn(deletes);
        long times = timeConsumer.end();
        logger.info("方法名:{}保存项目组组员数据耗时:{}",new Object[]{"saveProjectGroupMembers",times});
    }

    @Override
    public Result<ProjectGroupDetailViewDO> getProjectGroupMembersList(Integer groupId, Integer pageSize, Integer pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "leader"));
        orders.add(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orders));
        Specification<ProjectGroupDetailViewDO> spec = new Specification<ProjectGroupDetailViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectGroupDetailViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("groupId"),groupId));
                criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
                return criteriaQuery.getRestriction();
            }
        };
        Page<ProjectGroupDetailViewDO> pageResult = projectGroupDetailViewDao.findAll(spec, pageable);
        Result<ProjectGroupDetailViewDO> result = ResultUtils.parseResult(pageResult);
        long times = timeConsumer.end();
        logger.info("方法名:{}项目组成员列表获取数据耗时:{}",new Object[]{"getProjectGroupMembersList",times});
        return result;
    }

    @Override
    public Result<ProjectGroupLeaderSelfViewDO> getLeaderSelfProjectList(String personId, Integer pageSize, Integer pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        Page<ProjectGroupLeaderSelfViewDO> pageResult = projectGroupLeaderSelfViewDao.findAllByLeaderId(personId,pageable);
        List<ProjectGroupLeaderSelfViewDO> pageList = pageResult.getContent();

        pageList.forEach(leaderSelfProject -> {
            Integer membersNum = getLeaderGroupMembersNum(leaderSelfProject.getContractNo(), personId);
            leaderSelfProject.setMembersNumber(membersNum);

        });
        Result<ProjectGroupLeaderSelfViewDO> result = ResultUtils.parseResult(pageResult);
        long times = timeConsumer.end();
        logger.info("方法名:{}组长管理项目获取数据耗时:{}",new Object[]{"getLeaderSelfProjectList",times});
        return result;
    }

    @Override
    public Set<String> checkProjectGroupMembers(String contractNo,List<ProjectGroupDetailDO> members,List<Integer> deletes,List<Integer> updates) {
        Set<String> personIds = new HashSet<>();
        //获取同一合同号下的所有成员
        List<ProjectGroupDetailDO> allMembers = projectGroupDetailDao.getProjectGroupAllMembers(contractNo);
        //过滤出提交组员列表下的所有新增组员
        Collection<ProjectGroupDetailDO> addMembers = Collections2.filter(members,x->x.getId()==null);
        //过滤出提交组员列表下的所有修改（未修改）的组员
        Collection<ProjectGroupDetailDO> modifyMembers = Collections2.filter(members,x->x.getId() != null);
        Map<Integer,ProjectGroupDetailDO> allMembersMap = allMembers.stream().collect(Collectors.toMap(ProjectGroupDetailDO::getId,detail->detail));
        //将修改的组员覆盖原明细id的数据
        modifyMembers.forEach(member->{
            allMembersMap.put(member.getId(),member);
        });
        //条件查询后组员修改组长，原组长修改成组员
        updates.forEach(id -> {
            ProjectGroupDetailDO member = allMembersMap.get(id);
            member.setLeader(0);
            allMembersMap.put(id,member);
        });
        List<ProjectGroupDetailDO> noRepeatMember =  allMembersMap.values().stream().collect(Collectors.toList());
        noRepeatMember.addAll(addMembers);
        Map<String,Long> noRepeatLeaderMap = noRepeatMember.stream().filter(member-> !deletes.contains(member.getId())).map(person->person.getGroupId() + ":" + person.getPersonId()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        noRepeatLeaderMap.forEach((k,v)->{
            if(v > 1){
                String personId = k.split(":")[1];
                personIds.add(personId);
            }
        });
        //将去重后的成员列表中去除不在提交列表下的所有组长、去除待删除的组员构成一个key为工号，value为出现次数的map
        Map<String, Long> collect = noRepeatMember.stream().filter(member->member.getLeader().equals(0) && !deletes.contains(member.getId())).map(ProjectGroupDetailDO::getPersonId).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k,v)->{
            if(v > 1){
                personIds.add(k);
            }
        });
        return personIds;
    }

    @Override
    public Boolean isLeader(String personId, String contractNo) {
        Integer memberCount = projectGroupDetailDao.isGroupMember(personId,contractNo);
        if(memberCount == 0){
            return true;
        }
        Integer count = projectGroupDetailDao.isLeader(personId,contractNo);
        return count > 0 ? true:false;
    }

    @Override
    public Boolean haveLeader(String personId, String contractNo) {
        Integer count = projectGroupRepository.getGroupLeaderCount(personId,contractNo);
        return count > 0 ? true:false;
    }

    @Override
    public String getLeader(String personId, String contractNo) {
        return projectGroupRepository.getGroupLeader(personId,contractNo);
    }

    @Override
    public String getProjectManager(String personId) {
        return projectGroupRepository.getProjectManager(personId);
    }


    @Override
    public ProjectGroupDO getGroupById(Integer id) {
        return projectGroupDao.getOne(id);
    }


    private void saveOriginProjectTree(String contractNo) {
        ArrayList<ProjectGroupDO> projectGroupDOList = new ArrayList<ProjectGroupDO>();
        List<PublicDicDO> projectGroups = publicDicManager.getPublicDic(2001); //获取项目组字典

        for (PublicDicDO projectGroup : projectGroups) {
            ProjectGroupDO projectGroupDO = new ProjectGroupDO();
            projectGroupDO.setParentId(0);
            projectGroupDO.setGroupName(projectGroup.getName());
            projectGroupDO.setContractNo(contractNo);
            projectGroupDO.setSortNo(projectGroup.getId());
            projectGroupDOList.add(projectGroupDO);
        }

        this.saveProjectGroups(projectGroupDOList);
    }


    private List<ProjectGroupTreeDO> getGroupTree(String contractNo){
        List<ProjectGroupTreeDO> result = projectGroupTreeDao.findByContractNo(contractNo);
        if(result.isEmpty()){
            this.saveOriginProjectTree(contractNo);
            result = projectGroupTreeDao.findByContractNo(contractNo);
        }

        Collection<ProjectGroupTreeDO> roots = Collections2.filter(result,x->x.getParentId().equals(0));
        Integer level = 1;
        for(ProjectGroupTreeDO group : roots){
            group.setLevelNo(level);
            toGroupTree(group,result,level);
        }
        List<ProjectGroupTreeDO> sortedTree = roots.stream().sorted(Comparator.comparing(ProjectGroupTreeDO::getSortNo)).collect(Collectors.toList());
        return sortedTree;

    }

    private void toGroupTree(ProjectGroupTreeDO group,List<ProjectGroupTreeDO> result,Integer level){
        Integer sonLevel = level + 1;
        Integer parentId = group.getGroupId();
        Collection<ProjectGroupTreeDO> childrens = Collections2.filter(result, x->x.getParentId().equals(parentId));
        List<ProjectGroupTreeDO> sortedChildrens = childrens.stream().sorted(Comparator.comparing(ProjectGroupTreeDO::getSortNo)).collect(Collectors.toList());
        group.setChildren(sortedChildrens);
        for(ProjectGroupTreeDO children : childrens){
            children.setLevelNo(sonLevel);
            toGroupTree(children,result,sonLevel);
        }
    }

    private List<ProjectGroupTreeDO> getLeaderGroup(ProjectGroupTreeDO group,String personId){
        List<ProjectGroupTreeDO> childrens = group.getChildren();
        List<ProjectGroupTreeDO> leaderChildren = new ArrayList<>();
        if(childrens != null){
            for(ProjectGroupTreeDO children : childrens){
                if(personId.equals(children.getLeaderId())){
                    leaderChildren.add(children);
                }else{
                    List<ProjectGroupTreeDO> result = getLeaderGroup(children,personId);
                    leaderChildren.addAll(result);
                }
            }
        }
        return leaderChildren;
    }

    private List<Integer> getLeaderGroupId(String contractNo,String personId){
        List<ProjectGroupTreeDO> trees = getLeaderSelfProjectGroupsTree(personId,contractNo);
        List<ProjectGroupTreeDO> list = new ArrayList<>();
        for(ProjectGroupTreeDO group : trees){
            list.add(group);
            treeToList(group,list);
        }

        return list.stream().map(group->group.getGroupId()).distinct().collect(Collectors.toList());
    }

    private Integer getLeaderGroupMembersNum(String contractNo,String personId){
        List<ProjectGroupTreeDO> trees = getLeaderSelfProjectGroupsTree(personId,contractNo);
        List<ProjectGroupTreeDO> list = new ArrayList<>();
        for(ProjectGroupTreeDO group : trees){
            list.add(group);
            treeToList(group,list);
        }

        return list.stream().mapToInt(group->group.getMembersNum()).sum();
    }

    private void treeToList(ProjectGroupTreeDO group,List<ProjectGroupTreeDO> list){
        List<ProjectGroupTreeDO> childrens = group.getChildren();
        if(childrens != null){
            childrens.stream().forEach(children->{
                list.add(children);
                treeToList(children,list);
            });
        }
    }


}
