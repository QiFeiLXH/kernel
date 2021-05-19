package com.bsoft.house.repository.primary;

import com.bsoft.house.entity.primary.HouseViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author  hy
 * @date  2020/4/16 12:22
 * @description
 */
@Mapper
@Repository
public interface HouseRepository {
    List<HouseViewDO> searchHouseWithCommon(@Param("area")String area,@Param("userId")String userId,@Param("context")String context);
}
