package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.PersonDeptAuthViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/27 21:15
 * @Description:
 */
@Repository
public interface PersonDeptAuthViewDao extends JpaRepository<PersonDeptAuthViewDO,Integer>, JpaSpecificationExecutor<PersonDeptAuthViewDO> {
    List<PersonDeptAuthViewDO> findAllByPersonIdAndSystem(String personId,Integer system);
}
