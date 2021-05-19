package com.bsoft.project.report.processor.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.entity.primary.ManpowerCostPDO;
import com.bsoft.project.report.entity.primary.ManpowerCostPViewDO;
import com.bsoft.project.report.executor.AsyncService;
import com.bsoft.project.report.manager.ManpowerCostPManager;
import com.bsoft.project.report.manager.ManpowerCostPViewManager;
import com.bsoft.project.report.processor.ManpowerCostPProcessor;
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
public class ManpowerCostPProcessorImpl implements ManpowerCostPProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManpowerCostPProcessorImpl.class);

    @Autowired
    private ManpowerCostPViewManager manpowerCostPViewManager;

    @Autowired
    private ManpowerCostPManager manpowerCostPManager;

    @Autowired
    private AsyncService asyncService;

    private List<ManpowerCostPDO> list = new ArrayList<>();
    private List<ListenableFuture<List<ManpowerCostPDO>>> listenableFuture = new ArrayList<>();

    @Override
    public void saveOrUpdateData() {
        TimeConsumer consumer = TimeConsumer.start();
        try {
            for (ListenableFuture<List<ManpowerCostPDO>> listListenableFuture : listenableFuture) {
                list.addAll(listListenableFuture.get());
            }
            TimeConsumer consumer1 = TimeConsumer.start();
            manpowerCostPManager.saveAll(list);
            LOGGER.info("人力成本P保存数据用时：{}",consumer1.end());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        LOGGER.info("人力成本P保存总体用时：{}",consumer.end());
    }

    @Override
    public void process() {
        TimeConsumer consumer = TimeConsumer.start();
        List<ManpowerCostPDO> oldList = manpowerCostPManager.findLastYearData();
        List<ManpowerCostPViewDO> newList = manpowerCostPViewManager.findLastYearData();
        int size = newList.size() / 4;
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                listenableFuture.add(asyncService.manpowerCostPAsync(oldList, newList.subList(i * size, newList.size())));
            } else {
                listenableFuture.add(asyncService.manpowerCostPAsync(oldList, newList.subList(i * size, (i + 1) * size)));
            }
        }
        LOGGER.info("人力成本P查询处理用时：{}",consumer.end());
    }
}
