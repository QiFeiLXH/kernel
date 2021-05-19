package com.bsoft.person.service;

import com.bsoft.common.result.Result;
import com.bsoft.person.dto.WorkCertificateDTO;
import com.bsoft.person.dto.WorkCertificateNumDTO;

import java.util.List;

public interface WorkCertificateService {
    List<WorkCertificateDTO> getCertificate(String personId);

    /** 证书数量查询列表
     * @Param: deptId 部门id
     * @Param: inputContent 查找条件（姓名、拼音）
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @return com.bsoft.common.result.Result<WorkCertificateNumDTO>
     * @author Xuhui Lin
     */
    Result<WorkCertificateNumDTO> getCertificateNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize);

    /** 个人证书查询列表
     * @Param: personId 工号
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @return com.bsoft.common.result.Result<WorkCertificateDTO>
     * @author Xuhui Lin
     */
    Result<WorkCertificateDTO> getPersonalCertificateList(String personId, Integer pageNo, Integer pageSize) ;
}
