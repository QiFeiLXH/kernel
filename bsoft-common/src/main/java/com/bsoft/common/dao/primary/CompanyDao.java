package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.CompanyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends JpaRepository<CompanyDO,Integer>, JpaSpecificationExecutor<CompanyDO> {
    @Query("select a from CompanyDO a where a.parentCompanyId = 0 and a.signOff = 0 and a.reimbursement = 1 order by a.unitcode asc")
    List<CompanyDO> getCompanyList();

    List<CompanyDO> findAllByUnitcodeAndCompanyIdNot(String unitCode,Integer companyId);
    List<CompanyDO> findAllByAbbreviationAndCompanyIdNot(String name,Integer companyId);

    /**
     * 获取用途字段为空，或者比9912字典项短的公司机构
     * @return
     */
    @Query("select a from CompanyDO a where (length(a.purpose) is null or length(a.purpose) < :length) and a.signOff = 0")
    List<CompanyDO> getCompany(@Param("length") Integer length);

    @Modifying
    @Query("update CompanyDO set signOff = 1 where companyId = :companyId")
    void doCancelCompany(@Param("companyId") Integer companyId);

}
