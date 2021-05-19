package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.EmployViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployViewDao extends JpaRepository<EmployViewDO,Integer>, JpaSpecificationExecutor<EmployViewDO> {
    public List<EmployViewDO> findAllById(Integer id);
    public List<EmployViewDO> findAllByPhoneOrderByIdDesc(String pbone);
    public List<EmployViewDO> findAllByPhoneAndStatus(String pbone, Integer status);
    public EmployViewDO getById(Integer id);

    @Query(value = "from EmployViewDO  a where a.registrationTime > add_months(sysdate,-:months) order by a.id desc")
    public List<EmployViewDO> getRecruitmentInformationList(@Param("months") Integer months);
}
