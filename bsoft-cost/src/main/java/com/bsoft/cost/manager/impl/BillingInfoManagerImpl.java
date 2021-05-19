package com.bsoft.cost.manager.impl;

import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.common.nuonuo.HttpRequest;
import com.bsoft.common.utils.URLDownloader;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.cost.dao.primary.BillingInfoDao;
import com.bsoft.cost.entity.primary.BillingInfoDO;
import com.bsoft.cost.manager.BillingInfoManager;
import com.google.gson.Gson;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 19:31
 * @Description: 开票信息
 */
@Component
public class BillingInfoManagerImpl implements BillingInfoManager {

    private static Logger logger = LoggerFactory.getLogger(BillingInfoManagerImpl.class);

    @Value("${nuonuo.invoice.query}")
    private String QUERY_URL;

    @Value("${nuonuo.invoice.identity}")
    private String IDENTITY;

    private static Gson GSON = new Gson();

    @Autowired
    private FilerServerManager filerServerManager;

    @Autowired
    private BillingInfoDao billingInfoDao;
    @Override
    public List<BillingInfoDO> findAllNeedUpdateInvoice() {
        return billingInfoDao.findAllNeedUpdateInvoice();
    }

    @Override
    public void saveBillingInvoice() {
        List<BillingInfoDO> list = findAllNeedUpdateInvoice();
        if (list.size() > 0){
            List<Map<String,String>> mapList = queryInvoice(list);
            for (Map<String,String> map:mapList){
                String invoiceApplyId = map.get("invoiceApplyId");
                String invoicePdfUrl = map.get("invoicePdfUrl");
                String invoicePngUrl = map.get("invoicePngUrl");
                String fpdm = map.get("fpdm");
                String fphm = map.get("fphm");
                Integer key = Integer.valueOf(map.get("key"));
                for (BillingInfoDO billingInfoDO:list){
                    if (billingInfoDO.getInvoiceApplyId().equals(invoiceApplyId)){
                        billingInfoDO.setInvoicePngUrl(invoicePngUrl);
                        billingInfoDO.setInvoicePdfUrl(invoicePdfUrl);
                        billingInfoDO.setFpdm(fpdm);
                        billingInfoDO.setFphm(fphm);
                        billingInfoDO.setInvoicePdfId(key);
                    }
                }
            }
            logger.info("同步开票信息之后保存的开票记录信息：[{}]",JSONUtils.toString(list));
            billingInfoDao.saveAll(list);
        }
    }

    //查询开票文件Url信息
    public List<Map<String,String>> queryInvoice(List<BillingInfoDO> list){
        List strings = new ArrayList<>();
        for (BillingInfoDO billingInfoDO:list){
            strings.add(billingInfoDO.getInvoiceApplyId());
        }
        return queryByLsh(strings);
    }

    public List<Map<String,String>> queryByLsh(List fpqqlsh){
        Map<String,Object> map = new HashedMap();
        List<Map<String,String>> returnList = new ArrayList<>();
        map.put("identity",IDENTITY);
        map.put("fpqqlsh",fpqqlsh);
        String order = JSONUtils.toString(map);
        String queryOut = HttpRequest.httpRequest(QUERY_URL,order);
        logger.info("获取开票信息[{}]queryOutqueryOutqueryOut===[{}]",fpqqlsh.toString(),queryOut);
        Map<String,Object> queryMap = GSON.fromJson(queryOut, Map.class);
        if (queryMap.get("result").equals("success")){
            List<Map> list1 = (List<Map>) queryMap.get("list");
            logger.info("=========",list1);
            for (Map<String,String> map1:list1){
                Map<String,String> map2 = new HashedMap();
                String pdfUrl = map1.get("c_url");
                String applyId = map1.get("c_invoiceid");
                map2.put("invoiceApplyId",map1.get("c_invoiceid"));
                map2.put("invoicePdfUrl",pdfUrl);
                map2.put("invoicePngUrl",map1.get("c_imgUrls"));
                map2.put("fpdm",map1.get("c_fpdm"));
                map2.put("fphm",map1.get("c_fphm"));
                String fileName = applyId.concat("_").concat(URLDownloader.getFileNameFromUrl(pdfUrl));
                byte[] data = URLDownloader.getUrlFileData(pdfUrl);
                logger.info("文件大小：===[{}]==========[{}]",fileName,data.length);
                Integer key = filerServerManager.save(0,fileName,data);
                map2.put("key",key.toString());
                returnList.add(map2);
            }
        }
        return returnList;
    }
}
