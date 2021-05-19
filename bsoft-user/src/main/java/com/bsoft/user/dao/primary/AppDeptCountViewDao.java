package com.bsoft.user.dao.primary;

import com.bsoft.user.entity.primary.AppDeptCountViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户部门分布情况
 */
@Repository
public interface AppDeptCountViewDao extends JpaRepository<AppDeptCountViewDO, String>, JpaSpecificationExecutor<AppDeptCountViewDO> {

}
