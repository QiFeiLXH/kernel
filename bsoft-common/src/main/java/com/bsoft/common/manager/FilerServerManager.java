package com.bsoft.common.manager;

import com.bsoft.file.document.file.dto.FileDefinitionDTO;

public interface FilerServerManager {
    /**
     * 保存文档（保存到公用模块）
     *
     * @param fileName 文档名称
     * @param data     文档内容
     * @return
     */
    Integer save(String fileName, byte[] data);

    /**
     * 保存文档（保存到相应菜单下）
     *
     * @param menuId   菜单ID
     * @param fileName 文档名称
     * @param data     文档内容
     * @return
     */
    Integer save(Integer menuId, String fileName, byte[] data);

    /**
     * 更新文档
     *
     * @param key      文档ID
     * @param fileName 新文档名称
     * @param data     新文档内容
     */
    void update(Integer key, String fileName, byte[] data);

    /**
     * 获取文档（包含文档内容）
     *
     * @param key 文档ID
     */
    FileDefinitionDTO get(Integer key);

    /**
     * 删除文档
     *
     * @param key 文档ID
     */
    void remove(Integer key);

    /**
     * 获取文档信息（不包含文档内容）
     *
     * @param key 文档ID
     */
    FileDefinitionDTO getFileInfo(Integer key);
}
