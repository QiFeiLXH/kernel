package com.bsoft.user.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.person.entity.primary.AdministrativeAreaDO;
import com.bsoft.person.manager.DivisionManager;
import com.bsoft.user.condition.AppBindCountQueryCnd;
import com.bsoft.user.condition.AppDeptCountQueryCnd;
import com.bsoft.user.dao.primary.AppBoundDao;
import com.bsoft.user.dao.primary.AppDeptCountViewDao;
import com.bsoft.user.dao.primary.AppTerminalCountViewDao;
import com.bsoft.user.dao.primary.PersonContactDao;
import com.bsoft.user.entity.primary.*;
import com.bsoft.user.manager.AppUserCountManager;
import com.bsoft.user.repository.primary.AppBindCountRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户部门分布情况
 */
@Component
public class AppUserCountManagerImpl implements AppUserCountManager {

    @Autowired
    private AppDeptCountViewDao appDeptCountViewDao;
    @Autowired
    private PersonContactDao personContactDao;
    @Autowired
    private AppTerminalCountViewDao appTerminalCountViewDao;
    @Autowired
    private AppBindCountRepository appBindCountRepository;
    @Autowired
    private DivisionManager divisionManager;
    @Autowired
    private AppBoundDao appBoundDao;

    @Override
    public Result<AppDeptCountViewDO> getDeptCountList(AppDeptCountQueryCnd queryCnd) {
        Sort sort = Sort.by("deptType").ascending().and(Sort.by("sortBy").ascending());
        Pageable pageable = PageRequest.of(queryCnd.getPageNo() - 1 , queryCnd.getPageSize(), sort);
        Page<AppDeptCountViewDO> page = appDeptCountViewDao.findAll(new Specification<AppDeptCountViewDO>() {
            @Override
            public Predicate toPredicate(Root<AppDeptCountViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (queryCnd.getDeptType()!=null && !queryCnd.getDeptType().equals(0)){
                    predicates.add(criteriaBuilder.equal(root.get("deptType"), queryCnd.getDeptType()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        Result<AppDeptCountViewDO> result = ResultUtils.parseResult(page, AppDeptCountViewDO.class);


        return result;
    }

    @Override
    public List<AppProvinceCountDO> getProvinceCountList() {
        List<AppBoundDO> personContactDOList = appBoundDao.findAll(new Specification<AppBoundDO>() {
            @Override
            public Predicate toPredicate(Root<AppBoundDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.isNotNull(root.get("appbindDate")));
                predicates.add(criteriaBuilder.equal(root.get("logoff"),0));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });

        // 获取省份列表
        List<AdministrativeAreaDO> administrativeAreaDOList = divisionManager.getAdministrativeArea(1, 0);
        Map<String, Integer> provinceMap = new HashMap<>();
        administrativeAreaDOList.forEach(item ->{
            provinceMap.put(item.getName(), 0);
        });
        if(!provinceMap.containsKey("台湾省")) {
            provinceMap.put("台湾省", 0);
        }
        provinceMap.put("未知",0);

        // 统计各省数量
        personContactDOList.forEach(item -> {
            String appRegistPlace = item.getAppRegistPlace();
            String province = "未知";
            if (StringUtils.isNotBlank(appRegistPlace) && appRegistPlace.indexOf(",") > 0) { // 地址不为空且格式正确（浙江省,杭州市,滨江区）
                province = appRegistPlace.substring(0, appRegistPlace.indexOf(","));
            }
            Integer count = provinceMap.get(province);
            count += 1;
            provinceMap.put(province, count);
        });

        List<AppProvinceCountDO> result = provinceMap.entrySet().stream()
                .map(e -> new AppProvinceCountDO(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        List<AppProvinceCountDO> sortedResult = result.stream()
                .sorted(Comparator.comparing(AppProvinceCountDO::getUserCount).reversed())
                .collect(Collectors.toList());
        return sortedResult;
    }

    @Override
    public List<AppTerminalCountViewDO> getTerminalCountList() {
        List<AppTerminalCountViewDO> result = appTerminalCountViewDao.findAll();
        List<AppTerminalCountViewDO> sortedResult = result.stream()
                .sorted(Comparator.comparing(AppTerminalCountViewDO::getUserCount).reversed())
                .collect(Collectors.toList());
        return sortedResult;
    }

    @Override
    public List<AppBindCountDO> getBindCountList(AppBindCountQueryCnd queryCnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr = sdf.format(queryCnd.getStartDate());
        String endDateStr = sdf.format(queryCnd.getEndDate());
        List<AppBindCountDO> result =  appBindCountRepository.getBindCountList(startDateStr, endDateStr);
        return result;
    }

    @Override
    public Result<AppBindCountDO> getBindCountListWithPage(AppBindCountQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr = sdf.format(queryCnd.getStartDate());
        String endDateStr = sdf.format(queryCnd.getEndDate());
        List<AppBindCountDO> appBindCountDOList = appBindCountRepository.getBindCountList(startDateStr, endDateStr);
        PageInfo<AppBindCountDO> pageInfo = new PageInfo<>(appBindCountDOList);
        return ResultUtils.parseResult(pageInfo, AppBindCountDO.class);
    }

    @Override
    public Integer getBindTotalCount() {
        return appBindCountRepository.getTotalBindCount();
    }

    @Override
    public Integer getTotalCount(AppDeptCountQueryCnd cnd) {
        Integer total;
        if (cnd.getDeptType()!=null && !cnd.getDeptType().equals(0)){
            Integer deptType = cnd.getDeptType();
            total = appBindCountRepository.getTotalCountByDeptType(deptType);
        }else{
            total = appBindCountRepository.getTotalCount();
        }

        return total;
    }

    @Override
    public AppBoundProportionDO getBoundProportion(AppDeptCountQueryCnd cnd) {
        Integer total;
        Integer totalBound;
        AppBoundProportionDO appBoundProportio = new AppBoundProportionDO();
        if (cnd.getDeptType()!=null && !cnd.getDeptType().equals(0)){
            Integer deptType = cnd.getDeptType();
            total = appBindCountRepository.getTotalCountByDeptType(deptType);
            totalBound = appBindCountRepository.getTotalBindCountByDeptType(deptType);
        }else{
            total = appBindCountRepository.getTotalCount();
            totalBound = appBindCountRepository.getTotalBindCount();
        }

        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String proportion = numberFormat.format((float)totalBound/(float)total*100);
        appBoundProportio.setPersonCount(total);
        appBoundProportio.setBoundCount(totalBound);
        if(total.equals(0)){
            appBoundProportio.setProportion("0");
        }
        appBoundProportio.setProportion(proportion);
        return appBoundProportio;
    }
}
