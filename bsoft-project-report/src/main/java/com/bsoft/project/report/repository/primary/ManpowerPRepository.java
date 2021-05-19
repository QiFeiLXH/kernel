package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.ManpowerCostPViewDO;
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
public interface ManpowerPRepository {

    List<ManpowerCostPViewDO> find();
}
