package com.bsoft.project.repository.primary;

import com.bsoft.project.entity.primary.ProjectWorkLogsDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.repository
 * @Author: Xuhui Lin
 * @CreateTime: 2020-04-27
 * @Description: 项目组
 */
@Mapper
@Repository
public interface ProjectStartDateRepository {

    //批量修改项目里的开工日期
    void saveProjectStartDate();

}
