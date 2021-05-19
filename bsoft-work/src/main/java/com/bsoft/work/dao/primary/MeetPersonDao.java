package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.MeetDO;
import com.bsoft.work.entity.primary.MeetPersonDO;
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
public interface MeetPersonDao extends JpaRepository<MeetPersonDO, Integer>, JpaSpecificationExecutor<MeetPersonDO> {
    List<MeetPersonDO> findByMeetIdAndMobileNo(Integer meetId,String mobileNo);

    List<MeetPersonDO> findByMeetId(Integer meetId);

    List<MeetPersonDO> findByMobileNo(String mobileNO);

    @Query("select A.mobileNo from MeetUserDO A,MeetPersonDO B where A.mobileNo = B.mobileNo AND B.meetId = :id ")
    List<String> getMeetPersonMobileNo(@Param("id") Integer id);
}
