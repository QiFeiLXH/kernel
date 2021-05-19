package com.bsoft.project.report.processor.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.entity.primary.ReimbursementBonusDO;
import com.bsoft.project.report.entity.primary.ReimbursementBonusViewDO;
import com.bsoft.project.report.executor.AsyncService;
import com.bsoft.project.report.manager.ReimbursementBonusManager;
import com.bsoft.project.report.manager.ReimbursementBonusViewManager;
import com.bsoft.project.report.processor.ReimbursementBonusProcessor;
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
 * @Date: 2019/12/12
 * @Description:
 */
@Component
@Scope("prototype")
public class ReimbursementBonusProcessorImpl implements ReimbursementBonusProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReimbursementBonusProcessorImpl.class);

    @Autowired
    private ReimbursementBonusViewManager reimbursementBonusViewManager;

    @Autowired
    private ReimbursementBonusManager reimbursementBonusManager;

    @Autowired
    private AsyncService asyncService;

    private List<ReimbursementBonusDO> list = new ArrayList<>();
    private List<ListenableFuture<List<ReimbursementBonusDO>>> listenableFuture = new ArrayList<>();

    @Override
    public void saveOrUpdateData() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        try{
            for (ListenableFuture<List<ReimbursementBonusDO>> listListenableFuture : listenableFuture) {
                list.addAll(listListenableFuture.get());
            }
            TimeConsumer timeConsumer1 = TimeConsumer.start();
            reimbursementBonusManager.saveAll(list);
            LOGGER.info("报销奖金数据保存用时：{}",timeConsumer1.end());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        LOGGER.info("报销奖金处理用时：{}",timeConsumer.end());
    }

    @Override
    public void process() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ReimbursementBonusDO> oldList = reimbursementBonusManager.findLastYearData();
        List<ReimbursementBonusViewDO> newList = reimbursementBonusViewManager.findLastYearData();
        int size = newList.size()/4;
        for(int i = 0; i< 4 ; i++){
            if(i == 3){
                listenableFuture.add(asyncService.reimbursementBonusAsync(oldList,newList.subList(i*size,newList.size())));
            }else{
                listenableFuture.add(asyncService.reimbursementBonusAsync(oldList,newList.subList(i*size,(i+1)*size)));
            }
        }
        LOGGER.info("报销奖金查询处理用时：{}",timeConsumer.end());
    }
}
