package com.bsoft.person.dao.primary;


import com.bsoft.person.entity.primary.PersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CloudschoolUserSynDao extends JpaRepository<PersonDO,String>, JpaSpecificationExecutor<PersonDO> {

    @Query(value = "select u from PersonDO u where u.startDate =:startDate and u.isValid = 0")
    List<PersonDO> findStartDateSync(@Param(value = "startDate") Date startDate);



    @Modifying
    @Query(value = "select u from PersonDO u where u.endDate =:endDate and u.isValid = 1")
    List<PersonDO> findEndDateSync(@Param(value = "endDate") Date endDate);


    @Query(value="select u from PersonDO u where u.isValid = :flag")
    List<PersonDO> findByFlag(@Param(value = "flag") String flag);

}
