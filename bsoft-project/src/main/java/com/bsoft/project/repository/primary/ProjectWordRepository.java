package com.bsoft.project.repository.primary;

import com.bsoft.project.entity.primary.ProjectWordRecordDO;
import com.bsoft.project.entity.primary.StageDocumentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectWordRepository {

    List<StageDocumentDO> selectStageDocuments(@Param("contractNo") String contractNo,@Param("projectId") String projectId);

    List<ProjectWordRecordDO> countGroupByMilepostIdAndDocumentId(@Param("recordIds") List<Integer> recordIds,@Param("milepostIds") List<Integer> milepostIds);

    List<Integer> countStageDocumentByContractNo(@Param("contractNo") String contractNo);

    List<StageDocumentDO> findStageStandardDocuments();

    List<Integer> getMilepostStageDocumentCount();

    List<Integer> countStageByContractNo(@Param("contractNo") String contractNo);
    List<Integer> countMilepostByContractNo(@Param("contractNo") String contractNo);
}
