package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.VacationDateDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: zy
 * @date: 2020/9/11
 * @description
 */
public interface VacationDateDao extends JpaRepository<VacationDateDO, Integer>, JpaSpecificationExecutor<VacationDateDO> {
}
