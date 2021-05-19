package com.bsoft.hr.repository.primary;

import com.bsoft.hr.entity.primary.CompanySocialMeeterDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 10:45
 * @Description
 */
@Mapper
@Repository
public interface SocialSecurityRepository {
    List<CompanySocialMeeterDO> getLackSocialCompanys();
}
