package com.bsoft.hr.repository.primary;

import com.bsoft.hr.condition.WorkCardQueryCnd;
import com.bsoft.hr.entity.primary.WorkCardDateCountViewDO;
import com.bsoft.hr.entity.primary.WorkCardViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 10:45
 * @Description
 */
@Mapper
@Repository
public interface WorkCardRepository {
    List<WorkCardDateCountViewDO> getDateCountList();

    List<WorkCardViewDO> getWorkCardList(@Param("cnd") WorkCardQueryCnd cnd);

    Map<String, Object> getCurrentMonthAllAndLeftDays(@Param("startDate") Date startDate);

    Integer getWorkCardVerifyCount(@Param("cnd")WorkCardQueryCnd cnd);

    Integer getWorkCardReceiveCount(@Param("cnd")WorkCardQueryCnd cnd);

    Integer getWorkCardMakeCount(@Param("cnd")WorkCardQueryCnd cnd);

    Integer getWorkCardOpenAccessCount(@Param("cnd")WorkCardQueryCnd cnd);
}
