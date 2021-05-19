package com.bsoft.common.manager.impl;

import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import com.bsoft.file.document.file.service.FileService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class FileServerManagerImpl implements FilerServerManager {
    @Reference(protocol = "hessian",check=false,timeout = 10000)
    private FileService fileService;
    @Override
    public Integer save(String fileName, byte[] data) {
        return fileService.save(0,fileName,data);
    }

    @Override
    public Integer save(Integer menuId, String fileName, byte[] data) {
        return fileService.save(menuId,fileName,data);
    }

    @Override
    public void update(Integer key, String fileName, byte[] data) {
        fileService.update(key,fileName,data);
    }

    @Override
    public FileDefinitionDTO get(Integer key) {
        return fileService.get(key);
    }

    @Override
    public void remove(Integer key) {
        fileService.remove(key);
    }

    @Override
    public FileDefinitionDTO getFileInfo(Integer key) {
        return fileService.getFileInfo(key);
    }
}
