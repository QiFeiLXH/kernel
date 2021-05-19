package com.bsoft.person.service;

import com.bsoft.common.result.Result;
import com.bsoft.person.dto.KnowledgeDTO;
import com.bsoft.person.dto.KnowledgeNumDTO;

import java.util.List;

public interface KnowledgeService {
    List<KnowledgeDTO> getKnowledges(String personId);

    /** 知识贡献数量查询列表
     * @Param: deptId 部门id
     * @Param: inputContent 查找条件（姓名、拼音）
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @return com.bsoft.common.result.Result<KnowledgeNumDTO>
     * @author Xuhui Lin
     */
    Result<KnowledgeNumDTO> getKnowledgeNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize);


    /** 个人知识贡献查询列表
     * @Param: personId 工号
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @return com.bsoft.common.result.Result<KnowledgeDTO>
     * @author Xuhui Lin
     */
    Result<KnowledgeDTO> getPersonalKnowledgeList(String personId, Integer pageNo, Integer pageSize);
}
