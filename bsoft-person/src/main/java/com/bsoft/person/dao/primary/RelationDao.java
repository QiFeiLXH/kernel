package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.RelationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 13:05
 * @Description:
 */
@Repository
public interface RelationDao extends JpaRepository<RelationDO,String>, JpaSpecificationExecutor<RelationDO> {

    @Modifying
    @Query("delete from RelationDO a where a.zggh = :zggh and a.bmwh = 1")
    void deleteAllByZggh(@Param("zggh") String zggh);

    @Modifying
    @Query("delete from RelationDO a where a.yggh = :yggh and a.bmwh = 1")
    void deleteAllByYggh(@Param("yggh") String yggh);

}
