package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.AdministrativeAreaDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrativeAreaDao extends JpaRepository<AdministrativeAreaDO,Integer>, JpaSpecificationExecutor<AdministrativeAreaDO> {

    List<AdministrativeAreaDO> findByDeleted(Integer deleted);

    List<AdministrativeAreaDO> findByParentIdAndDeleted(Integer parentId,Integer deleted);

    List<AdministrativeAreaDO> findByLevelAndDeleted(Integer level, Integer delete);
}
