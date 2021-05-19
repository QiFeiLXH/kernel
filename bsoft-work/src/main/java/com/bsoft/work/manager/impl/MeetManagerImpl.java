package com.bsoft.work.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.utils.DateUtils;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.work.condition.MeetQueryCnd;
import com.bsoft.work.dao.primary.MeetDao;
import com.bsoft.work.dao.primary.MeetViewDao;
import com.bsoft.work.entity.primary.MeetDO;
import com.bsoft.work.entity.primary.MeetUserDO;
import com.bsoft.work.entity.primary.MeetViewDO;
import com.bsoft.work.manager.MeetManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class MeetManagerImpl implements MeetManager {
    @Autowired
    private MeetDao meetDao;
    @Autowired
    private MeetViewDao meetViewDao;
    @Override
    public void saveMeet(MeetDO meetDO) {
        meetDao.save(meetDO);
    }

    @Override
    public Result<MeetViewDO> getMeetList(MeetQueryCnd cnd) {
        Sort sort = Sort.by("startDate").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<MeetViewDO> page = meetViewDao.findAll((Specification<MeetViewDO>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(cnd.getMonth())){
                String firstDayStr = cnd.getMonth()+"-01 00:00:00";
                String lastDayStr = DateUtils.getLastDayOfMonth(cnd.getMonth()) + " 23:59:59";
                Date firstDay = null;
                Date lastDay = null;
                try {
                     firstDay = DateUtils.stringToDate(firstDayStr,"yyyy-MM-dd HH:mm:ss");
                    lastDay = DateUtils.stringToDate(lastDayStr,"yyyy-MM-dd HH:mm:ss");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                predicates.add(criteriaBuilder.between(root.get("startDate"), firstDay,lastDay));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        },pageable);
        Result<MeetViewDO> result = ResultUtils.parseResult(page);
        return result;
    }

    @Override
    public void grantProve(Integer id) {
        MeetDO meet = meetDao.findById(id).get();
        meet.setFlag(1);
        meetDao.save(meet);
    }

    @Override
    public MeetDO getMeetInfo(Integer id) {
        Optional<MeetDO> meetOp = meetDao.findById(id);
        meetOp.orElseThrow(()->new ServiceException("无对应会议"));
        return meetOp.get();
    }
}
