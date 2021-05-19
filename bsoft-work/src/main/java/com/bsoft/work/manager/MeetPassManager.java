package com.bsoft.work.manager;

import com.bsoft.work.entity.primary.MeetPassDO;

public interface MeetPassManager {
    MeetPassDO getMeetPassWithOpenId(String openId);
}
