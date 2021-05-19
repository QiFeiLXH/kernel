package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.TrainChartViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/5 14:11
 */

@Repository
public interface TrainChartViewDao extends JpaRepository<TrainChartViewDO, Integer>, JpaSpecificationExecutor<TrainChartViewDO> {

}
