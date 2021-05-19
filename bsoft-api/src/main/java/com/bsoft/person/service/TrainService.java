package com.bsoft.person.service;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.person.dto.*;

import java.util.List;

public interface TrainService {
    List<TrainDTO> getTrainWithPersonId(String personId);
    /** 培训管理-云学堂知识学习查询列表
     * @Param: trainQueryCndDTO 查找条件
     * @return com.bsoft.common.result.Result<TrainLearnDTO>
     * @author Xuhui Lin
     */
    Result<TrainLearnDTO> getKnowledgeLearnList(TrainQueryCndDTO trainQueryCndDTO);

    /** 培训管理-云学堂知识学习保存
     * @Param: personId 员工工号
     * @Param: trainLearnDTOS 知识学习数据
     * @Param: errorLearnDTOS 转换失败的数据
     * @return
     * @author Xuhui Lin
     */
    ImportResultDTO saveKnowledgeLearn(String personId, List<TrainLearnDTO> trainLearnDTOS, List<TrainLearnDTO> errorLearnDTOS);

    /** 培训管理-云学堂知识分享查询列表
     * @Param: trainQueryCndDTO 查找条件
     * @return com.bsoft.common.result.Result<TrainLearnDTO>
     * @author Xuhui Lin
     */
    Result<TrainShareDTO> getKnowledgeShareList(TrainQueryCndDTO trainQueryCndDTO);

    /** 培训管理-云学堂知识学习保存
     * @Param: personId 员工工号
     * @Param: trainShareDTOS 知识分享数据
     * @Param: failedMapList 转换失败的数据
     * @return
     * @author Xuhui Lin
     */
    ImportResultDTO saveKnowledgeShare(String personId, List<TrainShareDTO> trainShareDTOS, List<TrainShareDTO> errorShareDTOS);

    /** 培训管理-云学堂知识学习导入错误列表
     * @Param: personId 员工工号
     * @return
     * @author Xuhui Lin
     */
    List<TrainLearnDTO> getImportLearnErrorList(String personId);

    /** 培训管理-云学堂知识分享导入错误列表
     * @Param: personId 员工工号
     * @return
     * @author Xuhui Lin
     */
    List<TrainShareDTO> getImportShareErrorList(String personId);

    /** 培训管理-云学堂知识学习删除
     * @Param: deletes 删除id
     * @return
     * @author Xuhui Lin
     */
    void deleteBatchLearnList(List<Integer> deletes);

    /** 培训管理-云学堂知识分享
     * @Param: deletes 删除id
     * @return
     * @author Xuhui Lin
     */
    void deleteBatchShareList(List<Integer> deletes);


    /** 个人培训情况查询列表
     * @Param: cndDTO 查找条件
     * @return com.bsoft.common.result.Result<PersonalTrainDTO>
     * @author Xuhui Lin
     */
    Result<PersonalTrainDTO> getPersonalTrainList(PersonalTrainQueryCndDTO cndDTO);

}
