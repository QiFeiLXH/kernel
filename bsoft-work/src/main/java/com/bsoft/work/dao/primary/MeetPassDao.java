package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.MeetPassDO;
import com.bsoft.work.entity.primary.MeetPersonDO;
import com.bsoft.work.key.MeetPassKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xiangqj
 * @date: 2020/12/18
 * @description 会议和人员关系表
 */
@Repository
public interface MeetPassDao extends JpaRepository<MeetPassDO, MeetPassKey>, JpaSpecificationExecutor<MeetPassKey> {

    List<MeetPassDO> findByOpenId(String openId);
}
