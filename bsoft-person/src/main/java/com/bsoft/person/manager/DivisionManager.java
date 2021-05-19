package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.AdministrativeAreaDO;
import com.bsoft.person.entity.primary.AdministrativeDivisionDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/7/1
 * @Description:
 */
public interface DivisionManager {

    List<AdministrativeAreaDO> getAdministrativeAreaTree();

    /**
     * 获取行政规划区域
     * @param level 区域级别
     * @param deleted 删除标记
     * @return
     */
    List<AdministrativeAreaDO> getAdministrativeArea(Integer level, Integer deleted);

    List<AdministrativeAreaDO> getAdministrativeArea(Integer parentId);

    AdministrativeDivisionDO getAdministrativeDivision(Integer code);

    List<AdministrativeDivisionDO> getAdministrativeDivision(Integer level, Integer flag);

    List<AdministrativeDivisionDO> getAdministrativeDivisionList(Integer parentCode);

    List<AdministrativeDivisionDO> getAdministrativeDivisionTree();

    AdministrativeDivisionDO getDivisionCity(Integer code);
}
