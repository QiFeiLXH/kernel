package com.bsoft.word.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.result.Result;
import com.bsoft.file.document.common.result.FileResult;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import com.bsoft.file.document.file.dto.WdFileDefinitionCndDTO;
import com.bsoft.file.document.file.service.FileService;
import com.bsoft.menu.dao.primary.MenuDao;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.entity.primary.MenuDO;
import com.bsoft.word.condition.WordFileRecordQueryCnd;
import com.bsoft.word.dto.WordFileRecordDTO;
import com.bsoft.word.entity.second.WordFileRecordDO;
import com.bsoft.word.manager.WordFileRecordManager;
import com.bsoft.word.repository.second.WordFileRecordRepository;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class WordFileRecordManagerImpl implements WordFileRecordManager {

    @Reference(protocol = "hessian",check=false,timeout = 10000)
    private FileService fileService;
    @Autowired
    private WordFileRecordRepository wordFileRecordRepository;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public WordFileRecordDTO getRecordById(Integer id) {
        WordFileRecordDO wordFileRecordDO =  wordFileRecordRepository.selectById(id);
        return iGenerator.convert(wordFileRecordDO, WordFileRecordDTO.class);
    }

    @Override
    public List<MenuDTO> getFileMenu(){
        //查询已有菜单
        List<WordFileRecordDO> wordFileRecordDOS = wordFileRecordRepository.selectFileMenu();

        //根据已有菜单查菜单列表
        List<Integer> menuList = new ArrayList<>();
        for (WordFileRecordDO recordDO: wordFileRecordDOS){
            menuList.add(recordDO.getMenuId());
        }
        List<MenuDO> menuDOS = menuDao.findByIdIn(menuList);

        //找到所有菜单列表的父级
        List<Integer> parentIdList = new ArrayList<>();
        for(MenuDO menuDO:menuDOS){
            Integer parentId = menuDO.getParentId();
            if(parentId !=0 ){
                parentIdList.add(parentId);
            }
        }
        List<MenuDO> menuParentDOS = menuDao.findByIdIn(parentIdList);
        menuDOS.addAll(menuParentDOS);

        List<MenuDTO> menuDTOS = iGenerator.convert(menuDOS, MenuDTO.class);
        return menuDTOS;
    }

    @Override
    public PageInfo<WordFileRecordDO> getYearMenu(WordFileRecordQueryCnd queryCnd){
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<WordFileRecordDO> wordFileRecordDOS = wordFileRecordRepository.selectYearMenu(queryCnd.getMenuId());
        PageInfo<WordFileRecordDO> pageInfo = new PageInfo<>(wordFileRecordDOS);
        return pageInfo;
    }

    @Override
    public PageInfo<WordFileRecordDO> getMonthMenu(WordFileRecordQueryCnd queryCnd){
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<WordFileRecordDO> wordFileRecordDOS = wordFileRecordRepository.selectMonthMenu(queryCnd.getMenuId(), queryCnd.getFileYear());
        PageInfo<WordFileRecordDO> pageInfo = new PageInfo<>(wordFileRecordDOS);
        return pageInfo;
    }

    @Override
    public Result<WordFileRecordDTO> getByLimit(WordFileRecordQueryCnd queryCnd) {
        WdFileDefinitionCndDTO cndDTO = iGenerator.convert(queryCnd, WdFileDefinitionCndDTO.class);
        FileResult<FileDefinitionDTO> result = fileService.getWordFileRecord(cndDTO);
        return iGenerator.convert(result, WordFileRecordDTO.class);
    }

    @Override
    public PageInfo<WordFileRecordDO> getFileList(WordFileRecordQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<WordFileRecordDO> wordFileRecordDOS = wordFileRecordRepository.selectByLimit(queryCnd);
        PageInfo<WordFileRecordDO> pageInfo = new PageInfo<>(wordFileRecordDOS);
        return pageInfo;
    }

    @Override
    @Transactional
    public void removeFile(Integer id) {
        fileService.remove(id);
        wordFileRecordRepository.deleteRecordById(id);
    }

    @Override
    @Transactional
    public void changeFile(WordFileRecordDO wordFileRecordDO) {
        Integer id = wordFileRecordDO.getId();
        String fileName = wordFileRecordDO.getFileName();
        byte[] fileData = wordFileRecordDO.getData();
        fileService.update(id, fileName, fileData);
        wordFileRecordRepository.updateFileRecord(wordFileRecordDO);
    }

}
