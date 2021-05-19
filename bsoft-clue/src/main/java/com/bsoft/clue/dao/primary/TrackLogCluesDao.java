package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.TrackLogCluesDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/7/26 12:47
 * @Description: 销售线索跟单日志
 */
@Repository
public interface TrackLogCluesDao extends JpaRepository<TrackLogCluesDO,Integer>, JpaSpecificationExecutor<TrackLogCluesDO> {
}
