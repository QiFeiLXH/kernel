package com.bsoft.hr.manager;

import com.bsoft.hr.condition.NewEntryPersonInfoQueryCnd;
import com.bsoft.hr.entity.primary.PersonCompanyDO;
import com.bsoft.hr.entity.primary.NewEntryPersonInfoDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewEntryPersonInfoManager {
    /**
     * 获取每月新入职 员工信息 带分页
     * @param cnd
     * @return
     */
    Page<NewEntryPersonInfoDO> getPersonInfoList(NewEntryPersonInfoQueryCnd cnd);

    /**
     * 更新员工试用期薪资，转正薪资
     * @param personId 工号
     * @param probationSalary 试用期薪资
     * @param regularSalary 转正薪资
     * @return
     */
    void updateSalary(String personId,Double probationSalary,Double regularSalary, Double paymentBase,Integer place);

    /**
     * 获取每月新入职 员工信息 不带分页 用于导出数据
     * @param cnd
     * @return
     */
    List<NewEntryPersonInfoDO> getAllPersonInfoList(NewEntryPersonInfoQueryCnd cnd);

    /**
     * 获取所有所属公司
     * @return
     */
    List<PersonCompanyDO> getAllCompany();
}
