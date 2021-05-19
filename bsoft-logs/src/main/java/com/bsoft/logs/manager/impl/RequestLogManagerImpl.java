package com.bsoft.logs.manager.impl;

import com.alibaba.fastjson.JSON;
import com.bsoft.common.json.FastJsonUtils;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.logs.dao.primary.RequestLogDao;
import com.bsoft.logs.dao.primary.RequestLogMenuCountDao;
import com.bsoft.logs.dao.primary.RequestLogPathCountDao;
import com.bsoft.logs.entity.primary.*;
import com.bsoft.logs.manager.RequestLogManager;
import com.bsoft.menu.entity.primary.MenuDO;
import com.bsoft.menu.manager.MenuManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
@Component
public class RequestLogManagerImpl implements RequestLogManager {
    private final static Logger logger = LoggerFactory.getLogger(RequestLogManagerImpl.class);
    private static List<RequestLogSinkToRedisDO> COUNT_MENU_LIST= new ArrayList();
    private static List<RequestLogSinkToRedisDO> COUNT_PATH_LIST= new ArrayList();
    private final static String DEFAULT_MENU_COUNT_KEY = "requestLog:menuId:";
    private final static String DEFAULT_PATH_COUNT_KEY = "requestLog:url:";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RequestLogDao requestLogDao;
    @Autowired
    private RequestLogMenuCountDao requestLogMenuCountDao;
    @Autowired
    private RequestLogPathCountDao requestLogPathCountDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private MenuManager menuManager;
    @Value("${usagelog.count.host1}")
    private String host1;
    @Value("${usagelog.count.host2}")
    private String host2;

    @Override
    public void save(RequestLogDO requestLogDO) {

        // 请求时间
        Date dateTimeNow = serverDateManager.getServerDateTime();
        requestLogDO.setRequestDate(dateTimeNow);

        // 系统ID
        if (requestLogDO.getMenuId() != null) {// 菜单ID不为空则根据菜单ID获取系统ID
            MenuDO menuDO = menuManager.getMenuById(requestLogDO.getMenuId());
            if(menuDO != null) {
                requestLogDO.setSystem(menuDO.getSystem());
            }
        } else { // 菜单ID为空则设置默认菜单ID为0，不存系统ID
            requestLogDO.setMenuId(0);
        }

        // 保存请求信息
        requestLogDao.save(requestLogDO);

        // 统计请求信息
        if(requestLogDO.getUrl() != null) {// url不为空则统计请求路径
            countRequestLogByUrl(requestLogDO);
            countRequestLogByMenuId(requestLogDO);
        }

    }

