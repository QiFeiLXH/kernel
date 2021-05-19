package com.bsoft.clue.service;

import com.bsoft.clue.dto.ClueViewDTO;
import com.bsoft.clue.dto.TrackLogCluesDTO;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.result.Result;

import java.util.List;
import java.util.Map;

public interface ClueService {
    /**
     * @Description: 跟单日志的销售线索列表
     * @param personId  员工工号
     * @param content  搜索内容，为空是检索全部
     * @param page 页码，起始页从0开始
     * @param size 一页显示条数
     * @return Result<TrackLogCluesDTO> 销售线索列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<TrackLogCluesDTO> searchTrackLogClues(String personId, String content, Integer page, Integer size);

    /**
     * @Description: 获取目前阶段字典
     * @return List<SystemDicDTO> 字典对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<SystemDicDTO> getStageDic();
    /**
     * @Description: 获取线索性质字典
     * @return List<SystemDicDTO> 字典对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<SystemDicDTO> getClueNatureDic();

    /**
     * @Description: 获取线索信息
     * @param id 线索ID
     * @return ClueDTO  线索信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public ClueViewDTO getClue(Integer id);
}
