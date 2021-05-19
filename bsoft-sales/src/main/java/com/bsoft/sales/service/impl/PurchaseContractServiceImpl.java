package com.bsoft.sales.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.sales.condition.OwnPurchaseContractQueryCnd;
import com.bsoft.sales.condition.PurContractPayQueryCnd;
import com.bsoft.sales.condition.PurchaseContractQueryCnd;
import com.bsoft.sales.dto.*;
import com.bsoft.sales.entity.primary.*;
import com.bsoft.sales.manager.PurchaseContractManager;
import com.bsoft.sales.service.PurchaseContractService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 11:54
 * @Description: 采购合同service实现类
 */
@Service
public class PurchaseContractServiceImpl implements PurchaseContractService {
    private static Logger logger = LoggerFactory.getLogger(PurchaseContractServiceImpl.class);
    @Autowired
    private PurchaseContractManager purchaseContractManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<PurchaseContractViewDTO> getPurchaseContract(PurchaseContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurchaseContractQueryCnd cnd = generatorUtil.convert(cndDTO,PurchaseContractQueryCnd.class);
        Page<PurchaseContractViewDO> page = purchaseContractManager.getPurchaseContract(cnd);
        Result<PurchaseContractViewDTO> result = ResultUtils.parseResult(page, PurchaseContractViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取采购合同列表耗时,[{}]",times);
        return result;
    }

    @Override
    public Result<PurContractPayViewDTO> getPurContractPay(PurContractPayQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurContractPayQueryCnd cnd = generatorUtil.convert(cndDTO,PurContractPayQueryCnd.class);
        Page<PurContractPayViewDO> page = purchaseContractManager.getPurContractPay(cnd);
        Result<PurContractPayViewDTO> result = ResultUtils.parseResult(page,PurContractPayViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取支付信息列表耗时,[{}]",times);
        return result;
    }

    @Override
    public PurContractPayViewDTO getPurContractPay(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurContractPayViewDO payViewDO = purchaseContractManager.getPurContractPay(id);
        PurContractPayViewDTO payViewDTO = generatorUtil.convert(payViewDO,PurContractPayViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取支付信息详细信息耗时,[{}],[{}]",times,id);
        return payViewDTO;
    }

    @Override
    public Integer savePurContractPay(PurContractPayViewDTO payViewDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurContractPayDO payDO = generatorUtil.convert(payViewDTO,PurContractPayDO.class);
        PurContractPayDO payDO1 = purchaseContractManager.savePurContractPay(payDO);
        Integer key = payDO1.getId();
        long times = timeConsumer.end();
        logger.info("更新支付信息详细信息耗时,[{}],id=[{}]",times,key);
        return key;
    }

    @Override
    public void savePurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> paymentDTOs, List<Integer> ids, String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurchaseContractDO contractDO = generatorUtil.convert(purchaseContractDTO, PurchaseContractDO.class);
        contractDO.setApplyId(purchaseContractDTO.getId()); // 采购合同申请id
        List<PurchaseContractPaymentDO> contractPaymentDOS = generatorUtil.convert(paymentDTOs, PurchaseContractPaymentDO.class);
        purchaseContractManager.savePurchaseContract(contractDO,contractPaymentDOS,ids,contractNo);
        long times = timeConsumer.end();
        logger.info("更新采购合同信息，保存、删除付款条件耗时：{},合同号：{}",times,contractNo);
    }

    @Override
    public Integer saveOwnPurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> paymentDTOs, List<Integer> ids, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurchaseContractDO contractDO = generatorUtil.convert(purchaseContractDTO, PurchaseContractDO.class);
        List<PurchaseContractPaymentDO> contractPaymentDOS = generatorUtil.convert(paymentDTOs, PurchaseContractPaymentDO.class);
        Integer purchaseContractId = purchaseContractManager.saveOwnPurchaseContract(contractDO, contractPaymentDOS, ids, personId);
        long times = timeConsumer.end();
        logger.info("更新公司自用采购合同信息，保存、删除付款条件耗时：{}",times);
        return purchaseContractId;
    }

    @Override
    public List<PurchaseContractPaymentDTO> getPurchaseContractPaymentList(Integer purchaseContractId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PurchaseContractPaymentViewDO> list = purchaseContractManager.getPurchaseContractPaymentList(purchaseContractId);
        long times = timeConsumer.end();
        logger.info("获取采购合同付款列表耗时：{}，采购合同id:{}",times,purchaseContractId);
        return generatorUtil.convert(list,PurchaseContractPaymentDTO.class);
    }

    @Override
    public Integer savePaymentApplication(PurContractPayViewDTO payViewDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurContractPayViewDO payViewDO = generatorUtil.convert(payViewDTO,PurContractPayViewDO.class);
        Integer key = purchaseContractManager.savePaymentApplication(payViewDO);
        long times = timeConsumer.end();
        logger.info("生成支付申请耗时：{}，采购合同id:{}",times,payViewDTO);
        return key;
    }

    @Override
    public Result<PurchaseContractViewDTO> getOwnPurchaseContract(OwnPurchaseContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OwnPurchaseContractQueryCnd cnd = generatorUtil.convert(cndDTO,OwnPurchaseContractQueryCnd.class);
        Page<OwnPurchaseContractViewDO> page = purchaseContractManager.getOwnPurchaseContract(cnd);
        Result<PurchaseContractViewDTO> result = ResultUtils.parseResult(page, PurchaseContractViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同列表耗时,[{}]",times);
        return result;
    }

    @Override
    public List<PurchaseContractViewDTO> getAllOwnPurchaseContractList(OwnPurchaseContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OwnPurchaseContractQueryCnd cnd = generatorUtil.convert(cndDTO,OwnPurchaseContractQueryCnd.class);
        List<OwnPurchaseContractViewDO> list = purchaseContractManager.getAllOwnPurchaseContractList(cnd);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合所有列表耗时,[{}]",times);
        return generatorUtil.convert(list, PurchaseContractViewDTO.class);
    }

    @Override
    public PurchaseContractViewDTO getOwnPurchaseContract(Integer purchaseContractId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OwnPurchaseContractViewDO contractViewDO = purchaseContractManager.getOwnPurchaseContract(purchaseContractId);
        long times = timeConsumer.end();
        logger.info("获取公司采购合同耗时,[{}],采购id:{}",times,purchaseContractId);
        return generatorUtil.convert(contractViewDO, PurchaseContractViewDTO.class);
    }

    @Override
    public Integer getOwnUnfinishedCount(Integer signYear,String inputContent, String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = purchaseContractManager.getOwnUnfinishedCount(signYear,inputContent,userId);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同未完结数量耗时,[{}]",times);
        return count;
    }

    @Override
    public void deleteOwnPurchaseContractCount(Integer purchaseContractId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        purchaseContractManager.deleteOwnPurchaseContractCount(purchaseContractId);
        long times = timeConsumer.end();
        logger.info("删除公司自用采购合同耗时:{}, 采购id:{}",times, purchaseContractId);
    }

    @Override
    public Result<PurchaseContractViewDTO> getOwnPurchaseContractAuditList(OwnPurchaseContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OwnPurchaseContractQueryCnd cnd = generatorUtil.convert(cndDTO,OwnPurchaseContractQueryCnd.class);
        Page<OwnPurchaseContractViewDO> page = purchaseContractManager.getOwnPurchaseContractAuditList(cnd);
        Result<PurchaseContractViewDTO> result = ResultUtils.parseResult(page, PurchaseContractViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同审核列表耗时,[{}]",times);
        return result;
    }

    @Override
    public Integer getOwnUnreviewedCount(Integer signYear,String inputContent) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = purchaseContractManager.getOwnUnreviewedCount(signYear,inputContent);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同未审核数量耗时,[{}]",times);
        return count;
    }

    @Override
    public void auditOwnPurchaseContract(Integer contractId, Integer oldStatus, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        purchaseContractManager.auditOwnPurchaseContract(contractId, oldStatus, personId);
        long times = timeConsumer.end();
        logger.info("审核公司自用采购合同耗时[{}]，审核状态：{}, 审核人：{}",times, oldStatus,personId);
    }

    @Override
    public void disagreeOwnPurchaseContract(Integer contractId,Integer oldStatus) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        purchaseContractManager.disagreeOwnPurchaseContract(contractId,oldStatus);
        long times = timeConsumer.end();
        logger.info("驳回公司自用采购合同耗时[{}]，采购合同id：{},原状态：{}",times,contractId,oldStatus );
    }

    @Override
    public Result<OwnPurchaseCostPaymentDTO> getOwnPurchaseCostPaymentList(String purchaseContractNo, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<OwnPurchaseCostPaymentViewDO> page = purchaseContractManager.getOwnPurchaseCostPaymentList(purchaseContractNo, pageNo, pageSize);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同支付信息列表耗时,[{}]",times);
        return ResultUtils.parseResult(page, OwnPurchaseCostPaymentDTO.class);
    }

    @Override
    public Result<PurchaseContractViewDTO> getOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OwnPurchaseContractQueryCnd cnd = generatorUtil.convert(cndDTO,OwnPurchaseContractQueryCnd.class);
        PageInfo<OwnPurchaseContractViewDO> page = purchaseContractManager.getOwnPurchaseContractWithProgressList(cnd);
        Result<PurchaseContractViewDTO> result = ResultUtils.parseResult(page, PurchaseContractViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同(进度数据)列表耗时,[{}]",times);
        return result;
    }

    @Override
    public List<PurchaseContractViewDTO> getAllOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OwnPurchaseContractQueryCnd cnd = generatorUtil.convert(cndDTO,OwnPurchaseContractQueryCnd.class);
        List<OwnPurchaseContractViewDO> list = purchaseContractManager.getAllOwnPurchaseContractWithProgressList(cnd);
        long times = timeConsumer.end();
        logger.info("导出公司自用采购合同(进度数据)列表耗时,[{}]",times);
        return generatorUtil.convert(list, PurchaseContractViewDTO.class);
    }

