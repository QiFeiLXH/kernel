package com.bsoft.common.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicWordsDTO;
import com.bsoft.common.dto.PublicWordsViewDTO;
import com.bsoft.common.entity.primary.PublicWordsDO;
import com.bsoft.common.entity.primary.PublicWordsViewDO;
import com.bsoft.common.manager.PublicWordsManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicWordsService;
import com.bsoft.common.utils.ResultUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/13 10:13
 * @Description
 */
@Service
public class PublicWordsServiceImpl implements PublicWordsService {
    private static final Logger logger = LoggerFactory.getLogger(PublicWordsServiceImpl.class);
    @Autowired
    private PublicWordsManager publicWordsManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<PublicWordsViewDTO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer menuId, Integer type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<PublicWordsViewDO> pages = publicWordsManager.getPublicWordsList(pageNo, pageSize, mainId, menuId, type);
        long times = timeConsumer.end();
        logger.info("主表id：{}，菜单id: {},获取上传文件列表耗时:{}",mainId, menuId,times);
        return ResultUtils.parseResult(pages, PublicWordsViewDTO.class);
    }

    @Override
    public Result<PublicWordsViewDTO> getPublicWordsListWithWordType(Integer pageNo, Integer pageSize, Integer mainId, Integer type, Integer wordType) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<PublicWordsViewDO> pages = publicWordsManager.getPublicWordsListWithWordType(pageNo, pageSize, mainId, type, wordType);
        long times = timeConsumer.end();
        logger.info("主表id：{}，菜单id: {},获取上传文件列表耗时:{}",mainId, wordType,times);
        return ResultUtils.parseResult(pages, PublicWordsViewDTO.class);
    }

    @Override
    public void savePublicWords(PublicWordsDTO publicWordsDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PublicWordsDO publicWords = iGenerator.convert(publicWordsDTO, PublicWordsDO.class);
        publicWordsManager.savePublicWords(publicWords);
        long times = timeConsumer.end();
        logger.info("主表id:{}, 菜单id: {},上传文件耗时:{}",publicWordsDTO.getMainId(),publicWordsDTO.getMenuId(),times);
    }

    @Override
    public void deleteFile(Integer fileId, Integer wordId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        publicWordsManager.deleteFile(fileId, wordId);
        long times = timeConsumer.end();
        logger.info("文件:{}, 资料: {},删除文件耗时:{}",fileId,wordId,times);
    }

    @Override
    public PublicWordsDTO getPublicWords(Integer fileId, Integer wordId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PublicWordsDO word = publicWordsManager.getPublicWords(fileId, wordId);
        long times = timeConsumer.end();
        logger.info("文件id:{},资料id: {},下载文件耗时:{}",fileId,times);
        return iGenerator.convert(word, PublicWordsDTO.class);
    }

    @Override
    public PublicWordsDTO getWaterMarkPublicWords(Integer fileId, Integer wordId, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PublicWordsDO word = publicWordsManager.getWaterMarkPublicWords(fileId, wordId, personId);
        long times = timeConsumer.end();
        logger.info("文件id:{},资料id: {},下载水印文件耗时:{}",fileId,times);
        return iGenerator.convert(word, PublicWordsDTO.class);
    }
}
