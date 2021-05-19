package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonSelectViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.person.dao
 * @Author: Xuhui Lin
 * @CreateTime: 2020-03-14 16:07
 * @Description: 人员选择dao
 */
@Repository
public interface PersonSelectViewDao  extends JpaRepository<PersonSelectViewDO,String>, JpaSpecificationExecutor<PersonSelectViewDO> {
    List<PersonSelectViewDO>  findAllBySimpleCodeLikeAndIsValid(String simpleCode, String isValid);
}
