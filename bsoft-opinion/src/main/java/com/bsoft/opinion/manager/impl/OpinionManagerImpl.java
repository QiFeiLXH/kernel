package com.bsoft.opinion.manager.impl;

import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.exception.ServiceException;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import com.bsoft.file.document.file.service.FileService;
import com.bsoft.opinion.condition.OpinionQueryCnd;
import com.bsoft.opinion.dao.primary.OpinionDao;
import com.bsoft.opinion.dao.primary.OpinionViewDao;
import com.bsoft.opinion.entity.primary.OpinionDO;
import com.bsoft.opinion.entity.primary.OpinionViewDO;
import com.bsoft.opinion.manager.OpinionManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Component
public class OpinionManagerImpl implements OpinionManager {
    private static final String DEFAULT_IMAGE_FILENAME = "1.jpg";
    @Autowired
    private OpinionDao opinionDao;
    @Autowired
    private OpinionViewDao opinionViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private FilerServerManager filerServerManager;
    @Override
    public OpinionDO saveOpinion(OpinionDO opinion) {
        if(opinion.getSubmitDate() == null){
            Date now = serverDateManager.getServerDateTime();
            opinion.setSubmitDate(now);
        }
        ValidateUtil.check(opinion);
        return opinionDao.save(opinion);
    }

    @Override
    public OpinionViewDO getOpinionView(Integer id) {
        Optional<OpinionViewDO> opinionDO = opinionViewDao.findById(id);
        OpinionViewDO opinion = opinionDO.orElseThrow(()-> new ServiceException("无该建议记录"));
        return opinion;
    }


    @Override
    public Page<OpinionViewDO> getAppOpinionViews(String personId, Integer page, Integer size) {
        Sort sort = Sort.by("submitDate").descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<OpinionViewDO> result =  opinionViewDao.findAll(new Specification<OpinionViewDO>() {
            @Override
            public Predicate toPredicate(Root<OpinionViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate1 = criteriaBuilder.equal(root.get("submitter"),personId);
//                Predicate predicate2 = criteriaBuilder.equal(root.get("system"),1);
                return criteriaBuilder.and(predicate1);
            }
        },pageable);
        return result;
    }

    @Override
    public Page<OpinionViewDO> getWebOpinionViews(String personId, Integer status, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<OpinionViewDO> result = opinionViewDao.findAll(new Specification<OpinionViewDO>() {
            @Override
            public Predicate toPredicate(Root<OpinionViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate1 = null;
                Predicate predicate3 = null;
                if(status.equals(10)){
                    predicate1 = criteriaBuilder.in(root.get("status")).value(1).value(2).value(3);
                }else{
                    predicate1 = criteriaBuilder.equal(root.get("status"),status);
                }
                if(StringUtils.isNotBlank(personId)){
                    Predicate predicate2 = criteriaBuilder.equal(root.get("submitter"),personId);
                    predicate3 = criteriaBuilder.and(predicate1,predicate2);
                }else{
                    predicate3 = predicate1;
                }
                return predicate3;
            }
        },pageable);
        return result;
    }

    @Override
    public OpinionDO submitOpinion(OpinionDO opinion) {
        if(opinion.getSubmitDate() == null){
            Date now = serverDateManager.getServerDateTime();
            opinion.setSubmitDate(now);
        }
        ValidateUtil.check(opinion);
        return opinionDao.save(opinion);
    }

    @Override
    public OpinionDO feedbackOpinion(OpinionDO opinion) {
        if(opinion.getFeedbackDate() == null){
            Date now = serverDateManager.getServerDateTime();
            opinion.setFeedbackDate(now);
        }
        ValidateUtil.check(opinion);
        return opinionDao.save(opinion);
    }

    @Override
    public String writeOpinionImages(List<byte[]> images) {
        if(images.isEmpty()){
            return "";
        }
        StringJoiner names = new StringJoiner(",");
        for(byte[] image : images){
            Integer key = filerServerManager.save(DEFAULT_IMAGE_FILENAME,image);
            names.add(key.toString());
        }

        return names.toString();
    }

    @Override
    public List<byte[]> readOpinionImages(String paths) {
        String[] names = paths.split(",");
        List<byte[]> images = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            byte[] file = filerServerManager.get(Integer.parseInt(names[i])).getData();
            images.add(file);
        }
        return images;
    }

    @Override
    public Page<OpinionViewDO> getOponions(OpinionQueryCnd cnd) {
        Sort sort = Sort.by("submitDate").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<OpinionViewDO> result = opinionViewDao.findAll(new Specification<OpinionViewDO>() {
            @Override
            public Predicate toPredicate(Root<OpinionViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cnd.getSystem() != null){
                    predicates.add(criteriaBuilder.equal(root.get("system"),cnd.getSystem()));
                }
                if(cnd.getStatus().equals(10)){
                    predicates.add(criteriaBuilder.in(root.get("status")).value(1).value(2).value(3));
                }else{
                    predicates.add(criteriaBuilder.equal(root.get("status"),cnd.getStatus()));
                }
                if(StringUtils.isNotBlank(cnd.getInputContent())){
                    Predicate c1 = criteriaBuilder.like(root.get("submitterText"), "%" + cnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return result;
    }

    @Override
    public OpinionViewDO getOpinionById(Integer id) {
        return opinionViewDao.getOne(id);
    }

    @Override
    public byte[] getImageByte(Integer id) {
        byte[] file = filerServerManager.get(id).getData();
        return file;
    }

    @Override
    public List<OpinionViewDO> findAllOpinion(OpinionQueryCnd cnd) {
        List<OpinionViewDO> list = opinionViewDao.findAll(new Specification<OpinionViewDO>() {
            @Override
            public Predicate toPredicate(Root<OpinionViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cnd.getSystem() != null){
                    predicates.add(criteriaBuilder.equal(root.get("system"),cnd.getSystem()));
                }
                if(cnd.getStatus().equals(10)){
                    predicates.add(criteriaBuilder.in(root.get("status")).value(1).value(2).value(3));
                }else{
                    predicates.add(criteriaBuilder.equal(root.get("status"),cnd.getStatus()));
                }
                if(StringUtils.isNotBlank(cnd.getInputContent())){
                    Predicate c1 = criteriaBuilder.like(root.get("submitterText"), "%" + cnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }

}
