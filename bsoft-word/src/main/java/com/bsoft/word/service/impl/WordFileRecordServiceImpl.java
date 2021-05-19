package com.bsoft.word.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.FileUploadTypeManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.word.condition.WordFileRecordQueryCnd;
import com.bsoft.word.dto.WordFileRecordQueryCndDTO;
import com.bsoft.word.dto.WordFileRecordDTO;
import com.bsoft.word.entity.second.WordFileRecordDO;
import com.bsoft.word.manager.WordFileRecordManager;
import com.bsoft.word.service.WordFileRecordService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WordFileRecordServiceImpl implements WordFileRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordFileRecordServiceImpl.class);
    @Autowired
    private WordFileRecordManager wordFileRecordManager;
    @Autowired
    private FileUploadTypeManager fileUploadTypeManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public WordFileRecordDTO getRecordById(String userId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WordFileRecordDTO wordFileRecordDTO = wordFileRecordManager.getRecordById(id);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]根据id获取文件记录耗时[{}]", userId, new Object[]{times});
        return wordFileRecordDTO;
    }

    @Override
    public List<MenuDTO> getFileMenu(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<MenuDTO> menuDTOS = wordFileRecordManager.getFileMenu();
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取文件菜单列表耗时[{}]", userId, new Object[]{times});
        return menuDTOS;
    }

    @Override
    public Result<WordFileRecordDTO> getYearMenu(String userId, WordFileRecordQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WordFileRecordQueryCnd queryCnd = iGenerator.convert(queryCndDTO, WordFileRecordQueryCnd.class);
        PageInfo<WordFileRecordDO> pageInfo = wordFileRecordManager.getYearMenu(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取文件年份列表耗时[{}]", userId, new Object[]{times});
        return ResultUtils.parseResult(pageInfo, WordFileRecordDTO.class);
    }

    @Override
    public Result<WordFileRecordDTO> getMonthMenu(String userId, WordFileRecordQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WordFileRecordQueryCnd queryCnd = iGenerator.convert(queryCndDTO, WordFileRecordQueryCnd.class);
        PageInfo<WordFileRecordDO> pageInfo = wordFileRecordManager.getMonthMenu(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取文件月份列表耗时[{}]", userId, new Object[]{times});
        return ResultUtils.parseResult(pageInfo, WordFileRecordDTO.class);
    }

    @Override
    public Result<WordFileRecordDTO> getFileList(String userId, WordFileRecordQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WordFileRecordQueryCnd queryCnd = iGenerator.convert(queryCndDTO, WordFileRecordQueryCnd.class);
        PageInfo<WordFileRecordDO> pageInfo = wordFileRecordManager.getFileList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取文件列表耗时[{}]", userId, new Object[]{times});
        return ResultUtils.parseResult(pageInfo, WordFileRecordDTO.class);
    }

    @Override
    public void removeFile(String userId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        wordFileRecordManager.removeFile(id);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]删除文件耗时[{}]", userId, new Object[]{times});
    }

    @Override
    public void changeFile(String userId, WordFileRecordDTO wordFileRecordDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WordFileRecordDO wordFileRecordDO = iGenerator.convert(wordFileRecordDTO, WordFileRecordDO.class);
        wordFileRecordManager.changeFile(wordFileRecordDO);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]更新文件耗时[{}]", userId, new Object[]{times});
    }

    @Override
    public List<PublicDicDTO> getFileUploadType(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicDicDO> fileUploadTypes = fileUploadTypeManager.getFileUploadType();
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取文件上传类型耗时[{}]", userId, new Object[]{times});
        return iGenerator.convert(fileUploadTypes, PublicDicDTO.class);
    }
}
