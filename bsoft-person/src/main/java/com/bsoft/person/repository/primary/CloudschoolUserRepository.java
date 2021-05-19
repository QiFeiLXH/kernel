package com.bsoft.person.repository.primary;

import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.entity.primary.PersonQuitSyncDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author  kanghua Ling
 * @Date 2020/7/21 16:35
 * @Description
 */
@Mapper
@Repository
public interface CloudschoolUserRepository {
    List<PersonQuitSyncDO> getQuitPersons(Date date);
}
