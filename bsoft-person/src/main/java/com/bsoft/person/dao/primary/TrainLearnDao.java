package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.TrainLearnDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 13:52
 * @Description
 */
@Repository
public interface TrainLearnDao extends JpaRepository<TrainLearnDO, Integer>, JpaSpecificationExecutor<TrainLearnDO> {
    void deleteAllByIdIn(List<Integer> ids);
}
