package com.bsoft.cost.repository.primary;

import com.bsoft.cost.entity.primary.AccountCaliberDO;
import com.bsoft.cost.entity.primary.AccountCaliberViewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 14:39
 * @Description
 */
@Mapper
@Repository
public interface AccountCaliberRepository {
    List<AccountCaliberDO> getValidDeptAccountCaliberListByYear(@Param("year")Integer year);
    List<AccountCaliberViewDO> getAccountCaliberListByYear(@Param("year")Integer year,@Param("deptId")String deptId,@Param("deptType")Integer deptType,@Param("accountCaliber")Integer accountCaliber);
}
