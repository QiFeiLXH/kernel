package com.bsoft.hr.manager.impl;

import com.bsoft.common.manager.PrimaryKeyManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.hr.condition.LeaveQueryCnd;
import com.bsoft.hr.condition.WorkVacationQueryCnd;
import com.bsoft.hr.dao.primary.*;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.manager.AnnualVacationManager;
import com.bsoft.hr.manager.VacationReduceManager;
import com.bsoft.hr.repository.primary.LeaveRepository;
import com.bsoft.person.entity.primary.AnnualVacationPersonInfoDO;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.AnnualVacationPersonInfoManager;
import com.bsoft.person.manager.PersonManager;
import com.google.j2objc.annotations.AutoreleasePool;
import net.sf.cglib.asm.$ClassTooLargeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class AnnualVacationManagerImpl implements AnnualVacationManager {
    private final static String REDUCEREMARK = "春节统一扣除年假";
    @Autowired
    private AnnualVacationPersonInfoManager annualVacationPersonInfoManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private WorkVacationDao workVacationDao;
    @Autowired
    private WorkVacationDetailDao workVacationDetailDao;
    @Autowired
    private AnnualVacationInfoDao annualVacationInfoDao;
    @Autowired
    private LeaveRepository leaveRepository;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private PrimaryKeyManager primaryKeyManager;
    @Autowired
    private VacationReduceManager vacationReduceManager;
    @Autowired
    private VacationDateDao vacationDateDao;

    @Override
    public List<WorkVacationDO> getWorkVacations(List<WorkVacationDO> workVacationDOS, Integer workVacationKey, Integer workVacationDetailKey) {
        for(WorkVacationDO workVacationDO : workVacationDOS){
            //为假期主表设置id
            workVacationKey++;
            workVacationDO.setId(workVacationKey);
            List<WorkVacationDetailDO> workVacationDetails = workVacationDO.getWorkVacationDetails();
            for(WorkVacationDetailDO workVacationDetailDO : workVacationDetails){
                //为假期明细表设置明细id
                workVacationDetailKey++;
                workVacationDetailDO.setId(workVacationDetailKey);
                workVacationDetailDO.setWorkId(workVacationKey);
            }
        }
        return workVacationDOS;
    }


    @Override
    public List<WorkVacationDO> getWorkVacations() {
        List<Integer> types = new ArrayList<>();
        types.add(0);
        types.add(1);
        List<AnnualVacationPersonInfoDO> list = annualVacationPersonInfoManager.getNeedCreateAnnualPerson(types);
        Date now = serverDateManager.getServerDate();//当前日期 作为生成日期
//        Date now = new Date();
//        try {
//            String starDateStr = "2020-09-01";
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            now = sdf.parse(starDateStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        String year = getYear(now);//获取年份
        List<WorkVacationDO> workVacationDOS = new ArrayList<>(); //假期加班主表
//        Date finalNow = now;
        list.forEach(annualVacationPersonInfoDO -> {
            if(now.getTime() > annualVacationPersonInfoDO.getProbationEndDate().getTime() ){ //新入司员工转正后才生成年假
                Integer type = annualVacationPersonInfoDO.getType();
                WorkVacationDO workVacationDO = initWorkVacationDO(annualVacationPersonInfoDO,now,year,type);
                Double workTimes = workVacationDO.getWorkTimes();
                List<WorkVacationDetailDO> WorkVacationDetails = initWorkVacationDetailDO(annualVacationPersonInfoDO,now,year,workTimes);
                workVacationDO.setWorkVacationDetails(WorkVacationDetails);
                workVacationDOS.add(workVacationDO);
            }
        });
        return workVacationDOS;
    }

    @Override
    public List<WorkVacationDetailDO> getWorkVacationDetails(List<WorkVacationDO> workVacationDOS) {
        List<WorkVacationDetailDO> workVacationDetailDOS = new ArrayList<>();
        workVacationDOS.forEach(workVacationDO -> {
            List<WorkVacationDetailDO> workVacationDetails = workVacationDO.getWorkVacationDetails();
            workVacationDetailDOS.addAll(workVacationDetails);
        });
        return workVacationDetailDOS;
    }


    @Override
    public List<WorkVacationDO> getWorkVacationsNeedDelete() {
        List<Integer> types = new ArrayList<>();
        types.add(2);
        List<AnnualVacationPersonInfoDO> list = annualVacationPersonInfoManager.getNeedDeleteAnnualPerson(types);
        List<String> personids = new ArrayList<>();
        list.forEach(annualVacationPersonInfoDO -> {
            String personid = annualVacationPersonInfoDO.getPersonId();
            personids.add(personid);
        });
        List<WorkVacationDO> workVacationDOS = workVacationDao.findAllByPersonIdIn(personids);
        return workVacationDOS;
    }

    @Override
    public List<WorkVacationDetailDO> getWorkVacationDetailsNeedDelete(List<WorkVacationDO> workVacationDOS) {
        List<Integer> annualIds = new ArrayList<>();
        workVacationDOS.forEach(workVacationDO -> {
            annualIds.add(workVacationDO.getId());
        });
        List<WorkVacationDetailDO> workVacationDetailDOS = workVacationDetailDao.findAllByWorkIdIn(annualIds);
        return workVacationDetailDOS;
    }

    @Override
    @Transactional
    public void save(List<WorkVacationDO> workVacationDOS,List<WorkVacationDO> workVacationsDelete,List<WorkVacationDetailDO> workVacationDetailsDelete) {
        List<WorkVacationDetailDO> workVacationDetailDOS = new ArrayList<>();
        workVacationDOS.forEach(workVacationDO -> {
            List<WorkVacationDetailDO> workVacationDetails = workVacationDO.getWorkVacationDetails();
            workVacationDetailDOS.addAll(workVacationDetails);
        });
        workVacationDao.saveAll(workVacationDOS);
        workVacationDetailDao.saveAll(workVacationDetailDOS);
        workVacationDao.deleteAll(workVacationsDelete);
        workVacationDetailDao.deleteAll(workVacationDetailsDelete);
    }

    @Override
    public Page<AnnualVacationInfoDO> getAnnualVacationInfo(WorkVacationQueryCnd cnd) {
        String year = cnd.getYear();
        String personName =cnd.getPersonName();
        String deptId = cnd.getDeptId();
        Integer autoFlag = cnd.getAutoFlag();
        Integer pageNo = cnd.getPageNo();
        Integer pageSize = cnd.getPageSize();
        Integer type = cnd.getType();
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of( pageNo - 1, pageSize, sort);
        Page<AnnualVacationInfoDO> page = annualVacationInfoDao.findAll(new Specification<AnnualVacationInfoDO>() {
            @Override
            public Predicate toPredicate(Root<AnnualVacationInfoDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("year"), year));
                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), deptId));
                }
                if (StringUtils.isNotBlank(cnd.getPersonName())){
                    Predicate c1 = criteriaBuilder.like(root.get("nameCode"),"%" + personName + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("nameCode"),"%" + personName.toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%" + personName + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if(type != null){
                    predicates.add(criteriaBuilder.equal(root.get("type"), type));
                }
                if (autoFlag.equals(0) || autoFlag.equals(1)) {
                    predicates.add(criteriaBuilder.equal(root.get("autoFlag"), autoFlag));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return  page;
    }

    @Override
    public WorkVacationDO processWorkVacationForSave(WorkVacationDO workVacationDO) {
        Integer key = primaryKeyManager.increase("HR_WORK_VACATION");
        workVacationDO.setId(key);// id
        workVacationDO.setWorkTimes(workVacationDO.getWorkTimes()*8);// 天数换成小时1天8小时
        Date now = serverDateManager.getServerDate();
        workVacationDO.setCreateDate(now); // 生成日期
        Date startDate = initStartDate(workVacationDO.getYear());
        Date endDate = initEndDate(startDate);
        workVacationDO.setStartDate(now); // 开始生效日期
        workVacationDO.setEndDate(endDate); // 有效截止日期
        workVacationDO.setAuditFlag(1); // 默认审核通过
        workVacationDO.setAutoFlag(0); // 非系统自动生成

        List<VacationDateDO> vacationDates = vacationDateDao.findAll();
        Integer workType = 1;
        for (VacationDateDO date:vacationDates){
            if (date.getDate().getTime() == workVacationDO.getCreateDate().getTime()) {
                workType = 2;
                break;
            }
        }
        workVacationDO.setWorkType(workType);// 加班类型 1周末2节假日

        // 生成明细
        List<WorkVacationDetailDO> workVacationDetailDOS = new ArrayList<>();
        Integer size = Double.valueOf(workVacationDO.getWorkTimes() * 2 ).intValue();
        Integer detailKey = primaryKeyManager.increaseWithSize("HR_WORK_VACATION_DETAIL", size);
        while ( size > 0 ) {
            WorkVacationDetailDO workVacationDetailDO = new WorkVacationDetailDO();
            workVacationDetailDO.setId(detailKey++);//id
            workVacationDetailDO.setYear(workVacationDO.getYear()); //年份
            workVacationDetailDO.setPersonId(workVacationDO.getPersonId());//员工工号
            workVacationDetailDO.setDept(workVacationDO.getDept()); //部门
            workVacationDetailDO.setWorkTimes(0.5);//明细表默认存0.5小时
            workVacationDetailDO.setType(workVacationDO.getType());//假期类型 13年假
            workVacationDetailDO.setCreateDate(workVacationDO.getCreateDate()); //生成日期
            workVacationDetailDO.setStartDate(workVacationDO.getStartDate()); //有效开始日期
            workVacationDetailDO.setEndDate(workVacationDO.getEndDate());//有效截止日期
            workVacationDetailDO.setUseFlag(0);//使用标志默认为0
            workVacationDetailDO.setWorkId(key);// 假期库id
            workVacationDetailDOS.add(workVacationDetailDO);
            size--;
        }
        workVacationDO.setWorkVacationDetails(workVacationDetailDOS);

        return workVacationDO;
    }

    @Override
    public WorkVacationDO processWorkVacationForUpdate(WorkVacationDO workVacationDO) {
        Date startDate = serverDateManager.getServerDate();
        workVacationDO.setWorkTimes(workVacationDO.getWorkTimes() * 8);// 天数换成小时1天8小时
        Date endDate = initEndDate(startDate);
        workVacationDO.setStartDate(startDate);
        workVacationDO.setEndDate(endDate);

        // 重置明细
        List<WorkVacationDetailDO> workVacationDetailDOS = new ArrayList<>();
        Integer size = Double.valueOf(workVacationDO.getWorkTimes() * 2).intValue();
        Integer detailKey = primaryKeyManager.increaseWithSize("HR_WORK_VACATION_DETAIL", size);
        while ( size > 0 ) {
            WorkVacationDetailDO workVacationDetailDO = new WorkVacationDetailDO();
            workVacationDetailDO.setId(detailKey++);//id
            workVacationDetailDO.setYear(workVacationDO.getYear()); //年份
            workVacationDetailDO.setPersonId(workVacationDO.getPersonId());//员工工号
            workVacationDetailDO.setDept(workVacationDO.getDept()); //部门
            workVacationDetailDO.setWorkTimes(0.5);//明细表默认存0.5小时
            workVacationDetailDO.setType(workVacationDO.getType());//假期类型 13年假
            workVacationDetailDO.setCreateDate(workVacationDO.getCreateDate()); //生成日期
            workVacationDetailDO.setStartDate(workVacationDO.getStartDate()); //有效开始日期
            workVacationDetailDO.setEndDate(workVacationDO.getEndDate());//有效截止日期
            workVacationDetailDO.setUseFlag(0);//使用标志默认为0
            workVacationDetailDO.setWorkId(workVacationDO.getId());// 假期库id
            workVacationDetailDOS.add(workVacationDetailDO);
            size--;
        }
        workVacationDO.setWorkVacationDetails(workVacationDetailDOS);

        return workVacationDO;
    }

    @Override
    @Transactional
    public void saveFromHr(WorkVacationDO workVacationDO) {
        List<WorkVacationDetailDO> workVacationDetailDOS = workVacationDO.getWorkVacationDetails();
        workVacationDao.save(workVacationDO);
        workVacationDetailDao.saveAll(workVacationDetailDOS);
    }

    @Override
    public List<LeaveDO> getReduceAnnualLeaves(String year, Integer days) {
        LeaveQueryCnd cnd = new LeaveQueryCnd();
        cnd.setYear(year);
        List<WorkLeaveVacationDO> workLeaveVacationDOS = leaveRepository.getAnnualVacationUnified(cnd);
        Date now = serverDateManager.getServerDate();//当前日期 作为生成日期
        List<LeaveDO> leaveDOS = new ArrayList<>();
        workLeaveVacationDOS.forEach(workLeaveVacationDO -> {
            LeaveDO leaveDO = new LeaveDO();
            leaveDO.setType(13);//类型13为年假
            leaveDO.setPersonId(workLeaveVacationDO.getPersonId());
            leaveDO.setRemark(REDUCEREMARK);//统一扣除年假备注
            leaveDO.setApplyDate(now);//申请时间默认当前系统时间
//            leaveDO.setLeaveDate(now);//请假时间默认当前系统时间
            if(workLeaveVacationDO.getAnnualDaysLeft() >= days){
                leaveDO.setLeaveTimes(days.doubleValue());//统一扣除年假 请假单 存天数
            }else{
                leaveDO.setLeaveTimes(workLeaveVacationDO.getAnnualDaysLeft());//统一扣除年假 请假单 存天数
            }
            leaveDOS.add(leaveDO);
        });
        return leaveDOS;
    }

    @Override
    @Transactional
    public void updateFromHr(WorkVacationDO workVacationDO, List<WorkVacationDetailDO> deleteList) {
        List<WorkVacationDetailDO> saveList = workVacationDO.getWorkVacationDetails();
        workVacationDao.save(workVacationDO);
        workVacationDetailDao.deleteAll(deleteList);
        workVacationDetailDao.saveAll(saveList);
    }

    private Date initStartDate(String year) {
        try {
            String starDateStr = year + "-01-01";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(starDateStr);
            return startDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Date initEndDate(Date startDate){
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            String endDateStr = (calendar.get(Calendar.YEAR) + 1) + "-03-31";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date endDate = sdf.parse(endDateStr);
            return endDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<WorkVacationDetailDO> initDetail(WorkVacationDO workVacationDO){

        return null;
    }


    @Override
    @Transactional
    public void reduceAnnualVacationUnified(List<LeaveDO> leaveDOS,Integer leaveKey,Integer reduceId) {
        Date now = serverDateManager.getServerDate();//当前日期 作为使用日期
        List<WorkVacationDetailDO> workVacationDetails = workVacationDetailDao.findAllByTypeAndUseFlagOrderByEndDateAsc(13,0);
        List<WorkVacationDetailDO> needSave = new ArrayList<>();
        for(LeaveDO leaveDO : leaveDOS){
            leaveKey++;
            leaveDO.setId(leaveKey);
            Double leaveTimes = Double.valueOf(leaveDO.getLeaveTimes()*8); //换算为小时 作为明细表扣除依据
            for(WorkVacationDetailDO workVacationDetailDO : workVacationDetails){
                if(workVacationDetailDO.getPersonId().equals(leaveDO.getPersonId()) && leaveTimes > 0){
                    workVacationDetailDO.setUseFlag(1);
                    workVacationDetailDO.setLeaveId(leaveKey);
                    workVacationDetailDO.setUseDate(now);
                    leaveTimes = leaveTimes - workVacationDetailDO.getWorkTimes();
                    needSave.add(workVacationDetailDO);
                }
            }
        }
        vacationReduceManager.setFlag(reduceId);
        workVacationDetailDao.saveAll(needSave);
        leaveDao.saveAll(leaveDOS);
    }


    private List<WorkVacationDetailDO> initWorkVacationDetailDO(AnnualVacationPersonInfoDO annualVacationPersonInfoDO,Date now, String year,Double workTimes){
        List<WorkVacationDetailDO> list = new ArrayList<>();
        Integer size = Double.valueOf(workTimes*2).intValue();//明细表将所有年假时间 拆分为0.5小时一个单位
        for(int i = 0;i<size;i++){
            WorkVacationDetailDO workVacationDetailDO = new WorkVacationDetailDO();
            workVacationDetailDO.setYear(year); //年份
            workVacationDetailDO.setPersonId(annualVacationPersonInfoDO.getPersonId());//员工工号
            workVacationDetailDO.setDept(annualVacationPersonInfoDO.getDept()); //部门
            workVacationDetailDO.setWorkTimes(0.5);//明细表默认存4小时
            workVacationDetailDO.setType(13);//假期类型 设为13 年假
            workVacationDetailDO.setCreateDate(now); //生成日期
            workVacationDetailDO.setStartDate(now); //有效开始日期
            workVacationDetailDO.setEndDate(getEndDate(now));//有效截止日期
            workVacationDetailDO.setUseFlag(0);//使用标志默认为0
            list.add(workVacationDetailDO);
        }
        return list;
    }

    private WorkVacationDO initWorkVacationDO(AnnualVacationPersonInfoDO annualVacationPersonInfoDO,Date now, String year,Integer type){
        WorkVacationDO workVacationDO = new WorkVacationDO();
        workVacationDO.setPersonId(annualVacationPersonInfoDO.getPersonId());//员工工号
        workVacationDO.setYear(year); //获取年份
        workVacationDO.setDept(annualVacationPersonInfoDO.getDept());//部门id
        Double standing = getStanding(annualVacationPersonInfoDO,now); //累计工龄
        Double afterStanding = getAfterStanding(annualVacationPersonInfoDO,now); //在司累计工龄
        //年假天数
        workVacationDO.setStanding((double) standing.intValue());
        Integer annualDays = getAnnualDays(standing,afterStanding,annualVacationPersonInfoDO,type,now);
        // 年假天数 存为小时；
        Double workTimes = Double.valueOf(annualDays * 8);
        workVacationDO.setWorkTimes(workTimes);
        workVacationDO.setType(13);//假期类型 设为13 年假
        workVacationDO.setCreateDate(now); //生成日期
        workVacationDO.setStartDate(now); //有效开始日期
        workVacationDO.setEndDate(getEndDate(now));//有效截止日期
        workVacationDO.setAutoFlag(1);//系统自动生成标志
        workVacationDO.setRemark("工龄"+standing.intValue()+"年");
        return workVacationDO;
    }

    //获取年假有效开始日期
    private Date getStartDate(Date now){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        Integer year = cal.get(Calendar.YEAR);
        cal.set(year,0,1);
        return cal.getTime();
    }

    //获取有效截止日期
    private Date getEndDate(Date now){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        Integer year = cal.get(Calendar.YEAR);
        cal.set(year+1,2,31);
        return cal.getTime();
    }

    private String getDept(String personId){
        PersonDO personDO = personManager.getPerson(personId);
        return personDO.getDeptId();
    }

    private String getYear(Date now){
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        String year = String.valueOf(cal.get(Calendar.YEAR));
        return year;
    }

    //获取在司累计工龄
    private Double getAfterStanding(AnnualVacationPersonInfoDO annualVacationPersonInfoDO,Date now){
        Date joiningDate = annualVacationPersonInfoDO.getJioningDate(); //到职日期
        Double month = Double.valueOf(getMonthSpace(joiningDate,now)); //在司累计月份
        Double afterStanding = Double.valueOf(month/12); //在司累计工龄
        return afterStanding;
    }

    //获取累计工龄  在司累计工龄+入司前累计工龄
    private Double getStanding(AnnualVacationPersonInfoDO annualVacationPersonInfoDO,Date now){
        Date joiningDate = annualVacationPersonInfoDO.getJioningDate(); //到职日期
        Double month = Double.valueOf(getMonthSpace(joiningDate,now)); //在司累计月份
        Double standing = Double.valueOf(month/12); //在司累计工龄
        Double beforeStanding = annualVacationPersonInfoDO.getBeforeStanding(); //入司前累计工龄
        standing += beforeStanding;
        return standing;
    }

    private Integer getAnnualDays(Double standing,Double afterStanding,AnnualVacationPersonInfoDO annualVacationPersonInfoDO,Integer type,Date now){
        Integer annualDays = 0;
        /*
            根据到职日期换算在司工龄，在司工龄和入司前工龄，作为累计工龄，换算年假天数
            累计工龄：1-10（小于10）：5天；
            10~20：10天
            20（含）年以上：15天
         */
        Integer yearSpace = getYearSpace(annualVacationPersonInfoDO.getJioningDate(),now);
        if(type.equals(0)){//生成有变化的年假
            annualDays = resetAnnualDays(5,now);
        }else{ //第一次生成年假
            if(standing >= 20){
                annualDays = 15;
                if(yearSpace <= 1){
                    annualDays = resetAnnualDays(annualDays,now);
                }
            }else if(standing >= 10 && standing < 20){
                annualDays = 10;
                if(yearSpace <= 1){
                    annualDays = resetAnnualDays(annualDays,now);
                }
            }else if(standing >= 1 && standing < 10){
                annualDays = 5;
                if(yearSpace <= 1){
                    annualDays = resetAnnualDays(annualDays,now);
                }
            }
        }
        return annualDays;
    }

    public Integer getYearSpace(Date date,Date now){
        Integer result;
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(date);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(now);
        result = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        return Math.abs(result);
    }


    //根据当年在司工作月份数 获取年假天数
    public Integer resetAnnualDays(Integer annualDays,Date now)  {
        int result;
        Calendar nowCal = new GregorianCalendar();
        nowCal.setTime(now);
        result = 12 - nowCal.get(Calendar.MONTH);
        result = result == 0 ? 1 : Math.abs(result);
        annualDays = Double.valueOf(result * annualDays / 12 ).intValue();
        return annualDays;

    }

    //获取月份相差数
    public int getMonthSpace(Date date,Date now)  {
        int result=0;
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(date);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(now);
        result =(cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12 + cal1.get(Calendar.MONTH)- cal2.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);

    }

}
