package com.bsoft.common.manager;

import com.bsoft.common.condition.ModifyRecordQueryCnd;
import com.bsoft.common.entity.primary.ModifyRecordDO;
import com.bsoft.common.entity.primary.ModifyRecordViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 9:35
 * @Description
 */
public interface ModifyRecordManager {
    void saveAttendanceModifyRecords(List<ModifyRecordDO> recordDOS);

    Integer saveModifyRecord(ModifyRecordDO recordDO);

    Page<ModifyRecordViewDO> getModifyRecordList(ModifyRecordQueryCnd cnd);

    void deleteModifyRecord(Integer ModifyId);
}
