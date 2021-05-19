package com.bsoft.person.repository.primary;

import com.bsoft.person.entity.primary.DeptCostMaintainLookDO;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.entity.primary.PostAndCostLookDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 16:35
 * @Description
 */
@Mapper
@Repository
public interface PersonRepository {
    List<PersonDO> getPersonsEvaluated();

    List<PersonDO> getPersonsEvaluatedByPersonIds(List<String> personIdList);

    void updateBatchPersonPaymentPlace(List<PersonDO> persons);

    PostAndCostLookDO getPostAndCost(Integer posttype);

    List<DeptCostMaintainLookDO> findDeptCostMaintain(@Param("ddrq") Date ddrq, @Param("deptId") String deptId);

    List<DeptCostMaintainLookDO> findPersonCostMaintain(@Param("ddrq") Date ddrq, @Param("personId") String personId);
}
