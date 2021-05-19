package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.result.Result;
import com.bsoft.hr.condition.HrFeeRulesRecordQueryCnd;
import com.bsoft.hr.dto.HrFeeRulesRecordCndDTO;
import com.bsoft.hr.dto.HrFeeRulesRecordDTO;
import com.bsoft.hr.dto.PersonFinancialMaintainDTO;
import com.bsoft.hr.manager.PersonFinancialMaintainManager;
import com.bsoft.hr.service.PersonFinancialMaintainService;
import com.bsoft.hr.service.PersonTypeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class PersonFinancialMaintainServiceImpl implements PersonFinancialMaintainService {
    @Autowired
    private PersonFinancialMaintainManager personFinancialMaintainManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<HrFeeRulesRecordDTO> getHrFeeRulesRecordList(String userId,HrFeeRulesRecordCndDTO cndDTO) {
        HrFeeRulesRecordQueryCnd convert = iGenerator.convert(cndDTO, HrFeeRulesRecordQueryCnd.class);
        Result<HrFeeRulesRecordDTO> hrFeeRulesRecordList = personFinancialMaintainManager.getHrFeeRulesRecordList(userId,convert);
        return hrFeeRulesRecordList;
    }
}
