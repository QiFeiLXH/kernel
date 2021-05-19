package com.bsoft.person.manager;

import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.person.condition.PersonalTrainQueryCnd;
import com.bsoft.person.condition.TrainKnowledgeQueryCnd;
import com.bsoft.person.entity.primary.PersonalTrainViewDO;
import com.bsoft.person.entity.primary.TrainDO;
import com.bsoft.person.entity.primary.TrainLearnViewDO;
import com.bsoft.person.entity.primary.TrainShareViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TrainManager {
    List<TrainDO> getTrainWithPersonId(String personId);

    Page<TrainLearnViewDO> getKnowledgeLearnList(TrainKnowledgeQueryCnd cnd);

    ImportResultDO saveKnowledgeLearn(String personId, List<TrainLearnViewDO> knowledgeLearnViewDOS, List<TrainLearnViewDO> errorLearnViewDOS);

    Page<TrainShareViewDO> getKnowledgeShareList(TrainKnowledgeQueryCnd cnd);

    ImportResultDO saveKnowledgeShare(String personId, List<TrainShareViewDO> knowledgeShareViewDOS, List<TrainShareViewDO> errorShareViewDO);

    List<TrainLearnViewDO> getImportLearnErrorRecords(String personId);

    List<TrainShareViewDO> getImportShareErrorRecords(String personId);

    void deleteBatchLearnList(List<Integer> deletes);

    void deleteBatchShareList(List<Integer> deletes);

    Page<PersonalTrainViewDO> getPersonalTrainList(PersonalTrainQueryCnd cnd);
}
