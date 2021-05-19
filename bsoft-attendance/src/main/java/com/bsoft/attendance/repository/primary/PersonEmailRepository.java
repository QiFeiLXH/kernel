package com.bsoft.attendance.repository.primary;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanglf
 * @Date 2021-01-08 10:27
 * @Version 1.0
 */

@Mapper
@Repository
public interface PersonEmailRepository {
    String getPersonEmail(@Param("personId") String personId);
}
