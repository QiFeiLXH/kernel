package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanDicDao extends JpaRepository<HumanDicDO,Integer>, JpaSpecificationExecutor<HumanDicDO> {
    public List<HumanDicDO> findByType(Integer type);
    public HumanDicDO findByTypeAndId(Integer type, Integer Id);
    public List<HumanDicDO> findAllByTypeAndIdNotOrderByIdAsc(Integer type,Integer id);
    @Query("select a from HumanDicDO a where a.type = :type and a.logout = 0 and a.id <> 0 order by a.id")
    List<HumanDicDO> getVisibledDic(@Param("type") Integer type);



    @Query("select max(id) from HumanDicDO where type = :type")
    Integer getMaxIdByType(@Param("type") Integer type);

    HumanDicDO findByTypeAndName(Integer type, String name);

    List<HumanDicDO> findByTypeAndIdIsGreaterThan(Integer type, Integer id);

}
