package com.bsoft.house.service;

import com.bsoft.common.result.Result;
import com.bsoft.house.dto.HouseDTO;

public interface HouseService {

    /**
     * @Description: 获取房屋列表
     * @param page 页码，起始页从0开始
     * @param size 一页显示条数
     * @return Result<HouseDTO> 房屋列表对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<HouseDTO> getHouses(Integer page,Integer size);

    /**
     * @Description: 获取房屋列表
     * @param page 页码，起始页从0开始，一页条数默认25条
     * @return Result<HouseDTO> 房屋列表对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<HouseDTO> getHouses(Integer page);

    /**
     * @Description: 根据宿舍名称和宿舍地址搜索房屋列表、
     * @param context 检索关键字
     * @param page 页码，起始页从0开始，一页条数默认25条
     * @return Result<HouseDTO> 房屋列表对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<HouseDTO> searchHouses(String context,Integer page);

    /**
     * @Description: 根据宿舍名称和宿舍地址搜索房屋列表、
     * @param context 检索关键字
     * @param page 页码，起始页从0开始
     * @param size 一页数据条数
     * @return Result<HouseDTO> 房屋列表对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<HouseDTO> searchHouses(String context,Integer page,Integer size);

    public Result<HouseDTO> searchHouseViews(String context,String area,String userId, Integer page, Integer size);

}
