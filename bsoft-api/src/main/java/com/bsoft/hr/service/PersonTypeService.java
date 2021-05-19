package com.bsoft.hr.service;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;

import java.util.List;

public interface PersonTypeService {
    /**
     * 根据ID获取人员财务类别
     * @param publicDicDTO
     * @return
     */
    PublicDicDTO getPersonTypeInfo( PublicDicDTO publicDicDTO);

    /**
     * 获取人员财务类别列表
     * @param
     * @return
     */
    Result<PublicDicDTO> getPersonTypeInfoList(Integer pageNo,Integer pageSize,Integer type,Integer personflag);

    /**
     * 保存人员财务类别（hr）
     * @param publicDicDTO
     */
    void addPersonType(String userId,PublicDicDTO publicDicDTO);

    /**
     * 修改人员财务类别（hr）
     * @param publicDicDTO
     */
    void updatePersonType(String userId, PublicDicDTO publicDicDTO);

    /**
     * 注销人员财务类别（hr）
     * @param id
     */
    boolean logoutPersonType(Integer id);

  

}
