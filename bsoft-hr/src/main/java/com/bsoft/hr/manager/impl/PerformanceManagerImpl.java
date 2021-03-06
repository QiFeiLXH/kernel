package com.bsoft.hr.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.hr.dao.primary.PerformanceDao;
import com.bsoft.hr.dao.primary.PerformanceViewDao;
import com.bsoft.hr.entity.primary.PerformanceDO;
import com.bsoft.hr.entity.primary.PerformanceSaveResultDO;
import com.bsoft.hr.entity.primary.PerformanceViewDO;
import com.bsoft.hr.manager.PerformanceManager;
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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 15:21
 * @Description
 */
@Service
public class PerformanceManagerImpl implements PerformanceManager {
    private static final String DEFAULT_ERROR_DATA_TOKEN = "ErrorDataToken";
    @Autowired
    private PerformanceDao performanceDao;
    @Autowired
    private PerformanceViewDao performanceViewDao;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private IGenerator iGenerator;
    private List<String> grade = Arrays.asList("A","B","B+","C","D","E");

    @Override
    public Page<PerformanceViewDO> getPerformanceList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("evaluationDate").descending()
                .and(Sort.by("personId").descending());
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<PerformanceViewDO> pages = performanceViewDao.findAll(new Specification<PerformanceViewDO>() {
            @Override
            public Predicate toPredicate(Root<PerformanceViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("year"), year)); // ????????????
                if (StringUtils.isNotBlank(deptId)) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), deptId));
                }
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent.toLowerCase()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+inputContent+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public PerformanceSaveResultDO savePerformance(String personId, List<PerformanceViewDO> performanceViewDOS, List<PerformanceViewDO> errorPerformanceViewDOS) {
        List<PersonDO> allPersons = personManager.getPersonsEvaluated();
        Map<String, Object> dataMap = doJudgePerformanceData(performanceViewDOS, allPersons);
        List<PersonDO> persons = (List<PersonDO>)dataMap.get("persons");
        List<PerformanceDO> performances = (List<PerformanceDO>)dataMap.get("performances");
        List<PerformanceViewDO> failedData = (List<PerformanceViewDO>)dataMap.get("failed");
        failedData.addAll(errorPerformanceViewDOS);
        // ???????????????
        performanceDao.saveAll(performances);
        // ??????????????????
        personManager.savePersons(persons);
        // ??????????????????
        this.cacheErrorData(personId, "performance", failedData);

        PerformanceSaveResultDO result = new PerformanceSaveResultDO();
        result.setSuccessCount(performances.size());
        result.setFailCount(failedData.size());
        return result;
    }

    @Override
    @Transactional
    public void deletePerformances(List<PerformanceDO> performanceDOS) {
        List<String> personIdList = performanceDOS.stream().map(PerformanceDO::getPersonId).collect(Collectors.toList());
        performanceDao.deleteAll(performanceDOS);
        performanceDao.flush();
        // ?????????????????????????????????
        List<PersonDO> personsEvaluated = personManager.getPersonsEvaluated(personIdList);
        personManager.savePersons(personsEvaluated);


    }

    @Override
    public List<PerformanceViewDO> getErrorPerformanceList(String personId) {
        String errorDataString = redisTemplate.opsForValue().get(getKey(personId, "performance"));
        List<PerformanceViewDO> errorData = (List<PerformanceViewDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    private String getKey(String personId, String key){
        return new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append(key).append(":").append(personId).toString();
    }

    private void cacheErrorData(String personId, String key,List data){
        // ?????????redis??????
        redisTemplate.delete(getKey(personId, key));
        // ?????????????????????
        redisTemplate.opsForValue().set(getKey(personId, key), JSONObject.toJSONString(data));
    }

    private Map<String, Object> doJudgePerformanceData(List<PerformanceViewDO> performanceViewDOS, List<PersonDO> allPersons) {
        // ???????????????????????????????????? ?????????key, ?????????????????????value
        Map<Integer, List<PerformanceViewDO>> performancesMap = performanceViewDOS.stream().collect(Collectors.groupingBy(PerformanceViewDO::getYear));
        Map<Integer, List<PerformanceDO>> performancesDataMap = new HashMap<>();
        performancesMap.entrySet().stream().forEach((entry) -> {
            // ???????????????????????????????????????????????????????????????????????????
            performancesDataMap.put(entry.getKey(), performanceDao.findAllByYear(entry.getKey()));
        });
        // ????????????????????????????????????key????????????value???map
        Map<String, PersonDO> persons = allPersons.stream().collect(Collectors.toMap(PersonDO::getPersonId, personDO -> personDO));

        List<PersonDO> personDOS = new ArrayList<>();
        // ?????????????????????
        List<PerformanceViewDO> needSaveData = new ArrayList<>();
        // ????????????????????????
        List<PerformanceViewDO> failedData = new ArrayList<>();

        // ?????????????????????map
        performancesMap.entrySet().stream().forEach((entry) -> {
            // ????????????
            Integer year = entry.getKey();
            // ?????????????????????????????????
            List<PerformanceViewDO> performances = entry.getValue();
            // ?????????????????????????????????????????????
            List<PerformanceDO> performanceDatas = performancesDataMap.get(year);
            performances.stream().forEach(performanceViewDO -> {
                if (!checkData(performanceViewDO,persons)) {
                    failedData.add(performanceViewDO);
                } else {
                    if (persons.get(performanceViewDO.getPersonId()).getYear() == null || persons.get(performanceViewDO.getPersonId()).getYear() <= year) {
                        // ????????????????????????
                        persons.get(performanceViewDO.getPersonId()).setEvaluationContent(performanceViewDO.getEvaluationContent());
                        // ????????????????????????
                        persons.get(performanceViewDO.getPersonId()).setEvaluationGrade(performanceViewDO.getEvaluationGrade().toUpperCase());
                        personDOS.add(persons.get(performanceViewDO.getPersonId()));
                    }
                    // ??????????????????
                    performanceViewDO.setEvaluationGrade(performanceViewDO.getEvaluationGrade().toUpperCase());
                    // ????????????
                    performanceViewDO.setDeptId(persons.get(performanceViewDO.getPersonId()).getDeptId());
                    // ??????????????????
                    performanceViewDO.setJobCategory(Integer.valueOf(persons.get(performanceViewDO.getPersonId()).getRestype()));
                    // ??????????????????
                    performanceViewDO.setFlag(1);

                    needSaveData.add(performanceViewDO);
                }

            });
        });
        // ?????????????????????DO
        List<PerformanceDO> needSaveDOS = iGenerator.convert(needSaveData, PerformanceDO.class);
        Map<String, Object> data = new HashMap<>();
        data.put("persons", personDOS); // ?????????????????????
        data.put("performances", needSaveDOS);// ?????????????????????
        data.put("failed", failedData); // ?????????????????????
        return data;
    }

    private Boolean checkData(PerformanceViewDO performanceViewDO,Map<String, PersonDO> persons){
        // ????????????????????????
        if (persons.get(performanceViewDO.getPersonId()) == null) {
            return false;
        }
        // ?????????????????????????????????
//        if (StringUtils.isNotBlank(performanceViewDO.getPersonName()) && !persons.get(performanceViewDO.getPersonId()).getPersonName().equals(performanceViewDO.getPersonName())) {
//            return false;
//        }
        // ???????????????????????????
        if (performanceViewDO.getPerformance() == null || performanceViewDO.getPerformance() < 0 || performanceViewDO.getPerformance() > 100)  {
            return false;
        }
        // ??????????????????????????????
        if (StringUtils.isBlank(performanceViewDO.getEvaluationGrade()) || (StringUtils.isNotBlank(performanceViewDO.getEvaluationGrade()) && !grade.contains(performanceViewDO.getEvaluationGrade().toUpperCase()))) {
            return false;
        }
        // ????????????????????????????????????
        if (StringUtils.isNotBlank(performanceViewDO.getEvaluationContent()) && performanceViewDO.getEvaluationContent().length() > 80) {
            performanceViewDO.setEvaluationContent(performanceViewDO.getEvaluationContent().substring(0,80));
            return true;
        }
        return true;
    }
}
