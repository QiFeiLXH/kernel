package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.AccountCaliberViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 10:02
 * @Description
 */
@Repository
public interface AccountCaliberViewDao extends JpaRepository<AccountCaliberViewDO,String>, JpaSpecificationExecutor<AccountCaliberViewDO> {

    @Query("select a from AccountCaliberViewDO a where a.deptId =:deptId and a.year = :year")
    public List<AccountCaliberViewDO> findAccountCaliberList(@Param("deptId") String deptId,@Param("year")  Integer year);
}
