package com.bsoft.person.service;

import com.bsoft.common.dto.CommunicationSubsidyDTO;
import com.bsoft.common.result.Result;
import com.bsoft.person.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
 */
public interface EmployService {
    /**
     * 获取最近几个月的招聘信息
     * @param cnd 相关查询条件
     * @return
     */
    Result<EmployDTO> getRecruitmentRecentInfo(EmployQueryDTO cnd);

    /**
     * 获取最近几个月的招聘信息列表
     * @param cnd 相关查询条件
     * @return
     */
    List<EmployDTO> getRecentEmployList(EmployQueryDTO cnd);

    /**
     * 获取招聘信息
     * @param recruitmentId 招聘id
     * @return
     */
    EmployDTO getRecruitmentInfo(Integer recruitmentId);

    /**
     * 保存招聘基本信息
     * @param dto
     * @return
     */
    EmployDTO saveRecruitmentBaseInfo(EmployDTO dto);

    /**
     * 审核招聘信息
     * @param dto
     * @return
     */
    EmployAuditDTO saveRecruitmentAuditInfo(EmployAuditDTO dto);

    /**
     * 查询审核信息详情
     * @param recruitmentId 招聘id
     * @return
     */
    EmployAuditDTO getRecruitmentAuditInfo(Integer recruitmentId);

    /**
     * 删除招聘信息
     * @param recruitmentId 招聘id
     */
    void deleteRecruitmentInfo(Integer recruitmentId);

    /**
     * 删除家庭情况
     * @param id
     */
    void deleteFamily(Integer id);

    /**
     * 删除工作经历
     * @param id
     */
    void deleteWork(Integer id);

    /**
     * 删除教育经历
     * @param id
     */
    void deleteEducation(Integer id);

    /**
     * 发送邮件
     * @param dto
     */
    void sendRecruitmentEmail(EmployDTO dto);

    /**
     * 获取省市县树
     * @return
     */
    List<AdministrativeAreaDTO> getAdministrativeAreaTree();

    /**
     * 通过上级id获取省或市或县
     * @return parentId 上级id
     */
    List<AdministrativeAreaDTO> getAdministrativeArea(Integer parentId);

    /**
     * 上传招聘资料
     * @param bytes
     * @param fileName
     * @param menuId
     * @return
     */
    Integer uploadImage(byte[] bytes, String fileName,Integer menuId);

    /**
     * 获取招聘资料图片
     * @param id
     * @return
     */
    String getImage(Integer id);

    /**
     * 获取招聘资料字节图片
     */
    byte[] getImageByte(Integer id);

    /**
     * 是否允许发送二维码
     * @param telno
     * @param zpid
     * @return
     */
    Map<String, Object> checkSendMessage(String telno, String zpid);

    /**
     * 扫描二维码获取招聘信息状态
     * @param zpid
     * @return
     */
    Map<String,Object> checkRecruitmentStatus(String zpid);

    /**
     * 填写入司资料获取手机验证码
     * @param telno
     */
    void sendMessage(String telno);

    /**
     * 填写入司资料验证手机和验证码
     * @param telno
     * @param smsCode
     */
    void checkSmsCode(String telno, String smsCode);

    /**
     * 通过电话号码获取招聘信息
     * @param mobileno
     * @return
     */
    EmployDTO getRecruitmentInfo(String mobileno);

    /**
     * 更新待入司人员基本信息
     * @param employDTO
     */
    void upDateEmploymentInfo(EmployDTO employDTO);

    /**
     * 获取待入司人员家庭人员情况
     * @param zpid
     * @return
     */
    List<FamilyPersonDTO> getFamilyList(Integer zpid);

    /**
     * 保存家庭人员信息
     * @param familyPersonDTOS
     */
    void saveFamilyList(List<FamilyPersonDTO> familyPersonDTOS);

    /**
     * 获取教育经历信息
     * @param zpid
     * @return
     */
    List<EducationDTO> getEducationInfo(Integer zpid);

    /**
     * 保存教育经历信息
     * @param list
     */
    void saveEducationInfo(List<EducationDTO> list);

    /**
     * 获取学习经历的其他证书情况
     * @param educationId
     * @return
     */
    List<CertificateDTO> getCertificates(Integer educationId);

    /**
     * 删除学习经历的其他证书
     * @param id
     */
    void deleteCertificate(Integer id);

    /**
     * 获取下级行政区划
     * @param level 级别
     * @return
     */
    List<AdministrativeDivisionDTO> getAdministrativeDivision(Integer level);

    /**
     * 通过上级id 获取行政区划
     * @param parentCode
     * @return
     */
    List<AdministrativeDivisionDTO> getAdministrativeDivisionList(Integer parentCode);

    /**
     * 获取行政区划市
     * @param code id
     * @return
     */
    AdministrativeDivisionDTO getDivisionCity(Integer code);

    /**
     * 获取工作经历
     * @param zpid
     * @return
     */
    List<WorkDTO> getWorkInfo(Integer zpid);

    /**
     * 保存工作经历
     * @param list
     */
    void saveWorkInfo(List<WorkDTO> list);

    /**
     * 获取工资卡
     * @param id
     * @return
     */
    BankCardInfoDTO getBankCardInfo(Integer id);

    /**
     * 保存工资卡信息
     * @param bankCardInfoDTO
     */
    void saveBankCardInfo(BankCardInfoDTO bankCardInfoDTO);

    /**
     * 获取行政区划树
     * @return
     */
    List<AdministrativeDivisionDTO> getAdministrativeDivisionTree();

    /**
     * 获取通讯补贴
     * @return
     */
    public List<CommunicationSubsidyDTO> getCommunicationSubsidy();

    /**
     * 退回到未提交状态，员工修改资料
     * @param employId
     */
    void doBack(Integer employId);

    /**
     * 更新招聘信息中的一寸照
     * @param imageId 图片id
     * @param id 招聘id
     */
    void updateOneInchPhoto(Integer imageId,Integer id);

    /**
     * 批量总部审核
     * @param recruitmentIds 招聘id
     * @param personId 审核人
     */
    void doBatchHeadquartersAudit(List<Integer> recruitmentIds, String personId);
}
