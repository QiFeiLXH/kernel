package com.bsoft.person.manager;

import com.bsoft.person.condition.BusinessCardQueryCnd;
import com.bsoft.person.entity.primary.BusinessCardDO;
import com.bsoft.person.entity.primary.BusinessCardViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BusinessCardManager {
    public BusinessCardDO getLastedCard(String personId);

    Page<BusinessCardViewDO> getBusinessCardList(BusinessCardQueryCnd cnd);

    Integer getBusinessCardUnpaidCount(BusinessCardQueryCnd cnd);

    Double getBusinessCardUnpaidAmount();

    Double getBusinessCardTotalAmount(List<Integer> businessCardIds);

    List<Integer> getBusinessCardIdList(BusinessCardQueryCnd cnd);

    List<BusinessCardViewDO> updateBusinessCardApplyPay(List<Integer> businessCardIds);

    void updateBusinessCardPay(List<Integer> businessCardIds);

    byte[] showImageByte(Integer id);
}
