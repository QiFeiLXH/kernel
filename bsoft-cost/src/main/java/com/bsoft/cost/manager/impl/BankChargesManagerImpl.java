package com.bsoft.cost.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.condition.PublicCostCnd;
import com.bsoft.cost.dao.primary.BankChargesDao;
import com.bsoft.cost.dao.primary.BankChargesNoBillDao;
import com.bsoft.cost.dao.primary.CostRecordDao;
import com.bsoft.cost.dao.primary.DeptPublicCostDao;
import com.bsoft.cost.dto.PublicCostCndDTO;
import com.bsoft.cost.entity.primary.BankChargesDO;
import com.bsoft.cost.entity.primary.BankChargesNoBillDO;
import com.bsoft.cost.entity.primary.CostRecordDO;
import com.bsoft.cost.entity.primary.DeptPublicCostDO;
import com.bsoft.cost.manager.BankChargesManager;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.message.bean.EmailMessageBean;
import com.bsoft.message.manager.MessageSenderManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-20 9:48
 * @Version 1.0
 * @Description
 */
@Component
public class BankChargesManagerImpl implements BankChargesManager {
    private static final Logger logger = LoggerFactory.getLogger(BankChargesManagerImpl.class);
    private static final String DEFAULT_FINANCE_CC = "wangsy@bsoft.com.cn"; //财务抄送人（汪思雨）
    @Autowired
    private BankChargesDao bankChargesDao;
    @Autowired
    private BankChargesNoBillDao bankChargesNoBillDao;
    @Autowired
    private MessageSenderManager messageSenderManager;
    @Autowired
    private DeptPublicCostDao deptPublicCostDao;
    @Autowired
    private CostRecordDao costRecordDao;

    @Override
    public void sendPublicFeRemindMessage() {
        logger.info("开始统计对公费用申请待挂账相关邮件 15天 7天");
        List<BankChargesDO> bankChargesDOS = bankChargesDao.findByCostType(1); //costType：1为对公费用
        if (bankChargesDOS.size() > 0) {
            for (BankChargesDO bankChargesDO : bankChargesDOS) {
                EmailSenderBean emailSenderBean = createBankChargesEmail(bankChargesDO);
                emailSenderBean.setSubject("对公费用的待挂账通知");
                String context = setBankChargesMailContext(bankChargesDO);
                emailSenderBean.setText(context);
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                logger.info("对公费用邮件发送消息队列,单号{}",bankChargesDO.getAccountNo());
            }
        }
    }

    @Override
    public void sendWinningBidMessage() {
        logger.info("开始统计中标服务费待挂账相关邮件 15天 7天");
        List<BankChargesDO> bankChargesDOS = bankChargesDao.findByCostType(2); //costType：2为中标服务费
        if (bankChargesDOS.size() > 0) {
            for (BankChargesDO bankChargesDO : bankChargesDOS) {
                EmailSenderBean emailSenderBean = createBankChargesEmail(bankChargesDO);
                emailSenderBean.setSubject("中标服务费待挂账通知");
                String context = setBankChargesMailContext(bankChargesDO);
                emailSenderBean.setText(context);
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                logger.info("中标服务费邮件发送消息队列,单号{}",bankChargesDO.getAccountNo());
            }
        }
    }

