package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.CloudschoolUserBackupDO;
import com.bsoft.person.entity.primary.CloudshoolRestypeBackupDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudschoolRestypeBackupDao extends JpaRepository<CloudshoolRestypeBackupDO,Integer>, JpaSpecificationExecutor<CloudshoolRestypeBackupDO> {
}
