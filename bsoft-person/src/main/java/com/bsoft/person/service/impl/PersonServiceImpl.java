package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.manager.HumanDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.person.condition.PersonSelectQueryCnd;
import com.bsoft.person.dto.*;
import com.bsoft.person.entity.primary.*;
import com.bsoft.person.manager.*;
import com.bsoft.person.service.PersonService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    private PersonManager personManager;
    @Autowired
    private LastSpecialRankManager lastSpecialRankManager;
    @Autowired
    private LastManagerRankManager lastManagerRankManager;
    @Autowired
    private BusinessCardManager businessCardManager;
    @Autowired
    private HumanDicManager humanDicManager;
    @Autowired
    private ExpertManager expertManager;
    @Autowired
    private JobPostManager jobPostManager;
    @Autowired
    DeptManager deptManager;
    @Autowired
    private PersonInfoManager personInfoManager;
    @Autowired
    private  IGenerator iGenerator;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public PersonDTO getPerson(String personid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonViewDO person = personManager.getPersonView(personid); //获取用户基本信息
        LastSpecialRankDO lastSpecialRankDO = lastSpecialRankManager.getLastSpecialRank(personid); //获取最新专业职级
        LastManagerRankDO lastManagerRankDO = lastManagerRankManager.getLastManagerRank(personid); //获取最新管理职级
        BusinessCardDO businessCardDO = businessCardManager.getLastedCard(personid);//获取员工电子名片二维码路径
        PersonDTO personDTO = generatorUtil.convert(person,PersonDTO.class);
        if(lastSpecialRankDO != null){ //有专业职级的设置专业职级
            personDTO.setSequence(lastSpecialRankDO.getSequence());
            personDTO.setSequenceText(lastSpecialRankDO.getSequenceText());
            personDTO.setSpecialRank(lastSpecialRankDO.getSpecialRank());
            personDTO.setSpecialRankText(lastSpecialRankDO.getSpecialRankText());
            personDTO.setSpecialDate(lastSpecialRankDO.getSpecialDate());
        }
        if(lastManagerRankDO != null){ //有管理职级的设置管理职级
            personDTO.setManagerRank(lastManagerRankDO.getManagerRank());
            personDTO.setManagerRankText(lastManagerRankDO.getManagerRankText());
            personDTO.setManagerDate(lastManagerRankDO.getManagerDate());
        }
        if(businessCardDO != null){
            personDTO.setCardPath(businessCardDO.getCardPath());
        }
        if (person.getDeptId() != null){
            personDTO.setDeptIdText(deptManager.getDept(person.getDeptId()).getDeptName());
        }
        if (person.getRestype() != null){
            HumanDicDO humanDicDO = humanDicManager.getValue(14,Integer.valueOf(person.getRestype()));
            personDTO.setRestypeText(humanDicDO.getName());
        }
        long times = timeConsumer.end();
        logger.info("获取工号:{}的人员信息耗时:{}",personid,times);
        return personDTO;
    }

    @Override
    public List<PersonDTO> getPersonList(List<String> personIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonDO> persons = personManager.getPersonList(personIds);
        long times = timeConsumer.end();
        logger.info("根据工号列表查找员工信息耗时:{}",times);
        return generatorUtil.convert(persons, PersonDTO.class);
    }

    @Override
    public List<PersonSelectViewDTO> findPersonSelectList(String simpleCode) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonSelectViewDO> persons = personManager.getPersonSelectList(simpleCode); //获取用户基本信息
        List<PersonSelectViewDTO> result = generatorUtil.convert(persons,PersonSelectViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取拼音码:{}的人员基本信息耗时:{}",simpleCode,times);
        return result;
    }

    @Override
    public List<PersonSelectViewDTO> findPersonSelectList(String inputContent, Integer isValid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonSelectViewDO> persons = personManager.getPersonSelectList(inputContent, isValid); //获取用户基本信息
        List<PersonSelectViewDTO> result = generatorUtil.convert(persons,PersonSelectViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取姓名、拼音:{}，在职情况：{}的人员基本信息耗时:{}",inputContent,isValid,times);
        return result;
    }

    @Override
    public List<PersonSelectViewDTO> getPersonSelectList(PersonSelectQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonSelectQueryCnd queryCnd = generatorUtil.convert(queryCndDTO, PersonSelectQueryCnd.class);
        List<PersonSelectViewDO> persons = personManager.getPersonSelectList(queryCnd);
        List<PersonSelectViewDTO> result = generatorUtil.convert(persons,PersonSelectViewDTO.class);
        long times = timeConsumer.end();
        logger.info("根据条件获取人员基本信息耗时:{}",times);
        return result;
    }

    @Override
    public List<PersonDTO> getPerson() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonDO> personDOList = personManager.getPerson();
        List<PersonDTO> personDTOList = generatorUtil.convert(personDOList,PersonDTO.class);
        long times = timeConsumer.end();
        System.out.println("getPerson");
        logger.info("获取所有人员列表耗时:{}",times);
        return personDTOList;
    }

    @Override
    public Map<String, String> getPersonDic() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Map<String,String> map = personManager.getDicPerson();
        long times = timeConsumer.end();
        logger.info("获取人员字典耗时:{}",times);
        return map;
    }

    @Override
    public List<PersonDTO> getVaildPerson() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonDO> results = personManager.getVaildPerson();
        long times = timeConsumer.end();
        logger.info("获取在职人员信息耗时:{}",times);
        return generatorUtil.convert(results,PersonDTO.class);
    }

    @Override
    public List<String> getVaildPersonId() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<String> results = personManager.getVaildPersonId();
        long times = timeConsumer.end();
        logger.info("获取在职人员工号列表耗时:{}",times);
        return results;
    }

    @Override
    public List<PersonDTO> getDeptPerson(String bmdm) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonDO> list = personManager.getDeptPerson(bmdm);
        List<PersonDTO> personDTOList = generatorUtil.convert(list,PersonDTO.class);
        long times = timeConsumer.end();
        logger.info("根据部门Id获取在职人员工号列表耗时:{}",times);
        return personDTOList;
    }

    @Override
    public List<PersonDTO> getPersonInfo(String value) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonDO> personDO= personManager.getPersonInfo(value);
        List<PersonDTO> personDTO = generatorUtil.convert(personDO,PersonDTO.class);
        long times = timeConsumer.end();
        logger.info("根据拼音码或者姓名获取在职人员工号列表耗时:{}",times);
        return personDTO;
    }

    @Override
    public List<HumanDicDTO> getHumanDic(Integer type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<HumanDicDO> humanDicDOS = humanDicManager.getTypePersonDic(type);
        List<HumanDicDTO> humanDicDTOS = generatorUtil.convert(humanDicDOS,HumanDicDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人事代码字典选项[{}]耗时:{}",type,times);
        return humanDicDTOS;
    }

    @Override
    public RankRoleDTO getRankRole(String personId) {
        RankRoleDTO rankRoleDTO = new RankRoleDTO();
        rankRoleDTO.setPersonId(personId);
        if(jobPostManager.isFirstManager(personId)){
            rankRoleDTO.setIsFirstManager(1);
        }
        if(jobPostManager.isSecondManager(personId)){
            rankRoleDTO.setIsSecondManager(1);
        }
        if(jobPostManager.isHr(personId) || jobPostManager.isRankManager(personId)){
            rankRoleDTO.setIsHr(1);
        }
        if(jobPostManager.isLeader(personId)){
            rankRoleDTO.setIsLeader(1);
        }
        if(expertManager.isExpert(personId)){
            rankRoleDTO.setIsExpert(1);
        }
        PersonDO personDO = personManager.getPerson(personId);
        DeptDO deptDO = deptManager.getDept(personDO.getDeptId());
        if(deptDO.getHeadQuarters().equals(1)){
            if(deptDO.getDeptFlag().equals(3)){
                rankRoleDTO.setType(2);
            }else{
                rankRoleDTO.setType(3);
            }
        }else{
            rankRoleDTO.setType(1);
        }
        return rankRoleDTO;
    }

    @Override
    public RankPersonDTO getRankPerson(String personId) {
        RankPersonDO rankPerson = personManager.getRankPerson(personId);
        return generatorUtil.convert(rankPerson,RankPersonDTO.class);
    }

    @Override
    public List<String> getEmails(List<String> personId) {
        return personManager.getEmails(personId);
    }

    @Override
    public PersonInfoDTO getPersonAttendFlag(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonInfoDO personInfoDO =  personInfoManager.getPersonInfo(personId);
        long times = timeConsumer.end();
        logger.info("获取[{}]考勤方式耗时:{}",personId,times);
        return generatorUtil.convert(personInfoDO,PersonInfoDTO.class);
    }

    @Override
    public Result<PersonTransferConditionDTO> getPersonTransfer(PersonTransferQueryCndDTO cndDTO)   {
        Page<PersonTransferConditionsDO> pages = null;
        try {
            pages = personManager.getPersonTransfer(cndDTO);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ResultUtils.parseResult(pages, PersonTransferConditionDTO.class);
    }

    @Override
    public List<PersonTransferConditionDTO> getExcelPersonTransfer(PersonTransferQueryCndDTO cndDTO)   {
        List<PersonTransferConditionDTO> personTransferConditionDTOS  = new ArrayList<>();
        try {
            personTransferConditionDTOS =iGenerator.convert(personManager.getExcelPersonTransfer(cndDTO),PersonTransferConditionDTO.class);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return personTransferConditionDTOS;
    }


}
