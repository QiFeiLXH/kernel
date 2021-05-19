package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface PersonDao extends JpaRepository<PersonDO,String>, JpaSpecificationExecutor<PersonDO> {
    public List<PersonDO> findByUserId(Integer id);

    public List<PersonDO> findByIsValid(String flag);

    public List<PersonDO> findByPersonIdIn(List<String> personIds);

    @Query("select a.personId from PersonDO a where a.isValid = '0' and a.company = 1")
    public List<String> getVaildPersonId();

    List<PersonDO> findBySimpleCodeLikeAndIsValid(String SimpleCode,String isValid);

    @Query("SELECT a.personId as personId,a.personName as personName,a.deptId as deptId,b.deptName as deptName FROM PersonDO a, DeptDO b WHERE a.deptId = b.deptId and a.isValid = '0' and a.company = 1")
    List<Map> findAllVaildPerson();

    List<PersonDO> findByDeptIdAndIsValidAndCompany(String bmdm,String isValid,Integer company);

    @Query("SELECT a from PersonDO a WHERE (a.personName like :value or a.simpleCode like :value) and a.isValid = '0' and a.company = 1")
    List<PersonDO> findByPerson(@Param("value") String value);

    @Query("select a.email from PersonDO a where a.personId in (:personId)")
    List<String> getEmails(@Param("personId") List<String> personId);
}
