package com.bsoft.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 20:04
 * @Description: 根据URL下载文件
 */
public class URLDownloader {
    private static Logger logger = LoggerFactory.getLogger(URLDownloader.class);

    //获取链接地址文件的byte数据
    public static byte[] getUrlFileData(String fileUrl){
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.connect();
            InputStream cin = httpConn.getInputStream();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = cin.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            cin.close();
            byte[] fileData = outStream.toByteArray();
            outStream.close();
            logger.error("根据Url获取文件byte成功！,[{}]",fileUrl);
            return fileData;
        }catch (Exception e){
            logger.error("根据Url获取文件byte失败！,[{}]",fileUrl);
            return null;
        }
    }


        //获取文件后缀名
    public static String getFileNameFromUrl(String url){
        String times = new Long(System.currentTimeMillis()).toString();
        int index = url.lastIndexOf(".");
        String fileType = url.substring(index + 1)!=""?url.substring(index + 1):"pdf";
        return times.concat(".").concat(fileType);
    }
}
