package com.bsoft.system.manager;

import com.bsoft.system.condition.PublicInfoQueryCnd;
import com.bsoft.system.entity.primary.PublicInfoDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PublicInfoManager {
    public List<PublicInfoDO> getNews(Long count);
    public List<PublicInfoDO> getNotice(Long count);
    public List<PublicInfoDO> getSystemNotice(Long count);
    public Page<PublicInfoDO> getNewsByType(PublicInfoQueryCnd cnd);
}
