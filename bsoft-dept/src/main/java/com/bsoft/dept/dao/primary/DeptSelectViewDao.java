package com.bsoft.dept.dao.primary;

import com.bsoft.dept.entity.primary.DeptSelectViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 11:00
 * @Description:
 */
@Repository
public interface DeptSelectViewDao extends JpaRepository<DeptSelectViewDO,String>, JpaSpecificationExecutor<DeptSelectViewDO> {
}
