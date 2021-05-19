package com.bsoft.opinion.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.opinion.condition.OpinionQueryCnd;
import com.bsoft.opinion.dto.OpinionDTO;
import com.bsoft.opinion.dto.OpinionQueryCndDTO;
import com.bsoft.opinion.entity.primary.OpinionDO;
import com.bsoft.opinion.entity.primary.OpinionViewDO;
import com.bsoft.opinion.manager.OpinionManager;
import com.bsoft.opinion.service.OpinionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.List;

@Service(protocol = {"hessian","dubbo"})
public class OpinionServiceImpl implements OpinionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpinionServiceImpl.class);
    @Autowired
    private OpinionManager opinionManager;
    @Autowired
    private IGenerator generator;
    @Override
    public OpinionDTO saveOpinion(OpinionDTO opinion) {
        OpinionDO opinionDO = generator.convert(opinion,OpinionDO.class);
        opinionDO = opinionManager.saveOpinion(opinionDO);
        return generator.convert(opinionDO,OpinionDTO.class);
    }

    @Override
    public OpinionDTO getOpinion(Integer id) {
        OpinionViewDO opinion = opinionManager.getOpinionView(id);
        OpinionDTO opinionDTO = generator.convert(opinion,OpinionDTO.class);
        String names = opinion.getPath();
        if(StringUtils.isNotBlank(names)){
            List<byte[]> images = opinionManager.readOpinionImages(names);
            opinionDTO.setImages(images);
        }
        return opinionDTO;
    }

    @Override
    public Result<OpinionDTO> getAppOpinion(String personId, Integer page, Integer size) {
        Page<OpinionViewDO> result = opinionManager.getAppOpinionViews(personId,page,size);
        Result<OpinionDTO> resultDTO = ResultUtils.parseResult(result,OpinionDTO.class);
        return resultDTO;
    }

    @Override
    public Result<OpinionDTO> getWebOpinion(String personId, Integer status, Integer page, Integer size) {
        Page<OpinionViewDO> result = opinionManager.getWebOpinionViews(personId,status,page,size);
        return ResultUtils.parseResult(result,OpinionDTO.class);
    }

    @Override
    @Transactional
    public OpinionDTO submitOpinion(OpinionDTO opinion) {
        OpinionDO opinionDO = generator.convert(opinion,OpinionDO.class);
        List<byte[]> images = opinion.getImages();
        String names = opinionManager.writeOpinionImages(images);
        opinionDO.setPath(names);
        opinionDO = opinionManager.submitOpinion(opinionDO);
        return generator.convert(opinionDO,OpinionDTO.class);
    }

    @Override
    public OpinionDTO feedbackOpinion(OpinionDTO opinion) {
        OpinionDO opinionDO = generator.convert(opinion,OpinionDO.class);
        opinionDO = opinionManager.feedbackOpinion(opinionDO);
        return generator.convert(opinionDO,OpinionDTO.class);
    }

    @Override
    public Result<OpinionDTO> getOpinions(OpinionQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OpinionQueryCnd cnd = generator.convert(cndDTO,OpinionQueryCnd.class);
        Page<OpinionViewDO> page = opinionManager.getOponions(cnd);
        Result<OpinionDTO> result = ResultUtils.parseResult(page,OpinionDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取意见列表耗时[{}]",times);
        return result;
    }

    @Override
    public OpinionDTO getOpinionById(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OpinionViewDO opinionViewDO = opinionManager.getOpinionById(id);
        OpinionDTO opinionDTO = generator.convert(opinionViewDO,OpinionDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取意见详细信息[{}]耗时[{}]",id,times);
        return opinionDTO;
    }

    @Override
    public byte[] getImageByte(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        byte[] data = opinionManager.getImageByte(id);
        long times = timeConsumer.end();
        LOGGER.info("获取意见字节图片[{}]耗时:{}",id,times);
        return data;
    }

    @Override
    public List<OpinionDTO> findAllOpinion(OpinionQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OpinionQueryCnd cnd = generator.convert(cndDTO,OpinionQueryCnd.class);
        List<OpinionViewDO> list = opinionManager.findAllOpinion(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取全部反馈意见耗时:{}",times);
        return generator.convert(list,OpinionDTO.class);
    }
}
