package com.bsoft.logs.manager.impl;

import com.alibaba.fastjson.JSON;
import com.bsoft.common.json.FastJsonUtils;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.logs.dao.primary.UsageLogCountDao;
import com.bsoft.logs.dao.primary.UsageLogDao;
import com.bsoft.logs.entity.primary.SinkToRedisCountDO;
import com.bsoft.logs.entity.primary.UsageLogCountDO;
import com.bsoft.logs.entity.primary.UsageLogDO;
import com.bsoft.logs.manager.UsageLogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Component
public class UsageLogManagerImpl implements UsageLogManager {
    private final static Logger logger = LoggerFactory.getLogger(UsageLogManagerImpl.class);
    private static List<SinkToRedisCountDO> COUNTLIST= new ArrayList();
    private final static String DEFAULT_COUNT_KEY = "usageLog:";
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UsageLogDao usageLogDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private UsageLogCountDao usageLogCountDao;
    @Value("${usagelog.count.host1}")
    private String host1;
    @Value("${usagelog.count.host2}")
    private String host2;
    @Override
    public void save(UsageLogDO usageLog) {
        usageLogDao.save(usageLog);
        countUsageLog(usageLog);//统计各个菜单点击次数，以及点击人数
    }


    //将数据缓存至redis
    @Override
    public void sinkToRedis() {
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("获取到本机IP为：{}",localHost +"将菜单访问情况数据写至redis");
            //更新redis上的日志统计数据
            redisTemplate.opsForValue().set(DEFAULT_COUNT_KEY+localHost,  FastJsonUtils.getBeanToJson(COUNTLIST));

        } catch (UnknownHostException e) {
            logger.error("获取IP失败，原因：{}",e.getMessage() );
        }
    }

    //将数据持久化至数据库
    @Override
    public void saveCount() {
        Boolean isHaveCountKey32 = redisTemplate.hasKey(DEFAULT_COUNT_KEY+host1);
        Boolean isHaveCountKey33 = redisTemplate.hasKey(DEFAULT_COUNT_KEY+host2);
        List<SinkToRedisCountDO> value32 = null;
        if(isHaveCountKey32){
            logger.info("获取10.10.3.32的redis数据，将日志统计数据保存至oracle");
            value32 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_COUNT_KEY + host1), SinkToRedisCountDO.class);
        }
        List<SinkToRedisCountDO> value33 = null;
        if(isHaveCountKey33){
            logger.info("获取10.10.3.33的redis数据，将日志统计数据保存至oracle");
            value33 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_COUNT_KEY+host2),SinkToRedisCountDO.class);
        }
        List<UsageLogCountDO> countDOS = initCountDOS(value32,value33);
        if(!countDOS.isEmpty()){
            usageLogCountDao.saveAll(countDOS);
        }

    }

    @Override
    public void initRedisCache() {
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("获取到本机IP为：{}",localHost );
            Boolean isHaveCountKey = redisTemplate.hasKey(DEFAULT_COUNT_KEY+localHost);
            if(isHaveCountKey){
                logger.info("获取"+localHost+"的redis数据，初始化菜单访问情况数据");
                COUNTLIST = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_COUNT_KEY+localHost),SinkToRedisCountDO.class);
            }
        } catch (UnknownHostException e) {
            logger.error("获取IP失败，原因：{}",e.getMessage() );
        }
    }

    @Override
    public void sinkToRedisWithClose() {
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("关闭项目时更新最新的菜单访问数据至redis");
            //更新redis上的日志统计数据
            redisTemplate.opsForValue().set(DEFAULT_COUNT_KEY+localHost, FastJsonUtils.getBeanToJson(COUNTLIST));
        } catch (UnknownHostException e) {
            logger.error("获取IP失败，原因：{}",e.getMessage() );
        }
    }

    @Override
    public void clearCache() {
        logger.error("每天定时清除菜单访问数据缓存");
        COUNTLIST.clear();
    }


    public void countUsageLog(UsageLogDO usageLog){
        if(COUNTLIST.size()>0){
            if (COUNTLIST.stream().filter(w->w.getMenuId().equals(usageLog.getMenuId())).findAny().isPresent()){
                //说明List中已经存在对应菜单的统计数量
                for(int i=0; i<COUNTLIST.size(); i++){
                    if(COUNTLIST.get(i).getMenuId().equals(usageLog.getMenuId())){
                        SinkToRedisCountDO sinkToRedisCountDO = COUNTLIST.get(i);
                        sinkToRedisCountDO.add();//次数自动+1
                        sinkToRedisCountDO.addPerson(usageLog.getPersonId());// 记录点击人数
                        COUNTLIST.set(i,sinkToRedisCountDO);
                    }
                }
            }else{
                addNewCountDO(usageLog);
            }
        }else{
            addNewCountDO(usageLog);
        }
    }

    public void addNewCountDO(UsageLogDO usageLog){
        SinkToRedisCountDO sinkToRedisCountDO = new SinkToRedisCountDO();
        sinkToRedisCountDO.setMenuId(usageLog.getMenuId());
        sinkToRedisCountDO.add();//次数自动+1
        sinkToRedisCountDO.addPerson(usageLog.getPersonId());// 记录点击人数
        COUNTLIST.add(sinkToRedisCountDO);
    }

    //处理从redis中取出的数据，并放到集合中统一保存
    public List<UsageLogCountDO> initCountDOS(List<SinkToRedisCountDO> value32,List<SinkToRedisCountDO> value33){
        List<UsageLogCountDO> countDOS = new ArrayList<>();
        Map<Integer,SinkToRedisCountDO> map = new HashMap<>();
        if(value32.size() > 0){
            value32.forEach(sinkToRedisCountDO -> {
                Integer menuId = sinkToRedisCountDO.getMenuId();
                map.put(menuId,sinkToRedisCountDO);
            });
        }
        if(value33.size() > 0){
            value33.forEach(sinkToRedisCountDO -> {
                Integer menuId = sinkToRedisCountDO.getMenuId();
                if(map.containsKey(menuId)){
                    SinkToRedisCountDO data32 = map.get(menuId);
                    Integer count33 = sinkToRedisCountDO.getCount();
                    data32.addCount(count33);
                    HashSet persons33 = sinkToRedisCountDO.getPersons();
                    data32.addAllPerson(persons33);
                    map.put(menuId,data32);
                } else {
                    map.put(menuId, sinkToRedisCountDO);
                }
            });
        }
        for(Map.Entry<Integer,SinkToRedisCountDO> entry : map.entrySet()){
            Integer menuId = entry.getKey();
            SinkToRedisCountDO data = entry.getValue();
            Integer count = data.getCount();
            HashSet persons  = data.getPersons();
            Date now = serverDateManager.getServerDate();
            UsageLogCountDO countDO = usageLogCountDao.getByCountDateAndMenuId(now,menuId);
            if(countDO == null){
                countDO = new UsageLogCountDO();
                countDO.setCount(count);
                countDO.setMenuId(menuId);
                countDO.setCountDate(now);
                countDO.setPersonCount(persons.size());
            }else{
                countDO.setCount(count);
                countDO.setPersonCount(persons.size());
            }
            countDOS.add(countDO);
        }
        return countDOS;
    }
}
