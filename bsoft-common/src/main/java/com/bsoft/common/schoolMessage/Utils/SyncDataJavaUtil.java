package com.bsoft.common.schoolMessage.Utils;

import com.bsoft.common.schoolMessage.QidaSHA256;
import com.bsoft.common.schoolMessage.ResultJavaEntity;
import com.bsoft.common.schoolMessage.ResultJavaRegisterEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SyncDataJavaUtil {

    /**
     * 获取企业大学接口数据
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static ResultJavaEntity getResult(String url, String params) throws IOException {
        String result = null;
        try {
            result = OKHttp2Utils.sendPost(url, params);
        } catch (IOException e) {
            try {
                // 发生异常重新请求一次
                result = OKHttp2Utils.sendPost(url, params);
            } catch (IOException e1) {
                throw new IOException("获取企业大学接口数据失败!", e1);
            }
        }
        // 统一将返回值封装为实体
        JSONObject jsonObject = JSONObject.fromObject(result);
        return (ResultJavaEntity) JSONObject.toBean(jsonObject, ResultJavaEntity.class);
    }

    /**
     * 初始化公共参数
     *
     * @param apikey
     * @param secretkey
     * @return
     */
    public static JSONObject getPublicParam(String apikey, String secretkey) {
        JSONObject params = new JSONObject();
        params.put("apikey", apikey);
        params.put("salt", new Random().nextInt(10000));
        params.put("signature", QidaSHA256.SHA256Encrypt(secretkey + params.get("salt")));
        System.out.println(QidaSHA256.SHA256Encrypt(secretkey + params.get("salt")));
        return params;
    }

    public static ResultJavaEntity arrayOp(List<String> strings, String url, String apikey, String secretkey)
            throws IOException {
        JSONObject params = getPublicParam(apikey, secretkey);
        JSONArray array = JSONArray.fromObject(strings);
        params.put("datas", array.toString());
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    public static ResultJavaRegisterEntity registerOp(String strings, String url, String apikey, String secretkey)
            throws IOException {
        JSONObject params = getPublicParam(apikey, secretkey);
//        JSONArray array = JSONArray.fromObject(strings);
        params.put("uname", strings);
        return SyncDataJavaUtil.getRegisterResult(url, params.toString());
    }



    public static ResultJavaRegisterEntity getRegisterResult(String url, String params) throws IOException {
        String result = null;
        try {
            result = OKHttp2Utils.sendPost(url, params);
        } catch (IOException e) {
            try {
                // 发生异常重新请求一次
                result = OKHttp2Utils.sendPost(url, params);
            } catch (IOException e1) {
                throw new IOException("获取企业大学接口数据失败!", e1);
            }
        }
        // 统一将返回值封装为实体
        JSONObject jsonObject = JSONObject.fromObject(result);
        return (ResultJavaRegisterEntity) JSONObject.toBean(jsonObject, ResultJavaRegisterEntity.class);
//        return (ResultJavaEntity) JSONObject.toBean(jsonObject, ResultJavaEntity.class);
    }
}
