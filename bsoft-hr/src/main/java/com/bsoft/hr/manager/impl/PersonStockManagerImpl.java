package com.bsoft.hr.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.hr.condition.PersonStockQueryCnd;
import com.bsoft.hr.dao.primary.PersonStockDao;
import com.bsoft.hr.dao.primary.PersonStockViewDao;
import com.bsoft.hr.entity.primary.PersonStockDO;
import com.bsoft.hr.entity.primary.PersonStockViewDO;
import com.bsoft.hr.manager.PersonStockManager;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:04
 * @Description
 */
@Service
public class PersonStockManagerImpl implements PersonStockManager {
    private static final String DEFAULT_ERROR_DATA_TOKEN = "ErrorDataToken";
    @Autowired
    private PersonStockDao personStockDao;
    @Autowired
    private PersonStockViewDao personStockViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Page<PersonStockViewDO> getPersonStockList(PersonStockQueryCnd cnd) {
        Sort sort = Sort.by("registerDate").descending().and(Sort.by("sortBy").ascending()).and(Sort.by("personId").ascending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<PersonStockViewDO> pages = personStockViewDao.findAll(new Specification<PersonStockViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonStockViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("logout"), 0));
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personId"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if (!"-1".equals(cnd.getFlag())) {
                    predicates.add(criteriaBuilder.equal(root.get("flag"), cnd.getFlag()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public void logoutOnePersonStock(Integer id) {
        personStockDao.updateLogoutById(id, 1);
    }

    @Override
    @Transactional
    public void batchLogoutPersonStocks(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new ServiceException("待删除的股份列表不能为空");
        }
        personStockDao.updateAllLogoutById(ids, 1);
    }

    @Override
    @Transactional
    public void savePersonStock(PersonStockDO personStockDO) {
        if (personStockDO.getRegisterDate() == null) {
            personStockDO.setRegisterDate(serverDateManager.getServerDate());
        }
        personStockDao.save(personStockDO);
    }

    @Override
    @Transactional
    public ImportResultDO savePersonStocks(List<PersonStockViewDO> personStocks, String personId) {
        List<PersonDO> allPersons = personManager.getPerson();
        List<DeptDO> allDepts = deptManager.getAllDept();
        Map<String, Object> dataMap = this.doValidatePersonStocks(personStocks, allPersons, allDepts);
        List<PersonStockDO> successData = (List<PersonStockDO>) dataMap.get("success");
        List<PersonStockViewDO> errorData = (List<PersonStockViewDO>) dataMap.get("error");
        if (!successData.isEmpty()) {
            personStockDao.saveAll(successData);
        }
        if (!errorData.isEmpty()) {
            this.cacheErrorData(personId, "personstock",errorData);
        }
        ImportResultDO result = new ImportResultDO();
        result.setSuccessCount(successData.size());
        result.setFailCount(errorData.size());
        return result;

    }

    @Override
    public List<PersonStockViewDO> getErrorPersonStockList(String personId) {
        String errorDataString = redisTemplate.opsForValue().get(getKey(personId, "personstock"));
        List<PersonStockViewDO> errorData = (List<PersonStockViewDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    @Override
    public List<PersonStockViewDO> getAllPersonStockList(PersonStockQueryCnd cnd) {
        Sort sort = Sort.by("registerDate").descending().and(Sort.by("sortBy").ascending());
        List<PersonStockViewDO> list = personStockViewDao.findAll(new Specification<PersonStockViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonStockViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("logout"), 0));
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personId"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if (!"-1".equals(cnd.getFlag())) {
                    predicates.add(criteriaBuilder.equal(root.get("flag"), cnd.getFlag()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },sort);
        return list;
    }

    private String getKey(String personId, String key){
        return new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append(key).append(":").append(personId).toString();
    }

    private void cacheErrorData(String personId, String key,List data){
        String redisKey = this.getKey(personId, key);
        // 先删除redis数据
        redisTemplate.delete(redisKey);
        // 再重新缓存数据,并设置30min的过期时间
        redisTemplate.opsForValue().set(redisKey, JSONObject.toJSONString(data), 30, TimeUnit.MINUTES);
    }

    private Map<String, Object> doValidatePersonStocks(List<PersonStockViewDO> personStocks, List<PersonDO> allPersons, List<DeptDO> allDepts) {
        Map<String, Object> map = new HashMap<>();
        // 需要保存的数据
        List<PersonStockViewDO> needSaveData = new ArrayList<>();
        // 校验不通过的数据
        List<PersonStockViewDO> failedData = new ArrayList<>();
        Map<String, PersonDO> persons = allPersons.stream().collect(Collectors.toMap(PersonDO::getPersonId, personDO -> personDO));
        Map<String, String> depts = allDepts.stream().collect(Collectors.toMap(DeptDO::getDeptId, DeptDO::getDeptName));
        personStocks.forEach(personStock -> {
            if (this.checkPersonStock(persons, depts, personStock)) {
                personStock.setLogout(0);
                needSaveData.add(personStock);
            } else {
                failedData.add(personStock);
            }
        });
        List<PersonStockDO> personStockDOS = iGenerator.convert(needSaveData, PersonStockDO.class);
        map.put("success", personStockDOS);
        map.put("error", failedData);
        return map;
    }

    private boolean checkPersonStock(Map<String, PersonDO> persons, Map<String, String> depts, PersonStockViewDO personStock) {
        // 工号校验
        if (StringUtils.isBlank(personStock.getPersonId())) {
            personStock.setFailureReason("工号不能为空");
            return false;
        }
        if (!persons.containsKey(personStock.getPersonId())) {
            personStock.setFailureReason("工号不存在");
            return false;
        }
        // 工号姓名匹配校验
        if (StringUtils.isNotBlank(personStock.getPersonName()) && !persons.get(personStock.getPersonId()).getPersonName().equals(personStock.getPersonName())) {
            personStock.setFailureReason("工号与姓名不匹配");
            return false;
        }
        // 工号姓名匹配校验
        if (StringUtils.isNotBlank(personStock.getDeptName()) && !depts.get(persons.get(personStock.getPersonId()).getDeptId()).equals(personStock.getDeptName())) {
            personStock.setFailureReason("工号与部门不匹配");
            return false;
        }
        return true;
    }
}
