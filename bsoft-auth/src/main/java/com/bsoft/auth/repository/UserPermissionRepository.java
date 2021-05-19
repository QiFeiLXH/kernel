package com.bsoft.auth.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.auth.repository
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-22
 * @Description:
 */
@Mapper
@Repository
public interface UserPermissionRepository {
    List<String> getUserPermissionDeptIdByLoginId(String loginId);
}
