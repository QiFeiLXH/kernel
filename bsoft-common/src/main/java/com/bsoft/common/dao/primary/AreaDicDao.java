package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.AreaDicDO;
import com.bsoft.common.entity.primary.HumanDicDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaDicDao extends JpaRepository<AreaDicDO,Integer>, JpaSpecificationExecutor<AreaDicDO> {

    public List<AreaDicDO> findByCancelFlagAndLevel(Integer cancelFlag,Integer level);
}
