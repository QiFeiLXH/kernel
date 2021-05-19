package com.bsoft.cost.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.condition.BondInfoQueryCnd;
import com.bsoft.cost.dao.primary.BondAcountDao;
import com.bsoft.cost.dao.primary.BondInfoDao;
import com.bsoft.cost.dao.primary.BondOverdueInfoDao;
import com.bsoft.cost.dao.primary.LeaderShipDao;
import com.bsoft.cost.dto.BondInfoQueryCndDTO;
import com.bsoft.cost.entity.primary.*;
import com.bsoft.cost.dao.primary.*;
import com.bsoft.cost.entity.primary.*;
import com.bsoft.cost.manager.BondManager;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.message.bean.EmailMessageBean;
import com.bsoft.message.manager.MessageSenderManager;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
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
public class BondManagerImpl implements BondManager {
    private static final Logger logger = LoggerFactory.getLogger(BondManagerImpl.class);
    @Autowired
    private LeaderShipDao leaderShipDao;
    @Autowired
    private BondAcountDao bondAcountDao;
    @Autowired
    private BondInfoDao bondInfoDao;
    @Autowired
    private BondSaveDao bondSaveDao;
    @Autowired
    private BankChargesNoBillDao bankChargesNoBillDao;
    @Autowired
    private BondOverdueInfoDao bondOverdueInfoDao;

    public List<String> getLeaderShips(){
        List<LeaderShipDO> leaderShipDOS = leaderShipDao.findByFlag(6);//保证金查询-》抄送领导 里维护的人员 flag为6
        List<String> leaderShips = new ArrayList<>();
        if(leaderShipDOS.size()>0){
            for(LeaderShipDO leaderShipDO:leaderShipDOS){
                if(StringUtils.isNotBlank(leaderShipDO.getEmail())){
                    leaderShips.add(leaderShipDO.getEmail());
                }
            }
        }
        return leaderShips;
    }

    @Override
    public void sendBondRemindMessage() {
        logger.info("开始统计保证金未冲账相关邮件-在预计退款时间，到期前15天，7天，当天");
        List<BondAccountDO> bondAccountDOS = bondAcountDao.findByCostType(1); //costType：1 为保证金
        List<String> leaderShips = getLeaderShips();
        if(bondAccountDOS.size()>0){
            for(BondAccountDO bondAccountDO : bondAccountDOS){
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                emailSenderBean.setSubject("投标保证金预计退款时间到期提醒");
                String toEmail = bondAccountDO.getUserEmail();
                emailSenderBean.addTo(toEmail);
                setBondMailCC(bondAccountDO,emailSenderBean,leaderShips);
                String context = setBondMailContext(bondAccountDO,1);
                emailSenderBean.setText(context);
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                logger.info("保证金未冲账邮件发送消息队列,单号：{}",bondAccountDO.getAccountNo());
            }
        }
    }

    @Override
    public void sendPerformanceBondRemindMessage() {
        logger.info("开始统计履约保证金未冲账相关邮件-在预计退款时间，到期前30天，7天");
        List<BondAccountDO> bondAccountDOS = bondAcountDao.findByCostType(2); //costType：1 为履约保证金
        List<String> leaderShips = getLeaderShips();
        if(bondAccountDOS.size()>0){
            for(BondAccountDO bondAccountDO : bondAccountDOS){
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                emailSenderBean.setSubject("履约保证金预计退款时间到期提醒");
                String toEmail = bondAccountDO.getUserEmail();
                if(StringUtils.isNotBlank(toEmail)){
                    emailSenderBean.setTo(Lists.newArrayList(toEmail));
                }
                setBondMailCC(bondAccountDO,emailSenderBean,leaderShips);
                String context = setBondMailContext(bondAccountDO,2);
                emailSenderBean.setText(context);
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                logger.info("履约保证金未冲账邮件发送消息队列,单号：{}",bondAccountDO.getAccountNo());
            }
        }
    }

