package com.bsoft.dept.dao.primary;

import com.bsoft.dept.entity.primary.DeptWithPersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptWithPersonDao extends JpaRepository<DeptWithPersonDO,String>, JpaSpecificationExecutor<DeptWithPersonDO> {
    List<DeptWithPersonDO> findByLogout(Integer flag);
}
