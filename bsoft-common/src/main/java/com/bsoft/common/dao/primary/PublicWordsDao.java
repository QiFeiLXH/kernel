package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.PublicWordsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Description
 */
@Repository
public interface PublicWordsDao extends JpaRepository<PublicWordsDO,Integer>, JpaSpecificationExecutor<PublicWordsDO> {

}
