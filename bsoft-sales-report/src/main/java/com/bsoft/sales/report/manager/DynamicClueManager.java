package com.bsoft.sales.report.manager;

import com.bsoft.sales.report.entity.primary.DynamicClueDO;
import com.bsoft.sales.report.entity.primary.DynamicClueViewDO;

import java.util.List;

public interface DynamicClueManager {
    public DynamicClueDO saveClue(DynamicClueDO dynamicClue);
    public List<DynamicClueDO> getClue(Integer dynamicId);
    public List<DynamicClueViewDO> getClueView(Integer dynamicId);
    public List<DynamicClueDO> save(List<DynamicClueDO> dynamicClues);
}
