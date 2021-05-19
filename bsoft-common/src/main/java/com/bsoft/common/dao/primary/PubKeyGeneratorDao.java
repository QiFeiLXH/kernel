package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.PubKeyGeneratorDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface PubKeyGeneratorDao extends JpaRepository<PubKeyGeneratorDO,Integer> {
    @Procedure(procedureName = "pd_ker_public_keygenerator")
    public Integer pd_ker_public_keygenerator(String tableName);
}
