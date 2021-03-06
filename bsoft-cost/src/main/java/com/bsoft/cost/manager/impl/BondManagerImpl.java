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
        List<LeaderShipDO> leaderShipDOS = leaderShipDao.findByFlag(6);//???????????????-??????????????? ?????????????????? flag???6
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
        logger.info("??????????????????????????????????????????-?????????????????????????????????15??????7????????????");
        List<BondAccountDO> bondAccountDOS = bondAcountDao.findByCostType(1); //costType???1 ????????????
        List<String> leaderShips = getLeaderShips();
        if(bondAccountDOS.size()>0){
            for(BondAccountDO bondAccountDO : bondAccountDOS){
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                emailSenderBean.setSubject("?????????????????????????????????????????????");
                String toEmail = bondAccountDO.getUserEmail();
                emailSenderBean.addTo(toEmail);
                setBondMailCC(bondAccountDO,emailSenderBean,leaderShips);
                String context = setBondMailContext(bondAccountDO,1);
                emailSenderBean.setText(context);
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                logger.info("??????????????????????????????????????????,?????????{}",bondAccountDO.getAccountNo());
            }
        }
    }

    @Override
    public void sendPerformanceBondRemindMessage() {
        logger.info("????????????????????????????????????????????????-?????????????????????????????????30??????7???");
        List<BondAccountDO> bondAccountDOS = bondAcountDao.findByCostType(2); //costType???1 ??????????????????
        List<String> leaderShips = getLeaderShips();
        if(bondAccountDOS.size()>0){
            for(BondAccountDO bondAccountDO : bondAccountDOS){
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                emailSenderBean.setSubject("?????????????????????????????????????????????");
                String toEmail = bondAccountDO.getUserEmail();
                if(StringUtils.isNotBlank(toEmail)){
                    emailSenderBean.setTo(Lists.newArrayList(toEmail));
                }
                setBondMailCC(bondAccountDO,emailSenderBean,leaderShips);
                String context = setBondMailContext(bondAccountDO,2);
                emailSenderBean.setText(context);
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                logger.info("????????????????????????????????????????????????,?????????{}",bondAccountDO.getAccountNo());
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
                // ?????????
                if (bondInfoQueryCnd.getChargeFlag() == 0) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 0));
                }
                // ?????????
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
                // ?????????
                if (bondInfoQueryCnd.getChargeFlag() == 0) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 0));
                }
                // ?????????
                if (bondInfoQueryCnd.getChargeFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 1));
                }

                // ?????????????????????
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
                // ?????????
                if (bondInfoQueryCnd.getChargeFlag() == 0) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 0));
                }
                // ?????????
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
                // ?????????
                if (bondInfoQueryCnd.getChargeFlag() == 0) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 0));
                }
                // ?????????
                if (bondInfoQueryCnd.getChargeFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("issueFlag"), 1));
                    predicates.add(criteriaBuilder.equal(root.get("chargeFlag"), 1));
                }

                // ?????????????????????
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
     * ???????????????????????????????????????
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
     * ??????????????????????????????????????????
     * @param bondAccountDO
     * @return
     */
    public String setBondMailContext(BondAccountDO bondAccountDO,Integer costType){
        String name = "";
        if(costType.equals(1)){
            name = "???????????????";
        }else{
            name = "???????????????";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        String drawBackDate = DateFormatUtils.format(bondAccountDO.getDrawBackTime(), "yyyy-MM-dd");
        String context = "&nbsp;&nbsp;?????????<br/>"
                + "<br/>"
                +"&nbsp;&nbsp;??????????????????" + bondAccountDO.getAccountNo() + "?????????"
                + bondAccountDO.getUnitName() + "??????????????????"
                + df.format(bondAccountDO.getMoney())
                + "??????"+name+"????????????????????????"+drawBackDate+"????????????????????????<br/>"
                + "<br/>"
                +"&nbsp;&nbsp;????????????????????????????????????????????????<br/>"
                + "<br/>"
                +"&nbsp;&nbsp;??????????????????<br/>"
                +"&nbsp;&nbsp;??????       ?????????0571-81025962<br/>"
                +"&nbsp;&nbsp;?????????     ?????????0571-88925657<br/>";
        return context;
    }
}
