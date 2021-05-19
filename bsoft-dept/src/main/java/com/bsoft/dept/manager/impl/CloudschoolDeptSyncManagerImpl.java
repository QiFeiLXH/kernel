package com.bsoft.dept.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.schoolMessage.ResultJavaEntity;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.schoolMessage.manager.SchoolDeptSyncManager;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.dept.dao.primary.CloudschoolDeptSyncBackupDao;
import com.bsoft.dept.dao.primary.CloudschoolDeptSyncDao;
import com.bsoft.dept.dto.CloudschoolDeptSyncDTO;
import com.bsoft.dept.entity.primary.CloudschoolDeptSyncBackupDO;
import com.bsoft.dept.entity.primary.CloudschoolDeptSyncDO;
import com.bsoft.dept.manager.CloudschoolDeptSyncManager;
import com.bsoft.dept.manager.DeptManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;


@Component
public class CloudschoolDeptSyncManagerImpl implements CloudschoolDeptSyncManager {
    private static final Logger logger = LoggerFactory.getLogger(CloudschoolDeptSyncManagerImpl.class);

    @Autowired
    private CloudschoolDeptSyncDao cloudschoolDeptSyncDao;
    @Autowired
    private CloudschoolDeptSyncBackupDao cloudschoolDeptSyncBackupDao;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private IGenerator iGenerator;
    private SchoolDeptSyncManager emailSenderRepository = SpringContextUtil.getBean(SchoolDeptSyncManager.class);
    @Value("${yxt.baseurl}")
    private String baseUrl;
    @Value("${yxt.apikey}")
    private String apiKey;
    @Value("${yxt.secretkey}")
    private String secretKey;


    private   Boolean FLAG =  true;
    @Override
    public void SyncSaveDept() {
        //通过当前部门表与备份部门表数据进行比对,筛选出更新或新增的部门数据
        List<CloudschoolDeptSyncDO> deptSyncDOS = deptManager.findByLogout(0);
        List<CloudschoolDeptSyncBackupDO> deptSyncBackupDOS = cloudschoolDeptSyncBackupDao.findByLogout(0);
        //部门备份Map
        Map<String, CloudschoolDeptSyncBackupDO> deptSyncDOMap = this.getDeptSyncDOMap(deptSyncBackupDOS);
        //比较主表比备份表中新增或者更新的值
        List<CloudschoolDeptSyncDO> deptSyncDOList = getDeptSyncDOS(deptSyncDOS, deptSyncDOMap,0);
        //一级部门
        List<CloudschoolDeptSyncDO> parentDepts = new ArrayList<>();
        //二级部门及其子部门
        List<CloudschoolDeptSyncDO> sonDepts = new ArrayList<>();
        deptSyncDOList.forEach(dept->{
            //先提取一级部门同步，然后再同步二级部门
            if(dept.getParentDept()==null){
                dept.setParentDept("697818633");
                parentDepts.add(dept);
            }else{
                sonDepts.add(dept);
            }
        });
        //一级部门信息同步
        parentDepts.forEach(dept->{
            SyncDept(emailSenderRepository,dept,0);
        });
        //二级部门信息同步
        sonDepts.forEach(dept->{
            SyncDept(emailSenderRepository,dept,0);
        });
    }

    @Override
    public void SyncDeleteDept() {
        List<CloudschoolDeptSyncDO> deptSyncDOS = deptManager.findByLogout(1);
        List<CloudschoolDeptSyncBackupDO> deptSyncBackupDOS = cloudschoolDeptSyncBackupDao.findByLogout(1);
        //部门备份Map
        Map<String, CloudschoolDeptSyncBackupDO> deptSyncDOMap = this.getDeptSyncDOMap(deptSyncBackupDOS);
        //比较主表比备份表中新增的值
        List<CloudschoolDeptSyncDO> deptSyncDOList = getDeptSyncDOS(deptSyncDOS, deptSyncDOMap,1);
        deptSyncDOList.forEach(dept->{
            SyncDept(emailSenderRepository,dept,1);
        });
    }

    @Override
    public void SyncOneDept() {
        //获取备份表未注销的部门所有的数据进行同步
        List<CloudschoolDeptSyncBackupDO> deptSyncBackupDOS = cloudschoolDeptSyncBackupDao.findByLogout(0);
        deptSyncBackupDOS.forEach(deptSyncBackupDO->{
            List<CloudschoolDeptSyncDTO> cloudschoolDeptSyncDTOS = new ArrayList<>();
            CloudschoolDeptSyncDTO cloudschoolDeptSyncDTO = new CloudschoolDeptSyncDTO();
            cloudschoolDeptSyncDTO.setId(deptSyncBackupDO.getDept());
            cloudschoolDeptSyncDTO.setOuName(deptSyncBackupDO.getDeptName());
            if(deptSyncBackupDO.getParentDept()==null){
                cloudschoolDeptSyncDTO.setParentId("697818633");
            }else {
                cloudschoolDeptSyncDTO.setParentId(deptSyncBackupDO.getParentDept());
            }
            cloudschoolDeptSyncDTOS.add(cloudschoolDeptSyncDTO);
            if(cloudschoolDeptSyncDTOS.size()!=0) {
                ResultJavaEntity result = null;
                try {
                    result = emailSenderRepository.ous(1, cloudschoolDeptSyncDTOS, apiKey, secretKey, baseUrl);
                    logger.info("首次云学堂同步部门数据日志信息：{}",result );
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("首次云学堂同步部门数据异常日志信息：{}",result );
                }
            }
            });
    }


