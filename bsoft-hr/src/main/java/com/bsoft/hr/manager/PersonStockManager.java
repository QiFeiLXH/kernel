package com.bsoft.hr.manager;

import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.hr.condition.PersonStockQueryCnd;
import com.bsoft.hr.entity.primary.PersonStockDO;
import com.bsoft.hr.entity.primary.PersonStockViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:04
 * @Description
 */
public interface PersonStockManager {
    Page<PersonStockViewDO> getPersonStockList(PersonStockQueryCnd cnd);

    void logoutOnePersonStock(Integer id);

    void batchLogoutPersonStocks(List<Integer> ids);

    void savePersonStock(PersonStockDO personStockDO);

    ImportResultDO savePersonStocks(List<PersonStockViewDO> personStockViewDOS, String personId);

    List<PersonStockViewDO> getErrorPersonStockList(String personId);

    List<PersonStockViewDO> getAllPersonStockList(PersonStockQueryCnd cnd);
}
