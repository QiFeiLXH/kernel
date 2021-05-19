package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.PersonDeptAuthDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/22 13:44
 * @Description:
 */
@Repository
public interface PersonDeptAuthDao extends JpaRepository<PersonDeptAuthDO,Integer>, JpaSpecificationExecutor<PersonDeptAuthDO> {
    void deleteAllByMenuId(Integer menuId);

    void deleteAllByIdIn(List<Integer> ids);

    void deleteAllByPersonIdIn(List<String> personIds);

    void deleteAllByPersonId(String personId);

}
