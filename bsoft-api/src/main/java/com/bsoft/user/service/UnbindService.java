package com.bsoft.user.service;

import com.bsoft.common.result.Result;
import com.bsoft.user.dto.UnbindDTO;
import com.bsoft.user.dto.UnbindQueryCndDTO;
import com.bsoft.user.dto.UnbindViewDTO;

import java.util.Date;

public interface UnbindService {
    /**
     * @Description: 保存解绑申请信息
     * @param unbindDTO 解绑申请信息
     * @return UnbindDTO 解绑申请信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public UnbindDTO saveUnbind(UnbindDTO unbindDTO);
    /**
     * @Description: 根据工号获取员工未处理的解绑申请信息
     * @param personId 工号
     * @return UnbindDTO 解绑申请信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public UnbindDTO getUnbind(String personId);
    /**
     * @Description: 根据解绑申请信息审核解绑申请
     * @param unbindDTO 解绑申请信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public void auditUnbind(UnbindDTO unbindDTO);
    /**
     * @Description: 根据工号、审核标志获取解绑申请列表
     * @param personId 工号
     * @param auditFlag 审核标志 0：未审核 1：同意 2：不同意 10：全部
     * @param page 页数
     * @param size 一页行数
     * @return Result<UnbindDTO> 解绑申请列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<UnbindDTO> getUnbind(String personId,Integer auditFlag,Integer page,Integer size);
    /**
     * @Description: 根据ID获取解绑申请信息
     * @param id 解绑申请ID
     * @return UnbindDTO 解绑申请信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public UnbindDTO getUnbind(Integer id);

    /**
     * @Description: 获取申请解绑列表
     * @param queryCndDTO 查询条件
     * @return
     */
    Result<UnbindViewDTO> getUnbindList(UnbindQueryCndDTO queryCndDTO);

}
