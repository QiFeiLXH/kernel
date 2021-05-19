package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.ApiUserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ApiUserDao extends JpaRepository<ApiUserDO,Integer>, JpaSpecificationExecutor<ApiUserDO> {

}
