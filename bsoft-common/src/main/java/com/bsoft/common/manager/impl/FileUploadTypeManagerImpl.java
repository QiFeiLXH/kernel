package com.bsoft.common.manager.impl;

import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.FileUploadTypeManager;
import com.bsoft.common.manager.PublicDicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/13 10:39
 * @Description
 */
@Component
public class FileUploadTypeManagerImpl implements FileUploadTypeManager {
    @Autowired
    private PublicDicManager publicDicManager;
    @Override
    public List<PublicDicDO> getFileUploadType() {
        List<PublicDicDO> fileTypes = publicDicManager.getPublicDic(2002); //获取上传格式
        return fileTypes;
    }
}
