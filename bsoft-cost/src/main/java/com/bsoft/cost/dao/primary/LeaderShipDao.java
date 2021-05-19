package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.LeaderShipDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-09 18:35
 * @Version 1.0
 * @Description
 */
@Repository
public interface LeaderShipDao extends JpaRepository<LeaderShipDO,Integer>, JpaSpecificationExecutor<LeaderShipDO> {
    List<LeaderShipDO> findByFlag(Integer flag);
}
