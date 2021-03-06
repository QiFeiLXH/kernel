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
        //???????????????????????????????????????????????????????????????
        List<CloudshoolRestypeBackupDO> CloudshoolRestypeBackupDOS = cloudschoolRestypeBackupDao.findAll();
        //??????????????????
        CloudshoolRestypeBackupDOS.forEach(cloudshoolRestypeBackupDO -> {
            List<CloudschoolRestypeSynDTO>  cloudschoolRestypeSynDTOS  = new ArrayList<>();
            CloudschoolRestypeSynDTO cloudschoolRestypeSynDTO = new CloudschoolRestypeSynDTO();
            cloudschoolRestypeSynDTO.setpNo(String.valueOf(cloudshoolRestypeBackupDO.getRestype()));
            //????????????????????????????????????
            cloudschoolRestypeSynDTO.setpNames("????????????????????????;"+cloudshoolRestypeBackupDO.getRestypeName());
            cloudschoolRestypeSynDTOS.add(cloudschoolRestypeSynDTO);
            try {
                ResultJavaEntity position = manager.position(cloudschoolRestypeSynDTOS, apiKey, secretKey, baseUrl);
                logger.info("??????????????????:{}",position);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void SyncRestype() {
        //???????????????
        List<HumanDicDO> byType = humanDicManager.getRestypeDic();
        //???????????????
        List<CloudshoolRestypeBackupDO> cloudshoolRestypeBackupDOS = cloudschoolRestypeBackupDao.findAll();
        //????????????List  ?????????????????????????????????????????? ??????????????????
        List<HumanDicDO> restypeSyncDOS = getRestypeSyncDOS(byType, cloudshoolRestypeBackupDOS, 0);
        //????????????????????????
        restypeSyncDOS.forEach(humanDicDO -> {
            SyncRestype(manager,humanDicDO);
        });
    }

    public List<HumanDicDO> getRestypeSyncDOS(List<HumanDicDO> humanDicDOS,List<CloudshoolRestypeBackupDO> CloudshoolRestypeBackupDOS,int flag){
        List<HumanDicDO> humanDicDOList = new ArrayList<>();
        Map<HumanDicDO,Integer> map = new HashMap<>();
        //??????????????????????????????????????????
        humanDicDOS.forEach(humanDicDO->{
            map.put(humanDicDO,1);
            CloudshoolRestypeBackupDOS.forEach(cloudshoolRestypeBackupDO->{
                if(humanDicDO.getId().equals(cloudshoolRestypeBackupDO.getRestype())){
                    //flag???1????????????????????? ??????0????????????????????????????????????
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
                cloudschoolRestypeSynDTO.setpNames("?????????;"+humanDicDO.getName());
                cloudschoolRestypeSynDTOS.add(cloudschoolRestypeSynDTO);
                if(cloudschoolRestypeSynDTOS.size()!=0){
                    ResultJavaEntity result = manager.position(cloudschoolRestypeSynDTOS, apiKey, secretKey, baseUrl);
                    logger.info("??????????????????????????????????????????{}",result );
                    if(result.getResult()==1){
                        //???????????????????????????????????????????????????
                        CloudshoolRestypeBackupDO cloudshoolRestypeBackupDO= new CloudshoolRestypeBackupDO();
                        cloudshoolRestypeBackupDO.setRestype(humanDicDO.getId());
                        cloudshoolRestypeBackupDO.setRestypeName(humanDicDO.getName());
                        cloudschoolRestypeBackupDao.save(cloudshoolRestypeBackupDO);
                        logger.info("?????????????????????????????????,??????????????????{}",result);
                    }else {
                        logger.info("?????????????????????????????????,?????????????????????{}",result);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
