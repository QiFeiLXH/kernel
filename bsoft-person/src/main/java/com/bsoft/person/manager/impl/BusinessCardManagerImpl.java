package com.bsoft.person.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.utils.QRCodeUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.person.condition.BusinessCardQueryCnd;
import com.bsoft.person.dao.primary.BusinessCardDao;
import com.bsoft.person.dao.primary.BusinessCardViewDao;
import com.bsoft.person.entity.primary.BusinessCardDO;
import com.bsoft.person.entity.primary.BusinessCardViewDO;
import com.bsoft.person.manager.BusinessCardManager;
import com.bsoft.person.repository.primary.BusinessCardRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BusinessCardManagerImpl implements BusinessCardManager {
    private final static Logger LOGGER = LoggerFactory.getLogger(BusinessCardManagerImpl.class);
    @Autowired
    private BusinessCardViewDao businessCardViewDao;
    @Autowired
    private BusinessCardDao businessCardDao;
    @Autowired
    private BusinessCardRepository businessCardRepository;
    @Autowired
    private ServerDateManager serverDateManager;


    @Override
    public BusinessCardDO getLastedCard(String personId) {
        BusinessCardDO businessCard = businessCardDao.getLastedCard(personId);
        return businessCard;
    }


    @Override
    public Page<BusinessCardViewDO> getBusinessCardList(BusinessCardQueryCnd cnd) {
        Sort sort = Sort.by("applyDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<BusinessCardViewDO> pages = businessCardViewDao.findAll(new Specification<BusinessCardViewDO>() {
            @Override
            public Predicate toPredicate(Root<BusinessCardViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.between(root.get("applyDate"),cnd.getStartDate(),cnd.getEndDate()));

                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("userId"),"%" + cnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("userName"),"%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("lshid"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("lshid"),"%" + cnd.getInputContent().toUpperCase() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3,c4,c5));
                }

                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("dept"),cnd.getDeptId()));
                }
                if (cnd.getStatus() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("status"),cnd.getStatus()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    public Integer getBusinessCardUnpaidCount(BusinessCardQueryCnd cnd) {
        return businessCardRepository.getBusinessCardUnpaidCount(cnd);
    }

    @Override
    public Double getBusinessCardUnpaidAmount() {
        return businessCardViewDao.getBusinessCardUnpaidAmount();
    }

    @Override
    public Double getBusinessCardTotalAmount(List<Integer> businessCardIds) {
        if (businessCardIds == null || businessCardIds.isEmpty()) {
            return 0.0;
        } else {
            return businessCardViewDao.getBusinessCardTotalAmount(businessCardIds);
        }
    }

    @Override
    public List<Integer> getBusinessCardIdList(BusinessCardQueryCnd cnd) {
        return businessCardRepository.getBusinessCardIdList(cnd);
    }

    @Override
    @Transactional
    public List<BusinessCardViewDO> updateBusinessCardApplyPay(List<Integer> businessCardIds) {
        if (businessCardIds == null || businessCardIds.isEmpty()) {
            throw new ServiceException("待操作的名片不能为空");
        }
        Date serverDate = serverDateManager.getServerDate();
        businessCardDao.updateStatusAndApplyPayDateByIdIn(businessCardIds,serverDate);
        businessCardDao.flush();
        return businessCardViewDao.findAllByIdIn(businessCardIds);
    }

    @Override
    @Transactional
    public void updateBusinessCardPay(List<Integer> businessCardIds) {
        if (businessCardIds == null || businessCardIds.isEmpty()) {
            throw new ServiceException("待操作的名片不能为空");
        }
        businessCardDao.updateStatusByIdIn(businessCardIds);
    }

    @Override
    public byte[] showImageByte(Integer id) {
        Optional<BusinessCardViewDO> opional = businessCardViewDao.findById(id);
        BusinessCardViewDO businessCardViewDO = opional.get();
        byte[] bytes = generateBusinessCardQRCode(businessCardViewDO);

        return bytes;
    }

    private byte[] generateBusinessCardQRCode(BusinessCardViewDO businessCardViewDO) {
        String username = businessCardViewDO.getUserName();
        String postname = businessCardViewDO.getPostName();
        String email = businessCardViewDO.getEmail();
        String fax = businessCardViewDO.getFax();
        String telephone = businessCardViewDO.getTelephone();
        String mobilephone = businessCardViewDO.getMobilePhone();
        String address = businessCardViewDO.getAddress();

        byte[] bytes = null;

        ClassPathResource resource = new ClassPathResource("/static/email.png");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String content = "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "N:"+username+"\n" + //姓名
                "EMAIL:"+email+"\n" + //邮箱
                "TEL;CELL:+86 "+mobilephone+"\n" + //手机
                "TEL;WORK:"+telephone+"\n" + //电话
                "TEL;WORK;FAX:"+fax+"\n"+ //传真
                "TEL;HOME;FAX:"+fax+"\n"+ //传真
                "ORG:创业慧康科技股份有限公司\n" + //公司
                "TITLE:"+postname+"\n" + // 岗位名称
                "ADR;WORK:"+address+"\n"+   //地址
                "URL:www.bsoft.com.cn\n" +
                "END:VCARD";
        try {
            bytes = QRCodeUtils.encode(content,null,baos,resource.getInputStream());
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }

        return bytes;
    }
}
