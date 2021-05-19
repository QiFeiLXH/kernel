package com.bsoft.auth.repository.primary;

import com.bsoft.auth.entity.primary.RoleMaintainBaseDO;
import com.bsoft.auth.entity.primary.RoleNameDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleMaintainRepository {

    List<RoleMaintainBaseDO> selectRoleMaintainBaseDO(@Param("dept") String dept);

    List<RoleMaintainBaseDO> getRoleMaintains(@Param("dept") String dept);

    List<Map<String,Object>> selectDeptRoles(List<RoleNameDO> list);
}
