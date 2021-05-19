package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.SubsidyStandardViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/19 17:27
 * @Description:
 */
@Repository
public interface SubsidyStandardViewDao extends JpaRepository<SubsidyStandardViewDO,Integer>, JpaSpecificationExecutor<SubsidyStandardViewDO> {

    List<SubsidyStandardViewDO> findAllByPersonIdAndStateAndFlagAndIdNot(String personId,Integer state,Integer flag,Integer id);

    List<SubsidyStandardViewDO> findAllByProjectIdAndStateAndFlagAndIdNot(String projectId,Integer state,Integer flag,Integer id);

    List<SubsidyStandardViewDO> findAllByCountyAndStateAndFlagAndIdNot(String county,Integer state,Integer flag,Integer id);

}
