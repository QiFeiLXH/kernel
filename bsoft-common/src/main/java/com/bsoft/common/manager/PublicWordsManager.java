package com.bsoft.common.manager;

import com.bsoft.common.entity.primary.PublicWordsDO;
import com.bsoft.common.entity.primary.PublicWordsViewDO;
import org.springframework.data.domain.Page;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/13 9:39
 * @Description 文档上传、下载功能
 */
public interface PublicWordsManager {

    /** 文件上传列表
     * @Param: pageNo 页码
     * @Param: pageSize 每页数据条数
     * @Param: mainId 主表id
     * @Param: menuId 菜单id
     * @Param: type 上传功能类别 默认1
     * @return
     * @author Xuhui Lin
     */
    Page<PublicWordsViewDO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer menuId, Integer type);

    /** 文件上传
     * @Param: publicWords 需上传文件
     * @return
     * @author Xuhui Lin
     */
    void savePublicWords(PublicWordsDO publicWords);

    /** 文件删除
     * @Param: fileId 文件服务器文件id
     * @Param: wordId PublicWords  id
     * @return
     * @author Xuhui Lin
     */
    void deleteFile(Integer fileId, Integer wordId);

    /** 文件下载
     * @Param: fileId 文件服务器文件id
     * @Param: wordId PublicWords  id
     * @return
     * @author Xuhui Lin
     */
    PublicWordsDO getPublicWords(Integer fileId, Integer wordId);

    /** 文件下载（添加水印）
     * @Param: fileId 文件服务器文件id
     * @Param: wordId PublicWords  id
     * @Param: personId 员工工号
     * @return
     * @author Xuhui Lin
     */
    PublicWordsDO getWaterMarkPublicWords(Integer fileId, Integer wordId, String personId);

    Page<PublicWordsViewDO> getPublicWordsListWithWordType(Integer pageNo, Integer pageSize, Integer mainId, Integer type, Integer wordType);
}
