package com.bsoft.person.manager.impl;

import com.bsoft.common.dao.primary.HumanDicDao;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.manager.HumanDicManager;
import com.bsoft.common.schoolMessage.ResultJavaEntity;
import com.bsoft.common.schoolMessage.manager.SchoolDeptSyncManager;
import com.bsoft.common.schoolMessage.manager.SchoolSyncUserJavaManager;
import com.bsoft.common.schoolMessage.manager.SyncPositionJavaManager;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.dept.dto.CloudschoolDeptSyncDTO;
import com.bsoft.dept.entity.primary.CloudschoolDeptSyncBackupDO;
import com.bsoft.dept.entity.primary.CloudschoolDeptSyncDO;
import com.bsoft.person.dao.primary.CloudschoolRestypeBackupDao;
import com.bsoft.person.dto.CloudschoolRestypeSynDTO;
import com.bsoft.person.entity.primary.CloudschoolUserBackupDO;
import com.bsoft.person.entity.primary.CloudshoolRestypeBackupDO;
import com.bsoft.person.manager.CloudschoolRestypeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CloudschoolRestypeManagerImpl implements CloudschoolRestypeManager {
    private static final Logger logger = LoggerFactory.getLogger(CloudschoolSynManagerImpl.class);

    @Autowired
    private CloudschoolRestypeBackupDao cloudschoolRestypeBackupDao;

    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private HumanDicManager humanDicManager;
    @Value("${yxt.baseurl}")
    private String baseUrl;
    @Value("${yxt.apikey}")
    private String apiKey;
    @Value("${yxt.secretkey}")
    private String secretKey;

    private SyncPositionJavaManager manager = SpringContextUtil.getBean(SyncPositionJavaManager.class);

    @Override
    public void SyncOneRestype() {
        //首次同步将备份表中所有数据全部同步到云学堂
        List<CloudshoolRestypeBackupDO> CloudshoolRestypeBackupDOS = cloudschoolRestypeBackupDao.findAll();
        //数据单条推送
        CloudshoolRestypeBackupDOS.forEach(cloudshoolRestypeBackupDO -> {
            List<CloudschoolRestypeSynDTO>  cloudschoolRestypeSynDTOS  = new ArrayList<>();
            CloudschoolRestypeSynDTO cloudschoolRestypeSynDTO = new CloudschoolRestypeSynDTO();
            cloudschoolRestypeSynDTO.setpNo(String.valueOf(cloudshoolRestypeBackupDO.getRestype()));
            //给岗位名称前面加上未分类
            cloudschoolRestypeSynDTO.setpNames("创业惠康岗位测试;"+cloudshoolRestypeBackupDO.getRestypeName());
            cloudschoolRestypeSynDTOS.add(cloudschoolRestypeSynDTO);
            try {
                ResultJavaEntity position = manager.position(cloudschoolRestypeSynDTOS, apiKey, secretKey, baseUrl);
                logger.info("岗位同步信息:{}",position);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void SyncRestype() {
        //现有岗位表
        List<HumanDicDO> byType = humanDicManager.getRestypeDic();
        //岗位备份表
        List<CloudshoolRestypeBackupDO> cloudshoolRestypeBackupDOS = cloudschoolRestypeBackupDao.findAll();
        //比较两个List  取出新增或者修改后的岗位数据 同步到云学堂
        List<HumanDicDO> restypeSyncDOS = getRestypeSyncDOS(byType, cloudshoolRestypeBackupDOS, 0);
        //单条请求发送同步
        restypeSyncDOS.forEach(humanDicDO -> {
            SyncRestype(manager,humanDicDO);
        });
    }

    public List<HumanDicDO> getRestypeSyncDOS(List<HumanDicDO> humanDicDOS,List<CloudshoolRestypeBackupDO> CloudshoolRestypeBackupDOS,int flag){
        List<HumanDicDO> humanDicDOList = new ArrayList<>();
        Map<HumanDicDO,Integer> map = new HashMap<>();
        //比较主表比备份表中多出来的值
        humanDicDOS.forEach(humanDicDO->{
            map.put(humanDicDO,1);
            CloudshoolRestypeBackupDOS.forEach(cloudshoolRestypeBackupDO->{
                if(humanDicDO.getId().equals(cloudshoolRestypeBackupDO.getRestype())){
                    //flag为1则只筛选出新增 ，为0则新增和更新都要筛选出来
                    if(flag==0){
                        if(humanDicDO.getName().equals(cloudshoolRestypeBackupDO.getRestypeName())||
                                (humanDicDO.getName()==null&&cloudshoolRestypeBackupDO.getRestypeName()==null)){
                            map.put(humanDicDO,2);
                        }
                    }else{
                        map.put(humanDicDO,2);
                    }
                }
            });
        });
        for(Map.Entry<HumanDicDO,Integer> m :map.entrySet()){
            if(m.getValue()==1){
                humanDicDOList.add(m.getKey());
            }
        }
        return humanDicDOList;
    }

    public void SyncRestype(SyncPositionJavaManager manager, HumanDicDO humanDicDO){
        try {
                List<CloudschoolRestypeSynDTO> cloudschoolRestypeSynDTOS = new ArrayList<>();
                CloudschoolRestypeSynDTO cloudschoolRestypeSynDTO = new CloudschoolRestypeSynDTO();
                cloudschoolRestypeSynDTO.setpNo(String.valueOf(humanDicDO.getId()));
                cloudschoolRestypeSynDTO.setpNames("未分类;"+humanDicDO.getName());
                cloudschoolRestypeSynDTOS.add(cloudschoolRestypeSynDTO);
                if(cloudschoolRestypeSynDTOS.size()!=0){
                    ResultJavaEntity result = manager.position(cloudschoolRestypeSynDTOS, apiKey, secretKey, baseUrl);
                    logger.info("云学堂同步的部门返回数据为：{}",result );
                    if(result.getResult()==1){
                        //部门同步成功没有异常则更新备份表。
                        CloudshoolRestypeBackupDO cloudshoolRestypeBackupDO= new CloudshoolRestypeBackupDO();
                        cloudshoolRestypeBackupDO.setRestype(humanDicDO.getId());
                        cloudshoolRestypeBackupDO.setRestypeName(humanDicDO.getName());
                        cloudschoolRestypeBackupDao.save(cloudshoolRestypeBackupDO);
                        logger.info("云学堂部门接口同步成功,更新备份表：{}",result);
                    }else {
                        logger.info("云学堂部门接口同步异常,备份表不更新：{}",result);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
