package com.bsoft.common.nuonuo;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 18:52
 * @Description: 自动开票，http请求
 */
public class HttpRequest {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequest.class);
    /**
     * @param SendUrl 请求接口URL
     * @param order 请求体
     */
    public static String httpRequest(String SendUrl,String order){
        String info = "";
        logger.info("请求诺诺开票URL:[{}],请求体:[{}]",SendUrl,order);
        order= DESDZFP.encrypt(order);
        HttpClient httpclient=null;
        PostMethod post=null;
        try {
            httpclient = new HttpClient() ;
            post = new PostMethod(SendUrl);
            //设置编码方式
            post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
            //添加参数
            post.addParameter("order",order);
            httpclient.executeMethod(post);
            InputStream inputStream = post.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String str= "";
            while((str = br.readLine()) != null){
                stringBuffer.append(str);
            }
            logger.info("请求诺诺开票接口成功，返回数据[{}]", stringBuffer.toString());
            return stringBuffer.toString();
        } catch (IOException e) {
            logger.info("请求诺诺开票接口失败！");
            e.printStackTrace();
        }finally {
            //关闭连接，释放资源
            post.releaseConnection();
            ((SimpleHttpConnectionManager)httpclient.getHttpConnectionManager()).shutdown();
        }
        return info;
    }
}
