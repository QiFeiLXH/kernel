package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.SystemDicDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemDicDao extends JpaRepository<SystemDicDO,Integer>, JpaSpecificationExecutor<SystemDicDO> {
    public List<SystemDicDO> findByType(Integer type);
    public List<SystemDicDO> findByTypeAndIdIsGreaterThan(Integer type,Integer id);
    public SystemDicDO findByTypeAndId(Integer type, Integer Id);
 }
