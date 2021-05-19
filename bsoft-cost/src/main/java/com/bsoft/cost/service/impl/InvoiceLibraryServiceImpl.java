package com.bsoft.cost.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.condition.InvoiceLibraryQueryCnd;
import com.bsoft.common.dto.CompanyDTO;
import com.bsoft.cost.dto.InvoiceLibraryDTO;
import com.bsoft.cost.dto.InvoiceLibraryQueryCndDTO;
import com.bsoft.common.entity.primary.CompanyDO;
import com.bsoft.cost.entity.primary.InvoiceLibraryDO;
import com.bsoft.common.manager.CompanyManager;
import com.bsoft.cost.manager.InvoiceLibraryManager;
import com.bsoft.cost.service.InvoiceLibraryService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class InvoiceLibraryServiceImpl implements InvoiceLibraryService {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceLibraryServiceImpl.class);
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    InvoiceLibraryManager invoiceLibraryManager;
    @Autowired
    CompanyManager companyManager;
    @Override
    public Result<InvoiceLibraryDTO> getInvoiceLibraryList(InvoiceLibraryQueryCndDTO invoiceLibraryQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        InvoiceLibraryQueryCnd cnd = generatorUtil.convert(invoiceLibraryQueryCndDTO, InvoiceLibraryQueryCnd.class);
        Page<InvoiceLibraryDO> pages = invoiceLibraryManager.getInvoiceLibraryList(cnd);
        Result<InvoiceLibraryDTO> result = ResultUtils.parseResult(pages, InvoiceLibraryDTO.class);
        long times = timeConsumer.end();
        logger.info("获取票据库列表[{}]，耗时[{}]",result,times);
        return result;
    }

    @Override
    public List<CompanyDTO> getCompanyList() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CompanyDO> companyDOS = companyManager.getCompanyList();
        List<CompanyDTO> companyDTOS = generatorUtil.convert(companyDOS,CompanyDTO.class);
        long times = timeConsumer.end();
        logger.info("获取公司机构列表[{}]，耗时[{}]",companyDTOS,times);
        return companyDTOS;
    }
}
