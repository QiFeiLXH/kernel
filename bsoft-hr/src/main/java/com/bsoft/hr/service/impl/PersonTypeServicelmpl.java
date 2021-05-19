package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.manager.PersonTypeManager;
import com.bsoft.hr.service.PersonTypeService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Service
public class PersonTypeServicelmpl implements PersonTypeService {
    private static final Logger logger = LoggerFactory.getLogger(PersonTypeServicelmpl.class);

    @Autowired
    private PublicDicManager publicDicManager;

    @Autowired
    private PersonTypeManager personTypeManager;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public PublicDicDTO getPersonTypeInfo( PublicDicDTO publicDicDTO) {
        PublicDicDO publicDicDO = publicDicManager.getValue(publicDicDTO.getType(), Integer.toString(publicDicDTO.getId()));
        return  iGenerator.convert(publicDicDO, PublicDicDTO.class);
    }


    public Result<PublicDicDTO> getPersonTypeInfoList(Integer pageNo,Integer pageSize,Integer type,Integer personflag) {
        Page<PublicDicDO> pages = personTypeManager.getPersonTypeList(pageNo,pageSize,type,personflag);
        return  ResultUtils.parseResult(pages, PublicDicDTO.class);
    }

    @Override
    public void addPersonType(String userId, PublicDicDTO publicDicDTO) {
        PublicDicDO convert = iGenerator.convert(publicDicDTO, PublicDicDO.class);
        personTypeManager.addPersonType(userId,convert);
    }

    @Override
    public void updatePersonType(String userId, PublicDicDTO publicDicDTO) {
        PublicDicDO convert = iGenerator.convert(publicDicDTO, PublicDicDO.class);
        personTypeManager.updatePersonType(userId,convert);
    }

    @Override
    public boolean logoutPersonType(Integer id) {
        //判断该财务类别ID是否被使用，被使用的话则禁止禁用
        boolean ifFinancialType = personTypeManager.ifFinancialType(id);
        if(ifFinancialType){
            publicDicManager.logout(id);
        }
        return ifFinancialType;
    }
}