    @Override
    public Result<BondInfoDO> getBondNotRushAccount(String userId,Integer performanceSymbol,String context, Integer pageSize, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        Page<BondInfoDO> bondInfoDOS = bondInfoDao.findAll(new Specification<BondInfoDO>() {
            @Override
            public Predicate toPredicate(Root<BondInfoDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("payee"),userId));
                predicates.add(criteriaBuilder.equal(root.get("performanceSymbol"),performanceSymbol));

                if (StringUtils.isNotBlank(context)) {
                    Predicate c1 = criteriaBuilder.like(root.get("collectionUnit"), "%"+context+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("payeeName"), "%"+context+"%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        Result<BondInfoDO> result = ResultUtils.parseResult(bondInfoDOS);
        return result;
    }

    @Override
    public NeedDealCountDO getNeedDealCount(String userId) {
        List<BondInfoDO> bonds = bondInfoDao.findByPayeeAndPerformanceSymbol(userId,0);
        List<BondInfoDO> performanceBonds = bondInfoDao.findByPayeeAndPerformanceSymbol(userId,1);
        List<BankChargesNoBillDO> bankCharges = bankChargesNoBillDao.findByApplicant(userId);
        NeedDealCountDO needDealCountDO = new NeedDealCountDO();
        needDealCountDO.setBond(bonds.size());
        needDealCountDO.setPerformanceBond(performanceBonds.size());
        needDealCountDO.setBankCharges(bankCharges.size());
        return needDealCountDO;
    }

    @Override
    public Page<BondOverdueInfoDO> getBondOverdueInfoList(BondInfoQueryCnd bondInfoQueryCnd) {
        Pageable pageable = PageRequest.of(bondInfoQueryCnd.getPageNo()-1,bondInfoQueryCnd.getPageSize());
        Page<BondOverdueInfoDO> pages = bondOverdueInfoDao.findAll(new Specification<BondOverdueInfoDO>() {
            @Override
            public Predicate toPredicate(Root<BondOverdueInfoDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                // 未冲账
                if (bondInfoQueryCnd.getChargeFlag() == 0) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 0));
                }
                // 已冲账
                if (bondInfoQueryCnd.getChargeFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 1));
                }

                if (!bondInfoQueryCnd.getAllPermission()) {
                    Predicate c1 = criteriaBuilder.equal(root.get("depManager"), bondInfoQueryCnd.getUserId());
                    Predicate c2 = criteriaBuilder.equal(root.get("areaManager"), bondInfoQueryCnd.getUserId());
                    Predicate c3 = criteriaBuilder.equal(root.get("payeeId"), bondInfoQueryCnd.getUserId());
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                if (!StringUtils.isBlank(bondInfoQueryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("receivingDept"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("receivingDeptSimpleCode"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("lshid"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("applicationPerson"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("applicationPersonSimpleCode"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4, c5));
                }
                predicates.add(criteriaBuilder.between(root.get("applicationDate"),bondInfoQueryCnd.getStartDate(),bondInfoQueryCnd.getEndDate()));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public Page<BondOverdueInfoDO> getPersonalBondList(BondInfoQueryCnd bondInfoQueryCnd) {
        Pageable pageable = PageRequest.of(bondInfoQueryCnd.getPageNo()-1,bondInfoQueryCnd.getPageSize());
        Page<BondOverdueInfoDO> pages = bondOverdueInfoDao.findAll(new Specification<BondOverdueInfoDO>() {
            @Override
            public Predicate toPredicate(Root<BondOverdueInfoDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                // 未充账
                if (bondInfoQueryCnd.getChargeFlag() == 0) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 0));
                }
                // 已充账
                if (bondInfoQueryCnd.getChargeFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 1));
                }

                // 获取个人的数据
                predicates.add(criteriaBuilder.equal(root.get("payeeId"), bondInfoQueryCnd.getUserId()));

                if (!StringUtils.isBlank(bondInfoQueryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("receivingDept"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("receivingDeptSimpleCode"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("lshid"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("applicationPerson"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("applicationPersonSimpleCode"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4, c5));
                }

                predicates.add(criteriaBuilder.between(root.get("applicationDate"),bondInfoQueryCnd.getStartDate(),bondInfoQueryCnd.getEndDate()));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public List<BondOverdueInfoDO> getAllBondOverdueInfoList(BondInfoQueryCnd bondInfoQueryCnd) {
        List<BondOverdueInfoDO> list = bondOverdueInfoDao.findAll(new Specification<BondOverdueInfoDO>() {
            @Override
            public Predicate toPredicate(Root<BondOverdueInfoDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                // 未冲账
                if (bondInfoQueryCnd.getChargeFlag() == 0) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 0));
                }
                // 已冲账
                if (bondInfoQueryCnd.getChargeFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 1));
                }

                if (!bondInfoQueryCnd.getAllPermission()) {
                    Predicate c1 = criteriaBuilder.equal(root.get("depManager"), bondInfoQueryCnd.getUserId());
                    Predicate c2 = criteriaBuilder.equal(root.get("areaManager"), bondInfoQueryCnd.getUserId());
                    Predicate c3 = criteriaBuilder.equal(root.get("payeeId"), bondInfoQueryCnd.getUserId());
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                if (!StringUtils.isBlank(bondInfoQueryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("receivingDept"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("receivingDeptSimpleCode"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("lshid"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("applicationPerson"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("applicationPersonSimpleCode"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4, c5));
                }
                predicates.add(criteriaBuilder.between(root.get("applicationDate"),bondInfoQueryCnd.getStartDate(),bondInfoQueryCnd.getEndDate()));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }

    @Override
    public List<BondOverdueInfoDO> getPersonalAllBondList(BondInfoQueryCnd bondInfoQueryCnd) {
        List<BondOverdueInfoDO> list = bondOverdueInfoDao.findAll(new Specification<BondOverdueInfoDO>() {
            @Override
            public Predicate toPredicate(Root<BondOverdueInfoDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                // 未冲账
                if (bondInfoQueryCnd.getChargeFlag() == 0) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 0));
                }
                // 已冲账
                if (bondInfoQueryCnd.getChargeFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 1));
                }

                // 获取个人的数据
                predicates.add(criteriaBuilder.equal(root.get("payeeId"), bondInfoQueryCnd.getUserId()));

                if (!StringUtils.isBlank(bondInfoQueryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("receivingDept"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("receivingDeptSimpleCode"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("lshid"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("applicationPerson"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("applicationPersonSimpleCode"), "%" + bondInfoQueryCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4, c5));
                }
                predicates.add(criteriaBuilder.between(root.get("applicationDate"),bondInfoQueryCnd.getStartDate(),bondInfoQueryCnd.getEndDate()));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }

    @Override
    public BondOverdueInfoDO getBondOverdueInfoById(String id) {
        return bondOverdueInfoDao.getOne(id);
    }

    @Override
    public List<BondSaveDO> getNeedFrozenAccount() {
        return bondSaveDao.getNeedFrozenAccount();
    }

    @Override
    public void saveBondInfos(List<BondSaveDO> bondSaveDOS) {
        bondSaveDao.saveAll(bondSaveDOS);
    }

    @Override
    public BondSaveDO getById(String id) {
        return bondSaveDao.getOne(id);
    }

    /**
     * 设置保证金未冲账提醒抄送人
     * @param bondAccountDO
     * @param emailSenderBean
     * @param leaderShips
     */
    public void setBondMailCC(BondAccountDO bondAccountDO, EmailSenderBean emailSenderBean, List<String> leaderShips){
        String ccEmail1 = bondAccountDO.getLeaderEmail();
        emailSenderBean.addCC(ccEmail1);
        if(leaderShips.size()>0){
            leaderShips.forEach(leaderShip->{
                emailSenderBean.addCC(leaderShip);
            });
        }
    }

    /**
     * 设置保证金未冲账提醒邮件内容
     * @param bondAccountDO
     * @return
     */
    public String setBondMailContext(BondAccountDO bondAccountDO,Integer costType){
        String name = "";
        if(costType.equals(1)){
            name = "投标保证金";
        }else{
            name = "履约保证金";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        String drawBackDate = DateFormatUtils.format(bondAccountDO.getDrawBackTime(), "yyyy-MM-dd");
        String context = "&nbsp;&nbsp;您好！<br/>"
                + "<br/>"
                +"&nbsp;&nbsp;申请单号为“" + bondAccountDO.getAccountNo() + "”，“"
                + bondAccountDO.getUnitName() + "”，金额为“"
                + df.format(bondAccountDO.getMoney())
                + "”的"+name+"预计退款时间为“"+drawBackDate+"”，请尽快处理。<br/>"
                + "<br/>"
                +"&nbsp;&nbsp;逾期不处理，将冻结个人报销账户。<br/>"
                + "<br/>"
                +"&nbsp;&nbsp;财务联系人：<br/>"
                +"&nbsp;&nbsp;叶菲       电话：0571-81025962<br/>"
                +"&nbsp;&nbsp;方莉颖     电话：0571-88925657<br/>";
        return context;
    }
}
