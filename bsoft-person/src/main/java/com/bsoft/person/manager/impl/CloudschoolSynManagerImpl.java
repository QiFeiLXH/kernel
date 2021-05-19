package com.bsoft.person.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.schoolMessage.ResultJavaRegisterEntity;
import com.bsoft.common.schoolMessage.ResultJavaEntity;
import com.bsoft.common.schoolMessage.manager.*;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.person.dao.primary.*;
import com.bsoft.person.dto.CloudschoolUserSynDTO;
import com.bsoft.person.entity.primary.*;
import com.bsoft.person.manager.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class CloudschoolSynManagerImpl implements CloudschoolSynManager {
    private static final Logger logger = LoggerFactory.getLogger(CloudschoolSynManagerImpl.class);



    @Autowired
    private CloudschoolUserBackupDao cloudschoolUserBackupDao;


    @Autowired
    private PersonQuitSyncDao personQuitSyncDao;

    @Autowired
    private PersonQuitManager personQuitManager;


    @Autowired
    private PersonManager personManager;
    @Autowired
    private PersonTransferManager personTransferManager;

    @Autowired
    private PersonDimissionManager personDimissionManager;

    @Autowired
    private IGenerator  iGenerator;

    private SchoolSyncUserJavaManager manager = SpringContextUtil.getBean(SchoolSyncUserJavaManager.class);

    @Value("${yxt.baseurl}")
    private String baseUrl;
    @Value("${yxt.apikey}")
    private String apiKey;
    @Value("${yxt.secretkey}")
    private String secretKey;
    @Value("${yxt.registerurl}")
    private String registerUrl;


    @Override
    public void SyncSavePersonnel() {
        List<PersonDO> personNewList = personManager.getVaildPerson();
        List<CloudschoolUserBackupDO> personOldList = cloudschoolUserBackupDao.findBackupFlag("0");
        //备份数据Map
        Map<String, CloudschoolUserBackupDO> userBackupMap = this.getUserBackupMap(personOldList);
        //比较两个集合筛选出需要更新或者新增的数据
        List<PersonDO> personList = getUserSyncDOS(personNewList, userBackupMap,0);
        //封装需要的用户集合
        List<CloudschoolUserSynDTO> cloudschoolUserSynDTOS = new ArrayList<>();
        personList.forEach(person->{
            cloudschoolUserSynDTOS.add(setSaveUser(person));
        });
        //先判断需要同步用户是否离职返聘,将该用户抽离出来调用启动用户接口
        List<PersonQuitSyncDO> personQuits = personDimissionManager.getPersonDimissions();
        //启用用户集合
        List<String> personQuitNews = new ArrayList<>();
        cloudschoolUserSynDTOS.forEach(personSync->{
            personQuits.forEach(personQuit->{
                if(personQuit.getYggh().equals(personSync.getId())){
                    personQuitNews.add(personSync.getId());
                }
            });
        });
        //能新增能更新
        try {
            if(cloudschoolUserSynDTOS.size()!=0){
                if(personQuitNews.size()!=0){
                    //先启用被禁用的用户
                    ResultJavaEntity result = manager.enabledusers(personQuitNews, apiKey, secretKey, baseUrl);
                    logger.info("云学堂启用用户日志信息：{}",result );
                    saveUserBackup(personList,result);

                }
                ResultJavaEntity result = manager.users(1, cloudschoolUserSynDTOS, apiKey, secretKey, baseUrl);
                logger.info("云学堂同步用户日志信息：{}",result );
                //同步成功后更新备份表
                saveUserBackup(personList,result);

            }
        }  catch(Exception e) {
            if (e instanceof IOException) {
                logger.info("云学堂同步用户异常日志信息：{}",e.getMessage() );
            }
        }
    }


    @Override
    public void SyncTransferPersonnel()  {
        //获取当天前一天的调动人员
        List<PersonTransferSyncViewDO> personList = personTransferManager.getTransferDateSync();
        //封装需要同步的用户集合
        List<CloudschoolUserSynDTO> cloudschoolUserSynDTOS = new ArrayList<>();
        personList.forEach(person->{
            //设置ID,账号，员工工号
            cloudschoolUserSynDTOS.add(setTransferUser(person));
        });

        try {
            if(cloudschoolUserSynDTOS.size()!=0){
                ResultJavaEntity result = manager.users(1,cloudschoolUserSynDTOS, apiKey, secretKey, baseUrl);
                logger.info("云学堂调动用户日志信息：{}",result );

            }
        }  catch(Exception e) {
            if (e instanceof IOException) {
                logger.info("云学堂调动用户异常日志信息：{}",e.getMessage() );
            }
        }
    }


    @Override
    public void SyncQuitPersonnel()  {
        //获取当天前一天的离职人员
        List<PersonQuitSyncDO> quitPersons = personQuitManager.SyncQuitPersonnel();
//        List<PersonDO> personNewList = cloudschoolUserSynDao.findEndDateSync(date);
//        List<CloudschoolUserBackupDO> personOldList = cloudschoolUserBackupDao.findBackupFlag("1");
//        //备份数据Map
//        Map<String, CloudschoolUserBackupDO> userBackupMap = this.getUserBackupMap(personOldList);
//        //比较两个集合筛选出需要更新或者新增的数据
//        List<PersonDO> personList = getUserSyncDOS(personNewList, userBackupMap,1);
        //封装需要禁用的用户集合
        List<String> idList = new ArrayList<>();
        quitPersons.forEach(person->{
            if(person.getYggh()!=null&&person.getYggh().length()==4) {
                String NewPersonId = "0" + person.getYggh();
                idList.add(NewPersonId);
            }else {
                idList.add(person.getYggh());
            }
        });
        try {
            if(idList.size()!=0){
                //校验用户是否存在
                ResultJavaEntity checkuser = manager.checkusers(idList, apiKey, secretKey, baseUrl);
                //result为0用户不存在
                if(checkuser.getResult()==1){
                    ResultJavaEntity result = manager.disabledusers(idList, apiKey, secretKey, baseUrl);
                    logger.info("云学堂禁用用户日志信息：{}",result );
                    //是否更新备份表
//                    saveUserBackup(personList,result);
                }
            }
        }  catch(Exception e) {
            if (e instanceof IOException) {
                logger.info("云学堂禁用用户异常日志信息：{}",e.getMessage() );
            }
        }
    }
    @Override
    public ResultJavaRegisterEntity SyncRegisterPersonnel(String uname) {
//             SyncUserJavaService service = new SyncUserJavaService();
             //result为0用户不存在
        ResultJavaRegisterEntity result = null;
             try {
                 result = manager.registerUser(uname, apiKey, secretKey, registerUrl);
                 return result;
             } catch (IOException e) {
                 e.printStackTrace();
             }
        return result;
    }

    @Override
    public void SyncOnePersonnel() {
        //查出备份表中所有数据
        List<CloudschoolUserBackupDO> personOldList = cloudschoolUserBackupDao.findBackupFlag("0");
        iGenerator.convert(personOldList,CloudschoolUserSynDTO.class);
        //封装需要的用户集合
        List<CloudschoolUserSynDTO> cloudschoolUserSynDTOS = new ArrayList<>();
        personOldList.forEach(person->{
            cloudschoolUserSynDTOS.add(setOneSaveUser(person));
        });
        //先判断需要同步用户是否离职返聘,将该用户抽离出来调用启动用户接口
        List<PersonQuitSyncDO> personQuits =  personDimissionManager.getPersonDimissions();
        //启用用户集合
        List<String> personQuitNews = new ArrayList<>();
        cloudschoolUserSynDTOS.forEach(personSync->{
            personQuits.forEach(personQuit->{
                if(personQuit.getYggh().equals(personSync.getId())){
                    personQuitNews.add(personSync.getId());
                }
            });
        });
        //能新增能更新
        try {
            if(cloudschoolUserSynDTOS.size()!=0){
                if(personQuitNews.size()!=0){
                    //先启用被禁用的用户
                    ResultJavaEntity result = manager.enabledusers(personQuitNews, apiKey, secretKey, baseUrl);
                    logger.info("云学堂启用用户日志信息：{}",result );
                }
                ResultJavaEntity result = manager.users(1, cloudschoolUserSynDTOS, apiKey, secretKey, baseUrl);
                logger.info("云学堂同步用户日志信息：{}",result );
            }
        }  catch(Exception e) {
            if (e instanceof IOException) {
                logger.info("云学堂同步用户异常日志信息：{}",e.getMessage() );
            }
        }
    }


    public CloudschoolUserSynDTO setSaveUser(PersonDO person ){
        //封装需要同步的用户集合
        CloudschoolUserSynDTO cloudschoolUserSynDTO = new CloudschoolUserSynDTO();
        if(person.getPersonId()!=null&&person.getPersonId().length()==4){
            String NewPersonId = "0"+person.getPersonId();
            cloudschoolUserSynDTO.setUserNo(NewPersonId);
            cloudschoolUserSynDTO.setId(NewPersonId);
            cloudschoolUserSynDTO.setUserName(NewPersonId);
        }else{
            cloudschoolUserSynDTO.setId(person.getPersonId());
            cloudschoolUserSynDTO.setUserName(person.getPersonId());
        }
        //设置ID,账号，员工工号,邮箱
        cloudschoolUserSynDTO.setMail(person.getEmail());
        cloudschoolUserSynDTO.setCnName(person.getPersonName());
        cloudschoolUserSynDTO.setOrgOuCode(person.getDeptId());
        cloudschoolUserSynDTO.setPostionNo(person.getRestype());
        return cloudschoolUserSynDTO;
    }

    public CloudschoolUserSynDTO setOneSaveUser(CloudschoolUserBackupDO person ){
        //封装需要同步的用户集合
        CloudschoolUserSynDTO cloudschoolUserSynDTO = new CloudschoolUserSynDTO();
        if(person.getPersonId()!=null&&person.getPersonId().length()==4){
            String NewPersonId = "0"+person.getPersonId();
            cloudschoolUserSynDTO.setUserNo(NewPersonId);
            cloudschoolUserSynDTO.setId(NewPersonId);
            cloudschoolUserSynDTO.setUserName(NewPersonId);
        }else{
            cloudschoolUserSynDTO.setId(person.getPersonId());
            cloudschoolUserSynDTO.setUserName(person.getPersonId());
        }
        //设置ID,账号，员工工号,邮箱
        cloudschoolUserSynDTO.setMail(person.getEmail());
        cloudschoolUserSynDTO.setCnName(person.getPersonName());
        cloudschoolUserSynDTO.setOrgOuCode(person.getDeptId());
        cloudschoolUserSynDTO.setPostionNo(person.getRestype());
        return cloudschoolUserSynDTO;
    }


    public CloudschoolUserSynDTO setTransferUser( PersonTransferSyncViewDO person ){
        //封装需要同步的用户集合
        CloudschoolUserSynDTO cloudschoolUserSynDTO = new CloudschoolUserSynDTO();
        if(person.getPersonId()!=null&&person.getPersonId().length()==4){
            String NewPersonId = "0"+person.getPersonId();
            cloudschoolUserSynDTO.setUserNo(NewPersonId);
            cloudschoolUserSynDTO.setId(NewPersonId);
            cloudschoolUserSynDTO.setUserName(NewPersonId);
        }else{
            cloudschoolUserSynDTO.setId(person.getPersonId());
            cloudschoolUserSynDTO.setUserName(person.getPersonId());
        }
        //设置ID,账号，员工工号
        cloudschoolUserSynDTO.setCnName(person.getPersonName());
        cloudschoolUserSynDTO.setOrgOuCode(person.getDeptId());
        cloudschoolUserSynDTO.setPostionNo(person.getRestype());
        return cloudschoolUserSynDTO;
    }

    public List<PersonDO> getUserSyncDOS(List<PersonDO> userSyncDOS, Map<String, CloudschoolUserBackupDO> userBackupMap,int flag){
        List<PersonDO> userSyncDOList = new ArrayList<>();
        Map<PersonDO,Integer> map = new HashMap<>();
        //比较主表比备份表中多出来的值,以及主表比较备份表更新了的值
        userSyncDOS.forEach(userSync->{
            map.put(userSync,1);
                if(userBackupMap.containsKey(userSync.getPersonId())){
                    //flag为0筛选新增和更新，为1则只筛选新增的数据。
                    if(flag==0){
                        CloudschoolUserBackupDO userSyncBackup = userBackupMap.get(userSync.getPersonId());
                        if(!(userSync.getPersonName()!=null&&userSync.getPersonName().equals(userSyncBackup.getPersonName())||
                                (userSync.getPersonName()==null&&userSyncBackup.getPersonName()==null))||
                        !(userSync.getRestype()!=null&&userSync.getRestype().equals(userSyncBackup.getRestype())||
                                (userSync.getRestype()==null&&userSyncBackup.getRestype()==null))||
                        !(userSync.getDeptId()!=null&&userSync.getDeptId().equals(userSyncBackup.getDeptId())||
                                (userSync.getDeptId()==null&&userSyncBackup.getDeptId()==null))) {
                            map.put(userSync,1);
                        }else{
                            map.put(userSync,2);
                        }
                    }else {
                        map.put(userSync,2);
                    }
                }
        });
        for(Map.Entry<PersonDO,Integer> m :map.entrySet()){
            if(m.getValue()==1){
                userSyncDOList.add(m.getKey());
            }
        }
        return userSyncDOList;
    }


    public void saveUserBackup(List<PersonDO> personList,ResultJavaEntity result){
        if(result.getResult()==1){
            //同步成功后更新备份表
            List<CloudschoolUserBackupDO> convert = iGenerator.convert(personList, CloudschoolUserBackupDO.class);
            cloudschoolUserBackupDao.saveAll(convert);
            logger.info("云学堂同步用户接口调用成功更新备份表：{}",result);
        }else{
            logger.info("云学堂同步用户接口出现异常不更新备份表：{}",result);
        }
    }

    public Map<String,CloudschoolUserBackupDO> getUserBackupMap(List<CloudschoolUserBackupDO> personOldList){
        Map<String,CloudschoolUserBackupDO> personOldMap = new HashMap<>();
        personOldList.forEach(personOld->{
            personOldMap.put(personOld.getPersonId(),personOld);
        });
        return personOldMap;
    }

}
