package com.bsoft.word.service;


import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.word.dto.WordFileRecordDTO;
import com.bsoft.word.dto.WordFileRecordQueryCndDTO;

import java.util.List;

public interface WordFileRecordService {



    /**
     * 根据id获取文件
     * @param id
     * @return List<com.bsoft.menu.dto.MenuDTO;>
     */
    WordFileRecordDTO getRecordById(String userId, Integer id);

    /**
     * 获取文件菜单列表
     * @return List<com.bsoft.menu.dto.MenuDTO;>
     */
    List<MenuDTO> getFileMenu(String userId);

    /**
     * 获取年份列表
     * @param queryCndDTO
     * @return List<com.bsoft.word.dto.WordFileRecordDTO>
     */
    Result<WordFileRecordDTO> getYearMenu(String userId, WordFileRecordQueryCndDTO queryCndDTO);

    /**
     * 获取月份列表
     * @param queryCndDTO
     * @return List<com.bsoft.word.dto.WordFileRecordDTO>
     */
    Result<WordFileRecordDTO> getMonthMenu(String userId, WordFileRecordQueryCndDTO queryCndDTO);

    /**
     * 条件获取文件列表
     * @param queryCndDTO
     * @return List<com.bsoft.word.dto.WordFileRecordDTO>
     */
    Result<WordFileRecordDTO> getFileList(String userId, WordFileRecordQueryCndDTO queryCndDTO);

    /**
     * 删除文件
     * @param id
     */
    void removeFile(String userId, Integer id);

    /**
     * 更新文件
     * @param wordFileRecordDTO
     */
    void changeFile(String userId, WordFileRecordDTO wordFileRecordDTO);

    /**
     * 获取文件上传类型
     * @return List<PublicDicDTO>
     */
    List<PublicDicDTO> getFileUploadType(String userId);
}
