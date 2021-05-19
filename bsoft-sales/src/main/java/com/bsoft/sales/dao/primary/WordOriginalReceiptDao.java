package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.WordOriginalReceiptDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/7/30 10:11
 * @Description: 合同原件接收记录
 */
@Repository
public interface WordOriginalReceiptDao extends JpaRepository<WordOriginalReceiptDO,Integer>, JpaSpecificationExecutor<WordOriginalReceiptDO> {
}
