package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.SalesCommisDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 13:11
 * @Description:
 */
@Repository
public interface SalesCommisDao extends JpaRepository<SalesCommisDO,Integer>, JpaSpecificationExecutor<SalesCommisDO> {
    void deleteAllByIdIn(List<Integer> ids);

    List<SalesCommisDO> findAllByIdIn(List<Integer> ids);

    List<SalesCommisDO> findAllByHtbhIn(List<String> htbhs);
}
