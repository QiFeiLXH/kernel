package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.PublicWordsDao;
import com.bsoft.common.dao.primary.PublicWordsViewDao;
import com.bsoft.common.entity.primary.PublicWordsDO;
import com.bsoft.common.entity.primary.PublicWordsViewDO;
import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.common.manager.PublicWordsManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.utils.WaterMarkUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/13 9:41
 * @Description
 */
@Component
public class PublicWordsManagerImpl implements PublicWordsManager {
    @Autowired
    private FilerServerManager filerServerManager;
    @Autowired
    private PublicWordsViewDao publicWordsViewDao;
    @Autowired
    private PublicWordsDao publicWordsDao;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public Page<PublicWordsViewDO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer menuId, Integer type) {
        Sort sort = Sort.by("uploadDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<PublicWordsViewDO> pages = publicWordsViewDao.findAllByMainIdAndMenuIdAndType(mainId, menuId, type, pageable);
        return pages;
    }

    @Override
    public void savePublicWords(PublicWordsDO publicWords) {
        // 将文件保存到文件服务器上
        Integer fileId = filerServerManager.save(publicWords.getMenuId(), publicWords.getFileName(), publicWords.getFileBytes());
        Date currentDate = serverDateManager.getServerDateTime();
        publicWords.setUploadDate(currentDate);
        publicWords.setFileId(fileId);
        publicWordsDao.save(publicWords);
    }

    @Override
    public void deleteFile(Integer fileId, Integer wordId) {
        // 删除文件服务器文件
        filerServerManager.remove(fileId);
        // 删除PublicWords记录
        publicWordsDao.deleteById(wordId);
    }

    @Override
    public PublicWordsDO getPublicWords(Integer fileId, Integer wordId) {
        FileDefinitionDTO file = filerServerManager.get(fileId);
        Optional<PublicWordsDO> word = publicWordsDao.findById(wordId);
        PublicWordsDO wordDO = word.orElseThrow(()->new ServiceException("没有该文件！"));
        wordDO.setFileBytes(file.getData());
        return wordDO;
    }

    @Override
    public PublicWordsDO getWaterMarkPublicWords(Integer fileId, Integer wordId, String personId) {
        FileDefinitionDTO file = filerServerManager.get(fileId);
        Optional<PublicWordsDO> word = publicWordsDao.findById(wordId);
        PublicWordsDO wordDO = word.orElseThrow(()->new ServiceException("没有该文件！"));
        // 文档下载，若文档为pdf类型则添加水印
        byte[] dataBytes = WaterMarkUtils.setWaterMark(file.getData(), file.getFileName(), personId);
        wordDO.setFileBytes(dataBytes);
        return wordDO;
    }

    @Override
    public Page<PublicWordsViewDO> getPublicWordsListWithWordType(Integer pageNo, Integer pageSize, Integer mainId, Integer type, Integer wordType) {
        Sort sort = Sort.by("uploadDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<PublicWordsViewDO> pages = publicWordsViewDao.findAllByMainIdAndTypeAndWordType(mainId, type, wordType, pageable);
        return pages;
    }
}
