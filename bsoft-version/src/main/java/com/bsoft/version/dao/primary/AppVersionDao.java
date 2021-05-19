package com.bsoft.version.dao.primary;

import com.bsoft.version.entity.primary.AppVersionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppVersionDao extends JpaRepository<AppVersionDO,Integer>, JpaSpecificationExecutor<AppVersionDO> {
    @Query("select a from AppVersionDO a where a.id = (select max(b.id) from AppVersionDO b where b.type = :type )")
    public AppVersionDO getLastestVersion(@Param("type") Integer type);

    public AppVersionDO findByTypeAndVersion(Integer type,String version);

    public List<AppVersionDO> findByType(Integer type);

}
