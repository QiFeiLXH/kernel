package com.bsoft.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.hr.condition.PersonFinancialViewQueryCnd;
import com.bsoft.hr.dto.PersonFinancialMaintainDTO;
import com.bsoft.hr.dto.PersonFinancialViewDTO;
import com.bsoft.hr.entity.primary.PersonFinancialViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonFinancialViewManager {
    /**
     * 岗位费用部门列表查询
     * @param cnd
     * @return
     */
    Page<PersonFinancialViewDO> getPersonFinancialList (PersonFinancialViewQueryCnd cnd);

    /**
     * 修改岗位费用部门列表
     * 1.可修改调整后财务类别（未注销的）、调整年月
     * 2、保存时，增加一条人员的财务类别调整记录。
     * 3、可批量调整修改
     * @param cnd
     */
    void updatePersonFinancial(List<PersonFinancialViewQueryCnd> cnd);
}
