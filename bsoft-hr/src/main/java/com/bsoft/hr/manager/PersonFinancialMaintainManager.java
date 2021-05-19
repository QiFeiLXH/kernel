package com.bsoft.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.hr.condition.HrFeeRulesRecordQueryCnd;
import com.bsoft.hr.dto.HrFeeRulesRecordCndDTO;
import com.bsoft.hr.dto.HrFeeRulesRecordDTO;
import com.bsoft.hr.dto.PersonFinancialMaintainDTO;
import com.bsoft.hr.dto.PersonFinancialViewDTO;
import com.bsoft.hr.entity.primary.PersonFinancialMaintainDO;

import java.util.List;

public interface PersonFinancialMaintainManager {
    void insertInfo(String userId,List<PersonFinancialMaintainDO> personFinancialMaintainDOS);


    /**
     * 调整记录
     * @param cndDTO
     * @return
     */
    Result<HrFeeRulesRecordDTO> getHrFeeRulesRecordList (String userId, HrFeeRulesRecordQueryCnd cndDTO);
}
