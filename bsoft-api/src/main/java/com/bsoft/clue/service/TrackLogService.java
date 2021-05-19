package com.bsoft.clue.service;

import com.bsoft.clue.dto.TrackLogLookDTO;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface TrackLogService {
    /**
     * @Description: 根据工号获取今日的跟踪日志
     * @param personId  员工工号
     * @return List<TrackLogLookDTO> 跟踪日志列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<TrackLogLookDTO> getTodayTrackLog(String personId,Integer clueId);
    /**
     * @Description: 根据工号获取指定日期的跟踪日志
     * @param personId  员工工号
     * @param attendacneDate 日期
     * @return List<TrackLogLookDTO> 跟踪日志列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<TrackLogLookDTO> getTrackLog(String personId, Date attendacneDate,Integer clueId);

    /**
     * @Description: 保存跟踪日志
     * @param trackLog 跟踪日志对象
     * @return TrackLogLookDTO 跟踪日志对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public TrackLogLookDTO saveTrackLog(TrackLogLookDTO trackLog);
    /**
     * @Description: 获取目前阶段和签约概率的对应关系
     * @return Map<Integer,Integer> 目前阶段和签约概率的对应关系
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Map<Integer,Integer> getSignChance();
}
