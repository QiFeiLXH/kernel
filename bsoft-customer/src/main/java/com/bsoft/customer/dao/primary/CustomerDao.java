package com.bsoft.customer.dao.primary;

import com.bsoft.customer.entity.primary.CustomerDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<CustomerDO,String>, JpaSpecificationExecutor<CustomerDO> {
    List<CustomerDO> findByNameIn(List<String> nameList);
}
