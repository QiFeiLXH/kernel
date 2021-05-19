package com.bsoft.sales.service;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.sales.dto.*;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 13:09
 * @Description 合作协议
 */
public interface CoopertaionAgreementService {
    /** 合作协议-合作单位列表
     * @Param: inputContent 查找条件
     * @Param: pageNo 页码
     * @Param: pageSize 每页条数
     * @return com.bsoft.common.result.Result<SalesPartnerViewDTO>
     * @author Xuhui Lin
     */
    Result<SalesPartnerViewDTO> getSalesPartnerList(String inputContent, Integer pageNo, Integer pageSize);

    /** 合作协议-保存合作单位
     * @Param: salesPartnerDTO 合作单位
     * @Param: provinceText 省
     * @Param: cityText 市
     * @Param: countyText 县
     * @return Integer 合作单位id
     * @author Xuhui Lin
     */
    Integer saveSalesPartner(SalesPartnerDTO salesPartnerDTO,String provinceText, String cityText, String countyText);

    /** 合作协议-删除合作单位
     * @Param: id 合作单位id
     * @author Xuhui Lin
     */
    void deleteSalesPartner(Integer id);

    /** 合作协议-合作单位列表
     * @Param: salesAgreementQueryCndDTO 查找条件
     * @return com.bsoft.common.result.Result<SalesAgreementViewDTO>
     * @author Xuhui Lin
     */
    Result<SalesAgreementViewDTO> getSalesAgreementList(SalesAgreementQueryCndDTO salesAgreementQueryCndDTO);

    /** 合作协议-保存合作单位
     * @Param: salesAgreementQueryCndDTO 合作协议
     * @Param: personId 员工id
     * @return SalesAgreementDTO
     * @author Xuhui Lin
     */
    SalesAgreementDTO saveSalesAgreement(SalesAgreementDTO salesAgreementDTO, String personId);

    /** 合作协议-删除合作协议
     * @Param: id 合作协议id
     * @author Xuhui Lin
     */
    void deleteSalesAgreement(Integer id);

    /** 合作协议-查找合作单位列表
     * @Param: partnerName 合作单位名称或拼音
     * @return List<SalesPartnerViewDTO>
     * @author Xuhui Lin
     */
    List<SalesPartnerViewDTO> getSalesPartnerList(String partnerName);

    /** 合作协议-获取可上传文件类型
     * @return List<PublicDicDTO>
     * @author Xuhui Lin
     */
    List<PublicDicDTO> getFileUploadType();
}
