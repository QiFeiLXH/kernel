package com.bsoft.person.manager;

import com.bsoft.common.result.Result;
import com.bsoft.person.condition.PersonSelectQueryCnd;
import com.bsoft.person.dto.PersonTransferConditionDTO;
import com.bsoft.person.dto.PersonTransferQueryCndDTO;
import com.bsoft.person.entity.primary.*;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface PersonManager {
    /**
     * 根据ID获取员工信息（结果为空则抛出异常）
     * @param personId 员工ID
     */
    PersonDO getPerson(String personId);

    /**
     * 根据工号查找员工信息
     * @param personIds 工号列表
     */
    List<PersonDO> getPersonList(List<String> personIds);
    List<PersonDO> getPerson();
    Map<String,String> getDicPerson();
    Map<String,String> getIdDicPerson();
    PersonDO getPersonWithId(Integer id);
    List<PersonDO> getVaildPerson();
    List<String> getVaildPersonId();
    List<PersonDO> getDeptPerson(String bmdm);
    List<PersonDO> getPersonInfo(String value);
    RankPersonDO getRankPerson(String personId);
    List<String> getEmails(List<String> personId);
    void savePersons(List<PersonDO> personDOS);
    List<PersonDO> getPersonsEvaluated();
    List<PersonDO> getPersonsEvaluated(List<String> personIds);
    PersonViewDO getPersonView(String personid);

    List<PersonSelectViewDO> getPersonSelectList(String simpleCode);
    List<PersonSelectViewDO> getPersonSelectList(String inputContent, Integer isValid);
    List<PersonSelectViewDO> getPersonSelectList(PersonSelectQueryCnd queryCnd);

    /** 批量更新员工社保缴纳地 */
    void updateBatchPersonPaymentPlace(List<PersonDO> persons);

    //更新人员信息
    void updatePerson(PersonDO personDO);

    /**
     * 按调动日期查询人员调动情况
     * @param cndDTO
     * @return
     */
    Page<PersonTransferConditionsDO> getPersonTransfer(PersonTransferQueryCndDTO cndDTO) throws ParseException;
    /**
     * 导出按调动日期查询人员调动情况
     * @param cndDTO
     * @return
     */
    public List<PersonTransferConditionsDO> getExcelPersonTransfer(PersonTransferQueryCndDTO cndDTO) throws ParseException;
    /**
     * 获取人员表中注销标志为0的员工 （）
     */
    List<PersonDO> findByFlag();

}
