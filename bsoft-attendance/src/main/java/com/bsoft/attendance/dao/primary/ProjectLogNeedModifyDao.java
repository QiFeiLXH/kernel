package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.ProjectLogNeedModifyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-08 15:37
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectLogNeedModifyDao extends JpaRepository<ProjectLogNeedModifyDO,Integer>, JpaSpecificationExecutor<ProjectLogNeedModifyDO> {
    List<ProjectLogNeedModifyDO> findByContractno(String contractno);
}
