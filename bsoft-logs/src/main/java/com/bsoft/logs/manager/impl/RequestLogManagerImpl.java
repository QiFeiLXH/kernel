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

        // ????????????
        Date dateTimeNow = serverDateManager.getServerDateTime();
        requestLogDO.setRequestDate(dateTimeNow);

        // ??????ID
        if (requestLogDO.getMenuId() != null) {// ??????ID????????????????????????ID????????????ID
            MenuDO menuDO = menuManager.getMenuById(requestLogDO.getMenuId());
            if(menuDO != null) {
                requestLogDO.setSystem(menuDO.getSystem());
            }
        } else { // ??????ID???????????????????????????ID???0???????????????ID
            requestLogDO.setMenuId(0);
        }

        // ??????????????????
        requestLogDao.save(requestLogDO);

        // ??????????????????
        if(requestLogDO.getUrl() != null) {// url??????????????????????????????
            countRequestLogByUrl(requestLogDO);
            countRequestLogByMenuId(requestLogDO);
        }

    }

    @Override
    public void sinkToRedis() {
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("???????????????IP??????{}",localHost +"???????????????????????????redis");
            //??????redis????????????????????????
            redisTemplate.opsForValue().set(DEFAULT_MENU_COUNT_KEY + localHost, FastJsonUtils.getBeanToJson(COUNT_MENU_LIST));
            redisTemplate.opsForValue().set(DEFAULT_PATH_COUNT_KEY + localHost, FastJsonUtils.getBeanToJson(COUNT_PATH_LIST));
        } catch (UnknownHostException e) {
            logger.error("??????IP??????????????????{}",e.getMessage() );
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
            logger.info("??????10.10.3.32???redis??????????????????????????????(menu)?????????oracle");
            menuValue32 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_MENU_COUNT_KEY + host1), RequestLogSinkToRedisDO.class);
        }
        if(hasPathCountKey32){
            logger.info("??????10.10.3.32???redis??????????????????????????????(url)?????????oracle");
            pathValue32 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_PATH_COUNT_KEY+host1),RequestLogSinkToRedisDO.class);
        }
        if(hasMenuCountKey33){
            logger.info("??????10.10.3.33???redis??????????????????????????????(menu)?????????oracle");
            menuValue33 = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_MENU_COUNT_KEY+host2),RequestLogSinkToRedisDO.class);
        }
        if(hasPathCountKey33){
            logger.info("??????10.10.3.33???redis??????????????????????????????(url)?????????oracle");
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
        /*// ??????
        Boolean hasMenuCountKey54 = redisTemplate.hasKey(DEFAULT_MENU_COUNT_KEY+"10.1.3.54");
        Boolean hasPathCountKey54 = redisTemplate.hasKey(DEFAULT_PATH_COUNT_KEY+"10.1.3.54");
        List<RequestLogSinkToRedisDO> menuValue54 = new ArrayList<>();
        List<RequestLogSinkToRedisDO> pathValue54 = new ArrayList<>();
        if(hasMenuCountKey54) {
            logger.info("??????10.1.3.54???redis???????????????????????????menuId??????????????????oracle");
            menuValue54 = (List<RequestLogSinkToRedisDO>) redisTemplate.opsForValue().get(DEFAULT_MENU_COUNT_KEY+"10.1.3.54");
        }
        if(hasPathCountKey54) {
            logger.info("??????10.1.3.54???redis???????????????????????????url??????????????????oracle");
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
            logger.info("???????????????IP??????{}",localHost );
            Boolean hasMenuCountKey = redisTemplate.hasKey(DEFAULT_MENU_COUNT_KEY+localHost);
            Boolean hasPathCountKey = redisTemplate.hasKey(DEFAULT_PATH_COUNT_KEY+localHost);
            if(hasMenuCountKey){
                logger.info("??????"+localHost+"???redis?????????????????????????????????menuId?????????");
                COUNT_MENU_LIST = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_MENU_COUNT_KEY+localHost),RequestLogSinkToRedisDO.class);
            }
            if(hasPathCountKey){
                logger.info("??????"+localHost+"???redis?????????????????????????????????url?????????");
                COUNT_PATH_LIST = FastJsonUtils.getJsonToList(redisTemplate.opsForValue().get(DEFAULT_PATH_COUNT_KEY+localHost),RequestLogSinkToRedisDO.class);
            }
        } catch (UnknownHostException e) {
            logger.error("??????IP??????????????????{}",e.getMessage() );
        }
    }

    @Override
    public void sinkToRedisWithClose() {
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("???????????????????????????????????????????????????redis");
            //??????redis????????????????????????
            redisTemplate.opsForValue().set(DEFAULT_MENU_COUNT_KEY+localHost, FastJsonUtils.getBeanToJson(COUNT_MENU_LIST));
            redisTemplate.opsForValue().set(DEFAULT_PATH_COUNT_KEY+localHost, FastJsonUtils.getBeanToJson(COUNT_PATH_LIST));
        } catch (UnknownHostException e) {
            logger.error("??????IP??????????????????{}",e.getMessage() );
        }
    }

    @Override
    public void clearCache() {
        logger.error("??????????????????????????????????????????");
        COUNT_MENU_LIST.clear();
        COUNT_PATH_LIST.clear();
    }


    public void countRequestLogByUrl(RequestLogDO requestLogDO){
        if(COUNT_PATH_LIST.size()>0){
            if (COUNT_PATH_LIST.stream().filter(w->w.getUrl().equals(requestLogDO.getUrl())).findAny().isPresent()){
                //??????List??????????????????????????????????????????
                for(int i=0; i<COUNT_PATH_LIST.size(); i++){
                    if(COUNT_PATH_LIST.get(i).getUrl().equals(requestLogDO.getUrl())){
                        RequestLogSinkToRedisDO sinkToRedisCountDO = COUNT_PATH_LIST.get(i);
                        sinkToRedisCountDO.add();//????????????+1
                        sinkToRedisCountDO.addPerson(requestLogDO.getPersonId());// ??????????????????
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
        sinkToRedisCountDO.add();//????????????+1
        sinkToRedisCountDO.addPerson(requestLogDO.getPersonId());// ??????????????????
        COUNT_PATH_LIST.add(sinkToRedisCountDO);
    }

    public void countRequestLogByMenuId(RequestLogDO requestLogDO){
        if(COUNT_MENU_LIST.size()>0){
            if (COUNT_MENU_LIST.stream().filter(w->w.getMenuId().equals(requestLogDO.getMenuId())).findAny().isPresent()){
                //??????List??????????????????????????????????????????
                for(int i=0; i<COUNT_MENU_LIST.size(); i++){
                    if(COUNT_MENU_LIST.get(i).getMenuId().equals(requestLogDO.getMenuId())){
                        RequestLogSinkToRedisDO sinkToRedisCountDO = COUNT_MENU_LIST.get(i);
                        sinkToRedisCountDO.add();//????????????+1
                        sinkToRedisCountDO.addPerson(requestLogDO.getPersonId());// ??????????????????
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
        sinkToRedisCountDO.add();//????????????+1
        sinkToRedisCountDO.addPerson(requestLogDO.getPersonId());// ??????????????????
        COUNT_MENU_LIST.add(sinkToRedisCountDO);
    }

    // url??????
    public List<RequestLogPathCountDO> initUrlCountDOS54(List<RequestLogSinkToRedisDO> value54) {
        List<RequestLogPathCountDO> countDOS = new ArrayList<>();
        Map<String, RequestLogSinkToRedisDO> urlMap = new HashMap<>();
        for(RequestLogSinkToRedisDO item : value54) {// ??????54???????????????map???
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

    // menu??????
    public List<RequestLogMenuCountDO> initMenuCountDOS54(List<RequestLogSinkToRedisDO> value54) {
        List<RequestLogMenuCountDO> countDOS = new ArrayList<>();
        Map<Integer, RequestLogSinkToRedisDO> menuMap = new HashMap<>();
        for(RequestLogSinkToRedisDO item : value54) {// ??????54???????????????map???
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

    // ??????url????????????
    public List<RequestLogPathCountDO> initUrlCountDOS(List<RequestLogSinkToRedisDO> value32, List<RequestLogSinkToRedisDO> value33){
        List<RequestLogPathCountDO> countDOS = new ArrayList<>();
        Map<String, RequestLogSinkToRedisDO> map = new HashMap<>();
        for(RequestLogSinkToRedisDO item : value32) {// ??????32???????????????map???
            String url = item.getUrl();
            map.put(url,item);
        }
        for(RequestLogSinkToRedisDO item : value33) {// ??????33???????????????map?????????????????????????????????
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
        for(Map.Entry<String, RequestLogSinkToRedisDO> entry : map.entrySet()){// ???map???????????????list
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

    // ??????menu????????????
    public List<RequestLogMenuCountDO> initMenuCountDOS(List<RequestLogSinkToRedisDO> value32, List<RequestLogSinkToRedisDO> value33){
        List<RequestLogMenuCountDO> countDOS = new ArrayList<>();
        Map<Integer, RequestLogSinkToRedisDO> map = new HashMap<>();
        for(RequestLogSinkToRedisDO item : value32) {// ??????32???????????????map???
            Integer menuId = item.getMenuId();
            map.put(menuId,item);
        }
        for(RequestLogSinkToRedisDO item : value33) {// ??????33???????????????map?????????????????????????????????
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
        for(Map.Entry<Integer, RequestLogSinkToRedisDO> entry : map.entrySet()){// ???map???????????????list
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
