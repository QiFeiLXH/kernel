package com.bsoft.common.service;

import com.bsoft.common.dto.CompanyViewDTO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/26 10:50
 * @Description:
 */
public interface CompanyService {

    Integer saveCompany(CompanyViewDTO companyViewDTO);

    List<CompanyViewDTO> getAllCompany();

    CompanyViewDTO getCompanyById(Integer id);

    /**
     * 1 费用归属，2 社保缴纳地，3 人员归属公司
     * @param type
     * @return
     */
    List<CompanyViewDTO> getCompanyDic(Integer type);

    /**
     * 1 费用归属，2 社保缴纳地，3 人员归属公司
     * @param type
     * @return
     */
    List<CompanyViewDTO> getCompanyDic(Integer type,String context);

    /**
     * 未注销的公司机构
     * @return
     */
    List<CompanyViewDTO> getNotCancelledCompany();


    /**
     * 注销
     * @param id
     */
    void cancelCompany(Integer id);

    /**
     * 公司选择组件模糊查询
     */
    List<CompanyViewDTO>  getCompanyViewList(String input);
}
