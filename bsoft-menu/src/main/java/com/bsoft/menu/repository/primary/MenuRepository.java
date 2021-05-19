package com.bsoft.menu.repository.primary;

import com.bsoft.menu.entity.primary.MenuDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/29 13:56
 * @Description
 */
@Repository
@Mapper
public interface MenuRepository {
    List<MenuDO> getAuthMenu(@Param("userId") String userId, @Param("system") Integer system);
    List<MenuDO> getMenuWithRole(@Param("userId") String userId, @Param("system") Integer system);
    List<MenuDO> getMenuWithPerson(@Param("userId") String userId, @Param("system") Integer system);
}
