package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LactationViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:13
 * @Description
 */
@Repository
public interface LactationViewDao extends JpaRepository<LactationViewDO, Integer>, JpaSpecificationExecutor<LactationViewDO> {
    @Query("select a from LactationViewDO a where a.status = 2")
    List<LactationViewDO> getValidLactationPersonIdList();

    List<LactationViewDO> findAllByPersonIdAndStatusIn(String personId, List<Integer> status);
}
