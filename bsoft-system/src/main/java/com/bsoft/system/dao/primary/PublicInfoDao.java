package com.bsoft.system.dao.primary;

import com.bsoft.system.entity.primary.PublicInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicInfoDao extends JpaRepository<PublicInfoDO,Integer>, JpaSpecificationExecutor<PublicInfoDO> {
    @Query("SELECT A FROM PublicInfoDO A WHERE type = 2 AND rownum <= :rows ORDER BY displaydate desc, id desc")
    public List<PublicInfoDO> getNews(@Param("rows") Long rows);

    @Query("SELECT A FROM PublicInfoDO A WHERE type = 1 AND rownum <= :rows ORDER BY displaydate desc, id desc")
    public List<PublicInfoDO> getNotice(@Param("rows") Long rows);

    @Query("SELECT A FROM PublicInfoDO A WHERE type = 3 AND rownum <= :rows ORDER BY displaydate desc, id desc")
    public List<PublicInfoDO> getSystemNotice(@Param("rows") Long rows);

}
