package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.PersonSocialPlaceQueryCnd;
import com.bsoft.hr.dto.CompanySocialMeeterDTO;
import com.bsoft.hr.dto.PersonSocialPlaceDTO;
import com.bsoft.hr.dto.PersonSocialPlaceQueryCndDTO;
import com.bsoft.hr.dto.SocialAdjustmentRecordDTO;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.manager.SocialSecurityManager;
import com.bsoft.hr.service.SocialSecurityService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 17:33
 * @Description
 */
@Service
public class SocialSecurityServiceImpl implements SocialSecurityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocialSecurityServiceImpl.class);
    @Autowired
    private SocialSecurityManager socialSecurityManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<CompanySocialMeeterDTO> getCompanySocialMeeterList(String inputContent, List<Integer>socialCompanyFlag,Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        // 刷新hr_company_social数据，从wh_gsjg中将hr_company_social缺少的社保公司刷到hr_company_social
        socialSecurityManager.generateLackSocialCompanys();
        LOGGER.info("查找缺少社保公司数据并保存");
        Page<CompanySocialMeeterViewDO> page = socialSecurityManager.getCompanySocialMeeterList(inputContent, socialCompanyFlag,pageNo, pageSize);
        long times = timeConsumer.end();
        LOGGER.info("获取分子公司社保对接人列表耗时:{},查询条件：{}", times,inputContent);
        return ResultUtils.parseResult(page, CompanySocialMeeterDTO.class);
    }

    @Override
    public void saveCompanySocialMeeter(CompanySocialMeeterDTO companySocialMeeterDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        CompanySocialMeeterDO companySocialMeeterDO = iGenerator.convert(companySocialMeeterDTO, CompanySocialMeeterDO.class);
        socialSecurityManager.saveCompanySocialMeeter(companySocialMeeterDO);
        long times = timeConsumer.end();
        LOGGER.info("保存分子公司社保对接人列表耗时:{},", times);
    }

    @Override
    public Result<PersonSocialPlaceDTO> getPersonalSocialPlaceList(PersonSocialPlaceQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonSocialPlaceQueryCnd cnd = iGenerator.convert(cndDTO, PersonSocialPlaceQueryCnd.class);
        Page<PersonSocialPlaceViewDO> page = socialSecurityManager.getPersonalSocialPlaceList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("获取员工社保缴纳地列表耗时:{}", times);
        return ResultUtils.parseResult(page, PersonSocialPlaceDTO.class);
    }

    @Override
    public Result<SocialAdjustmentRecordDTO> getPersonalSocialAdjustmentRecordList(String personId, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<SocialAdjustmentRecordViewDO> page = socialSecurityManager.getPersonalSocialAdjustmentRecordList(personId, pageNo, pageSize);
        long times = timeConsumer.end();
        LOGGER.info("获取员工社保缴纳地调整记录列表耗时:{},工号：{}", times,personId);
        return ResultUtils.parseResult(page, SocialAdjustmentRecordDTO.class);
    }

    @Override
    public void savePersonalSocialPlaces(List<SocialAdjustmentRecordDTO> recordDTOS, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SocialAdjustmentRecordDO> recordDOS = iGenerator.convert(recordDTOS, SocialAdjustmentRecordDO.class);
        socialSecurityManager.savePersonalSocialPlaces(recordDOS, personId);
        long times = timeConsumer.end();
        LOGGER.info("保存员工社保缴纳地及调整记录耗时:{},", times);
    }
}
