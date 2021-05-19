package com.bsoft.person.manager;

import com.bsoft.common.entity.primary.CommunicationSubsidyDO;
import com.bsoft.person.condition.EmployQueryCnd;
import com.bsoft.person.dto.*;
import com.bsoft.person.entity.primary.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
 */
public interface EmployManager {

    /**
     * 分页获取最近5天内及以后的招聘信息
     * @param queryCnd
     * @return
     */
    Page<EmployViewDO> getRecruitmentRecentInfo(EmployQueryCnd queryCnd);

    /**
     * 获取最近5天内及以后的招聘信息列表
     * @param query
     * @return
     */
    List<EmployViewDO> getRecentEmployList(EmployQueryCnd query);

    /**
     * 保存招聘基本信息
     * @param dto
     * @return
     */
    EmployDO saveRecruitmentBaseInfo(EmployDTO dto);

    /**
     * 通过招聘Id获取招聘信息
     * @param id
     * @return
     */
    EmployViewDO getRecruitmentInfo(Integer id);

    /**
     * 保存招聘审核信息
     * @param dto
     */
    void saveRecruitmentAuditInfo(EmployAuditDTO dto);

    /**
     * 通过招聘id获取审核信息
     * @param recruitmentId
     * @return
     */
    EmployAuditDO getRecruitmentAuditInfo(Integer recruitmentId);

    /**
     * 根据id删除招聘信息
     * @param recruitmentId
     */
    void deleteRecruitmentInfo(Integer recruitmentId);

    /**
     * 保存招聘基本信息并发送邮件
     * @param dto
     */
    void sendRecruitmentEmail(EmployDTO dto);

    /**
     * 验证招聘信息状态
     * @param zpid 招聘ID
     */
    Map<String,Object> checkRecruitmentStatus(String zpid);

    /**
     * 入司人员填写资料，根据手机号获取短信验证码
     * @param telno
     */
    void sendMessage(String telno);

    /**
     * 验证是否是正确的验证码
     * @param telno 手机号码
     * @param smsCode 验证码
     * @return
     */
    void checkSms(String telno,String smsCode);

    /**
     * 获取已发二维码右键的入司人员资料
     * @param telno 手机号码
     * @return
     */
    EmployViewDO getEmployeinfoWithPhone(String telno);

    /**
     * 获取已发二维码右键的入司人员资料
     * @param zpid 招聘ID
     * @return
     */
    EmployDO getRecruitment(Integer zpid);

    /**
     * 更新入司人员基本信息
     * @return
     */
    void updateEmploymentInfo(EmployDO e);

    Integer uploadImage(byte[] bytes, String fileName,Integer menuId);

    String getImage(Integer id);

    byte[] getImageByte(Integer id);

    EmployViewDO getBankCardInfo(Integer id);

    void saveBankCard(EmployDO employDO);

    /**
     * 验证是否可以发送短信验证码
     * @param telno
     * @param zpid
     * @return
     */
    Map<String,Object> checkSendMessage(String telno, String zpid);

    void updateEducation(Integer level,Integer employId);

    List<CommunicationSubsidyDO> getCommunicationSubsidy();

    void doBack(Integer employId);

    void updateOneInchPhoto(Integer imageId,Integer id);

    void doBatchHeadquartersAudit(List<Integer> recruitmentIds, String personId);
}
