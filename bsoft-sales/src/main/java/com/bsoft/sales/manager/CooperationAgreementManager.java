package com.bsoft.sales.manager;

import com.bsoft.sales.condition.SalesAgreementQueryCnd;
import com.bsoft.sales.entity.primary.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 13:16
 * @Description
 */
public interface CooperationAgreementManager {
    Page<SalesPartnerViewDO> getSalesPartnerList(String inputContent, Integer pageNo, Integer pageSize);

    Integer saveSalesPartner(SalesPartnerDO salesPartner,String provinceText, String cityText, String countyText);

    Integer updateSalesPartner(SalesPartnerUpdateDO salesPartner,String provinceText, String cityText, String countyText);

    void deleteSalesPartner(Integer id);

    Page<SalesAgreementViewDO> getSalesAgreementList(SalesAgreementQueryCnd cnds);

    void deleteSalesAgreement(Integer id);

    List<SalesPartnerViewDO> getSalesPartnerList(String partnerName);

    SalesAgreementDO saveSalesAgreement(SalesAgreementDO salesAgreementDO, String personId);

    SalesAgreementUpdateDO updateSalesAgreement(SalesAgreementUpdateDO salesAgreementUpdateDO, String personId);

}
