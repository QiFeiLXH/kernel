package com.bsoft.sales.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.FileUploadTypeManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.sales.condition.SalesAgreementQueryCnd;
import com.bsoft.sales.dto.*;
import com.bsoft.sales.entity.primary.*;
import com.bsoft.sales.manager.CooperationAgreementManager;
import com.bsoft.sales.service.CoopertaionAgreementService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 13:10
 * @Description
 */
@Service
public class CoopertaionAgreementServiceImpl implements CoopertaionAgreementService {
    private static final Logger logger = LoggerFactory.getLogger(CoopertaionAgreementServiceImpl.class);

    @Autowired
    private CooperationAgreementManager cooperationAgreementManager;
    @Autowired
    private FileUploadTypeManager fileUploadTypeManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<SalesPartnerViewDTO> getSalesPartnerList(String inputContent,Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<SalesPartnerViewDO> pages = cooperationAgreementManager.getSalesPartnerList(inputContent,pageNo, pageSize);
        long times = timeConsumer.end();
        logger.info("查找条件：{},获取合作协议-合作单位列表耗时:{}",inputContent,times);
        return ResultUtils.parseResult(pages, SalesPartnerViewDTO.class);
    }

    @Override
    public Integer saveSalesPartner(SalesPartnerDTO salesPartnerDTO,String provinceText, String cityText, String countyText) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer id = null;
        if (salesPartnerDTO.getId() == null) {
            SalesPartnerDO salesPartnerDO = iGenerator.convert(salesPartnerDTO, SalesPartnerDO.class);
            id = cooperationAgreementManager.saveSalesPartner(salesPartnerDO, provinceText, cityText, countyText);
        } else {
            SalesPartnerUpdateDO salesPartnerUpdateDO = iGenerator.convert(salesPartnerDTO, SalesPartnerUpdateDO.class);
            id = cooperationAgreementManager.updateSalesPartner(salesPartnerUpdateDO, provinceText, cityText, countyText);
        }
        long times = timeConsumer.end();
        logger.info("合作协议-保存合作单位耗时:{}",times);
        return id;
    }

    @Override
    public void deleteSalesPartner(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        cooperationAgreementManager.deleteSalesPartner(id);
        long times = timeConsumer.end();
        logger.info("合作单位id：{},合作协议-删除合作单位耗时:{}",id,times);
    }

    @Override
    public Result<SalesAgreementViewDTO> getSalesAgreementList(SalesAgreementQueryCndDTO salesAgreementQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesAgreementQueryCnd cnds = iGenerator.convert(salesAgreementQueryCndDTO, SalesAgreementQueryCnd.class);
        Page<SalesAgreementViewDO> pages = cooperationAgreementManager.getSalesAgreementList(cnds);
        long times = timeConsumer.end();
        logger.info("原件状态：{},合作类别：{},是否披露：{},单位名称：{}，获取合作协议-合作协议列表耗时:{}",salesAgreementQueryCndDTO.getOriginalStatus(), salesAgreementQueryCndDTO.getCooperateType(),salesAgreementQueryCndDTO.getPartnerName(),salesAgreementQueryCndDTO.getNotice(),times);
        return ResultUtils.parseResult(pages, SalesAgreementViewDTO.class);
    }

    @Override
    public SalesAgreementDTO saveSalesAgreement(SalesAgreementDTO salesAgreementDTO, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesAgreementDTO resultDTO = null;
        if (salesAgreementDTO.getId() == null) {
            SalesAgreementDO salesAgreementDO = iGenerator.convert(salesAgreementDTO, SalesAgreementDO.class);
            resultDTO = iGenerator.convert(cooperationAgreementManager.saveSalesAgreement(salesAgreementDO, personId), SalesAgreementDTO.class);
        } else {
            SalesAgreementUpdateDO salesAgreementUpdateDO = iGenerator.convert(salesAgreementDTO, SalesAgreementUpdateDO.class);
            resultDTO = iGenerator.convert(cooperationAgreementManager.updateSalesAgreement(salesAgreementUpdateDO, personId), SalesAgreementDTO.class);
        }
        long times = timeConsumer.end();
        logger.info("员工id:{},合作协议-保存合作协议耗时:{}",personId,times);
        return resultDTO;
    }

    @Override
    public void deleteSalesAgreement(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        cooperationAgreementManager.deleteSalesAgreement(id);
        long times = timeConsumer.end();
        logger.info("合作协议id：{},合作协议-删除合作协议耗时:{}",id,times);
    }

    @Override
    public List<SalesPartnerViewDTO> getSalesPartnerList(String partnerName) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SalesPartnerViewDO> list = cooperationAgreementManager.getSalesPartnerList(partnerName);
        long times = timeConsumer.end();
        logger.info("合作单位名称：{},获取合作协议-合作单位列表耗时:{}",partnerName,times);
        return iGenerator.convert(list, SalesPartnerViewDTO.class);
    }

    @Override
    public List<PublicDicDTO> getFileUploadType() {
        List<PublicDicDO> fileUploadTypes = fileUploadTypeManager.getFileUploadType();
        return iGenerator.convert(fileUploadTypes, PublicDicDTO.class);
    }
}