    @Override
    public Result<BankChargesNoBillDO> getBillNotReceived(String userId,String context, Integer pageSize, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        Page<BankChargesNoBillDO> costRecordNeedDealDOS = bankChargesNoBillDao.findAll(new Specification<BankChargesNoBillDO>() {
            @Override
            public Predicate toPredicate(Root<BankChargesNoBillDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("applicant"),userId));

                if (!context.equals(null)) {
                    Predicate c1 = criteriaBuilder.like(root.get("collectionUnit"), "%"+context+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("department"), "%"+context+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("attributionItems"), "%"+context+"%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        Result<BankChargesNoBillDO> result = ResultUtils.parseResult(costRecordNeedDealDOS);
        return result;
    }

    @Override
    public Page<DeptPublicCostDO> getPublicCostList(PublicCostCnd publicCostCnd) {
        Pageable pageable = PageRequest.of(publicCostCnd.getPageNo()-1,publicCostCnd.getPageSize());
        Page<DeptPublicCostDO> pages = deptPublicCostDao.findAll(new Specification<DeptPublicCostDO>() {
            @Override
            public Predicate toPredicate(Root<DeptPublicCostDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (publicCostCnd.getReturnFlag() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("invoiceReturnFlag"),publicCostCnd.getReturnFlag()));
                    predicates.add(criteriaBuilder.equal(root.get("releaseMark"),1));
                }

                if (!publicCostCnd.getAllPermission()) {
                    Predicate c1 = criteriaBuilder.equal(root.get("humanResourcesManager"), publicCostCnd.getUserId());
                    Predicate c2 = criteriaBuilder.equal(root.get("depManager"), publicCostCnd.getUserId());
                    Predicate c3 = criteriaBuilder.equal(root.get("areaManager"), publicCostCnd.getUserId());
                    Predicate c4 = criteriaBuilder.equal(root.get("applicationPersonId"), publicCostCnd.getUserId());
                    predicates.add(criteriaBuilder.or(c1, c2, c3,c4));
                }
                if (!StringUtils.isBlank(publicCostCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("receivingDept"), "%" + publicCostCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("receivingDeptSimpleCode"), "%" + publicCostCnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("lshid"), "%" + publicCostCnd.getInputContent() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("applicationPerson"), "%" + publicCostCnd.getInputContent() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("applicationPersonSimpleCode"), "%" + publicCostCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4, c5));
                }

                predicates.add(criteriaBuilder.between(root.get("sqsj"),publicCostCnd.getStartDate(),publicCostCnd.getEndDate()));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public List<CostRecordDO> getNeedFrozenAccount() {
        return costRecordDao.getNeedFrozenAccount();
    }

    @Override
    public DeptPublicCostDO getDeptPublicCostById(Integer id) {
        return deptPublicCostDao.getOne(id);
    }

    @Override
    public void saveCostRecords(List<CostRecordDO> costRecordDOS) {
        costRecordDao.saveAll(costRecordDOS);
    }

    @Override
    public Page<DeptPublicCostDO> getPersonalPublicCostList(PublicCostCnd publicCostCnd) {
        Pageable pageable = PageRequest.of(publicCostCnd.getPageNo()-1,publicCostCnd.getPageSize());
        Page<DeptPublicCostDO> pages = deptPublicCostDao.findAll(new Specification<DeptPublicCostDO>() {
            @Override
            public Predicate toPredicate(Root<DeptPublicCostDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (publicCostCnd.getReturnFlag() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("invoiceReturnFlag"),publicCostCnd.getReturnFlag()));
                    predicates.add(criteriaBuilder.equal(root.get("releaseMark"),1));
                }

                // 获取个人的数据
                predicates.add(criteriaBuilder.equal(root.get("applicationPersonId"), publicCostCnd.getUserId()));
                if (!StringUtils.isBlank(publicCostCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("receivingDept"), "%" + publicCostCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("receivingDeptSimpleCode"), "%" + publicCostCnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("lshid"), "%" + publicCostCnd.getInputContent() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("applicationPerson"), "%" + publicCostCnd.getInputContent() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("applicationPersonSimpleCode"), "%" + publicCostCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4, c5));
                }

                predicates.add(criteriaBuilder.between(root.get("sqsj"),publicCostCnd.getStartDate(),publicCostCnd.getEndDate()));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    /**
     * 设置对公费用，中标服务费的邮件信息
     * @param bankChargesDO
     * @return
     */
    public EmailSenderBean createBankChargesEmail(BankChargesDO bankChargesDO){
        EmailSenderBean emailSenderBean = new EmailSenderBean();
        String userEmail = bankChargesDO.getUserEmail();
        String registrantEmail = bankChargesDO.getRegistrantEmail();
        emailSenderBean.addTo(userEmail);
        emailSenderBean.addTo(registrantEmail);
        setBankChargesMailCC(bankChargesDO, emailSenderBean);
        setDefaultMailCC(emailSenderBean);
        return emailSenderBean;
    }

    /**
     * 设置对公费用，中标服务费提醒邮件抄送人
     * @param bankChargesDO
     * @param emailSenderBean
     */
    public void setBankChargesMailCC(BankChargesDO bankChargesDO, EmailSenderBean emailSenderBean){
        String ccEmail1 = bankChargesDO.getLeaderEmail();
        emailSenderBean.addCC(ccEmail1);
        String officerEmail = bankChargesDO.getOfficerEmail();
        emailSenderBean.addCC(officerEmail);
    }

    public void setDefaultMailCC(EmailSenderBean emailSenderBean){
        emailSenderBean.addCC(DEFAULT_FINANCE_CC);
    }

    /**
     * 设置对公费用，中标服务费邮件内容
     * @param bankChargesDO
     * @return
     */
    public String setBankChargesMailContext(BankChargesDO bankChargesDO){
        String name = "";
        if(bankChargesDO.getCostType().equals(1)){
            name = "对公费用申请单";
        }else{
            name = "中标服务费申请单";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        String context = "&nbsp;&nbsp;您好！<br/>"
                + "<br/>"
                +"&nbsp;&nbsp;申请单号为“" + bankChargesDO.getAccountNo() + "”，“"
                + bankChargesDO.getUnitName() + "”，金额为“"
                + df.format(bankChargesDO.getMoney())
                + "”的"+name+"，未收到发票，将于" + bankChargesDO.getRemindDay() + "日后影响个人账户，请尽快将发票寄到公司财务。<br/>"
                + "<br/>"
                + "&nbsp;&nbsp;逾期不处理，将冻结个人报销账户。<br/>"
                + "<br/>"
                + "&nbsp;&nbsp;财务联系人：<br/>"
                + "&nbsp;&nbsp;周琛       邮箱：zhou.c@bsoft.com.cn<br/>";
        return context;
    }
}
