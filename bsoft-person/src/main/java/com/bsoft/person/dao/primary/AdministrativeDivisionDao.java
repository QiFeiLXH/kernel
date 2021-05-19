package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.AdministrativeDivisionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrativeDivisionDao extends JpaRepository<AdministrativeDivisionDO,Integer>, JpaSpecificationExecutor<AdministrativeDivisionDO> {
    public List<AdministrativeDivisionDO> findAllByLevelAndFlagOrderByCodeAsc(Integer level,Integer flag);
    public List<AdministrativeDivisionDO> findAllByParentCodeAndFlagOrderByCodeAsc(Integer parentCode,Integer flag);
    public List<AdministrativeDivisionDO> findAllByZipCodeAndFlag(String zipCode,Integer flag);
    List<AdministrativeDivisionDO> findAllByFlag(Integer flag);
    @Query("select a from AdministrativeDivisionDO a where code = (select parentCode from AdministrativeDivisionDO where code = :code)")
    AdministrativeDivisionDO findCity(@Param("code") Integer code);
    AdministrativeDivisionDO findByCode(Integer code);
}
