package com.bsoft.common.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dto.CompanyViewDTO;
import com.bsoft.common.entity.primary.CompanyDO;
import com.bsoft.common.entity.primary.CompanyViewDO;
import com.bsoft.common.manager.CompanyManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.service.CompanyService;
import com.bsoft.common.utils.PinyinUtil;
import com.bsoft.exception.ServiceException;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/26 10:52
 * @Description:
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);
    @Autowired
    private CompanyManager companyManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Integer saveCompany(CompanyViewDTO companyViewDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        CompanyDO companyDO = generatorUtil.convert(companyViewDTO,CompanyDO.class);
        String unitCode = companyDO.getUnitcode();
        Integer companyId = companyDO.getCompanyId() == null?0:companyDO.getCompanyId();
        doCheckCompanyName(companyDO.getAbbreviation(),companyId);
        doCheckUnitcode(unitCode,companyId);//验证公司编号唯一性
        setPinYinCode(companyDO);//设置拼音码
        Integer newCompanyId = companyManager.saveCompany(companyDO);
        companyManager.saveCompanyPurpose();//统一更新purpose字段长度，补0处理
        long times = timeConsumer.end();
        logger.info("保存、更新公司信息耗时:[{}]",times);
        return newCompanyId;
    }

    private CompanyDO setPinYinCode(CompanyDO companyDO){
        String pym = PinyinUtil.getFirstSpell(companyDO.getAbbreviation());
        if (pym.length() >= 10){
            companyDO.setPinyinCode(pym.substring(0,10));
        }else{
            companyDO.setPinyinCode(pym);
        }
        return companyDO;
    }

    private void doCheckCompanyName(String CompanyName,Integer companyId){
        List<CompanyDO> list = companyManager.findByName(CompanyName,companyId);
        if (list.size() > 0 ){
            throw new ServiceException("公司简称已存在，请修改！");
        }
    }

    private void doCheckUnitcode(String unitCode,Integer companyId){
        List<CompanyDO> list = companyManager.findByUnitCode(unitCode,companyId);
        if (list.size() > 0 ){
            throw new ServiceException("单位编码已存在，请修改！");
        }
    }

    @Override
    public List<CompanyViewDTO> getAllCompany() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CompanyViewDO> list = companyManager.getAllCompany();
        long times = timeConsumer.end();
        logger.info("获取所有公司信息耗时:[{}]",times);
        return generatorUtil.convert(list,CompanyViewDTO.class);
    }

    @Override
    public CompanyViewDTO getCompanyById(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        CompanyViewDO companyViewDO = companyManager.getCompanyById(id);
        long times = timeConsumer.end();
        logger.info("获取公司ID=[{}]的信息耗时:[{}]",id,times);
        return generatorUtil.convert(companyViewDO,CompanyViewDTO.class);
    }

    @Override
    public List<CompanyViewDTO> getCompanyDic(Integer type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CompanyViewDO> companyViewDOS = companyManager.getCompanyDic(type);
        long times = timeConsumer.end();
        logger.info("获取type=[{}]的公司字典耗时:[{}]",type,times);
        return generatorUtil.convert(companyViewDOS,CompanyViewDTO.class);
    }

    @Override
    public List<CompanyViewDTO> getCompanyDic(Integer type,String context) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CompanyViewDO> companyViewDOS = companyManager.getCompanyDic(type,context);
        long times = timeConsumer.end();
        logger.info("获取type=[{}],查询like=[{}]的公司字典耗时:[{}]",type,context,times);
        return generatorUtil.convert(companyViewDOS,CompanyViewDTO.class);
    }

    @Override
    public List<CompanyViewDTO> getNotCancelledCompany() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CompanyViewDO> list = companyManager.getNotCancelledCompany();
        long times = timeConsumer.end();
        logger.info("获取未注销的公司信息耗时:[{}]",times);
        return generatorUtil.convert(list,CompanyViewDTO.class);
    }


    @Override
    public void cancelCompany(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        companyManager.cancelCompany(id);
        long times = timeConsumer.end();
        logger.info("注销公司信息[{}]耗时:[{}]",id,times);
    }

    @Override
    public List<CompanyViewDTO> getCompanyViewList(String input) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CompanyViewDO> companyViewList = companyManager.getCompanyViewList(input);
        long times = timeConsumer.end();
        logger.info("公司选择框信息[{}]耗时:[{}]",input,times);
        return generatorUtil.convert(companyViewList,CompanyViewDTO.class);
    }
}