    @Override
    public List<PurchaseContractProgressDTO> getOwnPurchaseContractProgressList(Integer purchaseContractId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<OwnPurchaseContractProgressViewDO> list = purchaseContractManager.getOwnPurchaseContractProgressList(purchaseContractId);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同进度列表耗时[{}]，采购合同id: {}",times,purchaseContractId);
        return generatorUtil.convert(list, PurchaseContractProgressDTO.class);
    }

    @Override
    public String getOwnPurchaseContractNo(Integer hasContract, Integer classification, String signDate) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        String contractNo = purchaseContractManager.getOwnPurchaseContractNo(hasContract, classification, signDate);
        long times = timeConsumer.end();
        logger.info("生成公司自用采购合同号耗时[{}]，有无合同: {}，合同分类：{}, 签定日期：{}",times,hasContract, classification, signDate);
        return contractNo;
    }

    @Override
    public Result<PurchaseContractViewDTO> getOwnPurchaseContractSelectList(String inputContent, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<OwnPurchaseContractViewDO> page = purchaseContractManager.getOwnPurchaseContractSelectList(inputContent, pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同选择列表耗时[{}]，输入内容: {}",times,inputContent);
        return ResultUtils.parseResult(page, PurchaseContractViewDTO.class);
    }

    @Override
    public Result<PurchaseContractViewDTO> getOwnPurchaseContractSearchList(Integer purchaseContractId, String inputContent, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<OwnPurchaseContractViewDO> page = purchaseContractManager.getOwnPurchaseContractSearchList(purchaseContractId, inputContent, pageNo, pageSize);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同查找列表耗时[{}]，采购合同id:{},输入内容: {}",times,purchaseContractId,inputContent);
        return ResultUtils.parseResult(page, PurchaseContractViewDTO.class);
    }

    @Override
    public Integer savePurchaseContractProgress(PurchaseContractProgressDTO progressDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurchaseContractProgressDO progress = generatorUtil.convert(progressDTO, PurchaseContractProgressDO.class);
        Integer progressId = null;
        if (progress.getId() == null) {
            // 保存
            progressId = purchaseContractManager.savePurchaseContractProgress(progress);
        } else {
            progressId = purchaseContractManager.updatePurchaseContractProgress(progress);
        }
        long times = timeConsumer.end();
        logger.info("保存公司自用采购合同进度耗时[{}]",times);
        return progressId;
    }

    @Override
    public Result<PurchaseContractViewDTO> getOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OwnPurchaseContractQueryCnd cnd = generatorUtil.convert(cndDTO,OwnPurchaseContractQueryCnd.class);
        PageInfo<OwnPurchaseContractViewDO> pageInfo = purchaseContractManager.getOwnPurchaseContractInfoList(cnd);
        long times = timeConsumer.end();
        logger.info("获取公司自用采购合同情况列表耗时,[{}]",times);
        return ResultUtils.parseResult(pageInfo, PurchaseContractViewDTO.class);
    }

    @Override
    public List<PurchaseContractViewDTO> getAllOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OwnPurchaseContractQueryCnd cnd = generatorUtil.convert(cndDTO,OwnPurchaseContractQueryCnd.class);
        List<OwnPurchaseContractViewDO> list = purchaseContractManager.getAllOwnPurchaseContractInfoList(cnd);
        long times = timeConsumer.end();
        logger.info("获取公司所有自用采购合同情况列表耗时,[{}]",times);
        return generatorUtil.convert(list,PurchaseContractViewDTO.class);
    }

    @Override
    public Integer getPortalPurchaseContractAuditNeedDoCount(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer needDoCount = purchaseContractManager.getPortalPurchaseContractAuditNeedDoCount(personId);
        long times = timeConsumer.end();
        logger.info("获取工号：{}，门户采购合同待审核数量耗时,[{}]",personId,times);
        return needDoCount;
    }

    @Override
    public Boolean existPurchaseContract(String purchaseContractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        boolean result = purchaseContractManager.existPurchaseContract(purchaseContractNo);
        long times = timeConsumer.end();
        logger.info("判断采购合同号：{}，是否存在耗时,[{}]",purchaseContractNo,times);
        return result;
    }

    @Override
    public Integer getOwnPurchaseContractSuplementCount(Integer purchaseContractId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer count = purchaseContractManager.getOwnPurchaseContractSuplementCount(purchaseContractId);
        long times = timeConsumer.end();
        logger.info("查询采购合同id：{}已有的补充协议数量，是否存在耗时,[{}]",purchaseContractId,times);
        return count;
    }

    @Override
    public void alterOwnPurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> saves, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurchaseContractDO contractDO = generatorUtil.convert(purchaseContractDTO, PurchaseContractDO.class);
        List<PurchaseContractPaymentViewDO> contractPaymentDOS = generatorUtil.convert(saves, PurchaseContractPaymentViewDO.class);
        purchaseContractManager.alterOwnPurchaseContract(contractDO, contractPaymentDOS, personId);
        long times = timeConsumer.end();
        logger.info("变更公司自用采购合同金额，保存付款条件耗时：{}",times);
    }

    @Override
    public void auditAlterOwnPurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> saves,String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurchaseContractDO contractDO = generatorUtil.convert(purchaseContractDTO, PurchaseContractDO.class);
        List<PurchaseContractPaymentDO> contractPaymentDOS = generatorUtil.convert(saves, PurchaseContractPaymentDO.class);
        purchaseContractManager.auditAlterOwnPurchaseContract(contractDO, contractPaymentDOS, personId);
        long times = timeConsumer.end();
        logger.info("审核通过变更公司自用采购合同金额，付款条件耗时：{}",times);
    }

    @Override
    public void disagreeAlterOwnPurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> saves) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PurchaseContractDO contractDO = generatorUtil.convert(purchaseContractDTO, PurchaseContractDO.class);
        List<PurchaseContractPaymentDO> contractPaymentDOS = generatorUtil.convert(saves, PurchaseContractPaymentDO.class);
        purchaseContractManager.disagreeAlterOwnPurchaseContract(contractDO, contractPaymentDOS);
        long times = timeConsumer.end();
        logger.info("退回变更公司自用采购合同金额，付款条件耗时：{}，审核人：{}",times);

    }

    @Override
    public List<PurchaseContractPaymentDTO> getOwnPurchaseContractPaymentList(Integer purchaseContractId, Integer alterFlag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PurchaseContractPaymentViewDO> list = purchaseContractManager.getOwnPurchaseContractPaymentList(purchaseContractId, alterFlag);
        long times = timeConsumer.end();
        logger.info("获取公司采购合同付款列表耗时：{}，采购合同id:{},变更id:{}",times,purchaseContractId,alterFlag);
        return generatorUtil.convert(list,PurchaseContractPaymentDTO.class);
    }


}
