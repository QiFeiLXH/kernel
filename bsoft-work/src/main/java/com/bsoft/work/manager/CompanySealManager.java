package com.bsoft.work.manager;

import com.bsoft.work.entity.primary.CompanySealDO;
import com.bsoft.work.entity.primary.CompanySealViewDO;
import com.bsoft.work.dto.CompanySealDTO;
import com.bsoft.work.dto.CompanySealQueryCnd;
import org.springframework.data.domain.Page;

public interface CompanySealManager {
    /**
     * 查询公司印章列表
     * @param companySealQueryCnd
     * @return
     */
    Page<CompanySealViewDO> getCompanySealList(CompanySealQueryCnd companySealQueryCnd);

    /**
     * 保存公司印章
     * @param companySealDO
     */
    void saveCompanySeal(CompanySealDO companySealDO);


    /**
     * 根据ID查找公司印章信息
     * @param id
     */
    CompanySealViewDO getCompanySealView(Integer id);
}
