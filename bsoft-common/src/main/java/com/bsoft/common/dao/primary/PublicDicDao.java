package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.PublicDicDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PublicDicDao extends JpaRepository<PublicDicDO,Integer>, JpaSpecificationExecutor<PublicDicDO> {
    List<PublicDicDO> findByType(Integer type);
    List<PublicDicDO> findByTypeAndIdIsGreaterThan(Integer type,Integer id);
    PublicDicDO findByTypeAndId(Integer type, Integer Id);
    PublicDicDO findByTypeAndProduct(Integer type,String product);
    PublicDicDO findByTypeAndName(Integer type,String name);
    List<PublicDicDO> findAllByTypeAndFlag(Integer type,Integer flag);
    List<PublicDicDO> findByTypeAndFlagAndIdIsGreaterThan(Integer type,Integer flag, Integer id);
    @Transactional
    @Modifying
    @Query(value = "update PublicDicDO gy set gy.personflag = 1 where gy.type=3012 and gy.id= :id")
    void logout (@Param("id") Integer id);

    @Query(value = "select max(gy.id)+1 from PublicDicDO gy where gy.type = 3012")
    Integer selectMaxId();

    @Query(value = "select gy from   PublicDicDO gy where gy.personflag = 1 and gy.type=3012 and gy.id= :id")
    PublicDicDO findByDeptlogout (@Param("id") Integer id);


}
