package com.bsoft.common.schoolMessage.manager;


import com.bsoft.common.schoolMessage.ResultJavaEntity;
import com.bsoft.common.schoolMessage.Utils.SyncDataJavaUtil;
import com.bsoft.dept.dto.CloudschoolDeptSyncDTO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class SchoolDeptSyncManager {

    /**
     * 同步组织单位
     *
     * @param isBaseInfo
     * @param ouInfos
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity ous(int isBaseInfo, List<CloudschoolDeptSyncDTO> ouInfos, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONArray array = JSONArray.fromObject(ouInfos);
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("isbaseinfo", isBaseInfo);
        params.put("datas", array);
        String url = baseUrl + "udp/sy/ous";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 同步删除组织单位
     *
     * @param ouCodes   部门编号列表 JSON格式例如 ["java01", "java02"]
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity deleteous(List<String> ouCodes, String apikey, String secretkey, String baseUrl) throws IOException {
        String url = baseUrl + "udp/sy/deleteous";
        return SyncDataJavaUtil.arrayOp(ouCodes, url, apikey, secretkey);
    }

    /**
     * 将用户从组织单位中移除
     *
     * @param userNames 用户名列表JSON格式例如：[“sum11”, “sum10”];
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity removeusersfromou(List<String> userNames, String apikey, String secretkey, String baseUrl) throws IOException {
        String url = baseUrl + "udp/sy/removeusersfromou";
        return SyncDataJavaUtil.arrayOp(userNames, url, apikey, secretkey);
    }

    /**
     * 将一批用户移动至新部门
     *
     * @param userNames 用户名列表JSON格式例如：[“sum11”, “sum10”]
     * @param newOuID   部门编号
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity batchchangeorgou(List<String> userNames, String newOuID, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        JSONArray array = JSONArray.fromObject(userNames);
        params.put("datas", array.toString());
        params.put("extendKey", newOuID);
        String url = baseUrl + "udp/sy/batchchangeorgou";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 同步设置部门主管
     *
     * @param userName
     * @param ouCode
     * @param isCancelManager 是否取消部门主管
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity setmanager(String userName, String ouCode, int isCancelManager, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("extendKey", userName);
        params.put("masterKey", ouCode);
        params.put("isCancelManager", isCancelManager);
        String url = baseUrl + "udp/sy/setmanager";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }
}
