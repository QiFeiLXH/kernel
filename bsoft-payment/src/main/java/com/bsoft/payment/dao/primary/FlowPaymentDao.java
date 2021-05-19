package com.bsoft.payment.dao.primary;

import com.bsoft.payment.entity.primary.FlowPaymentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.payment.dao.primary
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:28
 * @Description:
 */
@Repository
public interface FlowPaymentDao extends JpaRepository<FlowPaymentDO, Integer>, JpaSpecificationExecutor<FlowPaymentDO> {
    void deleteAllByIdIn(List<Integer> ids);
}
