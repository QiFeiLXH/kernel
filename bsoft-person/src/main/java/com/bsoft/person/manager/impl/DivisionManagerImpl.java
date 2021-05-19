package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.AdministrativeAreaDao;
import com.bsoft.person.dao.primary.AdministrativeDivisionDao;
import com.bsoft.person.entity.primary.AdministrativeAreaDO;
import com.bsoft.person.entity.primary.AdministrativeDivisionDO;
import com.bsoft.person.manager.DivisionManager;
import com.google.common.collect.Collections2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: hy
 * @Date: 2020/7/1
 * @Description:
 */
@Component
public class DivisionManagerImpl implements DivisionManager {

    @Autowired
    private AdministrativeDivisionDao administrativeDivisionDao;

    @Autowired
    private AdministrativeAreaDao administrativeAreaDao;

    @Override
    public List<AdministrativeAreaDO> getAdministrativeAreaTree() {
        List<AdministrativeAreaDO> result = administrativeAreaDao.findByDeleted(0);
        result.sort(Comparator.comparing(AdministrativeAreaDO::getId));
        Collection<AdministrativeAreaDO> roots = Collections2.filter(result, x->x.getParentId().equals(0));
        for(AdministrativeAreaDO root : roots){
            toTree(root,result);
        }
        return new ArrayList<>(roots);
    }

    @Override
    public List<AdministrativeAreaDO> getAdministrativeArea(Integer level, Integer deleted) {
        List<AdministrativeAreaDO> result = administrativeAreaDao.findByLevelAndDeleted(level, deleted);
        List<AdministrativeAreaDO> sortResult = result.stream().sorted(Comparator.comparing(AdministrativeAreaDO::getId)).collect(Collectors.toList());
        return sortResult;
    }

    @Override
    public List<AdministrativeAreaDO> getAdministrativeArea(Integer parentId) {
        List<AdministrativeAreaDO> area = administrativeAreaDao.findByParentIdAndDeleted(parentId, 0);
        return area;
    }



    @Override
    public List<AdministrativeDivisionDO> getAdministrativeDivision(Integer level, Integer flag) {
        List<AdministrativeDivisionDO> administrativeDivisionDOS = administrativeDivisionDao.findAllByLevelAndFlagOrderByCodeAsc(level,flag);
        return administrativeDivisionDOS;
    }

    @Override
    public List<AdministrativeDivisionDO> getAdministrativeDivisionList(Integer parentCode) {
        List<AdministrativeDivisionDO> administrativeDivisionDOS = administrativeDivisionDao.findAllByParentCodeAndFlagOrderByCodeAsc(parentCode,0);
        return administrativeDivisionDOS;
    }

    @Override
    public AdministrativeDivisionDO getAdministrativeDivision(Integer code) {
        return administrativeDivisionDao.findByCode(code);
    }

    @Override
    public AdministrativeDivisionDO getDivisionCity(Integer code) {
        AdministrativeDivisionDO divisionDO = administrativeDivisionDao.findCity(code);
        return divisionDO;
    }

    @Override
    public List<AdministrativeDivisionDO> getAdministrativeDivisionTree() {
        List<AdministrativeDivisionDO> result = administrativeDivisionDao.findAllByFlag(0);
        result.sort(Comparator.comparing(AdministrativeDivisionDO::getCode));
        Collection<AdministrativeDivisionDO> roots = Collections2.filter(result, x->x.getParentCode().equals(0));
        for(AdministrativeDivisionDO root : roots){
            toDivisionTree(root,result);
        }
        return new ArrayList<>(roots);
    }

    private void toDivisionTree(AdministrativeDivisionDO parent,List<AdministrativeDivisionDO> result){
        Integer parentId = parent.getCode();
        Collection<AdministrativeDivisionDO> childrens = Collections2.filter(result,x->x.getParentCode().equals(parentId));
        if(childrens != null && !childrens.isEmpty()){
            parent.setChildren(new ArrayList<>(childrens));
            for(AdministrativeDivisionDO children : childrens){
                toDivisionTree(children,result);
            }
        }else{
            parent.setChildren(new ArrayList<>());
        }

    }

    private void toTree(AdministrativeAreaDO parent,List<AdministrativeAreaDO> result){
        Integer parentId = parent.getId();
        Collection<AdministrativeAreaDO> childrens = Collections2.filter(result,x->x.getParentId().equals(parentId));
        if(childrens != null && !childrens.isEmpty()){
            parent.setChildren(new ArrayList<>(childrens));
            for(AdministrativeAreaDO children : childrens){
                toTree(children,result);
            }
        }else{
            parent.setChildren(new ArrayList<>());
        }

    }


}
