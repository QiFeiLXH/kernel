package com.bsoft.system.service;

import com.bsoft.common.result.Result;
import com.bsoft.system.dto.PublicInfoDTO;
import com.bsoft.system.dto.PublicInfoQueryCndDTO;

import java.util.List;

public interface PublicInfoService {

    /**
     * @Description: 获取最新count条数新闻信息
     * @param count 条数
     * @return List<PublicInfoDTO> 新闻信息列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<PublicInfoDTO> getNews(Long count);
    /**
     * @Description: 获取最新count条数通知信息
     * @param count 条数
     * @return List<PublicInfoDTO> 通知信息列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<PublicInfoDTO> getNotice(Long count);

    /**
     * @Description: 获取最新count条数系统工号信息
     * @param count 条数
     * @return List<PublicInfoDTO> 系统工号信息列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<PublicInfoDTO> getSystemNotice(Long count);

    /**
     * 分页查询新闻信息
     * @param queryCndDTO type 类型
     * @return
     */
    public Result<PublicInfoDTO> getNewsByCnd(PublicInfoQueryCndDTO queryCndDTO);
}
