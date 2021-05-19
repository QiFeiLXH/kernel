package com.bsoft.common.key;

import com.bsoft.common.manager.WordKeyGeneratorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordKeyGenerator {
    @Autowired
    private WordKeyGeneratorManager wordKeyGeneratorManager;
    public Integer increaseDbFileId(String fileYear){
        return increase("WD_WDMX_"+fileYear);
    }

    private Integer increase(String table){
        return wordKeyGeneratorManager.nextKey(table);
    }
}
