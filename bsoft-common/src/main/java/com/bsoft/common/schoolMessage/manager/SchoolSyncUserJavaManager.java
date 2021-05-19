package com.bsoft.common.schoolMessage.manager;

import com.bsoft.common.schoolMessage.ResultJavaEntity;
import com.bsoft.common.schoolMessage.ResultJavaRegisterEntity;
import com.bsoft.common.schoolMessage.Utils.SyncDataJavaUtil;
import com.bsoft.person.dto.CloudschoolUserSynDTO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SchoolSyncUserJavaManager {

    /**
     * 创建用户
     *
     * @param islink    是否同步用户基本信息
     * @param users
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity createusers(int islink, List<CloudschoolUserSynDTO> users, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONArray array = JSONArray.fromObject(users);
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("islink", islink);
        params.put("datas", array);
        String url = baseUrl + "udp/sy/sv/use";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 同步用户
     *
     * @param islink    是否同步用户基本信息
     * @param users
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity users(int islink, List<CloudschoolUserSynDTO> users, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONArray array = JSONArray.fromObject(users);
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("islink", islink);
        params.put("datas", array);
        String url = baseUrl + "udp/sy/users";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 同步禁用用户
     *
     * @param userNames
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity disabledusers(List<String> userNames, String apikey, String secretkey, String baseUrl) throws IOException {
        String url = baseUrl + "udp/sy/disabledusers";
        return SyncDataJavaUtil.arrayOp(userNames, url, apikey, secretkey);
    }

    /**
     * 同步删除用户
     *
     * @param userNames
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity deletedusers(List<String> userNames, String apikey, String secretkey, String baseUrl) throws IOException {
        String url = baseUrl + "udp/sy/deletedusers";
        return SyncDataJavaUtil.arrayOp(userNames, url, apikey, secretkey);
    }

    /**
     * 同步启用用户
     *
     * @param userNames
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity enabledusers(List<String> userNames, String apikey, String secretkey, String baseUrl) throws IOException {
        String url = baseUrl + "udp/sy/enabledusers";
        return SyncDataJavaUtil.arrayOp(userNames, url, apikey, secretkey);
    }

    /**
     * 同步校验用户是否存在
     *
     * @param userNames
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity checkusers(List<String> userNames, String apikey, String secretkey, String baseUrl) throws IOException {
        String url = baseUrl + "udp/sy/sv/cku";
        return SyncDataJavaUtil.arrayOp(userNames, url, apikey, secretkey);
    }

//    /**
//     * 自动建用户组
//     *
//     * @param groupMaps 关系数据信息
//     * @param groupName 业务组名称
//     * @param remark    用户组简介
//     * @param apikey
//     * @param secretkey
//     * @param baseUrl
//     * @return
//     * @throws IOException
//     */
//    public ResultJavaEntity groupadd(List<CloudschoolGroupSynDTO> groupMaps, String groupName, String remark, String apikey, String secretkey, String baseUrl) throws IOException {
//        JSONArray array = JSONArray.fromObject(groupMaps);
//        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
//        params.put("groupName", groupName);
//        params.put("remark", remark);
//        params.put("userGroupMaps", array);
//        String url = baseUrl + "udp/sy/groupadd";
//        return SyncDataJavaUtil.getResult(url, params.toString());
//    }

    /**
     * 同步角色删除人员
     *
     * @param userNames
     * @param roleNo    角色编号
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity roledeleteuser(List<String> userNames, String roleNo, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        JSONArray array = JSONArray.fromObject(userNames);
        params.put("extendKey", roleNo);
        params.put("datas", array.toString());
        String url = baseUrl + "udp/sy/rldeu";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 同步角色增加人员
     *
     * @param userNames
     * @param roleNo    角色编号
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity roleadduser(List<String> userNames, String roleNo, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        JSONArray array = JSONArray.fromObject(userNames);
        params.put("extendKey", roleNo);
        params.put("datas", array.toString());
        String url = baseUrl + "udp/sy/rladu";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 用户组添加人员
     *
     * @param masterNos 关系数据信息（人员账号或部门编号或岗位编号）格式如：["cuim@yunxuetang.cn","user001","user002"]
     * @param groupId   业务组ID
     * @param mapType   关系类型(固定值 部门：Department,岗位：Position,用户：User)
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity groupMapAdd(List<String> masterNos, String groupId, String mapType, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        JSONArray array = JSONArray.fromObject(masterNos);
        params.put("groupId", groupId);
        params.put("masterNo", array.toString());
        params.put("mapType", mapType);
        String url = baseUrl + "udp/sy/gmadd";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 用户组删除人员
     *
     * @param masterNos 关系数据信息（人员账号或部门编号或岗位编号）格式如：["cuim@yunxuetang.cn","user001","user002"]
     * @param groupId   业务组ID
     * @param mapType   关系类型(固定值 部门：Department,岗位：Position,用户：User)
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity groupMapDel(List<String> masterNos, String groupId, String mapType, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        JSONArray array = JSONArray.fromObject(masterNos);
        params.put("groupId", groupId);
        params.put("masterNo", array.toString());
        params.put("mapType", mapType);
        String url = baseUrl + "udp/sy/gmdel";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 同步增加直属经理
     *
     * @param datas
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity addmgr(List<CloudschoolUserSynDTO> datas, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONArray array = new JSONArray();
        for (CloudschoolUserSynDTO data : datas) {
            JSONObject param = new JSONObject();
            param.put("userId", data.getId());
//            param.put("managerNo", data.getManagerNo());
            array.add(param);
        }
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("datas", array);
        String url = baseUrl + "udp/sy/addmgr";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 同步更新直属经理
     *
     * @param datas
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity updmgr(List<CloudschoolUserSynDTO> datas, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONArray array = new JSONArray();
        for (CloudschoolUserSynDTO data : datas) {
            JSONObject param = new JSONObject();
            param.put("userId", data.getId());
//            param.put("managerNo", data.getManagerNo());
            array.add(param);
        }
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("datas", array);
        String url = baseUrl + "udp/sy/updmgr";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 同步删除直属经理
     *
     * @param userIds
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity delmgr(List<String> userIds, String apikey, String secretkey, String baseUrl) throws IOException {
        String url = baseUrl + "udp/sy/delmgr";
        return SyncDataJavaUtil.arrayOp(userIds, url, apikey, secretkey);
    }

    /**
     * 同步单点登录用户
     *
     * @param userNames
     * @param apikey
     * @param secretkey
     * @param registerUrl
     * @return
     * @throws IOException
     */
    public ResultJavaRegisterEntity registerUser(String userNames, String apikey, String secretkey, String registerUrl) throws IOException {
        String registerUrls = registerUrl +"el/sso";
        return SyncDataJavaUtil.registerOp(userNames, registerUrls, apikey, secretkey);
    }
}
