package com.bsoft.email.repository.primary;

import com.bsoft.email.entity.primary.TimeTaskEmailDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmailSenderRepository {
    TimeTaskEmailDO findByBeanClass (@Param(value = "path") String path);

    String findById (@Param("id") String id);
}

