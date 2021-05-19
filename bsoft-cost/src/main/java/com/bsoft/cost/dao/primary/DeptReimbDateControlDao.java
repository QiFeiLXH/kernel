package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.DeptReimbDateControlDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:03
 * @Description:
 */
@Repository
public interface DeptReimbDateControlDao extends JpaRepository<DeptReimbDateControlDO,Integer>, JpaSpecificationExecutor<DeptReimbDateControlDO> {
    List<DeptReimbDateControlDO> findAllByDeptIdAndControlYear(String deptId,Integer controlYear);
}
