package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonTClassDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonTClassDao extends JpaRepository<PersonTClassDO,String>, JpaSpecificationExecutor<PersonTClassDO> {

    @Query("from PersonTClassDO where zxbz = 0 and cost*20 - 1000 >= :meritPay and rownum = 1")
    PersonTClassDO findPersonTClass(@Param("meritPay") Double meritPay);

    @Query("select max(classNo) from PersonTClassDO")
    String findMaxClass();
}
