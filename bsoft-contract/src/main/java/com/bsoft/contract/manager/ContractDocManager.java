package com.bsoft.contract.manager;

/**
 * @Author: xucl
 * @DateTime: 2020/12/9 10:05
 * @Description: 合同资料缺失Manager
 */
public interface ContractDocManager {

    /**
     * 考核日期在2020年1月1日以后的合同
     * 合同类型为有合同的
     * 判断是否上传合同原件，没有上传则提醒邮件
     */
    void sendContractOriginalEmail();

    /**
     * 考核日期在2020年1月1日以后的合同
     * 取得方式为招投标的
     * 判断投标会签表里是否有无中标通知书
     * 有则判断合同有无上传投标通知书，没有则邮件提醒
     */
    void sendBidWinningNoticeEmail();

    /**
     * 考核日期在2020年1月1日以后的合同
     * 合同类型：有合同，合同原件：有
     * 合同评审表或者合同原件未维护的
     * 则邮件自动提醒合同评审受理人。
     */
    void sendContractNotMaintainEmail();

}
