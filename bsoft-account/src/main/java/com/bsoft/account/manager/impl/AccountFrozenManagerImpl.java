package com.bsoft.account.manager.impl;

import com.bsoft.account.entity.primary.AccountFrozenInfoDO;
import com.bsoft.account.manager.AccountFrozenInfoManager;
import com.bsoft.account.manager.AccountFrozenManager;
import com.bsoft.account.manager.EmpAccountManager;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.cost.entity.primary.BondSaveDO;
import com.bsoft.cost.entity.primary.CostRecordDO;
import com.bsoft.cost.manager.BankChargesManager;
import com.bsoft.cost.manager.BondManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-14 9:36
 * @Version 1.0
 * @Description
 */
@Component
@Scope("prototype")
public class AccountFrozenManagerImpl implements AccountFrozenManager {
    private static final Logger logger = LoggerFactory.getLogger(AccountFrozenManagerImpl.class);
    @Autowired
    private BondManager bondManager;
    @Autowired
    private BankChargesManager bankChargesManager;
    @Autowired
    private EmpAccountManager empAccountManager;
    @Autowired
    private AccountFrozenInfoManager accountFrozenInfoManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private KeyGenerator keyGenerator;

    private List<AccountFrozenInfoDO> accountFrozenInfoDOS;
    private List<CostRecordDO> costRecordDOS;
    private List<BondSaveDO> bondSaveDOS;
    private List<String> userIds;

    private static final String  BANKCHARGES_REASON = "发票过期逾期";
    private static final String  BANKCHARGES_REMARKS = "（系统自动）超30天未收到票据";
    private static final String  BOND_REASON = "逾期未回款";
    private static final String  BOND_REMARKS = "（系统自动）过期30天未回款";
    private static final String  DEFALUT_INFO = "账户自动冻结";

    @Override
    public void process() {
        accountFrozenInfoDOS = new ArrayList<>();
        costRecordDOS = new ArrayList<>();
        bondSaveDOS = new ArrayList<>();
        userIds = new ArrayList<>();
        processBankCharges();
        processBonds();
    }

    @Override
    @Transactional
    public void doSave() {
        for(String userId : userIds){
            empAccountManager.frozenAccount(userId);
        }
        accountFrozenInfoManager.saveAccountFrozenInfos(accountFrozenInfoDOS);
        bondManager.saveBondInfos(bondSaveDOS);
        bankChargesManager.saveCostRecords(costRecordDOS);
    }

    /*
     * 设置默认账户情况信息
     * */
    public String defaultAccountInfo() {
        Date now = serverDateManager.getServerDate();
        String accountInfo = now + DEFALUT_INFO;
        return accountInfo;
    }

    public void processBankCharges() {
        logger.info("开始获取发票逾期未回的银行费用信息");
        List<CostRecordDO>  needFrozenInfos = bankChargesManager.getNeedFrozenAccount();
        for(CostRecordDO costRecordDO:needFrozenInfos){
            costRecordDO.setAccountInfo(defaultAccountInfo());
            costRecordDOS.add(costRecordDO);
            String userId = costRecordDO.getApplicant();//获取申请人作为归属人
            userIds.add(userId);
            addAccountFrozenInfo(userId,costRecordDO);
        }
    }

    public void processBonds() {
        logger.info("开始获取逾期未回款的保证金信息");
        List<BondSaveDO> needFrozenInfos = bondManager.getNeedFrozenAccount();
        for(BondSaveDO bondInfoDO : needFrozenInfos){
            BondSaveDO bondSaveDO = bondManager.getById(bondInfoDO.getId());
            bondSaveDO.setAccountInfo(defaultAccountInfo());
            bondSaveDOS.add(bondSaveDO);
            String userId = bondInfoDO.getPayee(); //归属人为保证金领款人
            userIds.add(userId);
            addAccountFrozenInfo(userId,bondInfoDO);
        }
    }

    public void addAccountFrozenInfo(String userId,CostRecordDO costRecordDO){
        AccountFrozenInfoDO accountFrozenInfoDO = new AccountFrozenInfoDO();
        accountFrozenInfoDO.setId(keyGenerator.increaseAccountFrozen());
        accountFrozenInfoDO.setDataSource(1); //数据来源 1.t_cbjl 2.t_bmjk
        accountFrozenInfoDO.setBelonger(userId); //归属人
        accountFrozenInfoDO.setReason(BANKCHARGES_REASON);
        accountFrozenInfoDO.setOriginalNo(String.valueOf(costRecordDO.getId()));
        accountFrozenInfoDO.setMoney(costRecordDO.getApprovedAmount());
        accountFrozenInfoDO.setAccountInfo(1);
        Date now  = serverDateManager.getServerDateTime();
        accountFrozenInfoDO.setFrozenTime(now);
        accountFrozenInfoDO.setRemarks(BANKCHARGES_REMARKS);
        accountFrozenInfoDOS.add(accountFrozenInfoDO);
    }

    public void addAccountFrozenInfo(String userId,BondSaveDO bondInfoDO){
        AccountFrozenInfoDO accountFrozenInfoDO = new AccountFrozenInfoDO();
        accountFrozenInfoDO.setId(keyGenerator.increaseAccountFrozen());
        accountFrozenInfoDO.setDataSource(2); //数据来源 1.t_cbjl 2.t_bmjk
        accountFrozenInfoDO.setBelonger(userId); //归属人
        accountFrozenInfoDO.setReason(BOND_REASON);
        accountFrozenInfoDO.setOriginalNo(bondInfoDO.getId());
        accountFrozenInfoDO.setMoney(bondInfoDO.getBond());
        accountFrozenInfoDO.setAccountInfo(1);
        Date now  = serverDateManager.getServerDateTime();
        accountFrozenInfoDO.setFrozenTime(now);
        accountFrozenInfoDO.setRemarks(BOND_REMARKS);
        accountFrozenInfoDOS.add(accountFrozenInfoDO);
    }


}
