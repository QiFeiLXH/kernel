package com.bsoft.menu.dao.primary;

import com.bsoft.menu.entity.primary.MenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao extends JpaRepository<MenuDO,Integer>, JpaSpecificationExecutor<MenuDO> {
    public List<MenuDO> findByPubFlagAndSystemAndActive(Integer pubFlag,Integer system,Integer active);

    public List<MenuDO> findByIdIn(List<Integer> menuIds);

    public List<MenuDO> findBySystemOrderBySortAsc(Integer system);

    public List<MenuDO> findByPubFlagAndAndSystem(Integer pubFlag, Integer system);

    List<MenuDO> findAllByPrefixAndPrefixIsNotNull(String prefix);
}
