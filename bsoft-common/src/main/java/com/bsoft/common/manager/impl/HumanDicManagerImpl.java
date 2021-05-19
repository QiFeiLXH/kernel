package com.bsoft.common.manager.impl;

import com.bsoft.common.condition.HumanDicSelectQueryCnd;
import com.bsoft.common.dao.primary.HumanDicDao;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.HumanDicManager;
import com.bsoft.common.manager.KeyGeneratorManager;
import com.bsoft.common.utils.PinyinUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class HumanDicManagerImpl implements HumanDicManager {
    private static final String DEFAULT_CACHENAME = "PersonDic";
    private static final String DEFAULT_CACHENAME_DETAIL = DEFAULT_CACHENAME + ":detail";
    private static final String DEFAULT_CACHENAME_ALL = DEFAULT_CACHENAME + ":all";
    private static final String DEFAULT_CACHENAME_TYPE = DEFAULT_CACHENAME + ":type";

    @Autowired
    private HumanDicDao humanDicDao;

    @Autowired
    private KeyGeneratorManager keyGeneratorManager;

    @Override
    public List<HumanDicDO> getRestypeDic() {
        return humanDicDao.findByType(14);
    }
    @Override
    public HumanDicDO getRestypeDic(Integer id) {
        return humanDicDao.findByTypeAndId(14,id);
    }

    @Override
    @Cacheable(cacheNames = DEFAULT_CACHENAME_ALL)
    public List<HumanDicDO> getPersonDic(Integer type) {
        return humanDicDao.findByType(type);
    }

    @Override
//    @Cacheable(cacheNames = DEFAULT_CACHENAME_TYPE,key = "#type")
    public List<HumanDicDO> getTypePersonDic(Integer type) {
        return humanDicDao.getVisibledDic(type);
    }

    @Override
    @Cacheable(cacheNames = DEFAULT_CACHENAME_DETAIL,key = "#type + ':' + #key")
    public HumanDicDO getValue(Integer type, Integer key) {
        return humanDicDao.findByTypeAndId(type,key);
    }

    public HumanDicDO getValue(Integer type,String name){
        return humanDicDao.findByTypeAndName(type,name);
    }

    @Override
    public HumanDicDO saveHumanDic(Integer type,String name) {
        HumanDicDO humanDicDO = new HumanDicDO();
        Integer id = humanDicDao.getMaxIdByType(type);
        humanDicDO.setType(type);
        humanDicDO.setId(id+1);
        humanDicDO.setName(name);
        humanDicDO.setLogout(0);
        String pym = PinyinUtil.getFirstSpell(name);
        if (pym.length()>=8){
            humanDicDO.setPinyin(PinyinUtil.getFirstSpell(name).substring(0,8));
        }else{
            humanDicDO.setPinyin(PinyinUtil.getFirstSpell(name));
        }
        humanDicDO = humanDicDao.save(humanDicDO);
        return humanDicDO;
    }

    @Override
    public Map<String, String> getDic(Integer type) {
        List<HumanDicDO> dicList = humanDicDao.findByType(type);
        return dicList.stream().filter((dic)->!dic.getId().equals("0")).collect(Collectors.toMap((dic)->String.valueOf(dic.getId()),HumanDicDO::getName,(key1, key2)->key1));
    }

    @Override
    public List<HumanDicDO> getHumanDicSelectList(HumanDicSelectQueryCnd queryCnd) {
        List<HumanDicDO> list = humanDicDao.findAll(new Specification<HumanDicDO>() {
            @Override
            public Predicate toPredicate(Root<HumanDicDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.greaterThan(root.get("id"), 0));
                predicates.add(criteriaBuilder.equal(root.get("type"), queryCnd.getType()));
                predicates.add(criteriaBuilder.equal(root.get("logout"), 0));
                if (StringUtils.isNotBlank(queryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("name"), "%" + queryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinyin"), "%" + queryCnd.getInputContent().toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("pinyin"), "%" + queryCnd.getInputContent().toUpperCase() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }


}
