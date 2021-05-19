package com.bsoft.common.manager;

import com.bsoft.common.entity.primary.CompanyDO;
import com.bsoft.common.entity.primary.CompanyViewDO;

import java.util.List;

public interface CompanyManager {

    List<CompanyDO> getCompanyList();

    Integer saveCompany(CompanyDO companyDO);

    List<CompanyViewDO> getAllCompany();

    CompanyViewDO getCompanyById(Integer id);

    List<CompanyViewDO> getCompanyDic(Integer type);

    List<CompanyViewDO> getCompanyDic(Integer type,String context);

    List<CompanyViewDO> getNotCancelledCompany();

    void cancelCompany(Integer companyId);

    List<CompanyDO> findByUnitCode(String unitCode,Integer companyId);
    List<CompanyDO> findByName(String Name,Integer companyId);

    /**
     * 统一更新公司机构作用字段长度，补0
     */
    void saveCompanyPurpose();

    /**
     * 公司选择组件模糊查询
     */
    List<CompanyViewDO>  getCompanyViewList(String input);


}
