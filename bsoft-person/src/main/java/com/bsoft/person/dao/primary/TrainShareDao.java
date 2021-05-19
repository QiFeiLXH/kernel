package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.TrainShareDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 13:53
 * @Description
 */
@Repository
public interface TrainShareDao extends JpaRepository<TrainShareDO, Integer>, JpaSpecificationExecutor<TrainShareDO> {
    void deleteAllByIdIn(List<Integer> ids);
}
