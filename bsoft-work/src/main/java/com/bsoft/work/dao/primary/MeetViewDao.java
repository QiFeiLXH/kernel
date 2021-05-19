package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.MeetDO;
import com.bsoft.work.entity.primary.MeetViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zhanglf
 * @date: 2020/12/22
 * @description 会议视图
 */
@Repository
public interface MeetViewDao extends JpaRepository<MeetViewDO, Integer>, JpaSpecificationExecutor<MeetViewDO> {

}