    @Override
    public void sinkToRedis() {
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("获取到本机IP为：{}",localHost +"将请求统计数据写至redis");
            //更新redis上的日志统计数据
            redisTemplate.opsForValue().set(DEFAULT_MENU_COUNT_KEY + localHost, FastJsonUtils.getBeanToJson(COUNT_MENU_LIST));
            redisTemplate.opsForValue().set(DEFAULT_PATH_COUNT_KEY + localHost, FastJsonUtils.getBeanToJson(COUNT_PATH_LIST));
        } catch (UnknownHostException e) {
            logger.error("获取IP失败，原因：{}",e.getMessage() );
        }
    }
    @Override
    public void saveCount() {
        Boolean hasMenuCountKey32 = redisTemplate.hasKey(DEFAULT_MENU_COUNT_KEY+host1);
        Boolean hasPathCountKey32 = redisTemplate.hasKey(DEFAULT_PATH_COUNT_KEY+host1);
        Boolean hasMenuCountKey33 = redisTemplate.hasKey(DEFAULT_MENU_COUNT_KEY+host2);
        Boolean hasPathCountKey33 = redisTemplate.hasKey(DEFAULT_PATH_COUNT_KEY+host2);
        List<RequestLogSinkToRedisDO> menuValue32 = new ArrayList<>();
        List<RequestLogSinkToRedisDO> pathValue32 = new ArrayList<>();
        List<RequestLogSinkToRedisDO> menuValue33 = new ArrayList<>();
        List<RequestLogSinkToRedisDO> pathValue33 = new ArrayList<>();
        if(hasMenuCountKey32){
            logger.info("获取10.10.3.32的redis数据，将请求统计数据(menu)保存至oracle");
            menuValue32 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_MENU_COUNT_KEY + host1), RequestLogSinkToRedisDO.class);
        }
        if(hasPathCountKey32){
            logger.info("获取10.10.3.32的redis数据，将请求统计数据(url)保存至oracle");
            pathValue32 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_PATH_COUNT_KEY+host1),RequestLogSinkToRedisDO.class);
        }
        if(hasMenuCountKey33){
            logger.info("获取10.10.3.33的redis数据，将请求统计数据(menu)保存至oracle");
            menuValue33 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_MENU_COUNT_KEY+host2),RequestLogSinkToRedisDO.class);
        }
        if(hasPathCountKey33){
            logger.info("获取10.10.3.33的redis数据，将请求统计数据(url)保存至oracle");
            menuValue33 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_PATH_COUNT_KEY+host2),RequestLogSinkToRedisDO.class);
        }
        List<RequestLogMenuCountDO> menuCountDOS = initMenuCountDOS(menuValue32, menuValue33);
        List<RequestLogPathCountDO> pathCountDOS = initUrlCountDOS(pathValue32, pathValue33);
        if(!menuCountDOS.isEmpty()) {
            requestLogMenuCountDao.saveAll(menuCountDOS);
        }
        if(!pathCountDOS.isEmpty()) {
            requestLogPathCountDao.saveAll(pathCountDOS);
        }
        /*// 测试
        Boolean hasMenuCountKey54 = redisTemplate.hasKey(DEFAULT_MENU_COUNT_KEY+"10.1.3.54");
        Boolean hasPathCountKey54 = redisTemplate.hasKey(DEFAULT_PATH_COUNT_KEY+"10.1.3.54");
        List<RequestLogSinkToRedisDO> menuValue54 = new ArrayList<>();
        List<RequestLogSinkToRedisDO> pathValue54 = new ArrayList<>();
        if(hasMenuCountKey54) {
            logger.info("获取10.1.3.54的redis数据，将请求统计（menuId）数据保存至oracle");
            menuValue54 = (List<RequestLogSinkToRedisDO>) redisTemplate.opsForValue().get(DEFAULT_MENU_COUNT_KEY+"10.1.3.54");
        }
        if(hasPathCountKey54) {
            logger.info("获取10.1.3.54的redis数据，将请求统计（url）数据保存至oracle");
            pathValue54 = (List<RequestLogSinkToRedisDO>) redisTemplate.opsForValue().get(DEFAULT_PATH_COUNT_KEY+"10.1.3.54");
        }
        List<RequestLogMenuCountDO> menuCountDOS = initMenuCountDOS54(menuValue54);
        List<RequestLogPathCountDO> pathCountDOS = initUrlCountDOS54(pathValue54);
        if(!menuCountDOS.isEmpty()) {
            requestLogMenuCountDao.saveAll(menuCountDOS);
        }
        if (!pathCountDOS.isEmpty()){
            requestLogPathCountDao.saveAll(pathCountDOS);
        }
*/
    }

    @Override
    public void initRedisCache() {
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("获取到本机IP为：{}",localHost );
            Boolean hasMenuCountKey = redisTemplate.hasKey(DEFAULT_MENU_COUNT_KEY+localHost);
            Boolean hasPathCountKey = redisTemplate.hasKey(DEFAULT_PATH_COUNT_KEY+localHost);
            if(hasMenuCountKey){
                logger.info("获取"+localHost+"的redis数据，初始化请求统计（menuId）数据");
                COUNT_MENU_LIST = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_MENU_COUNT_KEY+localHost),RequestLogSinkToRedisDO.class);
            }
            if(hasPathCountKey){
                logger.info("获取"+localHost+"的redis数据，初始化请求统计（url）数据");
                COUNT_PATH_LIST = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_PATH_COUNT_KEY+localHost),RequestLogSinkToRedisDO.class);
            }
        } catch (UnknownHostException e) {
            logger.error("获取IP失败，原因：{}",e.getMessage() );
        }
    }

    @Override
    public void sinkToRedisWithClose() {
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("关闭项目时更新最新的请求统计数据至redis");
            //更新redis上的日志统计数据
            redisTemplate.opsForValue().set(DEFAULT_MENU_COUNT_KEY+localHost, FastJsonUtils.getBeanToJson(COUNT_MENU_LIST));
            redisTemplate.opsForValue().set(DEFAULT_PATH_COUNT_KEY+localHost, FastJsonUtils.getBeanToJson(COUNT_PATH_LIST));
        } catch (UnknownHostException e) {
            logger.error("获取IP失败，原因：{}",e.getMessage() );
        }
    }

    @Override
    public void clearCache() {
        logger.error("每天定时清除菜单访问数据缓存");
        COUNT_MENU_LIST.clear();
        COUNT_PATH_LIST.clear();
    }


    public void countRequestLogByUrl(RequestLogDO requestLogDO){
        if(COUNT_PATH_LIST.size()>0){
            if (COUNT_PATH_LIST.stream().filter(w->w.getUrl().equals(requestLogDO.getUrl())).findAny().isPresent()){
                //说明List中已经存在对应路径的统计数量
                for(int i=0; i<COUNT_PATH_LIST.size(); i++){
                    if(COUNT_PATH_LIST.get(i).getUrl().equals(requestLogDO.getUrl())){
                        RequestLogSinkToRedisDO sinkToRedisCountDO = COUNT_PATH_LIST.get(i);
                        sinkToRedisCountDO.add();//次数自动+1
                        sinkToRedisCountDO.addPerson(requestLogDO.getPersonId());// 记录点击人数
                        COUNT_PATH_LIST.set(i,sinkToRedisCountDO);
                    }
                }
            }else{
                addNewPathCountDO(requestLogDO);
            }
        }else{
            addNewPathCountDO(requestLogDO);
        }
    }

    public void addNewPathCountDO(RequestLogDO requestLogDO){
        RequestLogSinkToRedisDO sinkToRedisCountDO = new RequestLogSinkToRedisDO();
        sinkToRedisCountDO.setUrl(requestLogDO.getUrl());
        sinkToRedisCountDO.setMenuId(requestLogDO.getMenuId());
        sinkToRedisCountDO.add();//次数自动+1
        sinkToRedisCountDO.addPerson(requestLogDO.getPersonId());// 记录点击人数
        COUNT_PATH_LIST.add(sinkToRedisCountDO);
    }

    public void countRequestLogByMenuId(RequestLogDO requestLogDO){
        if(COUNT_MENU_LIST.size()>0){
            if (COUNT_MENU_LIST.stream().filter(w->w.getMenuId().equals(requestLogDO.getMenuId())).findAny().isPresent()){
                //说明List中已经存在对应菜单的统计数量
                for(int i=0; i<COUNT_MENU_LIST.size(); i++){
                    if(COUNT_MENU_LIST.get(i).getMenuId().equals(requestLogDO.getMenuId())){
                        RequestLogSinkToRedisDO sinkToRedisCountDO = COUNT_MENU_LIST.get(i);
                        sinkToRedisCountDO.add();//次数自动+1
                        sinkToRedisCountDO.addPerson(requestLogDO.getPersonId());// 记录点击人数
                        COUNT_MENU_LIST.set(i,sinkToRedisCountDO);
                    }
                }
            }else{
                addNewMenuCountDO(requestLogDO);
            }
        }else{
            addNewMenuCountDO(requestLogDO);
        }
    }

    public void addNewMenuCountDO(RequestLogDO requestLogDO){
        RequestLogSinkToRedisDO sinkToRedisCountDO = new RequestLogSinkToRedisDO();
        sinkToRedisCountDO.setMenuId(requestLogDO.getMenuId());
        sinkToRedisCountDO.add();//次数自动+1
        sinkToRedisCountDO.addPerson(requestLogDO.getPersonId());// 记录点击人数
        COUNT_MENU_LIST.add(sinkToRedisCountDO);
    }

    // url测试
    public List<RequestLogPathCountDO> initUrlCountDOS54(List<RequestLogSinkToRedisDO> value54) {
        List<RequestLogPathCountDO> countDOS = new ArrayList<>();
        Map<String, RequestLogSinkToRedisDO> urlMap = new HashMap<>();
        for(RequestLogSinkToRedisDO item : value54) {// 遍历54的数据放到map中
            String url = item.getUrl();
            urlMap.put(url,item);
        }
        for(Map.Entry<String, RequestLogSinkToRedisDO> entry : urlMap.entrySet()){
            String url = entry.getKey();
            SinkToRedisCountDO data = entry.getValue();
            Date now = serverDateManager.getServerDate();
            RequestLogPathCountDO countDO = requestLogPathCountDao.getByUrlAndCountDate(url, now);
            if(countDO == null){
                countDO = new RequestLogPathCountDO();
                countDO.setUrl(url);
                countDO.setMenuId(data.getMenuId());
                countDO.setCountDate(now);
            }
            countDO.setRequestCount(data.getCount());
            countDO.setPersonCount(data.getPersons().size());
            countDOS.add(countDO);
        }
        return countDOS;
    }

    // menu测试
    public List<RequestLogMenuCountDO> initMenuCountDOS54(List<RequestLogSinkToRedisDO> value54) {
        List<RequestLogMenuCountDO> countDOS = new ArrayList<>();
        Map<Integer, RequestLogSinkToRedisDO> menuMap = new HashMap<>();
        for(RequestLogSinkToRedisDO item : value54) {// 遍历54的数据放到map中
            Integer menuId = item.getMenuId();
            menuMap.put(menuId, item);
        }
        for(Map.Entry<Integer, RequestLogSinkToRedisDO> entry : menuMap.entrySet()){
            Integer menuId = entry.getKey();
            RequestLogSinkToRedisDO data = entry.getValue();
            Integer count = data.getCount();
            HashSet persons  = data.getPersons();
            Date now = serverDateManager.getServerDate();
            RequestLogMenuCountDO countDO = requestLogMenuCountDao.getByMenuIdAndCountDate(menuId, now);
            if(countDO == null){
                countDO = new RequestLogMenuCountDO();
                countDO.setMenuId(menuId);
                countDO.setCountDate(now);
            }
            countDO.setRequestCount(count);
            countDO.setPersonCount(persons.size());
            countDOS.add(countDO);
        }
        return countDOS;
    }

    // 处理url统计数据
    public List<RequestLogPathCountDO> initUrlCountDOS(List<RequestLogSinkToRedisDO> value32, List<RequestLogSinkToRedisDO> value33){
        List<RequestLogPathCountDO> countDOS = new ArrayList<>();
        Map<String, RequestLogSinkToRedisDO> map = new HashMap<>();
        for(RequestLogSinkToRedisDO item : value32) {// 遍历32的数据放到map中
            String url = item.getUrl();
            map.put(url,item);
        }
        for(RequestLogSinkToRedisDO item : value33) {// 遍历33的数据放在map中并将于重复的数据合并
            String url = item.getUrl();
            if(map.containsKey(url)){
                RequestLogSinkToRedisDO data32 = map.get(url);
                data32.addCount(item.getCount());
                data32.addAllPerson(item.getPersons());
                map.put(url, data32);
            } else {
                map.put(url,item);
            }
        }
        for(Map.Entry<String, RequestLogSinkToRedisDO> entry : map.entrySet()){// 将map数据转换成list
            String url = entry.getKey();
            SinkToRedisCountDO data = entry.getValue();
            Date now = serverDateManager.getServerDate();
            RequestLogPathCountDO countDO = requestLogPathCountDao.getByUrlAndCountDate(url, now);
            if(countDO == null){
                countDO = new RequestLogPathCountDO();
                countDO.setUrl(url);
                countDO.setMenuId(data.getMenuId());
                countDO.setCountDate(now);
            }
            countDO.setRequestCount(data.getCount());
            countDO.setPersonCount(data.getPersons().size());
            countDOS.add(countDO);
        }
        return countDOS;
    }

    // 处理menu统计数据
    public List<RequestLogMenuCountDO> initMenuCountDOS(List<RequestLogSinkToRedisDO> value32, List<RequestLogSinkToRedisDO> value33){
        List<RequestLogMenuCountDO> countDOS = new ArrayList<>();
        Map<Integer, RequestLogSinkToRedisDO> map = new HashMap<>();
        for(RequestLogSinkToRedisDO item : value32) {// 遍历32的数据放到map中
            Integer menuId = item.getMenuId();
            map.put(menuId,item);
        }
        for(RequestLogSinkToRedisDO item : value33) {// 遍历33的数据放在map中并将于重复的数据合并
            Integer menuId = item.getMenuId();
            if(map.containsKey(menuId)){
                RequestLogSinkToRedisDO data32 = map.get(menuId);
                data32.addCount(item.getCount());
                data32.addAllPerson(item.getPersons());
                map.put(menuId, data32);
            } else {
                map.put(menuId,item);
            }
        }
        for(Map.Entry<Integer, RequestLogSinkToRedisDO> entry : map.entrySet()){// 将map数据转换成list
            Integer menuId = entry.getKey();
            SinkToRedisCountDO data = entry.getValue();
            Date now = serverDateManager.getServerDate();
            RequestLogMenuCountDO countDO = requestLogMenuCountDao.getByMenuIdAndCountDate(menuId, now);
            if(countDO == null){
                countDO = new RequestLogMenuCountDO();
                countDO.setMenuId(menuId);
                countDO.setCountDate(now);
            }
            countDO.setRequestCount(data.getCount());
            countDO.setPersonCount(data.getPersons().size());
            countDOS.add(countDO);
        }
        return countDOS;
    }
}
