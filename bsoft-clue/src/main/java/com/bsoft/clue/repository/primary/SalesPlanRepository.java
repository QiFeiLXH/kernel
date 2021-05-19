package com.bsoft.clue.repository.primary;

import com.bsoft.clue.entity.primary.SalesPlanDO;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.person.entity.primary.PersonDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020/11/18 15:43
 * @Description
 */
@Mapper
@Repository
public interface SalesPlanRepository {
    /**
     * 根据年份获取当年有数据的月份
     * @param year
     * @return
     */
    List<String> getReportMonthWithYear(@Param("personId") String personId, @Param("year") String year);

    /**
     * 获取跟单人列表
     * @return
     */
    List<SalesPlanDO> listTrackPersons();

    /**
     * 获取跟单部门列表
     * @return
     */
    List<SalesPlanDO> listTrackDepts();


}
