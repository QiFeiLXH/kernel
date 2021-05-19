package com.bsoft.common.manager;

import com.bsoft.common.entity.primary.PublicDicDO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/13 10:35
 * @Description
 */
public interface FileUploadTypeManager {
    /** 获取可上传文件类型列表
     * @return List<PublicDicDO>
     * @author Xuhui Lin
     */
    List<PublicDicDO> getFileUploadType();
}
