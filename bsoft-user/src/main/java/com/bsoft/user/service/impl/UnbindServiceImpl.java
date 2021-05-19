package com.bsoft.user.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.dto.InvoiceLibraryDTO;
import com.bsoft.user.condition.UnbindQueryCnd;
import com.bsoft.user.dao.primary.PersonContactDao;
import com.bsoft.user.dto.UnbindDTO;
import com.bsoft.user.dto.UnbindQueryCndDTO;
import com.bsoft.user.dto.UnbindViewDTO;
import com.bsoft.user.entity.primary.PersonContactDO;
import com.bsoft.user.entity.primary.UnbindDO;
import com.bsoft.user.entity.primary.UnbindViewDO;
import com.bsoft.user.manager.UnbindManager;
import com.bsoft.user.service.UnbindService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Service
public class UnbindServiceImpl implements UnbindService {
    private static final Logger logger = LoggerFactory.getLogger(UnbindServiceImpl.class);
    @Autowired
    private UnbindManager unbindManager;
    @Autowired
    private IGenerator generator;
    @Autowired
    private PersonContactDao personContactDao;
    @Override
    public UnbindDTO saveUnbind(UnbindDTO unbindDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        UnbindDO unbindDO = generator.convert(unbindDTO,UnbindDO.class);
        unbindDO = unbindManager.saveUnbind(unbindDO);
        long times = timeConsumer.end();
        logger.info("保存用户工号:{}的解绑信息耗时:{}",unbindDO.getPersonId(),times);
        return generator.convert(unbindDO,UnbindDTO.class);
    }

    @Override
    public UnbindDTO getUnbind(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        UnbindDO unbindDO = unbindManager.getUnbind(personId);
        if(unbindDO == null){
            return null;
        }
        long times = timeConsumer.end();
        logger.info("获取用户工号:{}的解绑信息耗时:{}",personId,times);
        return generator.convert(unbindDO,UnbindDTO.class);
    }

    @Override
    public void auditUnbind(UnbindDTO unbindDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer id = unbindDTO.getId();
        UnbindDO unbindDO = unbindManager.getUnbind(id);
        unbindDO.setAuditflag(unbindDTO.getAuditflag());
        unbindDO.setAuditter(unbindDTO.getAuditter());
        unbindDO.setAuditDate(unbindDTO.getAuditDate());
        unbindManager.saveUnbind(unbindDO);
        String personId = unbindDTO.getPersonId();
        if(unbindDTO.getAuditflag().equals(1)){
            PersonContactDO personContactDO = personContactDao.getAllByPersonid(personId);
            personContactDO.setPhoneModel("");
            personContactDO.setAppbindDate(null);
            personContactDao.save(personContactDO);
            unbindManager.unBindApp(personId);
        }
        long times = timeConsumer.end();
        logger.info("审核解绑用户APP工号:{}耗时:{}",personId,times);
    }

    @Override
    public Result<UnbindDTO> getUnbind(String personId, Integer auditFlag, Integer page, Integer size) {
        Page<UnbindViewDO> result = unbindManager.getUnbind(personId,auditFlag,page,size);
        return ResultUtils.parseResult(result,UnbindDTO.class);
    }

    @Override
    public UnbindDTO getUnbind(Integer id) {
        UnbindViewDO unbindDO =  unbindManager.getUnbindView(id);
        return generator.convert(unbindDO,UnbindDTO.class);
    }

    @Override
    public Result<UnbindViewDTO> getUnbindList(UnbindQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        UnbindQueryCnd queryCnd = generator.convert(queryCndDTO,UnbindQueryCnd.class);
        Page<UnbindViewDO> pages = unbindManager.getUnbindList(queryCnd);
        Result<UnbindViewDTO> result = ResultUtils.parseResult(pages, UnbindViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取App解绑申请列表耗时[{}]",times);
        return result;
    }
}
