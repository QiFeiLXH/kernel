package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.AccountCaliberDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 10:02
 * @Description
 */
@Repository
public interface AccountCaliberDao extends JpaRepository<AccountCaliberDO,Integer>, JpaSpecificationExecutor<AccountCaliberDO> {
    @Transactional
    @Modifying
    @Query("delete from AccountCaliberDO a where a.deptId = :deptId and a.year = :year and a.accountCaliber in (:calibers)")
    void deleteAllByDeptIdAndYearAndAccountCaliberIn(@Param("deptId") String deptId, @Param("year") Integer year, @Param("calibers") List<Integer> calibers);

    List<AccountCaliberDO> findAllByYear(Integer year);

    void deleteAllByYearAndDeptIdIn(Integer year,List<String> deptIds);

    @Query("select a from AccountCaliberDO a,DeptDO  b where a.deptId = b.deptId and a.year = :lastYear and b.logout = 0")
    List<AccountCaliberDO> findLastYear(@Param("lastYear") Integer lastYear);

}
