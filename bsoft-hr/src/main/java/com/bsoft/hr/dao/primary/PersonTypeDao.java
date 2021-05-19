package com.bsoft.hr.dao.primary;

import com.bsoft.common.entity.primary.PublicDicDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
@Repository
public interface PersonTypeDao extends JpaRepository<PublicDicDO,Integer>, JpaSpecificationExecutor<PublicDicDO> {
    @Transactional
    @Modifying
    @Query(value = "update PublicDicDO gy set gy.name = ?3,gy.personflag=?4 where gy.type=?1 and gy.id=?2")
    void updatePersonType(Integer type, Integer id, String name,Integer personFlag);
}
