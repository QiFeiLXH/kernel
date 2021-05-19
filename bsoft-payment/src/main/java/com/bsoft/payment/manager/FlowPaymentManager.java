package com.bsoft.payment.manager;

import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.payment.condition.FlowPaymentQueryCnd;
import com.bsoft.payment.entity.primary.FlowPaymentDO;
import com.bsoft.payment.entity.primary.FlowPaymentViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.payment.manager
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:26
 * @Description:
 */
public interface FlowPaymentManager {
    Page<FlowPaymentViewDO> getFinancialPaymentList(FlowPaymentQueryCnd cnd);

    void deleteFinancialPayments(List<Integer> ids);

    void auditFinancialPayments(List<FlowPaymentDO> flowPaymentDOS, String personId);

    ImportResultDO saveFinancialPayments(List<FlowPaymentViewDO> savesData, List<FlowPaymentViewDO> errorData, String personId, Integer flag);

    List<FlowPaymentViewDO> getErrorFinancialPayments(String personId, Integer flag);
}
