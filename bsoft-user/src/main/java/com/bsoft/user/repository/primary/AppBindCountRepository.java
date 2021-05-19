package com.bsoft.user.repository.primary;

import com.bsoft.user.condition.AppBindCountQueryCnd;
import com.bsoft.user.entity.primary.AppBindCountDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/21
 * @description APP用户绑定（解绑）情况统计
 */
@Repository
public interface AppBindCountRepository {
    List<AppBindCountDO> getBindCountList(@Param("startDateStr") String startDateStr, @Param("endDateStr") String endDateStr);
    Integer getTotalBindCount();
    Integer getTotalBindCountByDeptType(@Param("deptType")Integer deptType);
    Integer getTotalCount();
    Integer getTotalCountByDeptType(@Param("deptType")Integer deptType);

}
