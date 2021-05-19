package com.bsoft.hr.service.impl;

import com.bsoft.common.dao.primary.HumanDicDao;
import com.bsoft.common.dao.primary.PublicDicDao;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.PersonFinancialViewQueryCnd;
import com.bsoft.hr.dao.primary.PersonFinancialMaintainDao;
import com.bsoft.hr.dto.*;
import com.bsoft.hr.entity.primary.PersonFinancialMaintainDO;
import com.bsoft.hr.entity.primary.PersonFinancialViewDO;
import com.bsoft.hr.manager.PersonFinancialMaintainManager;
import com.bsoft.hr.manager.PersonFinancialViewManager;
import com.bsoft.hr.service.PersonFinancialMaintainService;
import com.bsoft.hr.service.PersonFinancialViewService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PersonFinancialViewServiceImpl implements PersonFinancialViewService {
    @Autowired
    private PersonFinancialViewManager personFinancialViewManager;

    @Autowired
    private PersonFinancialMaintainManager personFinancialMaintainManager;
    @Autowired
    private HumanDicDao humanDicDao;

    @Autowired
    private PublicDicDao publicDicDao;

    @Autowired
    private IGenerator iGenerator;


    @Override
    public Result<PersonFinancialViewDTO> getPersonFinancialList(PersonFinancialViewDTO personFinancialViewDTO) {
        PersonFinancialViewQueryCnd convert = iGenerator.convert(personFinancialViewDTO, PersonFinancialViewQueryCnd.class);
        Page<PersonFinancialViewDO> page =  personFinancialViewManager.getPersonFinancialList(convert);
        Result<PersonFinancialViewDTO> result = ResultUtils.parseResult(page, PersonFinancialViewDTO.class);

        //        Result<PersonFinancialViewDTO> result = ResultUtils.parseResult(personFinancialList, PersonFinancialViewDTO.class);
//        List<PersonFinancialViewDTO> items = result.getItems();
        List<PersonFinancialViewDTO> items = result.getItems();
        /** 将postName插入DTO返回*/
        List<HumanDicDO> humanDicDOList = humanDicDao.findAllByTypeAndIdNotOrderByIdAsc(2,0);
        for (PersonFinancialViewDTO personFinancialViewDTO1:items) {
            for (HumanDicDO humanDicDO:humanDicDOList) {
                if(humanDicDO.getId().equals(personFinancialViewDTO1.getPostType())){
                    personFinancialViewDTO1.setPostName(humanDicDO.getName());
                }
            }
        }


        /** 将financialName插入DTO返回*/
        List<PublicDicDO> allByTypeAndFlag = publicDicDao.findByType(3012);
        List<PublicDicDO> newallByTypeAndFlag = new ArrayList<>();
        for(PublicDicDO publicDicDO:allByTypeAndFlag){
            if(publicDicDO.getPersonflag()==0&&publicDicDO.getId()!=0){
                newallByTypeAndFlag.add(publicDicDO);
            }
        }
        for (PersonFinancialViewDTO personFinancialViewDTO2:items) {
            for (PublicDicDO publicDicDO:newallByTypeAndFlag) {
                if(publicDicDO.getId().equals(personFinancialViewDTO2.getFinancialTypeNow())){
                    personFinancialViewDTO2.setFinancialNameNow(publicDicDO.getName());
                }
            }
        }
        result.setItems(items);
        return result;

    }

    @Override
    @Transactional
    public void updatePersonFinancial(String userId,List<PersonFinancialViewDTO> personFinancialViewDTO) {
        List<PersonFinancialMaintainDO> convert = iGenerator.convert(personFinancialViewDTO, PersonFinancialMaintainDO.class);
        //插入调整记录
        convert.forEach(personFinancialMaintainDTO->{
            personFinancialMaintainDTO.setType(3);
        });
        personFinancialMaintainManager.insertInfo(userId,convert);
        List<PersonFinancialViewQueryCnd> cnd = iGenerator.convert(personFinancialViewDTO, PersonFinancialViewQueryCnd.class);
        personFinancialViewManager.updatePersonFinancial(cnd);
    }
}
