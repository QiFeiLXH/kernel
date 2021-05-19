package com.bsoft.user.dao.primary;

import com.bsoft.user.entity.primary.AppDeptCountViewDO;
import com.bsoft.user.entity.primary.AppTerminalCountViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/10/21
 * @description APP用户终端分布情况
 */
@Repository
public interface AppTerminalCountViewDao extends JpaRepository<AppTerminalCountViewDO, String>, JpaSpecificationExecutor<AppTerminalCountViewDO> {
}
