package com.bsoft.project.report.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: hy
 * @Date: 2019/12/13
 * @Description:
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorConfig.class);

    @Bean
    public Executor asyncServiceExecutor() {

        LOGGER.info("start manpowerCostPExecutor");

        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(16);
        //配置最大线程数
        executor.setMaxPoolSize(64);
        //配置队列大小
        executor.setQueueCapacity(16);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("history-service-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程空闲后的最大存活时间
        executor.setKeepAliveSeconds(60);
        //执行初始化
        executor.initialize();
        return executor;
    }

}
