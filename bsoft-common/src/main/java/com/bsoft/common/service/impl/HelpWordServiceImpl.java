package com.bsoft.common.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.common.service.HelpWordService;
import com.bsoft.common.utils.WaterMarkUtils;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: xucl
 * @DateTime: 2020/12/7 15:13
 * @Description:
 */
@Service
public class HelpWordServiceImpl implements HelpWordService {

    @Autowired
    private FilerServerManager filerServerManager;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public FileServerDefinitionDTO getHelpWord(Integer fileId, String personId) {
        FileDefinitionDTO fileServerDefinitionDTO = filerServerManager.get(fileId);
        String fileName = fileServerDefinitionDTO.getFileName();
        String fileType = WaterMarkUtils.getFileType(fileName);

        if (!fileType.equalsIgnoreCase("pdf")){
            return generatorUtil.convert(fileServerDefinitionDTO,FileServerDefinitionDTO.class);
        }else{
            byte[] dataBytes = WaterMarkUtils.setWaterMark(fileServerDefinitionDTO.getData(), fileServerDefinitionDTO.getFileName(), personId);
            fileServerDefinitionDTO.setData(dataBytes);
            return generatorUtil.convert(fileServerDefinitionDTO,FileServerDefinitionDTO.class);
        }
    }
}
