package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.KeyGeneratorDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyGeneratorDao extends JpaRepository<KeyGeneratorDO,Integer> {
    @Procedure(procedureName = "pd_ker_pub_keygenerator")
    public Integer pd_ker_pub_keygenerator(String tableName);
}