    public void SyncDept(SchoolDeptSyncManager manager, CloudschoolDeptSyncDO dept, int flag){
        try {
            //flag为0 新增，更新。
            if(flag==0){
                List<CloudschoolDeptSyncDTO> cloudschoolDeptSyncDTOS = new ArrayList<>();
                CloudschoolDeptSyncDTO cloudschoolDeptSyncDTO = new CloudschoolDeptSyncDTO();
                cloudschoolDeptSyncDTO.setId(dept.getDept());
                cloudschoolDeptSyncDTO.setOuName(dept.getDeptName());
                cloudschoolDeptSyncDTO.setParentId(dept.getParentDept());
                cloudschoolDeptSyncDTOS.add(cloudschoolDeptSyncDTO);
                if(cloudschoolDeptSyncDTOS.size()!=0){
                    ResultJavaEntity result = manager.ous(1, cloudschoolDeptSyncDTOS, apiKey, secretKey, baseUrl);
                    logger.info("云学堂同步的部门返回数据为：{}",result );
                    CloudschoolDeptSyncBackupDO convert = null;
                    if(result.getResult()==1){
                            //部门同步成功没有异常则更新备份表。
                            convert = iGenerator.convert(dept, CloudschoolDeptSyncBackupDO.class);
                            cloudschoolDeptSyncBackupDao.save(convert);
                            logger.info("云学堂部门接口同步成功,更新备份表：{}",result);
                    }else {
                            logger.info("云学堂部门接口同步异常,备份表不更新：{}",result);
                    }
                }
            }else if(flag==1){
                //flag为1，同步云学堂删除注销掉的部门。
                List<String> deleteDepts = new ArrayList<>();
                deleteDepts.add(dept.getDept());
                if(deleteDepts.size()!=0){
                    ResultJavaEntity result = manager.deleteous(deleteDepts, apiKey, secretKey, baseUrl);
                    logger.info("云学堂删除的部门返回数据为：{}",result );
                    CloudschoolDeptSyncBackupDO convert = null;
                    if(result.getResult()==1){
                        //部门同步成功没有异常则更新备份表。
                        convert = iGenerator.convert(dept, CloudschoolDeptSyncBackupDO.class);
                        cloudschoolDeptSyncBackupDao.save(convert);
                        logger.info("云学堂部门接口同步成功,更新备份表：{}",result);
                    }else {
                        logger.info("云学堂部门接口同步异常,备份表不更新：{}",result);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CloudschoolDeptSyncDO> getDeptSyncDOS(List<CloudschoolDeptSyncDO> deptSyncDOS,Map<String,CloudschoolDeptSyncBackupDO> deptSyncBackupMap,int flag){
        List<CloudschoolDeptSyncDO> deptSyncDOList = new ArrayList<>();
        Map<CloudschoolDeptSyncDO,Integer> map = new HashMap<>();
        //比较主表比备份表中多出来的值
        deptSyncDOS.forEach(deptSync->{
            map.put(deptSync,1);
                if(deptSyncBackupMap.containsKey(deptSync.getDept())){
                    //flag为1则只筛选出新增 ，为0则新增和更新都要筛选出来
                    if(flag==0){
                        CloudschoolDeptSyncBackupDO deptSyncBackup = deptSyncBackupMap.get(deptSync.getDept());
                        if(deptSync.getDeptName().equals(deptSyncBackup.getDeptName())||
                                (deptSync.getDeptName()==null&&deptSync.getDeptName()==null)){
                            map.put(deptSync,2);
                        }
                    }else{
                        map.put(deptSync,2);
                    }
                }
          
        });
        for(Map.Entry<CloudschoolDeptSyncDO,Integer> m :map.entrySet()){
            if(m.getValue()==1){
                deptSyncDOList.add(m.getKey());
            }
        }
        return deptSyncDOList;
    }


    public Map<String,CloudschoolDeptSyncBackupDO>  getDeptSyncDOMap (List<CloudschoolDeptSyncBackupDO> deptSyncBackupDOS) {
        //部门备份Map
        Map<String,CloudschoolDeptSyncBackupDO> deptSyncDOMap = new HashMap<>();
        deptSyncBackupDOS.forEach(deptSyncBackupDO->{
            deptSyncDOMap.put(deptSyncBackupDO.getDept(),deptSyncBackupDO);
        });
        return deptSyncDOMap;
    }

}
