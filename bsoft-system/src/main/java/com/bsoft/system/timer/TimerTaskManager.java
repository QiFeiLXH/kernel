package com.bsoft.system.timer;

import com.bsoft.account.timer.FrozenAccountTimer;
import com.bsoft.attendance.timer.EndAuditProjectLogTimer;
import com.bsoft.attendance.timer.EndEditProjectLogTimer;
import com.bsoft.logs.manager.RequestLogManager;
import com.bsoft.logs.manager.UsageLogManager;
import com.bsoft.logs.timer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Component
public class TimerTaskManager implements InitializingBean {
    private final static Logger logger = LoggerFactory.getLogger(TimerTaskManager.class);
    private static final String DEFAULT_TIMER_KEY = "Timer:AllowServer";
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private EndEditProjectLogTimer endEditProjectLogTimer;
    @Autowired
    private EndAuditProjectLogTimer endAuditProjectLogTimer;
    @Autowired
    private FrozenAccountTimer frozenAccountTimer;
    @Autowired
    private UsageLogSinkToRedisTimer usageLogSinkToRedisTimer;
    @Autowired
    private UsageLogCacheClearTimer usageLogCacheClearTimer;
    @Autowired
    private UsageLogManager usageLogManager;
    @Autowired
    private RequestLogSinkToRedisTimer requestLogSinkToRedisTimer;
    @Autowired
    private RequestLogCacheClearTimer requestLogCacheClearTimer;
    @Autowired
    private RequestLogManager requestLogManager;
    @Autowired
    private RequestLogCountTimer requestLogCountTimer;

    @Override
    public void afterPropertiesSet(){
        //在定时器启动前加载redis的缓存
        usageLogManager.initRedisCache();
        requestLogManager.initRedisCache();

        if(isAllowStart()){
            startTimer(endEditProjectLogTimer,new CronTrigger("0 0 2 * * ?")); //超过2天的未修改的结构化日志自动不同意。
            startTimer(endAuditProjectLogTimer,new CronTrigger("0 0 2 * * ?")); //超过3天的未审核的结构化日志自动同意。

            //定时邮件发送任务
            //结构化日志
//            startTimer(projectLogNeedAuditTimer,new CronTrigger("0 0 2 * * ?")); //发送结构化日志待审核的邮件。

            //财务
//            startTimer(bondRemindTimer,new CronTrigger("0 0 2 * * ?")); //保证金未冲账的邮件提醒功能：在预计退款时间，到期前15天，7天，当天。
//            startTimer(performanceBondRemindTimer,new CronTrigger("0 0 2 * * ?")); //履约保证金未冲账的邮件提醒功能 在预计退款时间，到期前30天，7天。
//            startTimer(publicExpenseRemindTimer,new CronTrigger("0 0 2 * * ?")); //对公费用未收到发票邮件提醒功能 影响个人账户前15天，7天邮件通知。
//            startTimer(winningBidRemindTimer,new CronTrigger("0 0 2 * * ?")); //中标服务费未收到发票邮件提醒功能 影响个人账户前15天，7天邮件通知。

            //财务自动冻结
            startTimer(frozenAccountTimer,new CronTrigger("0 0 2 * * ?")); //根据银行费用未回发票和保证金，逾期30天的冻结账户
        }
        startTimer(usageLogSinkToRedisTimer,new CronTrigger("0 */1 * * * ?"));//将菜单访问情况输出至redis 一分钟执行一次
        startTimer(usageLogCacheClearTimer,new CronTrigger("0 0 0 * * ?"));// 每天0点 定时清除菜单访问情况缓存

        startTimer(requestLogSinkToRedisTimer,new CronTrigger("0 */1 * * * ?"));//将请求情况统计保存至redis 一分钟执行一次
        startTimer(requestLogCacheClearTimer,new CronTrigger("0 0 0 * * ?"));//每天0点 定时清除请求情况统计缓存

//        startTimer(requestLogCountTimer,new CronTrigger("0 */1 * * * ?"));//将请求情况统计保存至oracle 一分钟执行一次


    }



    private void startTimer(Runnable task,Trigger trigger){
        threadPoolTaskScheduler.schedule(task,trigger);
    }

    private Boolean isAllowStart(){
        Boolean isHaveAllowServer = redisTemplate.hasKey(DEFAULT_TIMER_KEY);
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("获取到本机IP为：{}",localHost );
            if(isHaveAllowServer){
                String server = redisTemplate.opsForValue().get(DEFAULT_TIMER_KEY);
                if(server.equals(localHost)){
                    return true;
                }else{
                    return false;
                }
            }else{
                redisTemplate.opsForValue().set(DEFAULT_TIMER_KEY,localHost);
                return true;
            }
        } catch (UnknownHostException e) {
            logger.error("获取IP失败，原因：{}",e.getMessage() );
        }

        return false;
    }
}
