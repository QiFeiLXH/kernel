package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.CostDicDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
public interface CostDicDao extends JpaRepository<CostDicDO, Integer>, JpaSpecificationExecutor<CostDicDO> {
    CostDicDO findByTypeAndId(Integer type, Integer id);
    List<CostDicDO> findByType(Integer type);
    List<CostDicDO> findByTypeAndLogout(Integer type, Integer logout);
}
