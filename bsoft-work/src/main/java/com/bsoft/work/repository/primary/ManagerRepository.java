package com.bsoft.work.repository.primary;

import com.bsoft.work.entity.primary.ManagerDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ding cj
 * @date 2021/5/13 20:23
 */
@Mapper
@Repository
public interface ManagerRepository {
    /**
     * 成员维护页面查询
     */
    List<ManagerDO> findList(@Param("personName") String personName, @Param("councilId") Integer councilId);
}
