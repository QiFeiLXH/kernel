package com.bsoft.system.service.boot.filter;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.json.FastJsonUtils;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import com.bsoft.file.document.file.service.FileService;
import com.bsoft.project.dto.ProjectWordDetailDTO;
import com.bsoft.system.processor.DictionaryProcessorOld;
import org.apache.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DubboSystemFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(DubboSystemFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        HashMap<String, Object> logContent = new HashMap<>();
        if(isFile(invocation)){
            logContent.put("args", "请求参数为文件内容");
        }else{
            logContent.put("args", invocation.getArguments());
        }

        logContent.put("methodName", invocation.getMethodName());
        logContent.put("client", RpcContext.getContext().getRemoteAddressString());
        logContent.put("host", RpcContext.getContext().getLocalAddressString());
        Result result = null;
        try {
            long start = System.currentTimeMillis();
            result = invoker.invoke(invocation);
            long end = System.currentTimeMillis();
            logContent.put("elapsedtime", end - start);
            if (result.getException() != null) {
                logContent.put("exception", result.getException());
                logger.error("remote throw an exception, request url is {},param is {}.",
                        invoker.getUrl().getAbsolutePath(), FastJsonUtils.getBeanToJson(logContent));
            } else {
                logger.info("remote request url is {},param is {}.", invoker.getUrl().getAbsolutePath(),
                        FastJsonUtils.getBeanToJson(logContent));
            }
            logger.info("本次处理耗时：{}", end - start);
        } catch (Exception ex) {
            logger.error("remote throw an exception, request url is {},param is {}.", invoker.getUrl().getAddress(),
                    ex.getCause());
            throw ex;
        }
        return result;
    }

    @Override
    public Result onResponse(Result result, Invoker<?> invoker, Invocation invocation) {
        long start = System.currentTimeMillis();
        DictionaryProcessorOld.process(result.getValue());
        long end = System.currentTimeMillis();
        logger.info("本次处理字典耗时：{}",end - start);
        if(result.getValue() instanceof FileDefinitionDTO || result.getValue() instanceof ProjectWordDetailDTO || result.getValue() instanceof FileServerDefinitionDTO || result.getValue() instanceof byte[]){
            logger.info("reponse url is {}",invoker.getUrl().getAbsolutePath());
        }else{
            logger.info("reponse url is {},param is {}",invoker.getUrl().getAbsolutePath(),FastJsonUtils.getBeanToJson(result));
        }

        return result;
    }

    private Boolean isFile(Invocation invocation){
        Object[] objects = invocation.getArguments();
        for(int i=0;i<objects.length;i++){
            if(objects[i] instanceof FileDefinitionDTO || objects[i] instanceof FileServerDefinitionDTO || objects[i] instanceof byte[]){
                return true;
            }
        }
        return false;
    }

}
