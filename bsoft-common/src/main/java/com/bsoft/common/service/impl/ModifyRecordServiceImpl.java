package com.bsoft.common.service.impl;

import com.bsoft.common.condition.ModifyRecordQueryCnd;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.ModifyRecordDTO;
import com.bsoft.common.dto.ModifyRecordQueryCndDTO;
import com.bsoft.common.entity.primary.ModifyRecordViewDO;
import com.bsoft.common.manager.ModifyRecordManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.ModifyRecordService;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.common.utils.ResultUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/10 16:52
 * @Description
 */
@Service
public class ModifyRecordServiceImpl implements ModifyRecordService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyRecordServiceImpl.class);

    @Autowired
    private ModifyRecordManager modifyRecordManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<ModifyRecordDTO> getModifyRecordList(ModifyRecordQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ModifyRecordQueryCnd cnd = iGenerator.convert(cndDTO, ModifyRecordQueryCnd.class);
        Page<ModifyRecordViewDO> pages = modifyRecordManager.getModifyRecordList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取修改记录列表耗时:{}，查询条件：{}",times,JSONUtils.toString(cndDTO));
        return ResultUtils.parseResult(pages, ModifyRecordDTO.class);
    }
}
