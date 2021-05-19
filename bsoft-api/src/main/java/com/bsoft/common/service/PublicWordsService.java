package com.bsoft.common.service;

import com.bsoft.common.dto.PublicWordsDTO;
import com.bsoft.common.dto.PublicWordsViewDTO;
import com.bsoft.common.result.Result;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/13 10:12
 * @Description
 */
public interface PublicWordsService {

    /** 获取上传文件列表
     * @Param: pageNo 页码
     * @Param: pageSize 每页条数
     * @Param: mainId 主表id
     * @Param: menuId 菜单id
     * @Param: type 上传功能模块类别 默认1
     * @return Result<PublicWordsViewDTO>
     * @author Xuhui Lin
     */
    Result<PublicWordsViewDTO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer menuId, Integer type);

    /** 获取上传文件列表
     * @Param: pageNo 页码
     * @Param: pageSize 每页条数
     * @Param: mainId 主表id
     * @Param: type 上传功能模块类别 默认1
     * @Param: wordType
     * @return Result<PublicWordsViewDTO>
     * @author Xuhui Lin
     */
    Result<PublicWordsViewDTO> getPublicWordsListWithWordType(Integer pageNo, Integer pageSize, Integer mainId, Integer type, Integer wordType);

    /** 上传文件
     * @Param: publicWordsDTO 待上传文件
     * @author Xuhui Lin
     */
    void savePublicWords(PublicWordsDTO publicWordsDTO);

    /** 删除上传文件
     * @Param: fileId 文件服务器文件id
     * @Param: wordId 资料id
     * @author Xuhui Lin
     */
    void deleteFile(Integer fileId, Integer wordId);

    /** 下载文件
     * @Param: fileId 文件服务器文件id
     * @Param: wordId 资料id
     * @Param: personId 员工id
     * @return PublicWordsDTO
     * @author Xuhui Lin
     */
    PublicWordsDTO getPublicWords(Integer fileId, Integer wordId);

    /** 下载文件（带水印）
     * @Param: fileId 文件服务器文件id
     * @Param: wordId 资料id
     * @Param: personId 员工id
     * @return PublicWordsDTO
     * @author Xuhui Lin
     */
    PublicWordsDTO getWaterMarkPublicWords(Integer fileId, Integer wordId, String personId);
}
