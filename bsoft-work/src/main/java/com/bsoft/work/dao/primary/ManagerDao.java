package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.ManagerDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author ding cj
 * @date 2021/5/13 20:10
 */
@Repository
public interface ManagerDao extends JpaRepository<ManagerDO, Integer>, JpaSpecificationExecutor<ManagerDO> {

    /**
     * 删除成员
     * @param id
     */
    @Transactional
    @Modifying
    @Query("delete from ManagerDO m where m.id = :id")
    void deleteManager(@Param("id") Integer id);
}
