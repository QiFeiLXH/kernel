package com.bsoft.common.service;

import com.bsoft.common.dto.FileServerDefinitionDTO;

/**
 * @Author: xucl
 * @DateTime: 2020/12/7 15:10
 * @Description:
 */
public interface HelpWordService {
    FileServerDefinitionDTO getHelpWord(Integer fileId,String personId);
}
