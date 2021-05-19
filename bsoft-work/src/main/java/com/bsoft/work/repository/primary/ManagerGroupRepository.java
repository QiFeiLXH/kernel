package com.bsoft.work.repository.primary;


import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.ManagerGroupDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/10 10:53
 */
@Mapper
public interface ManagerGroupRepository {
    /**
     * 按照类型查询
     * @param queryCnd
     * @return
     */
    List<ManagerGroupDO> findAllByCnd(@Param("queryCnd") PolicyQueryCnd queryCnd);

    /**
     * 委员会组维护页面查询
     */
    List<ManagerGroupDO> findList(@Param("councilName") String councilName,@Param("isCancel") Integer isCancel);
}
