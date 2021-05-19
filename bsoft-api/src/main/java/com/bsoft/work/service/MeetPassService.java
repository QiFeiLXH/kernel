package com.bsoft.work.service;

import com.bsoft.work.dto.MeetPassDTO;

public interface MeetPassService {
    MeetPassDTO getMeetPassWithOpenId(String openId);
}
