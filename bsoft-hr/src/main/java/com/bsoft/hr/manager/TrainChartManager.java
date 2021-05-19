package com.bsoft.hr.manager;

import com.bsoft.hr.condition.TrainChartViewCnd;
import com.bsoft.hr.entity.primary.TrainChartViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/5 13:31
 */
public interface TrainChartManager {

    Page<TrainChartViewDO> getTrainChartList(TrainChartViewCnd cnd);
}
