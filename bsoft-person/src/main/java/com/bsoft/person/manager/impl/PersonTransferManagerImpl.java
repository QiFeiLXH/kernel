package com.bsoft.person.manager.impl;

import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.common.entity.primary.CommunicationSubsidyDO;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.CommunicationSubsidyManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.utils.DateUtils;
import com.bsoft.cost.entity.primary.DeptCostTypeViewDO;
import com.bsoft.cost.manager.DeptCostTypeManager;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.expense.manager.PersonReimburManager;
import com.bsoft.person.condition.PersonTransferQueryCnd;
import com.bsoft.person.dao.primary.PersonInfoDao;
import com.bsoft.person.dao.primary.PersonTransferDao;
import com.bsoft.person.dao.primary.PersonTransferSyncViewDao;
import com.bsoft.person.entity.primary.*;
import com.bsoft.person.manager.*;
import com.bsoft.person.repository.primary.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.*;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 10:43
 * @Description:
 */
@Component
public class PersonTransferManagerImpl implements PersonTransferManager {
    @Autowired
    private PersonTransferDao personTransferDao;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private ResidentManager residentManager;
    @Autowired
    private PositionManager positionManager;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private PersonCostLimitManager personCostLimitManager;
    @Autowired
    private CommunicationSubsidyManager communicationSubsidyManager;
    @Autowired
    private RelationManager relationManager;
    @Autowired
    private AttendanceManager attendanceManager;
    @Autowired
    private PersonReimburManager personReimburManager;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private MonthPersonInManager monthPersonInManager;
    @Autowired
    private DeptCostTypeManager deptCostTypeManager;
    @Autowired
    private PersonInfoDao personInfoDao;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonTransferSyncViewDao personTransferSyncViewDao;


