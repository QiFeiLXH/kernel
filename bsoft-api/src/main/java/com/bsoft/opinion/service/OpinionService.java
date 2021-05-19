package com.bsoft.opinion.service;

import com.bsoft.common.result.Result;
import com.bsoft.opinion.dto.OpinionDTO;
import com.bsoft.opinion.dto.OpinionQueryCndDTO;

import java.util.List;

public interface OpinionService {
    /**
     * @Description: 保存建议信息
     * @param opinion 建议信息
     * @return OpinionDTO 建议信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public OpinionDTO saveOpinion(OpinionDTO opinion);

    /**
     * @Description: 根据ID获取建议信息
     * @param id 建议ID
     * @return OpinionDTO 建议信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public OpinionDTO getOpinion(Integer id);

    /**
     * @Description: 根据提交人工号获取App建议信息
     * @param personId 提交人工号
     * @param page 页码
     * @param size 页数
     * @return Result<OpinionDTO> 建议信息列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<OpinionDTO> getAppOpinion(String personId,Integer page,Integer size);

    /**
     * @Description: 根据提交人工号和状态获取App建议信息
     * @param personId 提交人工号，为空则查询全部状态
     * @param status 状态，为10则查询全部状态
     * @param page 页码
     * @param size 页数
     * @return Result<OpinionDTO> 建议信息列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<OpinionDTO> getWebOpinion(String personId,Integer status,Integer page,Integer size);

    /**
     * @Description: 提交建议信息
     * @param opinion 建议信息
     * @return OpinionDTO 建议信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public OpinionDTO submitOpinion(OpinionDTO opinion);
    /**
     * @Description: 反馈建议信息
     * @param opinion 建议信息
     * @return OpinionDTO 建议信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public OpinionDTO feedbackOpinion(OpinionDTO opinion);

    /**
     * manager项目 意见查询
     * @param cndDTO
     * @return
     */
    public Result<OpinionDTO> getOpinions(OpinionQueryCndDTO cndDTO);

    /**
     * 根据ID获取意见详细信息
     * @param id
     * @return
     */
    OpinionDTO getOpinionById(Integer id);

    /**
     * 获取意见建议图片信息
     * @param id
     * @return
     */
    byte[] getImageByte(Integer id);

    /**
     * 获取对应条件的全部反馈建议信息（不分页） 用于导出
     * @param
     * @return
     */
    List<OpinionDTO> findAllOpinion(OpinionQueryCndDTO cndDTO);
}
