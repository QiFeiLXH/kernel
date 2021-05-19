package com.bsoft.attendance.manager;

import com.bsoft.attendance.entity.primary.WorkLogVerifyDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WorkLogVerifyManager {
    public Page<WorkLogVerifyDO> getPendingWorkLog(String personId,String content,Integer page,Integer size);

    public void verifyWorkLog(WorkLogVerifyDO workLogVerify);

    void verifyWorkLogs(List<WorkLogVerifyDO> workLogVerifys);
}