    @Override
    public Page<PersonTransferDO> findPersonTransfer(PersonTransferQueryCnd cnd) {
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1,cnd.getPageSize());
        Page<PersonTransferDO> pages = personTransferDao.findAll(new Specification<PersonTransferDO>() {
            @Override
            public Predicate toPredicate(Root<PersonTransferDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                String input = cnd.getInput();
                if (input != null && input.trim() != ""){
                    Predicate c1 = criteriaBuilder.like(root.get("personId"),"%"+input+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("personName"),"%"+input+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("pym"),"%"+input.toLowerCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                String bmdm = cnd.getBmdm();
                if (bmdm != null){
                    Predicate c = criteriaBuilder.equal(root.get("dept"),bmdm);
                    predicates.add(c);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public void savePersonTransfer(List<PersonTransferDO> personTransferDOs, String personId) {
        Date now = serverDateManager.getServerDateTime();
        for (PersonTransferDO personTransferDO : personTransferDOs){
            PersonTransferDO orgPersonTransferDO = personTransferDao.getOne(personTransferDO.getPersonId());//???????????????????????????????????????
            Date ddrq = personTransferDO.getTransferDate();
            boolean residentTransfer = false;
            boolean jobTransfer = false;
            boolean typeTransfer = false;
            if (
                    ((orgPersonTransferDO.getDivisionProvince() != null &&!orgPersonTransferDO.getDivisionProvince().equals(personTransferDO.getDivisionProvince())) ||
                            (orgPersonTransferDO.getDivisionProvince() == null && personTransferDO.getDivisionProvince() != null)) ||
                            ((orgPersonTransferDO.getDivisionCounty() != null && !orgPersonTransferDO.getDivisionCounty().equals(personTransferDO.getDivisionCounty())) ||
                                    (orgPersonTransferDO.getDivisionCounty() == null && personTransferDO.getDivisionCounty() != null)) ||
                            ((orgPersonTransferDO.getDivisionCity() != null && !orgPersonTransferDO.getDivisionCity().equals(personTransferDO.getDivisionCity())) ||
                                    (orgPersonTransferDO.getDivisionCity() == null && personTransferDO.getDivisionCity() != null)) ||
                            !orgPersonTransferDO.getLocalflag().equals(personTransferDO.getLocalflag())
            ){
                residentTransfer = true;
            }
            if (!orgPersonTransferDO.getDept().equals(personTransferDO.getDept()) ||
                    ((orgPersonTransferDO.getJobCategory() != null && !orgPersonTransferDO.getJobCategory().equals(personTransferDO.getJobCategory())) ||
                            (orgPersonTransferDO.getJobCategory() == null && personTransferDO.getJobCategory() != null)) ||
                    ((orgPersonTransferDO.getPost() != null && !orgPersonTransferDO.getPost().equals(personTransferDO.getPost())) ||
                            (orgPersonTransferDO.getPost() == null && personTransferDO.getPost() != null)) ||
                    ((orgPersonTransferDO.getCommunicationSubsidy() != null && !orgPersonTransferDO.getCommunicationSubsidy().equals(personTransferDO.getCommunicationSubsidy())) ||
                            (orgPersonTransferDO.getCommunicationSubsidy() == null && personTransferDO.getCommunicationSubsidy() != null)) ||
                    ((orgPersonTransferDO.getPersonnelGroup() != null && !orgPersonTransferDO.getPersonnelGroup().equals(personTransferDO.getPersonnelGroup()) ||
                            (orgPersonTransferDO.getPersonnelGroup() == null && personTransferDO.getPersonnelGroup() != null)))
            ){
                jobTransfer = true;
            }
            if ((orgPersonTransferDO.getType() != null && !orgPersonTransferDO.getType().equals(personTransferDO.getType())) ||
                    (orgPersonTransferDO.getType() == null && personTransferDO.getType() != null)){
                typeTransfer = true;
            }
            if (!residentTransfer && !jobTransfer && !typeTransfer){//???????????????
                continue;
            }
            try {
                //????????????????????????
                if (residentTransfer){
                    saveResident(personTransferDO,personId,now,ddrq);//????????????????????????
                }
                //?????????????????????????????????????????????????????????
                if (jobTransfer){
                    PositionDO positionDO = savePosition(orgPersonTransferDO,personTransferDO,personId,now,ddrq);//??????????????????
                    Date firstDate = DateUtils.getFristDateOfMonth(ddrq);
                    String yggh = personTransferDO.getPersonId();
                    //????????????????????????????????????????????????
                    if (!personTransferDO.getType().equals(4) && !personTransferDO.getType().equals(9)){
                        Integer dhbt = positionDO.getCommunicationSubsidy();
                        Integer id = positionDO.getId();
                        savePersonCostLimit(firstDate,now,yggh,dhbt,id,personId);//????????????
                    }
                    if (!orgPersonTransferDO.getDept().equals(personTransferDO.getDept())){
                        relationManager.deleteAllByZggh(yggh);//????????????????????????
                        relationManager.deleteAllByYggh(yggh);//??????????????????????????????
                    }
                    if (now.after(ddrq)){//??????????????????????????????
                        attendanceManager.updateDept(personTransferDO.getDept(),yggh,ddrq);//????????????????????????
                        personReimburManager.updateDept(personTransferDO.getId().toString(),personTransferDO.getDept(),ddrq);//??????????????????
                    }
                    //??????????????????????????????
                    saveMonthPersonInfo(personTransferDO,firstDate);
                }
                //??????xtuser??????????????????
                savePersonInfo(personTransferDO.getPersonId(),personTransferDO,orgPersonTransferDO,residentTransfer,jobTransfer,typeTransfer,ddrq,now);
            } catch (ParseException e) {
                e.printStackTrace();
                throw new ServiceException("?????????????????????!");
            }
        }
    }

    //??????xtuser??????????????????
    void savePersonInfo(String yggh,PersonTransferDO personTransferDO,PersonTransferDO orgPersonTransferDO,boolean residentTransfer,boolean jobTransfer,boolean typeTransfer,Date ddrq,Date now){
        PersonDO orgPersonInfo = personManager.getPerson(yggh);
        if (residentTransfer){//????????????
            orgPersonInfo.setLocalflag(personTransferDO.getLocalflag());
            orgPersonInfo.setDivisionprovince(personTransferDO.getDivisionProvince());
            orgPersonInfo.setDivisioncity(personTransferDO.getDivisionCity());
            orgPersonInfo.setDivisioncounty(personTransferDO.getDivisionCounty());
            orgPersonInfo.setTransfer(1);
        }
        if(jobTransfer){//??????????????????
            if(!now.before(ddrq)){//?????????????????????????????????
                orgPersonInfo.setDeptId(personTransferDO.getDept());
                orgPersonInfo.setJobCategory(personTransferDO.getJobCategory());
                orgPersonInfo.setRestype(personTransferDO.getPost());
                orgPersonInfo.setPersonnelGroup(personTransferDO.getPersonnelGroup());
                Integer costType = getCostType(ddrq,personTransferDO.getDept(),Integer.valueOf(personTransferDO.getJobCategory()));
                personInfoDao.updateCostType(personTransferDO.getPersonId(),costType);//????????????????????????
            }
            orgPersonInfo.setTransfer(1);
            orgPersonInfo.setImport_flag(1);
            orgPersonInfo.setImportflag(1);
            orgPersonInfo.setType(personTransferDO.getType());
            if (!orgPersonTransferDO.getDept().equals(personTransferDO.getDept()) && "0".equals(orgPersonInfo.getIsValid())){
                if (!orgPersonInfo.getEmailflag().equals(1)){
                    orgPersonInfo.setEmailflag(3); //??????????????????
                }
                orgPersonInfo.setYxrl("1,2,3,");
            }
            //???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
            if (orgPersonTransferDO.getCommunicationSubsidy() == null){
            }else{
                if ((orgPersonTransferDO.getCommunicationSubsidy().equals(10) && !personTransferDO.getCommunicationSubsidy().equals(10)) ||
                        (!orgPersonTransferDO.getCommunicationSubsidy().equals(10) && personTransferDO.getCommunicationSubsidy().equals(10))){
                    orgPersonInfo.setEmailflag(3); //??????????????????
                    orgPersonInfo.setYxrl("1,2,3,");
                }
            }
        }
        if (typeTransfer){//????????????
            orgPersonInfo.setType(personTransferDO.getType());
        }
        personManager.updatePerson(orgPersonInfo);
    }

    //??????????????????????????????
    void saveMonthPersonInfo(PersonTransferDO personTransferDO,Date firstDate){
        String yggh = personTransferDO.getPersonId();
        String dept = personTransferDO.getDept();
        String post = personTransferDO.getPost();
        Integer jobCategory = Integer.valueOf(personTransferDO.getJobCategory());
        DeptDO deptDO = deptManager.getDept(dept);
        Integer bmlb = deptDO.getDeptType();
        monthPersonInManager.updateLastPersonInfo(dept,bmlb,jobCategory,post,yggh,firstDate);
    }
    /**
     *
     * @param firstDate ??????????????????????????????
     * @param now ??????????????????
     * @param yggh ????????????
     * @param dhbt ????????????
     * @param id ??????ID
     * @param personId ????????????
     */
    void savePersonCostLimit(Date firstDate,Date now,String yggh,Integer dhbt,Integer id,String personId){
        CommunicationSubsidyDO communicationSubsidyDO = communicationSubsidyManager.getCommunicationSubsidy(dhbt);
        List<PersonCostLimitDO> personCostLimitDOS = personCostLimitManager.findAll(yggh,9910,id);
        if (personCostLimitDOS.size() > 0){
            PersonCostLimitDO personCostLimitDO = personCostLimitDOS.get(0);
            boolean ModiFlag = false;
            if (!personCostLimitDO.getExecudate().equals(firstDate)){//????????????
                ModiFlag = true;
                personCostLimitDO.setExecudate(firstDate);
            }
            if (!personCostLimitDO.getCostlevel().equals(dhbt)){//????????????
                ModiFlag = true;
                personCostLimitDO.setCostlevel(dhbt);
                personCostLimitDO.setCostlimit(communicationSubsidyDO.getAmount());
            }
            if (ModiFlag){//?????????????????????
                personCostLimitDO.setAdduser(personId);
                personCostLimitDO.setAdddate(now);
                List<PersonCostLimitDO> personCostLimitDOList = personCostLimitManager.getPersonCostLimitList(yggh,9910,firstDate);
                if (personCostLimitDOList.size()>0){
                    throw new ServiceException("??????[" + yggh +"]?????????????????????????????????");
                }
                personCostLimitManager.savePersonCostLimit(personCostLimitDO);
            }
        }else{
            List<PersonCostLimitDO> personCostLimitDOList = personCostLimitManager.getPersonCostLimitList(yggh,9910,firstDate);
            if (personCostLimitDOList.size()>0){
                throw new ServiceException("??????[" + yggh +"]?????????????????????????????????");
            }
            PersonCostLimitDO personCostLimitDO = new PersonCostLimitDO();
            personCostLimitDO.setPersonid(yggh);
            personCostLimitDO.setCosttype(9910);
            personCostLimitDO.setCostlevel(dhbt);
            personCostLimitDO.setCostlimit(communicationSubsidyDO.getAmount());
            personCostLimitDO.setExecudate(firstDate);
            personCostLimitDO.setSourceflag(1);
            personCostLimitDO.setSourceid(id);
            personCostLimitDO.setAdduser(personId);
            personCostLimitDO.setAdddate(now);
            personCostLimitManager.savePersonCostLimit(personCostLimitDO);
        }
    }

    PositionDO savePosition(PersonTransferDO orgPersonTransferDO,PersonTransferDO personTransferDO, String personId,Date now,Date ddrq){
        PositionDO positionDO = new PositionDO();
        positionDO.setId(keyGenerator.increasePositionInfo());
        positionDO.setFlag(0);
        positionDO.setCsbz(1);
        positionDO.setRegistrant(personId);
        positionDO.setRegistrationTime(now);
        positionDO.setDepartmentDefore(orgPersonTransferDO.getDept());
        positionDO.setDepartmentAfter(personTransferDO.getDept());
        positionDO.setJobCategoryBefore(orgPersonTransferDO.getJobCategory());
        positionDO.setJobCategory(personTransferDO.getJobCategory());
        positionDO.setPostDefore(orgPersonTransferDO.getPost());
        positionDO.setPostAfter(personTransferDO.getPost());
        positionDO.setCommunicationSubsidyBefore(orgPersonTransferDO.getCommunicationSubsidy());
        positionDO.setCommunicationSubsidy(personTransferDO.getCommunicationSubsidy());
        positionDO.setPersonnelGroupBefore(orgPersonTransferDO.getPersonnelGroup());
        positionDO.setPersonnelGroup(personTransferDO.getPersonnelGroup());
        positionDO.setCostTypeBefore(orgPersonTransferDO.getDhcost());//??????????????????
        positionDO.setTransferDate(ddrq);
        positionDO.setPersonId(personTransferDO.getPersonId());
        positionDO.setFinancialBefore(orgPersonTransferDO.getDhfinancial());//??????????????????

        Integer PersonType = personTransferDO.getType();
        if (!PersonType.equals(4) && !PersonType.equals(9) && personTransferDO.getCommunicationSubsidy() == null){
            //??????????????????????????????
            throw new ServiceException(personTransferDO.getPersonName() + "???????????????????????????!");
        }
        String dept = personTransferDO.getDept();
        DeptDO deptDO = deptManager.getDept(dept);
        if (deptDO.getLogout().equals(1) && deptDO.getLogoutDate().before(now)){
            throw new ServiceException(personTransferDO.getPersonName() + "???????????????????????????????????????!");
        }
        List<PositionDO> positionDOS = positionManager.findAllByDateAndPersonId(ddrq,personTransferDO.getPersonId());
        if (positionDOS.size() > 0){
            throw new ServiceException(personTransferDO.getPersonName() + "????????????????????????????????????!");
        }
        List<PositionDO> positionDOS1 = positionManager.findAllByDateAfterAndPersonId(ddrq,personTransferDO.getPersonId());
        if (positionDOS1.size()>0){
            throw new ServiceException(personTransferDO.getPersonName() + "??????????????????????????????????????????????????????!");
        }
        Date byrq = orgPersonTransferDO.getGraduationDate();
        if (byrq != null && ddrq.before(byrq) && !personTransferDO.getPost().equals("930")){
            throw new ServiceException(personTransferDO.getPersonName() + "?????????, ?????????????????????'?????????'!");
        }
        //??????????????????????????????
        Integer jobCategory = Integer.valueOf(personTransferDO.getJobCategory());//??????????????????
        Integer costType = getCostType(ddrq,dept,jobCategory);
        positionDO.setCostTypeAfter(costType);

        Integer financial = getFinancialType(ddrq,dept,jobCategory,personTransferDO.getPersonId());//
        positionDO.setFinancialAfter(financial);

        positionManager.savePosition(positionDO);
        return positionDO;
    }

    /**
     * ????????????????????????
     * @param ddrq ????????????
     * @param dept ????????????
     * @param jobCategory ??????????????????
     * @return
     */
    private Integer getFinancialType(Date ddrq,String dept,Integer jobCategory,String personId){
        //??????????????????
        List<DeptCostMaintainLookDO> personCostTypes = personRepository.findPersonCostMaintain(ddrq,personId);
        if (!personCostTypes.isEmpty()){
            return personCostTypes.get(0).getFinancialTypeAfter();
        }
        //
        List<DeptCostMaintainLookDO> dos = personRepository.findDeptCostMaintain(ddrq,dept);
        if (!dos.isEmpty()){
            Integer type = dos.get(0).getType();
            if ("1".equals(type.toString())){
                return dos.get(0).getFinancialTypeAfter();
            }else{
                for (DeptCostMaintainLookDO costMaintainDO:dos){
                    if (costMaintainDO.getPostType().toString().equals(jobCategory.toString())){
                        return costMaintainDO.getFinancialTypeAfter();
                    }
                }
            }
        }
        PostAndCostLookDO postAndCostLookDO = personRepository.getPostAndCost(jobCategory);
        if(Optional.ofNullable(postAndCostLookDO).isPresent()){
            return postAndCostLookDO.getFinancialType();
        }
        return null;
    }

    //??????????????????
    private Integer getCostType(Date ddrq,String dept,Integer jobCategory){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ddrq);
        Integer year = calendar.get(Calendar.YEAR);
        DeptCostTypeViewDO deptCostType = deptCostTypeManager.getDeptCostType(year,dept);//??????????????????
        PostAndCostLookDO postAndCostLookDO = personRepository.getPostAndCost(jobCategory);
        Integer jobCostType = postAndCostLookDO != null ? postAndCostLookDO.getCostType() : null;//???????????????????????????
        if (deptCostType == null){
            throw new ServiceException("??????????????????????????????,????????????!");
        }
        if (jobCostType == null){
            return deptCostType.getCostType();
        }
        if (deptCostType.getCostTypes().contains(jobCostType.toString())){//???????????????????????????????????????????????????????????????????????????
            return jobCostType;
        }else{
            return deptCostType.getCostType();
        }
    }

    void saveResident(PersonTransferDO personTransferDO, String personId,Date now,Date ddrq){
        if (personTransferDO.getLocalflag() > 0 && (
                personTransferDO.getDivisionProvince() == null &&
                personTransferDO.getDivisionCity() == null &&
                personTransferDO.getDivisionCounty() == null
        )){
            throw new ServiceException("?????????"+personTransferDO.getPersonName()+"?????????!");
        }
        ResidentDO residentDO = new ResidentDO();
        residentDO.setId(keyGenerator.increaseResidentInfo());
        residentDO.setUserId(personTransferDO.getPersonId());
        residentDO.setRegistrant(personId);
        residentDO.setRegistrationTime(now);
        residentDO.setDivisionProvince(personTransferDO.getDivisionProvince());
        residentDO.setDivisionCity(personTransferDO.getDivisionCity());
        residentDO.setDivisionCounty(personTransferDO.getDivisionCounty());
        residentDO.setLocalFlag(personTransferDO.getLocalflag());
        residentDO.setTransferDate(ddrq);
        residentManager.saveRedisent(residentDO);
    }

    @Override
    public PersonTransferDO getPersonTransfer(String personId) {
        return personTransferDao.getOne(personId);
    }

    @Override
    public List<PersonTransferSyncViewDO> getTransferDateSync() {
        //??????????????????
        Date now = serverDateManager.getServerDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE,-1);
        Date date = calendar.getTime();
        return personTransferSyncViewDao.findTransferDateSync(date);

    }

}
