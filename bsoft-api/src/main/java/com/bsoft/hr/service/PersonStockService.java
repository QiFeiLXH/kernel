package com.bsoft.hr.service;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.PersonStockDTO;
import com.bsoft.hr.dto.PersonStockQueryCndDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:08
 * @Description
 */
public interface PersonStockService {

    /** 员工股份列表查询
     * @Param: cndDTO 查询条件
     * @return com.bsoft.common.result.Result<PersonStockDTO>
     * @author Xuhui Lin
     */
    Result<PersonStockDTO> getPersonStockList(PersonStockQueryCndDTO cndDTO);

    /** 注销员工股份
     * @Param: id
     * @return
     * @author Xuhui Lin
     */
    void logoutOnePersonStock(Integer id);

    /** 批量注销员工股份
     * @Param: ids
     * @return
     * @author Xuhui Lin
     */
    void batchLogoutPersonStocks(List<Integer> ids);

    /** 保存、更新员工股份
     * @Param: personStockDTO
     * @return
     * @author Xuhui Lin
     */
    void savePersonStock(PersonStockDTO personStockDTO);

    /** 批量保存员工股份
     * @Param: personStockDTO
     * @Param: personId 导入操作人
     * @return
     * @author Xuhui Lin
     */
    ImportResultDTO savePersonStocks(List<PersonStockDTO> personStockDTOS, String personId);


    /** 查询导入失败数据
     * @Param: personId 导入操作人
     * @return
     * @author Xuhui Lin
     */
    List<PersonStockDTO> getErrorPersonStockList(String personId);

    /** 全部员工股份
     * @Param: cndDTO 查询条件
     * @return
     * @author Xuhui Lin
     */
    List<PersonStockDTO> getAllPersonStockList(PersonStockQueryCndDTO cndDTO);
}
