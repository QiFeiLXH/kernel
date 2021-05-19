package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.CompanySocialMeeterDTO;
import com.bsoft.hr.dto.PersonSocialPlaceDTO;
import com.bsoft.hr.dto.PersonSocialPlaceQueryCndDTO;
import com.bsoft.hr.dto.SocialAdjustmentRecordDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 17:32
 * @Description
 */
public interface SocialSecurityService {

    /** 分子公司社保对接人列表查询
     * @Param: inputContent 查询条件
     * @Param: socialCompanyFlag 社保缴纳地标志
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @return com.bsoft.common.result.Result<CompanySocialMeeterDTO>
     * @author Xuhui Lin
     */
    Result<CompanySocialMeeterDTO> getCompanySocialMeeterList(String inputContent, List<Integer> socialCompanyFlag,Integer pageNo, Integer pageSize);

    /** 分子公司社保对接人保存
     * @Param: 子公司社保对接人保存
     * @return
     * @author Xuhui Lin
     */
    void saveCompanySocialMeeter(CompanySocialMeeterDTO companySocialMeeterDTO);


    /** 查询员工社保缴纳地
     * @Param: cndDTO 查询条件
     * @return com.bsoft.common.result.Result<PersonSocialPlaceDTO>
     * @author Xuhui Lin
     */
    Result<PersonSocialPlaceDTO> getPersonalSocialPlaceList(PersonSocialPlaceQueryCndDTO cndDTO);


    /** 查询员工社保缴纳地调整记录
     * @Param: personId 工号
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @return com.bsoft.common.result.Result<SocialAdjustmentRecordDTO>
     * @author Xuhui Lin
     */
    Result<SocialAdjustmentRecordDTO> getPersonalSocialAdjustmentRecordList(String personId, Integer pageNo, Integer pageSize);

    /** 保存员工社保缴纳地及调整记录
     * @Param: recordDTOS 调整记录
     * @Param: personId 登记人工号
     * @return com.bsoft.common.result.Result<SocialAdjustmentRecordDTO>
     * @author Xuhui Lin
     */
    void savePersonalSocialPlaces(List<SocialAdjustmentRecordDTO> recordDTOS, String personId);


}
