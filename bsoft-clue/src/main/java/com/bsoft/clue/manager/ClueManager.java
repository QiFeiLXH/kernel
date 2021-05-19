package com.bsoft.clue.manager;

import com.bsoft.clue.dto.TrackLogCluesDTO;
import com.bsoft.clue.entity.primary.ClueDO;
import com.bsoft.clue.entity.primary.ClueViewDO;
import com.bsoft.clue.entity.primary.TrackLogCluesDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClueManager {
    public ClueViewDO getClueView(Integer id);
    public Page<TrackLogCluesDO> searchTrackLogClues(String personId, String content, Integer page, Integer size);
    public List<ClueViewDO> getTodayClue();
    public ClueDO getClue(Integer id);
    public ClueDO saveClue(ClueDO clue);
}
