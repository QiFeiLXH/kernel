package com.bsoft.person.manager;

import com.bsoft.person.dto.EmployAuditDTO;
import com.bsoft.person.dto.EmployDTO;
import com.bsoft.person.dto.EmployQueryDTO;
import com.bsoft.person.entity.primary.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
 */
public interface RecruitmentInfoManager {

    Page<EmployViewDO> getRecruitmentRecentInfo(EmployQueryDTO cnd);

    EmployDO saveRecruitmentBaseInfo(EmployDTO dto);

    EmployViewDO getRecruitmentInfo(Integer id);

    void saveRecruitmentAuditInfo(EmployAuditDTO dto);

    void deleteFamily(Integer id);

    void deleteWork(Integer id);

    void deleteEducation(Integer id);

    EmployAuditDO getRecruitmentAuditInfo(Integer recruitmentId);

    void deleteRecruitmentInfo(Integer recruitmentId);

    void sendRecruitmentEmail(EmployDTO dto);

    List<AdministrativeAreaDO> getAdministrativeAreaTree();

    List<AdministrativeAreaDO> getAdministrativeArea(Integer parentId);
}
