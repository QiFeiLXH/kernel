package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.KnowledgeDO;
import com.bsoft.person.entity.primary.KnowledgeNumViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KnowledgeManager {
    KnowledgeDO saveKnowledge(KnowledgeDO knowledge);

    List<KnowledgeDO> saveKnowledges(List<KnowledgeDO> konwledges);

    List<KnowledgeDO> getKnowledges(String personId);

    Page<KnowledgeNumViewDO> getKnowledgeNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize);

    Page<KnowledgeDO> getPersonalKnowledgeList(String personId, Integer pageNo, Integer pageSize);
}
