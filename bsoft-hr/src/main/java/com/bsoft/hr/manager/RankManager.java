package com.bsoft.hr.manager;

import com.bsoft.hr.entity.primary.RankDO;
import com.bsoft.hr.entity.primary.RankViewDO;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface RankManager {
    RankDO saveRank(RankDO rank);

    Integer saveRankAndOther(RankDO rank);

    Page<RankViewDO> getRankList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize);

    Date getNewestRankDate(String personId);
}
