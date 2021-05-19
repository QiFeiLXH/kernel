package com.bsoft.project.report.manager.impl;

import com.bsoft.project.report.entity.primary.ReimbursementBonusViewDO;
import com.bsoft.project.report.manager.ReimbursementBonusViewManager;
import com.bsoft.project.report.repository.primary.ReimbursementBonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
@Component
public class ReimbursementBonusManagerViewImpl implements ReimbursementBonusViewManager {

    @Autowired
    private ReimbursementBonusRepository reimbursementBonusRepository;

    @Override
    public List<ReimbursementBonusViewDO> findLastYearData() {
        return reimbursementBonusRepository.find();
    }
}
