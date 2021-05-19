package com.bsoft.user.dao.primary;

import com.bsoft.user.entity.primary.AppBoundDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 9:33
 * @Description: app已绑定Dao
 */
@Repository
public interface AppBoundDao extends JpaRepository<AppBoundDO,Integer>, JpaSpecificationExecutor<AppBoundDO> {
}
