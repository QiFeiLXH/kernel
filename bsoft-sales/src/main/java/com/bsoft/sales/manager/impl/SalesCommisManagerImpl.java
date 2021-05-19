package com.bsoft.sales.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.contract.entity.primary.ContractDO;
import com.bsoft.contract.manager.ContractManager;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.sales.condition.SalesCommisQueryCnd;
import com.bsoft.sales.dao.primary.SalesCommisDao;
import com.bsoft.sales.entity.primary.SalesCommisDO;
import com.bsoft.sales.entity.primary.SalesCommisImportDO;
import com.bsoft.sales.entity.primary.SalesCommisViewDO;
import com.bsoft.sales.manager.SalesCommisManager;
import com.bsoft.sales.repository.primary.SalesCommisRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 13:50
 * @Description:
 */
@Component
public class SalesCommisManagerImpl implements SalesCommisManager {
    private static final String DEFAULT_ERROR_DATA = "ErrorData";
    private static final String KEY = "salesCommis";
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private SalesCommisRepository salesCommisRepository;
    @Autowired
    private SalesCommisDao salesCommisDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private ContractManager contractManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private KeyGenerator keyGenerator;

    @Override
    public PageInfo<SalesCommisViewDO> getSalesCommis(SalesCommisQueryCnd cnd) {
        PageHelper.startPage(cnd.getPageNo(), cnd.getPageSize());
        Date endDate = cnd.getEndDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        cnd.setEndDate(cal.getTime());
        List<SalesCommisViewDO> list = salesCommisRepository.getSalesCommis(cnd);
        PageInfo<SalesCommisViewDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

    @Override
    @Transactional
    public void deleteSalesCommis(List<Integer> ids) {
        List<SalesCommisDO> list = salesCommisDao.findAllByIdIn(ids);
        List<String> htbhs = new ArrayList<>();
        list.forEach(SalesCommisDO->{
            if (!htbhs.contains(SalesCommisDO.getHtbh())){
                htbhs.add(SalesCommisDO.getHtbh());
            }
        });
        salesCommisDao.deleteAllByIdIn(ids);
        this.saveContractAssignFlag(htbhs);
    }

    @Override
    @Transactional
    public void aduitSalesCommis(List<Integer> ids, String personId) {
        List<SalesCommisDO> list = salesCommisDao.findAllByIdIn(ids);
        Date currentDate = serverDateManager.getServerDateTime();
        list.forEach(SalesCommisDO->{
            SalesCommisDO.setAuditFlag(1);
            SalesCommisDO.setAuditor(personId);
            SalesCommisDO.setAuditDate(currentDate);
        });
        salesCommisDao.saveAll(list);
    }

    @Override
    @Transactional
    public ImportResultDO importSalesCommis(List<SalesCommisImportDO> list, String personId) {
        Map<String,Object> map = checkData(list,personId);
        List<SalesCommisDO> saveData = (List<SalesCommisDO>) map.get("save");
        List<SalesCommisImportDO> errorData = (List<SalesCommisImportDO>) map.get("error");
        List<String> htbhs = (List<String>) map.get("htbhs");
        if (saveData.size()>0){
            salesCommisDao.saveAll(saveData);
            this.saveContractAssignFlag(htbhs);
        }
        this.cacheErrorData(personId,errorData);
        ImportResultDO importResultDO = new ImportResultDO();
        importResultDO.setSuccessCount(saveData.size());
        importResultDO.setFailCount(errorData.size());
        return importResultDO;
    }

    @Override
    public List<SalesCommisImportDO> getImportError(String personId) {
        String errorDataString = redisTemplate.opsForValue().get(getKey(personId));
        List<SalesCommisImportDO> errorData = (List<SalesCommisImportDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    //更新kh_htxx的分配标志
    public void saveContractAssignFlag(List<String> htbhs){
        Map<String,Integer> map = new HashMap<>();
        List<SalesCommisDO> salesCommisDOS = salesCommisDao.findAllByHtbhIn(htbhs);
        salesCommisDOS.forEach(SalesCommisDO->{
            if (map.containsKey(SalesCommisDO.getHtbh())){
                Integer count = Integer.valueOf(map.get(SalesCommisDO.getHtbh()).toString()) + 1;
                map.put(SalesCommisDO.getHtbh(),count);
            }else{
                map.put(SalesCommisDO.getHtbh(),1);
            }
        });
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            String htbh = entry.getKey();
            Integer count = entry.getValue();
            if (count > 0){
                contractManager.saveAssignFlag(htbh);
            }else{
                contractManager.calcleAssignFlag(htbh);
            }
        }
    }

    private String getKey(String personId){
        return new StringBuilder(DEFAULT_ERROR_DATA).append(":").append(KEY).append(":").append(personId).toString();
    }

    private void cacheErrorData(String personId,List data){
        // 先删除redis数据
        redisTemplate.delete(getKey(personId));
        // 再重新缓存数据
        redisTemplate.opsForValue().set(getKey(personId), JSONObject.toJSONString(data));
    }

    //验证数据，并获取可保存数据和验证失败数据
    public Map<String,Object> checkData(List<SalesCommisImportDO> list,String personId){
        Map<String,Object> map = new HashedMap();
        Date currentDate = serverDateManager.getServerDateTime();
        List<SalesCommisDO> saveData = new ArrayList<>();//验证成功需保存信息
        List<SalesCommisImportDO> errorData = new ArrayList<>();//验证失败信息
        List<String> htbhs = new ArrayList<>();//验证成功的htbh列表
        List<DeptDO> validDepts = deptManager.getAllDept();//所有部门
        Map<String, String> validDeptMap = validDepts.stream().collect(Collectors.toMap(DeptDO::getDeptName, DeptDO::getDeptId));
        List<PublicDicDO> AccountingCaliberDic = publicDicManager.getPublicDic(3505);//核算口径归属
        Map<String, Integer> AccountingCaliberDicMap = AccountingCaliberDic.stream().collect(Collectors.toMap(PublicDicDO::getName, PublicDicDO::getId));
        List<PersonDO> allPersons = personManager.getVaildPerson();//在职人员信息
        Map<String, String> validPersons = allPersons.stream().collect(Collectors.toMap(PersonDO::getPersonId, PersonDO::getPersonName));
        list.forEach(SalesCommisImportDO->{
            SalesCommisDO salesCommisDO = generatorUtil.convert(SalesCommisImportDO,SalesCommisDO.class);
            if (StringUtils.isBlank(SalesCommisImportDO.getAccountingCaliberText())){//无核算口径归属
                SalesCommisImportDO.setErrorMsg("核算口径不能为空");
                errorData.add(SalesCommisImportDO);
                return;
            }
            if (!AccountingCaliberDicMap.containsKey(SalesCommisImportDO.getAccountingCaliberText())){//核算口径归属无对应字典项
                SalesCommisImportDO.setErrorMsg("核算口径名称不正确");
                errorData.add(SalesCommisImportDO);
                return;
            }else{
                salesCommisDO.setAccountingCaliber(AccountingCaliberDicMap.get(SalesCommisImportDO.getAccountingCaliberText()));
            }
            if (StringUtils.isBlank(SalesCommisImportDO.getSalesMan())){//无申请人工号
                SalesCommisImportDO.setErrorMsg("申请人工号不能为空");
                errorData.add(SalesCommisImportDO);
                return;
            }
            if (!validPersons.containsKey(SalesCommisImportDO.getSalesMan())){//工号无对应人员信息
                SalesCommisImportDO.setErrorMsg("申请人工号不正确,或已离职");
                errorData.add(SalesCommisImportDO);
                return;
            }
            if (StringUtils.isBlank(SalesCommisImportDO.getDepartMentText())){//无归属部门
                SalesCommisImportDO.setErrorMsg("二级区域不能为空");
                errorData.add(SalesCommisImportDO);
                return;
            }
            if (!validDeptMap.containsKey(SalesCommisImportDO.getDepartMentText())){//归属部门名称无效
                SalesCommisImportDO.setErrorMsg("无对应二级区域的部门信息");
                errorData.add(SalesCommisImportDO);
                return;
            }else{
                salesCommisDO.setDepartMent(validDeptMap.get(SalesCommisImportDO.getDepartMentText()));
            }
            if(SalesCommisImportDO.getContractAmount() == null){//净软件额不能为空
                SalesCommisImportDO.setErrorMsg("净软件额不能为空");
                errorData.add(SalesCommisImportDO);
                return;
            }
            if (SalesCommisImportDO.getTotalRoyalty() == null){//可提成总额不能为空
                SalesCommisImportDO.setErrorMsg("可提成总额不能为空");
                errorData.add(SalesCommisImportDO);
                return;
            }
            if (SalesCommisImportDO.getSellingExpenses() == null){//可用费用不能为空
                SalesCommisImportDO.setErrorMsg("可用费用不能为空");
                errorData.add(SalesCommisImportDO);
                return;
            }
            //验证合同信息
            if (StringUtils.isBlank(SalesCommisImportDO.getContractNo())){//未填写合同号
                SalesCommisImportDO.setErrorMsg("合同编号不能为空");
                errorData.add(SalesCommisImportDO);
                return;
            }
            List<ContractDO> contractDOList = contractManager.findContractBynumber(SalesCommisImportDO.getContractNo());//无对应合同信息
            if (contractDOList.size()<=0){
                SalesCommisImportDO.setErrorMsg("合同编号不正确");
                errorData.add(SalesCommisImportDO);
                return;
            }
            ContractDO contractDO = contractDOList.get(0);
            if (!htbhs.contains(contractDO.getId())){
                htbhs.add(contractDO.getId());
            }
            salesCommisDO.setAuditFlag(0);
            salesCommisDO.setHtbh(contractDO.getId());
            salesCommisDO.setCommissionValidFlag(1);
            salesCommisDO.setPaymentValid(30);
            salesCommisDO.setRegistrant(personId);
            salesCommisDO.setRegistrantDate(currentDate);
            salesCommisDO.setTotalCommission(0.00);
            if (contractDO.getBigCustomers().equals(1)){//大客户标志
                salesCommisDO.setDistributionFlag(1);//业绩分配
            }else{
                salesCommisDO.setDistributionFlag(0);
            }
            if (contractDO.getSignDate()!=null){
                Calendar calendar = new GregorianCalendar();
                Date signDate = contractDO.getSignDate();
                calendar.setTime(signDate);
                calendar.add(Calendar.YEAR,2);
                calendar.set(Calendar.HOUR_OF_DAY,0);
                calendar.set(Calendar.MINUTE,0);
                calendar.set(Calendar.SECOND,0);
                salesCommisDO.setExpiryDate(new Date(calendar.getTimeInMillis()));//提成有效日期 = 合同签订日期 + 2年
            }
            salesCommisDO.setId(keyGenerator.increaseSalesCommis());
            saveData.add(salesCommisDO);
        });
        map.put("save",saveData);
        map.put("error",errorData);
        map.put("htbhs",htbhs);
        return map;
    }

}
