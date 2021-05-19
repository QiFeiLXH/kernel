package com.bsoft.user.dao.primary;

import com.bsoft.user.entity.primary.PersonContactDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/8/6 18:39
 * @Description: 人员联系信息Dao
 */
@Repository
public interface PersonContactDao extends JpaRepository<PersonContactDO,String>, JpaSpecificationExecutor<PersonContactDO> {
    PersonContactDO getAllByPersonid(String personId);

    List<PersonContactDO> getAllByPersonidIn(List<String> ids);

    @Modifying
//    @Transactional
    @Query(value = "update PersonContactDO a set a.phoneModel = '' , a.appbindDate = null where a.personid in :ids")
    void batchUnBound(@Param("ids") List<String> ids);
}
