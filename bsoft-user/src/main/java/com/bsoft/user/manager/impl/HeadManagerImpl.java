package com.bsoft.user.manager.impl;

import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import com.bsoft.file.document.file.service.FileService;
import com.bsoft.user.manager.HeadManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class HeadManagerImpl implements HeadManager {

    @Reference(protocol = "hessian",check = false)
    private FileService fileService;

    @Override
    public Integer writeHead(byte[] data,String fileName,Integer menuId) {
        return fileService.save(menuId,fileName,data);
    }

    @Override
    public byte[] readHead(Integer key) {
        if(key == null){
            return null;
        }
        FileDefinitionDTO fileDefinitionDTO = fileService.get(key);
        byte[] bytes = fileDefinitionDTO.getData();
        return bytes;
    }
}
