package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.MeetUserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xiangqj
 * @date: 2020/12/18
 * @description 参会证
 */
@Repository
public interface MeetUserDao extends JpaRepository<MeetUserDO, String>, JpaSpecificationExecutor<MeetUserDO> {
    List<MeetUserDO> findByOpenId(String openId);
}
