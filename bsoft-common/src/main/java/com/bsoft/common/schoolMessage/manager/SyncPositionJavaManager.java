package com.bsoft.common.schoolMessage.manager;

import com.bsoft.common.schoolMessage.ResultJavaEntity;
import com.bsoft.common.schoolMessage.Utils.SyncDataJavaUtil;
import com.bsoft.person.dto.CloudschoolRestypeSynDTO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SyncPositionJavaManager {

    /**
     * 同步岗位
     *
     * @param positions
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity position(List<CloudschoolRestypeSynDTO> positions, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONArray array = JSONArray.fromObject(positions);
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("datas", array);
        String url = baseUrl + "udp/sy/position";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }


    /**
     * 同步更改岗位名称
     *
     * @param positionNo   岗位编号
     * @param positionName 岗位名称(修改后)
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity updatePositionInfo(String positionNo, String positionName, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("positionNo", positionNo);
        params.put("positionName", positionName);
        String url = baseUrl + "udp/sy/updatepositioninfo";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

    /**
     * 查询岗位编号
     *
     * @param positionName 2级岗位类别;岗位名称1
     * @param apikey
     * @param secretkey
     * @param baseUrl
     * @return
     * @throws IOException
     */
    public ResultJavaEntity getPnoByPname(String positionName, String apikey, String secretkey, String baseUrl) throws IOException {
        JSONObject params = SyncDataJavaUtil.getPublicParam(apikey, secretkey);
        params.put("extendKey", positionName);
        String url = baseUrl + "udp/sy/getpnobypname";
        return SyncDataJavaUtil.getResult(url, params.toString());
    }

}
