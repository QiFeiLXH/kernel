package com.bsoft.hr.manager;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.hr.entity.primary.LeaveInfoDO;
import org.springframework.data.domain.Page;

public interface PersonTypeManager {
    /**
     * 保存人员财务类别（hr）
     * @param publicDicDO
     */
    void addPersonType(String userId,PublicDicDO publicDicDO);

    /**
     * 更新人员财务类别（hr）
     * @param publicDicDO
     */
    void updatePersonType(String userId,PublicDicDO publicDicDO);

    /**
     * 分页查询人员财务列表
     *
     */
    Page<PublicDicDO> getPersonTypeList(Integer pageNo, Integer pageSize, Integer type,Integer personflag);

    /**
     * 判断该财务类别有没有被使用
     */
    boolean ifFinancialType(Integer id);
}
