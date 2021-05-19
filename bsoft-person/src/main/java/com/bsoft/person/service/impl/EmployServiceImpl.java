package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dto.CommunicationSubsidyDTO;
import com.bsoft.common.entity.primary.CommunicationSubsidyDO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.BeanCopyUtil;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.person.condition.EmployQueryCnd;
import com.bsoft.person.dto.*;
import com.bsoft.person.entity.primary.*;
import com.bsoft.person.manager.*;
import com.bsoft.person.service.EmployService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/5/20
 * @Description:
 */
@Service
public class EmployServiceImpl implements EmployService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployServiceImpl.class);

    @Autowired
    private EmployManager employManager;

    @Autowired
    private FamilyManager familyManager;

    @Autowired
    private WorkManager workManager;

    @Autowired
    private EducationManager educationManager;

    @Autowired
    private DivisionManager divisionManager;

    @Autowired
    private GeneratorUtil generatorUtil;


    @Override
    public Integer uploadImage(byte[] bytes, String fileName,Integer menuId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer key = employManager.uploadImage(bytes,fileName,menuId);
        long times = timeConsumer.end();
        LOGGER.info("上传招聘资料耗时:{}",times);
        return key;
    }

    @Override
    public String getImage(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        String data = employManager.getImage(id);
        long times = timeConsumer.end();
        LOGGER.info("获取招聘资料图片[{}]耗时:{}",id,times);
        return data;
    }

    @Override
    public byte[] getImageByte(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        byte[] data = employManager.getImageByte(id);
        long times = timeConsumer.end();
        LOGGER.info("获取招聘资料字节图片[{}]耗时:{}",id,times);
        return data;
    }

    @Override
    public Map<String, Object> checkSendMessage(String telno, String zpid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Map<String,Object> map = employManager.checkSendMessage(telno,zpid);
        long times = timeConsumer.end();
        LOGGER.info("判断是否允许发送二维码耗时:{}",times);
        return map;
    }

    @Override
    public Map<String,Object> checkRecruitmentStatus(String zpid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Map<String,Object> map = employManager.checkRecruitmentStatus(zpid);
        long times = timeConsumer.end();
        LOGGER.info("扫描二维码获取招聘信息状态id = [{}]，耗时[{}]",zpid,times);
        return map;
    }

    @Override
    public void sendMessage(String telno) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        employManager.sendMessage(telno);
        long times = timeConsumer.end();
        LOGGER.info("填写入司资料获取手机[{}]验证码耗时:{}",telno,times);
    }

    @Override
    public void checkSmsCode(String telno, String smsCode) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        employManager.checkSms(telno,smsCode);
        long times = timeConsumer.end();
        LOGGER.info("填写入司资料验证手机[{}]和验证码[{}]耗时:{}",telno,smsCode,times);
    }

    @Override
    public EmployDTO getRecruitmentInfo(String mobileno) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        EmployViewDO employViewDO = employManager.getEmployeinfoWithPhone(mobileno);
        EmployDTO employDTO = generatorUtil.convert(employViewDO, EmployDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取待入司人员基本信息[{}]耗时:{}",mobileno,times);
        return employDTO;
    }

    @Override
    public void upDateEmploymentInfo(EmployDTO employDTO) {
        try {
            TimeConsumer timeConsumer = TimeConsumer.start();
            EmployDO employDO = employManager.getRecruitment(employDTO.getId());
            new BeanCopyUtil().copyProperties(employDO,employDTO,true);
            employManager.updateEmploymentInfo(employDO);
            long times = timeConsumer.end();
            LOGGER.info("更新待入司人员基本信息[{}]耗时:{}", employDTO,times);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            LOGGER.info("基本信息[{}]转换成招聘信息失败！",employDTO);
            throw new ServiceException("保存基本信息失败！");
        }
    }

    @Override
    public List<FamilyPersonDTO> getFamilyList(Integer zpid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<FamilyPersonViewDO> familyPersonViewDOS = familyManager.getFamily(zpid);
        List<FamilyPersonDTO> familyPersonViewDTOS = generatorUtil.convert(familyPersonViewDOS,FamilyPersonDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取待入司人员家庭人员情况[{}]耗时:{}",zpid,times);
        return familyPersonViewDTOS;
    }

    @Override
    public void saveFamilyList(List<FamilyPersonDTO> familyPersonDTOS) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        familyManager.saveFamily(familyPersonDTOS);
        long times = timeConsumer.end();
        LOGGER.info("保存家庭人员信息[{}],并获取最新家庭人员信息情况耗时:{}", familyPersonDTOS,times);
    }

    @Override
    public void deleteFamily(Integer id) {
        TimeConsumer time = TimeConsumer.start();
        familyManager.deleteFamilyWithTransaction(id);
        long times = time.end();
        LOGGER.info("id:{},删除待入司人员家庭情况耗时:{}",id,times);
    }

    @Override
    public List<EducationDTO> getEducationInfo(Integer zpid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<EducationViewDO> educationViewDOS = educationManager.getEducationList(zpid);
        List<EducationDTO> educationViewDTOS = generatorUtil.convert(educationViewDOS,EducationDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取招聘[{}]的教育经历信息情况耗时:{}",zpid,times);
        return educationViewDTOS;
    }

    @Override
    public void saveEducationInfo(List<EducationDTO> list) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        educationManager.saveEducation(list);
        long times = timeConsumer.end();
        LOGGER.info("保存教育经历信息情况[{}]耗时:{}",list,times);
    }

    @Override
    public List<CertificateDTO> getCertificates(Integer educationId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CertificateDO> certificateDOS = educationManager.getCertificate(educationId);
        List<CertificateDTO> certificateDTOS = generatorUtil.convert(certificateDOS,CertificateDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取学习经历[{}]的其他证书情况耗时:{}",educationId,times);
        return certificateDTOS;
    }

    @Override
    public void deleteEducation(Integer id) {
        TimeConsumer time = TimeConsumer.start();
        educationManager.deleteEducation(id);
        long times = time.end();
        LOGGER.info("id:{},删除教育情况耗时:{}",id,times);
    }

    @Override
    public void deleteCertificate(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        educationManager.deleteCertificate(id);
        long times = timeConsumer.end();
        LOGGER.info("删除学习经历的其他证书[{}]耗时:{}",id,times);
    }

    @Override
    public List<AdministrativeDivisionDTO> getAdministrativeDivision(Integer level) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AdministrativeDivisionDO> administrativeDivisionDOS = divisionManager.getAdministrativeDivision(level,0);
        List<AdministrativeDivisionDTO> administrativeDivisionDTOS = generatorUtil.convert(administrativeDivisionDOS,AdministrativeDivisionDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取级别 = [{}]的下级行政区划耗时:{}",level,times);
        return administrativeDivisionDTOS;
    }

    @Override
    public List<AdministrativeDivisionDTO> getAdministrativeDivisionList(Integer parentCode) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AdministrativeDivisionDO> administrativeDivisionDOS = divisionManager.getAdministrativeDivisionList(parentCode);
        List<AdministrativeDivisionDTO> administrativeDivisionDTOS = generatorUtil.convert(administrativeDivisionDOS,AdministrativeDivisionDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取[{}]的的下级行政区划耗时:{}",parentCode,times);
        return administrativeDivisionDTOS;
    }

    @Override
    public AdministrativeDivisionDTO getDivisionCity(Integer code) {
        TimeConsumer time = TimeConsumer.start();
        AdministrativeDivisionDO area = divisionManager.getDivisionCity(code);
        long times = time.end();
        LOGGER.info("县id:{},获取行政区划市耗时:{}",code,times);
        return generatorUtil.convert(area,AdministrativeDivisionDTO.class);
    }

    @Override
    public List<WorkDTO> getWorkInfo(Integer zpid) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<WorkDO> workDOS = workManager.getWorkList(zpid);
        List<WorkDTO> workDTOS = generatorUtil.convert(workDOS,WorkDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取[{}]的工作经历耗时:{}",zpid,times);
        return workDTOS;
    }

    @Override
    public void saveWorkInfo(List<WorkDTO> list) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        workManager.saveWork(list);
        long times = timeConsumer.end();
        LOGGER.info("保存工作经历信息情况[{}]耗时:{}",list,times);
    }

    @Override
    public void deleteWork(Integer id) {
        TimeConsumer time = TimeConsumer.start();
        workManager.deleteWork(id);
        long times = time.end();
        LOGGER.info("id:{},删除工作情况耗时:{}",id,times);
    }

    @Override
    public BankCardInfoDTO getBankCardInfo(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        EmployViewDO bankCardInfoDO = employManager.getBankCardInfo(id);
        BankCardInfoDTO bankCardInfoDTO = generatorUtil.convert(bankCardInfoDO,BankCardInfoDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取[{}]的工资卡信息耗时:{}",id,times);
        return bankCardInfoDTO;
    }

    @Override
    public void saveBankCardInfo(BankCardInfoDTO bankCardInfoDTO) {
        try {
            TimeConsumer timeConsumer = TimeConsumer.start();
            EmployDO employDO = employManager.getRecruitment(bankCardInfoDTO.getId());
            new BeanCopyUtil().copyProperties(employDO,bankCardInfoDTO,true);
            employManager.saveBankCard(employDO);
            long times = timeConsumer.end();
            LOGGER.info("保存工资卡信息[{}]耗时:{}",bankCardInfoDTO,times);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            LOGGER.info("工资卡信息[{}]转换成招聘信息失败！",bankCardInfoDTO);
            throw new ServiceException("工资卡信息保存失败！");
        }
    }

    @Override
    public List<AdministrativeDivisionDTO> getAdministrativeDivisionTree() {
        TimeConsumer time = TimeConsumer.start();
        List<AdministrativeDivisionDO> areaDOS = divisionManager.getAdministrativeDivisionTree();
        long times = time.end();
        LOGGER.info("获取行政区划树耗时:{}",times);
        return generatorUtil.convert(areaDOS,AdministrativeDivisionDTO.class);
    }

    @Override
    public Result<EmployDTO> getRecruitmentRecentInfo(EmployQueryDTO cnd) {
        TimeConsumer time = TimeConsumer.start();
        EmployQueryCnd queryCnd = generatorUtil.convert(cnd,EmployQueryCnd.class);
        Page<EmployViewDO> pages = employManager.getRecruitmentRecentInfo(queryCnd);
        Result<EmployDTO> result = ResultUtils.parseResult(pages, EmployDTO.class);
        long times = time.end();
        LOGGER.info("工号：{},pageNumber:{},pageSize:{},获取招聘信息耗时:{}",cnd.getUserId(),cnd.getPageNumber(),cnd.getPageSize(),times);
        return result;
    }

    @Override
    public List<EmployDTO> getRecentEmployList(EmployQueryDTO cnd) {
        TimeConsumer time = TimeConsumer.start();
        EmployQueryCnd queryCnd = generatorUtil.convert(cnd,EmployQueryCnd.class);
        List<EmployViewDO> list = employManager.getRecentEmployList(queryCnd);
        List<EmployDTO> result = generatorUtil.convert(list, EmployDTO.class);
        long times = time.end();
        LOGGER.info("工号：{},获取招聘信息列表耗时:{}",cnd.getUserId(),times);
        return result;
    }


    @Override
    public EmployDTO getRecruitmentInfo(Integer recruitmentId) {
        TimeConsumer time = TimeConsumer.start();
        EmployViewDO recruitmentInfo = employManager.getRecruitmentInfo(recruitmentId);
        long times = time.end();
        LOGGER.info("招聘id:{},获取招聘信息耗时:{}",recruitmentId,times);
        return generatorUtil.convert(recruitmentInfo,EmployDTO.class);
    }

    @Override
    public EmployDTO saveRecruitmentBaseInfo(EmployDTO dto) {
        TimeConsumer time = TimeConsumer.start();
        EmployDO baseInfoDO = employManager.saveRecruitmentBaseInfo(dto);
        if(dto.getSendStatus() == 1){
            dto.setId(baseInfoDO.getId());
            employManager.sendRecruitmentEmail(dto);
        }
        long times = time.end();
        LOGGER.info("登记人：{},保存招聘基本信息耗时:{}",dto.getRegistrant(),times);
        return generatorUtil.convert(baseInfoDO, EmployDTO.class);
    }

    @Override
    public EmployAuditDTO saveRecruitmentAuditInfo(EmployAuditDTO dto) {
        TimeConsumer time = TimeConsumer.start();
        employManager.saveRecruitmentAuditInfo(dto);
        long times = time.end();
        LOGGER.info("登记人：{},招聘id:{},保存招聘审核信息耗时:{}",dto.getRecruitmentInfoView().getRegistrant(),dto.getRecruitmentInfoView().getId(),times);
        return null;
    }

    @Override
    public EmployAuditDTO getRecruitmentAuditInfo(Integer recruitmentId) {
        TimeConsumer time = TimeConsumer.start();
        EmployAuditDO auditInfoDO = employManager.getRecruitmentAuditInfo(recruitmentId);
        long times = time.end();
        LOGGER.info("登记人：{},招聘id:{},获取招聘审核信息耗时:{}",auditInfoDO.getRecruitmentInfoView().getRegistrant(),auditInfoDO.getRecruitmentInfoView().getId(),times);
        return generatorUtil.convert(auditInfoDO,EmployAuditDTO.class);
    }

    @Override
    public void deleteRecruitmentInfo(Integer recruitmentId) {
        TimeConsumer time = TimeConsumer.start();
        employManager.deleteRecruitmentInfo(recruitmentId);
        long times = time.end();
        LOGGER.info("招聘id:{},删除招聘基本信息耗时:{}",times);
    }

    @Override
    public void sendRecruitmentEmail(EmployDTO dto) {
        TimeConsumer time = TimeConsumer.start();
        employManager.sendRecruitmentEmail(dto);
        long times = time.end();
        LOGGER.info("登记人：{},招聘id:{},发送招聘邮件耗时:{}",dto.getRegistrant(),dto.getId(),times);
    }

    @Override
    public List<AdministrativeAreaDTO> getAdministrativeAreaTree(){
        TimeConsumer time = TimeConsumer.start();
        List<AdministrativeAreaDO> areaDOS = divisionManager.getAdministrativeAreaTree();
        long times = time.end();
        LOGGER.info("获取省市县树耗时:{}",times);
        return generatorUtil.convert(areaDOS,AdministrativeAreaDTO.class);
    }

    @Override
    public List<AdministrativeAreaDTO> getAdministrativeArea(Integer parentId) {
        TimeConsumer time = TimeConsumer.start();
        List<AdministrativeAreaDO> areaDOS = divisionManager.getAdministrativeArea(parentId);
        long times = time.end();
        LOGGER.info("上级id:{},获取省或市或县耗时:{}",parentId,times);
        return generatorUtil.convert(areaDOS,AdministrativeAreaDTO.class);
    }

    @Override
    public List<CommunicationSubsidyDTO> getCommunicationSubsidy() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CommunicationSubsidyDO> list = employManager.getCommunicationSubsidy();
        long times = timeConsumer.end();
        LOGGER.info("保存通讯补贴耗时:{}",times);
        return generatorUtil.convert(list,CommunicationSubsidyDTO.class);
    }

    @Override
    public void doBack(Integer employId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        employManager.doBack(employId);
        long times = timeConsumer.end();
        LOGGER.info("招聘信息[{}]退回修改耗时:{}",employId,times);
    }

    @Override
    public void updateOneInchPhoto(Integer imageId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        employManager.updateOneInchPhoto(imageId, id);
        long times = timeConsumer.end();
        LOGGER.info("更新招聘信息id：{}一寸照:{}耗时:{}",id,imageId,times);
    }

    @Override
    public void doBatchHeadquartersAudit(List<Integer> recruitmentIds, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        employManager.doBatchHeadquartersAudit(recruitmentIds, personId);
        long times = timeConsumer.end();
        LOGGER.info("批量总部审核ids:{},审核人：{},耗时:{}",recruitmentIds,personId,times);
    }
}
