package com.bsoft.clue.manager;

import com.bsoft.common.result.Result;
import com.bsoft.clue.condition.SalesCluesTaskQueryCnd;
import com.bsoft.clue.entity.primary.SalesCluesTaskDO;
import com.bsoft.clue.entity.primary.SalesCluesViewDO;

import java.util.Map;

public interface SalesCluesManager {
    /**
     * 提交
     *
     * @param clueId           线索编号
     */
    void submit(Integer clueId);

    /**
     * 通过-审核
     * @param personId 审核人
     * @param opinion 审核意见
     * @param taskId  待办任务ID
     * @param clueId  线索编号
     */
    void successApply(String personId,String taskId,String opinion,Integer system,Integer clueId,String processInstanceId);

    /**
     * 拒绝-审核
     * @param personId 审核人
     * @param opinion 审核意见
     * @param taskId 待办任务ID
     */
    void failApply(String personId,String taskId,String opinion,Integer system);

    /**
     * 申请处理方法
     *
     * @param taskId 待办任务ID
     * @param map    变量组
     */
    void apply(String taskId, Map<String, Object> map);

    /**
     * 根据线索编号 获取对应的销售线索信息
     * @param clueId
     * @return
     */
    SalesCluesViewDO getByClueId(Integer clueId);

    /**
     * 根据条件或者流程待办任务
     * @param data
     * @return
     */
    Result<SalesCluesTaskDO> getTaskList(SalesCluesTaskQueryCnd data);

    /**
     * 未及时更新的邮件提醒（更新周期 到期前 7天 提醒 ）
     */
    void sendCluesRemindMessage();

    /**
     * 销售线索超过更新频率要求的时间未更新的，自动关闭立项
     */
    void closeClues();

}
