package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.HrFeeRulesRecordCndDTO;
import com.bsoft.hr.dto.HrFeeRulesRecordDTO;
import com.bsoft.hr.dto.PersonFinancialMaintainDTO;

import java.util.List;

public interface PersonFinancialMaintainService {


     /**
      * 调整记录
      * @param cndDTO
      * @return
      */
     Result<HrFeeRulesRecordDTO> getHrFeeRulesRecordList (String userId,HrFeeRulesRecordCndDTO cndDTO);


}
