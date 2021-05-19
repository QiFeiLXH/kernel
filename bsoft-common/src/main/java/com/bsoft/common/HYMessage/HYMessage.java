package com.bsoft.common.HYMessage;

import com.alibaba.druid.support.json.JSONUtils;
import com.bsoft.exception.ServiceException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HYMessage {

    private static final Logger logger = LoggerFactory.getLogger(HYMessage.class);

    private static final String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";
    private static final String Account = "C50534371";
    private static final String Password = "faefecc343c3fbcc44f95cd7d923387e";

    public static Map<String, Object> sendHYMessage(String mobileno,String content){
        HashMap<String, Object> res = new HashMap<>();
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);
        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
        NameValuePair[] data = {//提交短信
                new NameValuePair("account", Account), //查看用户名 登录用户中心->验证码通知短信>产品总览->API接口信息->APIID
                new NameValuePair("password", Password), //查看密码 登录用户中心->验证码通知短信>产品总览->API接口信息->APIKEY
                new NameValuePair("mobile", mobileno),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String SubmitResult =method.getResponseBodyAsString();
            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();
            String code = root.elementText("code");
            if(code.equals("2")){
                res.put("code", "200");
                res.put("msg", "短信发送成功");
            }else if(code.equals("4085")){
                res.put("code", "4085");
                res.put("msg", "一天内发送短信验证码超过五次");
            }else{
                res.put("code", "201");
                res.put("msg", "短信发送失败");
            }
            logger.info("发送短信验证码[{}]", JSONUtils.toJSONString(res));
        } catch (HttpException e) {
            e.printStackTrace();
            logger.info("发送短信验证码失败[{}]", JSONUtils.toJSONString(e.getMessage()));
            throw new ServiceException("发送短信验证码失败！");
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("发送短信验证码失败[{}]", JSONUtils.toJSONString(e.getMessage()));
            throw new ServiceException("发送短信验证码失败！");
        } catch (DocumentException e) {
            e.printStackTrace();
            logger.info("发送短信验证码失败[{}]", JSONUtils.toJSONString(e.getMessage()));
            throw new ServiceException("发送短信验证码失败！");
        }
        return res;
    }
}
