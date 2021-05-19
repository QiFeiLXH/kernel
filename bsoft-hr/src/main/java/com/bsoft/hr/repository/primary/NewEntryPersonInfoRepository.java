package com.bsoft.hr.repository.primary;

import com.bsoft.hr.entity.primary.PersonCompanyDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-09-07 14:44
 * @Version 1.0
 * @Description
 */
@Mapper
@Repository
public interface NewEntryPersonInfoRepository {
    List<PersonCompanyDO> findAllCompany();
}
