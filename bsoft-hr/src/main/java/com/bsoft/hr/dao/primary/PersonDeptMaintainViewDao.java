package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.PersonDeptMaintainViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 部门打卡方式
 */
@Repository
public interface PersonDeptMaintainViewDao extends JpaRepository<PersonDeptMaintainViewDO, String>, JpaSpecificationExecutor<PersonDeptMaintainViewDO> {
    List<PersonDeptMaintainViewDO> findByParentDeptIn(List<String> parentDeptList);

//    @Modifying
//    @Query(value = "update ClockInModeDeptInfoDO dp set dp.personTypeFlag = :personTypeFlag where dp.dept =:deptId ")
//    void updatePersonType(@Param("deptId") String deptId, @Param("personTypeFlag") Integer personTypeFlag);
}
