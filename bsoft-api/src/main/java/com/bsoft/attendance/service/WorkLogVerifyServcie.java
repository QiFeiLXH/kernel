package com.bsoft.attendance.service;

import com.bsoft.attendance.dto.WorkLogVerifyDTO;
import com.bsoft.common.result.Result;

public interface WorkLogVerifyServcie {
    /**
     * @Description: 根据工号获取待审核的日志
     * @param personId 项目经理工号
     * @param content 检索内容，默认为空则查全部
     * @param page 第几页
     * @param size 一页显示多少条
     * @return Result<WorkLogVerifyDTO> 日志待审核列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<WorkLogVerifyDTO> getPendingWorkLog(String personId,String content,Integer page,Integer size);
    /**
     * @Description: 根据工号获取待审核的日志
     * @param personId 项目经理工号
     * @param content 检索内容，默认为空则查全部
     * @param page 第几页，默认20条
     * @return Result<WorkLogVerifyDTO> 日志待审核列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<WorkLogVerifyDTO> getPendingWorkLog(String personId,String content,Integer page);
    /**
     * @Description: 根据工号获取待审核的日志
     * @param workLogVerify 日志审核信息
     * @return Boolean true为成功，false为不成功
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Boolean verifyWorkLog(WorkLogVerifyDTO workLogVerify);
}
