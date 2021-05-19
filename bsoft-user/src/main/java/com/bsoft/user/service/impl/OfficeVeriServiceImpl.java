package com.bsoft.user.service.impl;

import com.bsoft.user.manager.OfficeVeriManager;
import com.bsoft.user.service.OfficeVeriService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.TimeUnit;

@Service
public class OfficeVeriServiceImpl implements OfficeVeriService {

    @Autowired
    private OfficeVeriManager officeVeriManager;
    @Override
    public void setVeriInfo(String Ip, String mapString, long timeout, TimeUnit unit) {
        officeVeriManager.setVeriInfo(Ip,mapString,timeout,unit);
    }

    @Override
    public String getVeriInfo(String Ip) {
        return officeVeriManager.getVeriInfo(Ip);
    }

    @Override
    public void removeVeriInfo(String Ip) {
        officeVeriManager.removeVeriInfo(Ip);
    }

    @Override
    public Boolean hasVeriInfo(String Ip) {
        return officeVeriManager.hasVeriInfo(Ip);
    }
}
