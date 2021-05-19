package com.bsoft.person.service;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.person.dto.BusinessCardDTO;
import com.bsoft.person.dto.BusinessCardQueryCndDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 15:38
 * @Description
 */
public interface BusinessCardService {
    /**
     * 名片查询
     * @param cndDTO 查询条件
     */
    Result<BusinessCardDTO> getBusinessCardList(BusinessCardQueryCndDTO cndDTO);

    /**
     * 未支付数量查询
     * @param cndDTO 查询条件
     */
    Integer getBusinessCardUnpaidCount(BusinessCardQueryCndDTO cndDTO);

    /**
     * 未支付金额
     * @param
     */
    Double getBusinessCardUnpaidAmount();

    /**
     * 总金额
     * @param
     */
    Double getBusinessCardTotalAmount(List<Integer> businessCardIds);

    /**
     * 指定条件下的明片id
     * @param
     */
    List<Integer> getBusinessCardIdList(BusinessCardQueryCndDTO cndDTO);

    /**
     * 名片申请支付
     */
    List<BusinessCardDTO> updateBusinessCardApplyPay(List<Integer> businessCardIds);

    /**
     * 名片支付
     */
    void updateBusinessCardPay(List<Integer> businessCardIds);


    FileServerDefinitionDTO showImageByte(Integer id);

}
