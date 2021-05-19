package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.TrainLearnViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 13:52
 * @Description
 */
@Repository
public interface TrainLearnViewDao extends JpaRepository<TrainLearnViewDO, Integer>, JpaSpecificationExecutor<TrainLearnViewDO> {
}
