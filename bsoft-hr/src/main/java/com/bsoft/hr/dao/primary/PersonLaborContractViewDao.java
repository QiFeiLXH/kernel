package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.PersonLaborContractViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/12/11
 * @description 人员劳动合同信息
 */
@Repository
public interface PersonLaborContractViewDao extends JpaRepository<PersonLaborContractViewDO, String>, JpaSpecificationExecutor<PersonLaborContractViewDO> {

}
