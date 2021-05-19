package com.bsoft.system.dao.primary;

import com.bsoft.system.entity.primary.TimeTaskDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanglf
 * @Date 2020-06-29 10:36
 * @Version 1.0
 * @Description
 */
@Repository
public interface TimeTaskDao extends JpaRepository<TimeTaskDO,Integer>, JpaSpecificationExecutor<TimeTaskDO> {

}
