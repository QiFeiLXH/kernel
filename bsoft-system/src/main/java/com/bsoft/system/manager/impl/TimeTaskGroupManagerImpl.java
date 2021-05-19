package com.bsoft.system.manager.impl;

import com.bsoft.system.dao.primary.TimeTaskGroupDao;
import com.bsoft.system.entity.primary.TimeTaskGroupTreeDO;
import com.bsoft.system.manager.TimeTaskGroupManager;
import com.google.common.collect.Collections2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 11:00
 * @Version 1.0
 * @Description
 */
@Component
public class TimeTaskGroupManagerImpl implements TimeTaskGroupManager {
    @Autowired
    private TimeTaskGroupDao timeTaskGroupDao;
    @Override
    public TimeTaskGroupTreeDO save(TimeTaskGroupTreeDO timeTaskGroup) {
        timeTaskGroup.setValue(timeTaskGroup.getTitle());
        return timeTaskGroupDao.save(timeTaskGroup);
    }

    @Override
    public void delete(Integer id) {
        timeTaskGroupDao.deleteById(id);
    }

    @Override
    public List<TimeTaskGroupTreeDO> getGroupTree() {
        List<TimeTaskGroupTreeDO> result = timeTaskGroupDao.findAll();
        Collection<TimeTaskGroupTreeDO> roots = Collections2.filter(result, x->x.getParentId().equals(0));
        for(TimeTaskGroupTreeDO root : roots){
            toGroupTree(root,result);
        }
        return new ArrayList<>(roots);
    }

    private void toGroupTree(TimeTaskGroupTreeDO parent,List<TimeTaskGroupTreeDO> result){
        Integer parentId = parent.getKey();
        Collection<TimeTaskGroupTreeDO> childrens = Collections2.filter(result,x->x.getParentId().equals(parentId));
        if(childrens != null && !childrens.isEmpty()){
            parent.setChildren(new ArrayList<>(childrens));
            for(TimeTaskGroupTreeDO children : childrens){
                toGroupTree(children,result);
            }
        }

    }
}
