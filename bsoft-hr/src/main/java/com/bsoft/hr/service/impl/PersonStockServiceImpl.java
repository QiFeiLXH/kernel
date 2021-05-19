package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.PersonStockQueryCnd;
import com.bsoft.hr.dto.PersonStockDTO;
import com.bsoft.hr.dto.PersonStockQueryCndDTO;
import com.bsoft.hr.entity.primary.PersonStockDO;
import com.bsoft.hr.entity.primary.PersonStockViewDO;
import com.bsoft.hr.manager.PersonStockManager;
import com.bsoft.hr.service.PersonStockService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:08
 * @Description
 */
@Service
public class PersonStockServiceImpl implements PersonStockService {
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonStockServiceImpl.class);

    @Autowired
    private PersonStockManager personStockManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<PersonStockDTO> getPersonStockList(PersonStockQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonStockQueryCnd cnd = iGenerator.convert(cndDTO, PersonStockQueryCnd.class);
        Page<PersonStockViewDO> page = personStockManager.getPersonStockList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取员工股份列表耗时:{}", times);
        return ResultUtils.parseResult(page, PersonStockDTO.class);
    }

    @Override
    public void logoutOnePersonStock(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        personStockManager.logoutOnePersonStock(id);
        long times = timeConsumer.end();
        LOGGER.info("注销id为：{}的股份列表耗时:{}", id,times);
    }

    @Override
    public void batchLogoutPersonStocks(List<Integer> ids) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        personStockManager.batchLogoutPersonStocks(ids);
        long times = timeConsumer.end();
        LOGGER.info("批量注销id：{}的股份列表耗时:{}", JSONUtils.toString(ids),times);
    }

    @Override
    public void savePersonStock(PersonStockDTO personStockDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonStockDO personStockDO = iGenerator.convert(personStockDTO, PersonStockDO.class);
        personStockManager.savePersonStock(personStockDO);
        long times = timeConsumer.end();
        LOGGER.info("保存员工工号：{}的股份耗时:{}", personStockDTO.getPersonId(),times);
    }

    @Override
    public ImportResultDTO savePersonStocks(List<PersonStockDTO> personStockDTOS, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonStockViewDO> personStockViewDOS = iGenerator.convert(personStockDTOS, PersonStockViewDO.class);
        ImportResultDO result = personStockManager.savePersonStocks(personStockViewDOS, personId);
        long times = timeConsumer.end();
        LOGGER.info("批量保存员工股份耗时:{}", times);
        return iGenerator.convert(result, ImportResultDTO.class);
    }

    @Override
    public List<PersonStockDTO> getErrorPersonStockList(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonStockViewDO> list = personStockManager.getErrorPersonStockList(personId);
        long times = timeConsumer.end();
        LOGGER.info("获取员工股份导入失败列表耗时:{}", times);
        return iGenerator.convert(list, PersonStockDTO.class);
    }

    @Override
    public List<PersonStockDTO> getAllPersonStockList(PersonStockQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonStockQueryCnd cnd = iGenerator.convert(cndDTO, PersonStockQueryCnd.class);
        List<PersonStockViewDO> list = personStockManager.getAllPersonStockList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取全部员工股份列表耗时:{}", times);
        return iGenerator.convert(list, PersonStockDTO.class);
    }
}
