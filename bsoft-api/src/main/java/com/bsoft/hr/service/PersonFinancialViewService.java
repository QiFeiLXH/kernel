package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.PersonFinancialMaintainDTO;
import com.bsoft.hr.dto.PersonFinancialViewDTO;

import java.util.List;

public interface PersonFinancialViewService {


    /**
     * 岗位费用部门列表查询
      * @param personFinancialViewDTO
     * @return
     */
     Result<PersonFinancialViewDTO> getPersonFinancialList (PersonFinancialViewDTO personFinancialViewDTO);

     /**
      * 修改岗位费用部门列表
      * 1.可修改调整后财务类别（未注销的）、调整年月
      * 2、保存时，增加一条人员的财务类别调整记录。
      * 3、可批量调整修改
      * @param personFinancialViewDTO
      */
     void updatePersonFinancial(String userId,List<PersonFinancialViewDTO> personFinancialViewDTO);
}
