package com.bsoft.email.util;

import org.quartz.JobDataMap;

public class LocalThreadScopeDataUtil {
    //把对象与当前线程绑定
    private static  ThreadLocal<LocalThreadScopeDataUtil> mThreadLocal = new ThreadLocal<LocalThreadScopeDataUtil>();
    //当前实例
    private static LocalThreadScopeDataUtil instance = null;
    //任务数据
    private  JobDataMap jobDataMap =null;
    //单例模式
    public static LocalThreadScopeDataUtil getInstance() {
        instance = mThreadLocal.get();
        if (instance == null) {
            instance = new LocalThreadScopeDataUtil();
            mThreadLocal.set(instance);
        }
        return instance;

    }

    public  JobDataMap getJobDataMap() {
        return jobDataMap;
    }

    public  void setJobDataMap(JobDataMap jobDataMap) {
        this.jobDataMap = jobDataMap;
    }
}