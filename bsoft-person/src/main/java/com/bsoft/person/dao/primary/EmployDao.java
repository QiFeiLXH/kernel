package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.EmployDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployDao extends JpaRepository<EmployDO,Integer>, JpaSpecificationExecutor<EmployDO> {

    public EmployDO getById(Integer id);

    @Modifying
    @Query("update EmployDO set status = :status where id = :id")
    void updateStatusById(@Param("status")Integer status,@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update EmployDO set education = :education where id = :id")
    void updateEdtcationById(@Param("education")Integer education,@Param("id") Integer id);


    @Modifying
    @Query("update EmployDO set major = :major where id = :id")
    void updateMajorById(@Param("major")Integer major,@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update EmployDO a set a.workedYears = :workAge where a.id =:id")
    public void updateWorkAge(@Param("id") Integer zpid,@Param("workAge") Double workAge);

    @Transactional
    @Modifying
    @Query(value = "update EmployDO a set a.status = 4 where a.id =:id")
    void doBackToPerson(@Param("id") Integer zpid);

    @Transactional
    @Modifying
    @Query(value = "update EmployDO a set a.oneInchPhoto = :imageId where a.id =:id")
    void updateOneInchPhoto(@Param("imageId") Integer imageId, @Param("id") Integer id);
}
