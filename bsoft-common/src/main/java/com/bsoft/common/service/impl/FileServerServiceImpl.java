package com.bsoft.common.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.common.service.FileServerService;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(protocol = {"dubbo","hessian"})
public class FileServerServiceImpl implements FileServerService {
    @Autowired
    private FilerServerManager fileManager;
    @Autowired
    private IGenerator generator;
    @Override
    public Integer savePublic(String fileName, byte[] data) {
        return fileManager.save(fileName,data);
    }

    @Override
    public Integer saveWithMenu(Integer menuId, String fileName, byte[] data) {
        return fileManager.save(menuId,fileName,data);
    }

    @Override
    public void update(Integer key, String fileName, byte[] data) {
        fileManager.update(key,fileName,data);
    }

    @Override
    public FileServerDefinitionDTO get(Integer key) {
        FileDefinitionDTO fileDefinitionDTO = fileManager.get(key);
        return generator.convert(fileDefinitionDTO,FileServerDefinitionDTO.class);
    }

    @Override
    public void remove(Integer key) {
        fileManager.remove(key);
    }

    @Override
    public FileServerDefinitionDTO getFileInfo(Integer key) {
        FileDefinitionDTO fileDefinitionDTO = fileManager.getFileInfo(key);
        return generator.convert(fileDefinitionDTO,FileServerDefinitionDTO.class);
    }
}
