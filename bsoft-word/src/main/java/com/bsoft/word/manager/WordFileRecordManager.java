package com.bsoft.word.manager;


import com.bsoft.common.result.Result;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.word.condition.WordFileRecordQueryCnd;
import com.bsoft.word.dto.WordFileRecordDTO;
import com.bsoft.word.entity.second.WordFileRecordDO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WordFileRecordManager {

    /**
     * 按id获取
     */
    WordFileRecordDTO getRecordById(Integer id);

    /**
     * 获取文件菜单
     */
    List<MenuDTO> getFileMenu();

    /**
     *  获取年份列表
     */
    PageInfo<WordFileRecordDO> getYearMenu(WordFileRecordQueryCnd queryCnd);

    /**
     *  获取月份列表
     */
    PageInfo<WordFileRecordDO> getMonthMenu(WordFileRecordQueryCnd queryCnd);

    /**
     * 获取文件列表(文件服务器获取)
     */
    Result<WordFileRecordDTO> getByLimit(WordFileRecordQueryCnd queryCnd);

    /**
     * 获取文件列表
     */
    PageInfo<WordFileRecordDO> getFileList(WordFileRecordQueryCnd queryCnd);
    /**
     * 删除文件
     * @param id
     */
    void removeFile(Integer id);

    /**
     * 重传文件
     * @param
     */
    void changeFile(WordFileRecordDO wordFileRecordDO);
}
