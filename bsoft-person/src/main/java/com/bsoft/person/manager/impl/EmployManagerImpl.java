package com.bsoft.person.manager.impl;

import com.bsoft.common.HYMessage.HYMessage;
import com.bsoft.common.dao.primary.CommunicationSubsidyDao;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.entity.primary.CommunicationSubsidyDO;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.HumanDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.smscode.SMSCodeManager;
import com.bsoft.common.utils.DateUtils;
import com.bsoft.common.utils.QRCodeUtils;
import com.bsoft.common.utils.RandomCodeUtils;
import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.exception.ServiceException;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import com.bsoft.file.document.file.service.FileService;
import com.bsoft.message.bean.EmailBasePic;
import com.bsoft.person.condition.EmployQueryCnd;
import com.bsoft.person.dao.primary.*;
import com.bsoft.person.dto.EducationDTO;
import com.bsoft.person.dto.EmployAuditDTO;
import com.bsoft.person.dto.EmployDTO;
import com.bsoft.person.entity.primary.*;
import com.bsoft.person.manager.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
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
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
 */
@Component
public class EmployManagerImpl implements EmployManager {

    @Value("${employ.mail.url}")
    private String url;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployManagerImpl.class);

    @Autowired
    private EmployViewDao employViewDao;

    @Autowired
    private PositionManager positionManager;

    @Autowired
    private ResidentManager residentManager;

    @Autowired
    private FamilyManager familyManager;

    @Autowired
    private EducationManager educationManager;

    @Autowired
    private DivisionManager divisionManager;

    @Autowired
    private WorkManager workManager;

    @Autowired
    private EmployDao employDao;

    @Autowired
    private HumanDicManager humanDicManager;

    @Autowired
    private ServerDateManager serverDateManager;

    @Autowired
    private KeyGenerator keyGenerator;

    @Autowired
    private EmploySubmissionDao employSubmissionDao;

    @Autowired
    private PersonTClassDao personTClassDao;

    @Autowired
    private GeneratorUtil generatorUtil;

    @Reference(protocol = "dubbo",check = false,timeout = 10000)
    private FileService fileService;
    @Autowired
    private FamilyPersonViewDao familyPersonViewDao;
    @Autowired
    private FamilyPersonDao familyPersonDao;

    @Autowired
    private CommunicationSubsidyDao communicationSubsidyDao;
    @Autowired
    private SMSCodeManager smsCodeManager;

    private static final String DEFAULT_SMSCODE_KEY = "Employ_SMSCode";

    @Override
    public Page<EmployViewDO> getRecruitmentRecentInfo(EmployQueryCnd query) {
        Date now = serverDateManager.getServerDateTime();
        LocalDate date = DateUtils.dateToLocalDate(now);
        Sort sort = Sort.by("startDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(query.getPageNumber(),query.getPageSize(),sort);
        Page<EmployViewDO> pages = employViewDao.findAll(new Specification<EmployViewDO>() {
            @Override
            public Predicate toPredicate(Root<EmployViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(!query.getQueryAll()){
                    predicates.add(criteriaBuilder.equal(root.get("registrant"),query.getUserId()));
                }
                predicates.add(criteriaBuilder.greaterThan(root.get("startDate"), DateUtils.localDateToDate(date.minusDays(30))));
                if (!StringUtils.isBlank(query.getContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personName"), "%" + query.getContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("idCard"), "%" + query.getContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                if(!query.getCheckAll()){
                    CriteriaBuilder.In<Integer> in = criteriaBuilder.in(root.get("status"));
                    for(Integer status : query.getStatus()){
                        in.value(status);
                    }
                    predicates.add(in);
                }

                if(query.getCheckTime() != null){
                    predicates.add(criteriaBuilder.equal(root.get("startDate"),query.getCheckTime()));
                }
                if(query.getStartTime() != null){
                    LocalDate start = DateUtils.dateToLocalDate(query.getStartTime());
                    Date endTime = DateUtils.localDateToDate(start.with(TemporalAdjusters.lastDayOfMonth()));
                    predicates.add(criteriaBuilder.between(root.get("startDate"),query.getStartTime(),endTime));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public List<EmployViewDO> getRecentEmployList(EmployQueryCnd query) {
        Date now = serverDateManager.getServerDateTime();
        LocalDate date = DateUtils.dateToLocalDate(now);
        Sort sort = Sort.by("startDate").descending().and(Sort.by("id").descending());
        List<EmployViewDO> list = employViewDao.findAll(new Specification<EmployViewDO>() {
            @Override
            public Predicate toPredicate(Root<EmployViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(!query.getQueryAll()){
                    predicates.add(criteriaBuilder.equal(root.get("registrant"),query.getUserId()));
                }
                predicates.add(criteriaBuilder.greaterThan(root.get("startDate"), DateUtils.localDateToDate(date.minusDays(30))));
                if (!StringUtils.isBlank(query.getContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personName"), "%" + query.getContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("idCard"), "%" + query.getContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                if(!query.getCheckAll()){
                    CriteriaBuilder.In<Integer> in = criteriaBuilder.in(root.get("status"));
                    for(Integer status : query.getStatus()){
                        in.value(status);
                    }
                    predicates.add(in);
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },sort);
        return list;
    }

    @Override
    @Transactional
    public EmployDO saveRecruitmentBaseInfo(EmployDTO dto) {
        EmployDO employDO = employDao.getById(dto.getId());
        if (employDO != null){
            BeanUtils.copyProperties(dto, employDO);
        }else{
            employDO = generatorUtil.convert(dto,EmployDO.class);
        }
        PositionDO positionInfo = generatorUtil.convert(dto,PositionDO.class);
        ResidentDO residentDO = generatorUtil.convert(dto,ResidentDO.class);

        Date now = serverDateManager.getServerDateTime();
        employDO.setRegistrationTime(now);
        if(dto.getId() == null){
            employDO.setId(keyGenerator.increaseRecruitmentInfo());
        }
        ValidateUtil.check(employDO);
        employDO = employDao.save(employDO);

        if(positionInfo.getCommunicationSubsidy() != null){
            savePositionInfo(dto,positionInfo,employDO,now);//保存调动情况
        }

        if(residentDO.getLocalFlag() != null){
            saveResidentInfo(dto,residentDO,employDO,now);//驻地信息
        }

        return employDO;
    }

    @Override
    public EmployViewDO getRecruitmentInfo(Integer id) {

        Optional<EmployViewDO> info = employViewDao.findById(id);
        info.orElseThrow(()->new ServiceException("无该招聘信息"));
        return info.get();
    }

    @Override
    @Transactional
    public void saveRecruitmentAuditInfo(EmployAuditDTO dto) {
        Date now = serverDateManager.getServerDateTime();
        List<EducationDTO> educationListDTO = dto.getEducationList();
        EmployDTO employDTO = dto.getRecruitmentInfoView();
        EmployDO employDO = employDao.getById(employDTO.getId());
        BeanUtils.copyProperties(employDTO, employDO);
        List<EducationDTO> educationList = generatorUtil.convert(educationListDTO,EducationDTO.class);
        PositionDO positionInfo = generatorUtil.convert(employDTO,PositionDO.class);
        ResidentDO residentDO = generatorUtil.convert(employDTO,ResidentDO.class);

        if(employDO.getStatus() == 7){
            EmploySubmissionDO submissionDO = getSubmission(now, employDO);
            ValidateUtil.check(submissionDO);
            employSubmissionDao.save(submissionDO);//T等级情况
        }

        // 如果总部已审，赋值总部审核人，总部审核时间
        if (employDO.getStatus() == 8) {
            employDO.setAuditDate(now);
        }
        savePositionInfo(employDTO,positionInfo, employDO,now);//调动情况
        saveResidentInfo(employDTO, residentDO, employDO,now);//驻地信息
        saveEducation(educationList, employDO);//教育经历

        ValidateUtil.check(employDO);
        employDao.save(employDO);
        updateMajor(employDO.getId());
        updateEducationLevel(employDO.getId());
    }

    @Override
    public EmployAuditDO getRecruitmentAuditInfo(Integer employId) {
        EmployViewDO recruitmentInfo = employViewDao.getOne(employId);
        List<FamilyPersonViewDO> familyList = familyManager.getFamily(employId);
        List<EducationViewDO> educationList = educationManager.getEducationList(employId);
        List<WorkDO> workInfoList = workManager.getWorkList(employId);
        educationList.forEach((education) -> {
            education.setOthers(educationManager.getCertificate(education.getId()));
        });
        EmployAuditDO auditInfoDO = new EmployAuditDO();
        auditInfoDO.setRecruitmentInfoView(recruitmentInfo);
        auditInfoDO.setFamilyList(familyList);
        auditInfoDO.setEducationList(educationList);
        auditInfoDO.setWorkList(workInfoList);
        return auditInfoDO;
    }

    @Override
    @Transactional
    public void deleteRecruitmentInfo(Integer employId) {
        employDao.deleteById(employId);
        positionManager.deleteAllByRecruitmentId(employId);
        residentManager.deleteResident(employId);
    }

    @Transactional
    @Override
    public void sendRecruitmentEmail(EmployDTO dto){
        EmailSenderBean emailSenderBean = new EmailSenderBean();
        emailSenderBean.setSubject("通知");
        emailSenderBean.addTo(dto.getEmail());
        emailSenderBean.addCC(dto.getRegistrantEmail());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ClassPathResource resource = new ClassPathResource("/static/email.png");
        String text = url + java.util.Base64.getEncoder().encodeToString(dto.getId().toString().getBytes());
        try {
            byte[] bytes = QRCodeUtils.encode(text,null,outputStream,resource.getInputStream());
            String context = "尊敬的"+dto.getPersonName()+"先生/女士：<br/>"
                    +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;非常荣幸的通知您，经过初试、复试，您已经通过我司的面试考核，并成为我司的岗位候选人。感谢您对创业慧康“创造数字卫医，服务健康事业”使命的认同。<br/>"
                    +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为了更好的为您办理入职材料审批手续，请您扫描二维码填写相关信息。为确保信息的准确性，请填写好个人信息，仔细审查无误后，点击提交。<br/>"
                    +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"cid:employ\"/><br/>"
                    +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如有疑问，请及时与您对接面试的hr联系。静候佳音！<br/>"
                    +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color:red\"/>建议优先使用微信扫一扫，确保打开访问相机、相册权限！</span>";
            emailSenderBean.setText(context);
            List<EmailBasePic> pics = new ArrayList<>();
            EmailBasePic pic = new EmailBasePic("employ",bytes,"image/jpeg");
            pics.add(pic);
            emailSenderBean.setPics(pics);
            EmailSender.getHrEmailSender().sendEmail(emailSenderBean);
            employDao.updateStatusById(4,dto.getId());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info(e.getMessage());
            throw new ServiceException("发送邮件失败");
        }
    }

    private EmploySubmissionDO getSubmission(Date now, EmployDO employDO) {
        EmploySubmissionDO submissionDO = employSubmissionDao.findByRecruitmentId(employDO.getId());
        if(submissionDO == null){
            submissionDO = new EmploySubmissionDO();
            submissionDO.setId(keyGenerator.increaseSubmission());
        }

        String personClass;
        if(employDO.getRecruitmentType() == 1){ //实习生
            personClass = "T00";
        }else{
            int base = 0;
            Integer education = employDO.getEducation();
            if(education == 5 || education == 6 || education == 7){
                base = 800;
            }else if(education == 4 ){
                base = 1000;
            }else if(education == 3 || education == 8 || education == 9 || education == 10 ||education == 12 || education == 13){
                base = 1200;
            }else if(education == 1 || education == 2 || education == 11 || education == 14){
                base = 3000;
            }
            Double meritPay = employDO.getTrialSalary() - base;
            PersonTClassDO personTClassDO = personTClassDao.findPersonTClass(meritPay);
            if(personTClassDO == null){
                personClass = personTClassDao.findMaxClass();
            }else{
                personClass = personTClassDO.getClassNo();

            }
        }
        submissionDO.setPersonId("0");
        submissionDO.setPersonClass(personClass);
        submissionDO.setStartDate(employDO.getStartDate());
        submissionDO.setRegistrant(employDO.getRegistrant());
        submissionDO.setRegistDate(now);
        submissionDO.setType("入职");
        submissionDO.setFlag(1);
        submissionDO.setSystemParam(1);
        submissionDO.setRecruitmentId(employDO.getId());
        return  submissionDO;
    }

    @Override
    public Map<String,Object> checkRecruitmentStatus(String zpid) {
        Integer id = Integer.valueOf(zpid);
        EmployViewDO employViewDO = employViewDao.getById(id);
        if (employViewDO.getStatus() != 4){
            Map<String,Object> map = new HashMap<>();
            map.put("code",407);
            map.put("msg","已提交，请等待审核...");
            return map;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","SUCCESS");
        return map;
    }

    @Override
    public void sendMessage(String telno) {
        int mobile_code = RandomCodeUtils.getRandomCode(); //获取随机验证码
        String content = "您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。";
        LOGGER.info("mobileno:[{}],[{}]",telno,mobile_code);
        Map<String,Object> res = HYMessage.sendHYMessage(telno,content);
        if(res.get("code").equals("200")){
            smsCodeManager.setToken(DEFAULT_SMSCODE_KEY,telno,String.valueOf(mobile_code),5, TimeUnit.MINUTES);
        }else{
            throw new ServiceException(res.get("msg").toString());
        }
    }

    @Override
    public void checkSms(String telno, String smsCode) {
        if (smsCodeManager.hasToken(DEFAULT_SMSCODE_KEY,telno)){
            if (!smsCodeManager.getToken(DEFAULT_SMSCODE_KEY,telno).equals(smsCode)) {
                throw new ServiceException("您输入的短信验证码不正确!");
            }
        } else {
            throw new ServiceException("请重新获取验证码!");
        }
    }

    @Override
    public EmployViewDO getEmployeinfoWithPhone(String telno) {
        List<EmployViewDO> employViewDOS = employViewDao.findAllByPhoneOrderByIdDesc(telno);
        if (employViewDOS.isEmpty()){
            return null;
        }
        return employViewDOS.get(0);
    }

    @Override
    public EmployDO getRecruitment(Integer zpid) {
        return employDao.getById(zpid);
    }

    @Override
    public void updateEmploymentInfo(EmployDO e) {
        ValidateUtil.check(e);
        employDao.saveAndFlush(e);
    }

    @Override
    public Integer uploadImage(byte[] bytes, String fileName,Integer menuId) {
        Integer key = fileService.save(menuId,fileName,bytes);
        LOGGER.info("文件上传成功[{}]",key);
        return key;
    }

    @Override
    public String getImage(Integer id) {
        LOGGER.info("获取文件[{}]",id);
        FileDefinitionDTO fileDefinitionDTO = fileService.get(id);
        byte[] bytes = fileDefinitionDTO.getData();
        String data = org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
        return data;
    }

    @Override
    public byte[] getImageByte(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        FileDefinitionDTO fileDefinitionDTO = fileService.get(id);
        long times = timeConsumer.end();
        LOGGER.info("获取文件[{}]bean,耗时[{}]",id,times);
        byte[] bytes = fileDefinitionDTO.getData();
        return bytes;
    }

    @Override
    public Map<String, Object> checkSendMessage(String telno, String zpid) {
        Map<String,Object> res = new HashMap<>();
        EmployViewDO employViewDO = getEmployeinfoWithPhone(telno);
        if (employViewDO == null){
            res.put("code",404);
            res.put("msg","请输入面试时的手机号！");
            return res;
        }
        if (!zpid.equals(employViewDO.getId().toString())){
            res.put("code",404);
            res.put("msg","请输入面试时的手机号！");
            return res;
        }
        if (employViewDO.getStatus() != 4){
            res.put("code",407);
            res.put("msg","已提交，请等待审核！");
            return res;
        }
        res.put("code",200);
        res.put("msg","success");
        return res;
    }

    @Override
    public void updateEducation(Integer level,Integer employId) {
        employDao.updateEdtcationById(level,employId);
    }

    @Override
    public List<CommunicationSubsidyDO> getCommunicationSubsidy() {
        return communicationSubsidyDao.findAll();
    }

    @Override
    public void doBack(Integer employId) {
        employDao.doBackToPerson(employId);
    }

    @Override
    public void updateOneInchPhoto(Integer imageId,Integer id) {
        employDao.updateOneInchPhoto(imageId,id);
    }

    @Override
    @Transactional
    public void doBatchHeadquartersAudit(List<Integer> recruitmentIds, String personId) {
        if (!recruitmentIds.isEmpty()) {
            List<EmployDO> employs = employDao.findAllById(recruitmentIds);
            Date auditDate = serverDateManager.getServerDateTime();
            employs.forEach(employ -> {
                employ.setAuditter(personId);
                employ.setAuditDate(auditDate);
                employ.setStatus(8);
            });
            employDao.saveAll(employs);
        }
    }

    @Override
    public EmployViewDO getBankCardInfo(Integer id) {
        EmployViewDO bankCardInfoDO = employViewDao.getById(id);
        return bankCardInfoDO;
    }

    @Override
    public void saveBankCard(EmployDO e) {
        ValidateUtil.check(e);
        employDao.saveAndFlush(e);
    }

    private void updateEducationLevel(Integer zpid){
        List<EducationViewDO> list = educationManager.getEducationList(zpid);
        Integer educationLevel = 0;
        if (list.size()>0){
            educationLevel = list.get(0).getEducation();
            employDao.updateEdtcationById(educationLevel,zpid);
        }
    }

    private void updateMajor(Integer zpid){
        List<EducationViewDO> educationInfoDOS = educationManager.getEducationList(zpid);
        if (educationInfoDOS.size()>0){
            Integer major = educationInfoDOS.get(0).getMajor();
            if (major != null){
                employDao.updateMajorById(major,zpid);
            }
        }
    }

    //保存调动情况
    private void savePositionInfo(EmployDTO employDTO, PositionDO positionInfo, EmployDO employDO, Date now){
        if(employDTO.getPositionInfoId() == null){
            positionInfo.setId(keyGenerator.increasePositionInfo());
        }else{
            positionInfo.setId(employDTO.getPositionInfoId());
        }
        positionInfo.setPersonId("0");
        positionInfo.setRecruitmentId(employDO.getId());
        positionInfo.setRegistrationTime(now);
        positionInfo.setTransferDate(employDO.getStartDate());
        positionInfo.setDepartmentAfter(employDO.getDept());
        positionInfo.setPostAfter(String.valueOf(employDO.getAppliedPosition().intValue()));
        positionInfo.setCsbz(1);
        positionInfo.setFlag(0);
        ValidateUtil.check(positionInfo);
        positionManager.savePosition(positionInfo);
    }

    //驻地信息
    private void saveResidentInfo(EmployDTO employDTO, ResidentDO residentDO, EmployDO employDO, Date now){
        if(residentDO.getLocalFlag() != 0){
            if(residentDO.getLocalFlag() == 1 && residentDO.getDivisionCounty() == null){
                throw new ServiceException("请完善县驻地信息");
            }
            if(residentDO.getLocalFlag() == 2 && residentDO.getDivisionProvince() == null){
                throw new ServiceException("请完善县驻地信息");
            }
            if(residentDO.getLocalFlag() == 3 && residentDO.getDivisionCity() == null){
                throw new ServiceException("请完善县驻地信息");
            }
        }
        if(employDTO.getResidentInfoId() == null){
            residentDO.setId(keyGenerator.increaseResidentInfo());
        }else{
            residentDO.setId(employDTO.getResidentInfoId());
        }

        residentDO.setRecruitmentId(employDO.getId());
        residentDO.setRegistrationTime(now);
        residentDO.setTransferDate(employDO.getStartDate());
        residentDO.setUserId("0");
        ValidateUtil.check(residentDO);
        residentManager.saveRedisent(residentDO);
    }

    private void saveEducation(List<EducationDTO> educationList, EmployDO employDO){
        educationList.forEach(item -> {
            item.setZpid(employDO.getId());
            if(item.getId() == null){
                item.setId(keyGenerator.increaseEducationInfo());
            }
            if(employDO.getStatus() == 7){
                HumanDicDO school = humanDicManager.getValue(11, item.getSchoolName());
                if(school ==null){
                    school = humanDicManager.saveHumanDic(11,item.getSchoolName());
                }
                item.setSchool(school.getId());
                HumanDicDO major = humanDicManager.getValue(9, item.getMajorName() != null?item.getMajorName().trim():item.getMajorName());
                if(major ==null){
                    major = humanDicManager.saveHumanDic(9,item.getMajorName());
                }
                if (item.getMajorName() != null || item.getMajorName().trim() != ""){
                    item.setMajor(major.getId());
                }
            }
        });
        ValidateUtil.check(educationList);
        educationManager.saveEducation(educationList);
    }


}
