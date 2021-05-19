package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProProjectExpandSyncViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/27 14:34
 * @Description
 */
@Repository
public interface ProProjectExpandSyncViewDao extends JpaRepository<ProProjectExpandSyncViewDO,String>, JpaSpecificationExecutor<ProProjectExpandSyncViewDO> {
}
