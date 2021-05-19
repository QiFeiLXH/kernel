package com.bsoft.hr.manager;

import com.bsoft.hr.condition.LactationQueryCnd;
import com.bsoft.hr.entity.primary.LactationDO;
import com.bsoft.hr.entity.primary.LactationViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:17
 * @Description
 */
public interface LactationManager {
    Page<LactationViewDO> getLactationList(LactationQueryCnd cnd);

    Integer saveLactation(LactationDO lactationDO);

    void updateLactation(LactationDO lactationDO);

    List<LactationViewDO> getValidLactationPersonIdList();

    void updateLactationAttendance();

}
