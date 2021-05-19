package com.bsoft.common.dao.second;

import com.bsoft.common.entity.second.WordKeyGeneratorDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordKeyGeneratorDao extends JpaRepository<WordKeyGeneratorDO,String> {
}
