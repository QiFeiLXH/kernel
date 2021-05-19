package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.NewEntryPersonInfoDTO;
import com.bsoft.hr.dto.NewEntryPersonInfoQueryCndDTO;
import com.bsoft.hr.dto.PersonCompanyDTO;

import java.util.List;

public interface NewEntryPersonInfoService {
    /**
     * 获取每月新入职 员工信息 分页
     * @param cnd
     * @return
     */
    Result<NewEntryPersonInfoDTO> getPersonInfoList(String personId,NewEntryPersonInfoQueryCndDTO cnd);

    /**
     * 获取每月新入职 员工信息 不分页
     * @param cnd
     * @return
     */
    List<NewEntryPersonInfoDTO> getAllPersonInfoList(String personId, NewEntryPersonInfoQueryCndDTO cnd);

    /**
     * 更新员工试用期薪资，转正薪资
     * @param personId 操作人工号
     * @param updatePersonId 需要更新信息的员工工号
     * @param probationSalary 试用期薪资
     * @param regularSalary 转正薪资
     * @return
     */
    void updateSalary(String personId,String updatePersonId,Double probationSalary,Double regularSalary, Double paymentBase,Integer place);

    /**
     * 获取所有所属公司
     * @return
     */
    List<PersonCompanyDTO> getAllCompany(String personId);
}
