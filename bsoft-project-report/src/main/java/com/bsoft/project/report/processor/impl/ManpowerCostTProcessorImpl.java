package com.bsoft.project.report.processor.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.entity.primary.ManpowerCostTDO;
import com.bsoft.project.report.entity.primary.ManpowerCostTViewDO;
import com.bsoft.project.report.executor.AsyncService;
import com.bsoft.project.report.manager.ManpowerCostTManager;
import com.bsoft.project.report.manager.ManpowerCostTViewManager;
import com.bsoft.project.report.processor.ManpowerCostTProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Auther: hy
 * @Date: 2019/12/11
 * @Description:
 */
@Component
@Scope("prototype")
public class ManpowerCostTProcessorImpl implements ManpowerCostTProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManpowerCostTProcessorImpl.class);

    @Autowired
    private ManpowerCostTViewManager manpowerCostTViewManager;

    @Autowired
    private ManpowerCostTManager manpowerCostTManager;

    @Autowired
    private AsyncService asyncService;

    private List<ManpowerCostTDO> list = new ArrayList<>();
    private List<ListenableFuture<List<ManpowerCostTDO>>> listenableFuture = new ArrayList<>();

    @Override
    public void saveOrUpdateData() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        try{
            for (ListenableFuture<List<ManpowerCostTDO>> listListenableFuture : listenableFuture) {
                list.addAll(listListenableFuture.get());
            }
            TimeConsumer timeConsumer1 = TimeConsumer.start();
            manpowerCostTManager.saveAll(list);
            LOGGER.info("人力成本T数据保存用时：{}",timeConsumer1.end());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        LOGGER.info("人力成本T处理保存用时：{}",timeConsumer.end());
    }

    @Override
    public void process() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ManpowerCostTDO> oldList = manpowerCostTManager.findLastYearData();
        List<ManpowerCostTViewDO> newList = manpowerCostTViewManager.findLastYearData();
        int size = newList.size()/4;
        for(int i = 0; i< 4 ; i++){
            if(i == 3){
                listenableFuture.add(asyncService.manpowerCostTAsync(oldList,newList.subList(i*size,newList.size())));
            }else{
                listenableFuture.add(asyncService.manpowerCostTAsync(oldList,newList.subList(i*size,(i+1)*size)));
            }
        }
        LOGGER.info("人力成本T查询处理用时：{}",timeConsumer.end());
    }
}
