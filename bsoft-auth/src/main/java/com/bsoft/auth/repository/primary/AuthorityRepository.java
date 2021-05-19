package com.bsoft.auth.repository.primary;

import com.bsoft.auth.condition.AuthorityQueryCnd;
import com.bsoft.auth.entity.primary.AuthorityDO;
import com.bsoft.auth.entity.primary.AuthorityPersonDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AuthorityRepository {

    List<AuthorityPersonDO> getPermissionalPersonList(@Param("menuAuths") List<AuthorityQueryCnd> menuAuths, @Param("count") Integer count);

    Integer checkAllPermission(@Param("personId") String personId, @Param("menuId") Integer menuId, @Param("key") Integer key);

    Integer checkPrivateMenuPermission(@Param("personId") String personId, @Param("menuId") Integer menuId);

    Integer checkPrivateMenuPermissionWithPrefix(@Param("personId") String personId, @Param("menuPrefix") String menuPrefix);

    List<AuthorityDO> getAuthorityByPersonIdAndSystem(@Param("personId") String personId, @Param("system") Integer system);
}
