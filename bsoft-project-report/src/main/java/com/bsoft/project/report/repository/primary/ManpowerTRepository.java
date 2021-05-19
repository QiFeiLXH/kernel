package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.ManpowerCostTViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/24
 * @Description:
 */
@Mapper
@Repository
public interface ManpowerTRepository {

    List<ManpowerCostTViewDO> find();
}
