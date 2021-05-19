package com.bsoft.user.dao.primary;

import com.bsoft.user.entity.primary.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserDO,String>, JpaSpecificationExecutor<UserDO> {
    List<UserDO> getAllByIdIn(List<String> ids);

    @Modifying
//    @Transactional
    @Query(value = "update UserDO a set a.appdevice = '' where a.id in :ids")
    void batchUnBound(@Param("ids") List<String> ids);
}
