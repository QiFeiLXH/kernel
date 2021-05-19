package com.bsoft.person.repository.primary;

import com.bsoft.person.entity.primary.PersonToFormalCountDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/29 17:14
 * @Description:
 */
@Mapper
@Repository
public interface PersonToFormalRepository {

    List<PersonToFormalCountDO> getPersonToFormalMonthCount(String year);

}
