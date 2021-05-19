package com.bsoft.menu.dao.primary;

import com.bsoft.menu.entity.primary.OfficeMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeMenuDao extends JpaRepository<OfficeMenuDO,Integer>, JpaSpecificationExecutor<OfficeMenuDO> {
    public List<OfficeMenuDO> findBySystemAndActiveOrderBySortAsc(Integer system, Integer active);
    public List<OfficeMenuDO> findAllById(Integer id);
}
