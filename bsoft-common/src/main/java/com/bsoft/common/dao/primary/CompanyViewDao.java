package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.CompanyViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/26 10:47
 * @Description:
 */
@Repository
public interface CompanyViewDao extends JpaRepository<CompanyViewDO,Integer>, JpaSpecificationExecutor<CompanyViewDO> {
    @Query("select distinct a from CompanyViewDO a where a.signOff = 0 and substring(a.purpose, :type ,1) = '1' order by a.unitcode asc")
    List<CompanyViewDO> findCompanyDic(@Param("type") Integer type);

    List<CompanyViewDO> findAllBySignOffOrderByUnitcodeAsc(Integer signOff);

    @Query("select distinct a from CompanyViewDO a where a.signOff = 0 and substring(a.purpose, :type ,1) = '1' and (a.companyName like :context or a.abbreviation like :context or a.pinyinCode like :context) order by a.unitcode asc")
    List<CompanyViewDO> findCompanyDic(@Param("type") Integer type,@Param("context") String context);
}
