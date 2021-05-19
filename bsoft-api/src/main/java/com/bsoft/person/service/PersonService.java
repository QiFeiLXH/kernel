package com.bsoft.person.service;

import com.bsoft.common.result.Result;
import com.bsoft.person.dto.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface PersonService {
    /**
     * @Description: 根据工号获取人员信息
     * @param personid 工号
     * @return PersonDTO 人员对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public PersonDTO getPerson(String personid);

    /**
     * 根据工号列表查找员工信息
     * @param personIds 工号列表
     */
    List<PersonDTO> getPersonList(List<String> personIds);

    /**
     * @Description: 根据拼音码获取人员信息
     * @param simpleCode 拼音码
     * @return PersonDTO 人员对象
     * @author Xuhui Lin
     * @Time 2020年02月09日4
     */
    public List<PersonSelectViewDTO> findPersonSelectList(String simpleCode);

    /**
     * @Description: 根据拼音码获取人员信息
     * @param inputContent 姓名或拼音
     * @return PersonDTO 人员对象
     * @author Xuhui Lin
     * @Time 2020年02月09日4
     */
    public List<PersonSelectViewDTO> findPersonSelectList(String inputContent, Integer isValid);

    /**
     * 根据条件获取人员选择器的人员列表
     * @param queryCndDTO 查询条件
     */
    public List<PersonSelectViewDTO> getPersonSelectList(PersonSelectQueryCndDTO queryCndDTO);

    /**
     * @Description: 获取所有人员信息列表
     * @return List<PersonDTO> 人员对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<PersonDTO> getPerson();

    /**
     * @Description: 获取所有人员字典，封装成Map，key为工号，value为姓名
     * @return Map<String,String> 工号姓名键值对
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Map<String,String> getPersonDic();
    /**
     * @Description: 获取有效人员信息列表
     * @return List<PersonDTO> 人员对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<PersonDTO> getVaildPerson();

    /**
     * @Description: 获取有效人员工号列表
     * @return List<String> 人员工号列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<String> getVaildPersonId();

    /**
     *
     * @param bmdm 部门代码
     * @return
     */
    public List<PersonDTO> getDeptPerson(String bmdm);

    /**
     * 根据拼音码或姓名查询人员信息
     * @param value 拼音码或姓名
     * @return
     */
    public List<PersonDTO> getPersonInfo(String value);

    /**
     * 获取人事代码字典选项
     * @param type 代码类别
     * @return
     */
    public List<HumanDicDTO> getHumanDic(Integer type);

    /**
     * 获取职级管理系统角色信息
     * @param personId
     */
    RankRoleDTO getRankRole(String personId);

    /**
     * 获取职级管理系统人员档案
     * @param personId
     */
    RankPersonDTO getRankPerson(String personId);

    /**
     * 根据工号列表获取邮箱列表
     * @param personId
     */
    List<String> getEmails(List<String> personId);

    /**
     * 根据工号获取考勤方式
     * @param personId
     * @return
     */
    PersonInfoDTO getPersonAttendFlag(String personId);

    /**
     * 按调动日期查询人员调动情况
     * @param cndDTO
     * @return
     */
    Result<PersonTransferConditionDTO> getPersonTransfer(PersonTransferQueryCndDTO cndDTO) throws ParseException;

    /**
     * 导出按调动日期查询人员调动情况
     * @param cndDTO
     * @return
     */
    List<PersonTransferConditionDTO> getExcelPersonTransfer(PersonTransferQueryCndDTO cndDTO) throws ParseException;
}
