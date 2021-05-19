package com.bsoft.clue.manager.impl;

import com.bsoft.clue.dao.primary.ClueDao;
import com.bsoft.clue.dao.primary.ClueViewDao;
import com.bsoft.clue.dao.primary.TrackLogCluesDao;
import com.bsoft.clue.entity.primary.ClueDO;
import com.bsoft.clue.entity.primary.ClueViewDO;
import com.bsoft.clue.entity.primary.TrackLogCluesDO;
import com.bsoft.clue.manager.ClueManager;
import com.bsoft.common.manager.ServerDateManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Component
public class ClueManagerImpl implements ClueManager {
    @Autowired
    private ClueViewDao clueViewDao;
    @Autowired
    private TrackLogCluesDao trackLogCluesDao;
    @Autowired
    private ClueDao clueDao;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public ClueViewDO getClueView(Integer id) {
        return clueViewDao.findById(id).get();
    }

    @Override
    public Page<TrackLogCluesDO> searchTrackLogClues(String personId, String content, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<TrackLogCluesDO> cluePage = trackLogCluesDao.findAll(new Specification<TrackLogCluesDO>() {
            @Override
            public Predicate toPredicate(Root<TrackLogCluesDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate7 = null;
                if(StringUtils.isBlank(content)){
                    Predicate predicate4 = criteriaBuilder.equal(root.get("tracker"),personId);
                    Predicate predicate5 = criteriaBuilder.equal(root.get("projectFlag"),1);
                    Predicate predicate6 = criteriaBuilder.equal(root.get("closed"),0);
                    predicate7 = criteriaBuilder.and(predicate4,predicate5,predicate6);
                }else{
                    Predicate predicate1 = criteriaBuilder.like(root.get("customerName"),content);
                    Predicate predicate2 = criteriaBuilder.like(root.get("productContent"),content);
                    Predicate predicate3 = criteriaBuilder.or(predicate1,predicate2);
                    Predicate predicate4 = criteriaBuilder.equal(root.get("tracker"),personId);
                    Predicate predicate5 = criteriaBuilder.equal(root.get("projectFlag"),1);
                    Predicate predicate6 = criteriaBuilder.equal(root.get("closed"),0);
                    predicate7 = criteriaBuilder.and(predicate3,predicate4,predicate5,predicate6);
                }
                return predicate7;
            }
        },pageable);
        return cluePage;
    }

    @Override
    public List<ClueViewDO> getTodayClue() {
        java.sql.Date start =  serverDateManager.getServerDate();
        Date end = serverDateManager.getServerDateTime();
        return clueViewDao.getClue(start,end);
    }

    @Override
    public ClueDO getClue(Integer id) {
        return clueDao.findById(id).get();
    }

    @Override
    public ClueDO saveClue(ClueDO clue) {
        return clueDao.save(clue);
    }

}
