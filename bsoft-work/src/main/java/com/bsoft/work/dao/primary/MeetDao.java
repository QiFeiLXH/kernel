package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.MeetDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: xiangqj
 * @date: 2020/12/18
 * @description 会议表
 */
@Repository
public interface MeetDao extends JpaRepository<MeetDO, Integer>, JpaSpecificationExecutor<MeetDO> {

}
