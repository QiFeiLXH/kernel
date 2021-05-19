package com.bsoft.cost.manager;

import com.bsoft.cost.entity.primary.AccountCaliberDO;
import com.bsoft.cost.entity.primary.AccountCaliberViewDO;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 9:57
 * @Description
 */
public interface AccountCaliberManager {
    PageInfo<AccountCaliberViewDO> getDpetAccountCaliberList(Integer pageNo, Integer pageSize, Integer year, Integer accountCaliber, String deptId, Integer deptType);

    void saveYearlyDeptAccountCaliber(Integer year);

    void saveDeptAccountCaliber(List<Integer> caliberSaves, List<Integer> caliberDeletes, String deptId, Integer year);

    List<AccountCaliberViewDO> findByDeptIdAndYear(String deptId,Integer year);

    void saveAccountCaliber(List<AccountCaliberDO> accountCaliberDOS);

    void deleteAccountCaliber(Integer year,List<String> deptIds);

    List<AccountCaliberDO> findAllByYear(Integer year);

    List<AccountCaliberDO> getLastYear(Integer year);

}
