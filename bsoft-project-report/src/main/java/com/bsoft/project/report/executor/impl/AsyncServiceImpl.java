package com.bsoft.project.report.executor.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.executor.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: hy
 * @Date: 2019/12/13
 * @Description: 线程执行对比方法
 */
@Component
public class AsyncServiceImpl implements AsyncService {

    @Async("asyncServiceExecutor")
    @Override
    public ListenableFuture<List<ManpowerCostPDO>> manpowerCostPAsync(List<ManpowerCostPDO> oldList, List<ManpowerCostPViewDO> newList) {
        List<ManpowerCostPDO> pdoList = new ArrayList<>();
        Map<String,Object> oldMap = oldList.stream().collect(Collectors.toMap(manpowerCostPDO -> manpowerCostPDO.getProjectId() + manpowerCostPDO.getMonth() + manpowerCostPDO.getDepType() + manpowerCostPDO.getpGrade(), manpowerCostPDO->manpowerCostPDO));

        Map<String,Object> newMap = newList.stream().collect(Collectors.toMap(manpowerCostPViewDO -> manpowerCostPViewDO.getProjectId() + LocalDate.ofInstant(manpowerCostPViewDO.getMonth().toInstant(), ZoneId.systemDefault()) + manpowerCostPViewDO.getDepType() + manpowerCostPViewDO.getpGrade(), manpowerCostPViewDO->manpowerCostPViewDO));

        newMap.forEach((key,value) -> {
            ManpowerCostPViewDO manpowerCostPViewDO = (ManpowerCostPViewDO) value;
            if(oldMap.containsKey(key)){
                ManpowerCostPDO manpowerCostPDO = (ManpowerCostPDO) oldMap.get(key);
                int a = manpowerCostPDO.getWorkload().compareTo(manpowerCostPViewDO.getWorkload());
                int b = manpowerCostPDO.getAmount().compareTo(manpowerCostPViewDO.getAmount());
                if(Math.abs(a)+Math.abs(b) > 0){
                    manpowerCostPDO.setWorkload(manpowerCostPViewDO.getWorkload());
                    manpowerCostPDO.setAmount(manpowerCostPViewDO.getAmount());
                    pdoList.add(manpowerCostPDO);
                }
            }else{
                ManpowerCostPDO manpowerCostPDO = GeneratorUtil.instance().convert(manpowerCostPViewDO,ManpowerCostPDO.class);
                pdoList.add(manpowerCostPDO);
            }

        });
        return new AsyncResult<>(pdoList);
    }

    @Async("asyncServiceExecutor")
    @Override
    public ListenableFuture<List<ManpowerCostTDO>> manpowerCostTAsync(List<ManpowerCostTDO> oldList, List<ManpowerCostTViewDO> newList) {
        List<ManpowerCostTDO> pdoList = new ArrayList<>();
        Map<String,Object> oldMap = oldList.stream().collect(Collectors.toMap(manpowerCostTDO -> manpowerCostTDO.getProjectId() + manpowerCostTDO.getMonth() + manpowerCostTDO.getDepType() + manpowerCostTDO.gettGrade(), manpowerCostTDO->manpowerCostTDO));
        Map<String,Object> newMap = newList.stream().collect(Collectors.toMap(manpowerCostTViewDO -> manpowerCostTViewDO.getProjectId() + LocalDate.ofInstant(manpowerCostTViewDO.getMonth().toInstant(), ZoneId.systemDefault()) + manpowerCostTViewDO.getDepType() + manpowerCostTViewDO.gettGrade(), manpowerCostTViewDO->manpowerCostTViewDO));

        newMap.forEach((key,value)->{
            ManpowerCostTViewDO manpowerCostTViewDO = (ManpowerCostTViewDO) value;
            if(oldMap.containsKey(key)){
                ManpowerCostTDO manpowerCostTDO = (ManpowerCostTDO) oldMap.get(key);
                int a = manpowerCostTDO.getWorkload().compareTo(manpowerCostTViewDO.getWorkload());
                int b = manpowerCostTDO.getAmount().compareTo(manpowerCostTViewDO.getAmount());
                if(Math.abs(a)+Math.abs(b) > 0){
                    manpowerCostTDO.setWorkload(manpowerCostTViewDO.getWorkload());
                    manpowerCostTDO.setAmount(manpowerCostTViewDO.getAmount());
                    pdoList.add(manpowerCostTDO);
                }
            }else{
                ManpowerCostTDO manpowerCostTDO = GeneratorUtil.instance().convert(manpowerCostTViewDO,ManpowerCostTDO.class);
                pdoList.add(manpowerCostTDO);
            }
        });

        return new AsyncResult<>(pdoList);
    }

    @Async("asyncServiceExecutor")
    @Override
    public ListenableFuture<List<ReimbursementBonusDO>> reimbursementBonusAsync(List<ReimbursementBonusDO> oldList, List<ReimbursementBonusViewDO> newList) {
        List<ReimbursementBonusDO> pdoList = new ArrayList<>();
        Map<String,Object> oldMap = oldList.stream().collect(Collectors.toMap(reimbursementBonusDO -> reimbursementBonusDO.getProjectId() + reimbursementBonusDO.getMonth() + reimbursementBonusDO.getDepType() + reimbursementBonusDO.getCostSubject(), reimbursementBonusDO->reimbursementBonusDO));
        Map<String,Object> newMap = newList.stream().collect(Collectors.toMap(reimbursementBonusViewDO -> reimbursementBonusViewDO.getProjectId() + LocalDate.ofInstant(reimbursementBonusViewDO.getMonth().toInstant(), ZoneId.systemDefault()) + reimbursementBonusViewDO.getDepType() + reimbursementBonusViewDO.getCostSubject(), reimbursementBonusViewDO->reimbursementBonusViewDO));

        newMap.forEach((key,value)->{
            ReimbursementBonusViewDO reimbursementBonusViewDO = (ReimbursementBonusViewDO) value;
            if(oldMap.containsKey(key)){
                ReimbursementBonusDO reimbursementBonusDO = (ReimbursementBonusDO) oldMap.get(key);
                int a = reimbursementBonusDO.getAmount().compareTo(reimbursementBonusViewDO.getAmount());
                if(Math.abs(a) > 0){
                    reimbursementBonusDO.setAmount(reimbursementBonusViewDO.getAmount());
                    pdoList.add(reimbursementBonusDO);
                }
            }else{
                ReimbursementBonusDO reimbursementBonusDO = GeneratorUtil.instance().convert(reimbursementBonusViewDO,ReimbursementBonusDO.class);
                pdoList.add(reimbursementBonusDO);
            }

        });

        return new AsyncResult<>(pdoList);
    }

}
