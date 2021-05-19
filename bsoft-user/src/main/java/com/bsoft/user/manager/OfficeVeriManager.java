package com.bsoft.user.manager;

import java.util.concurrent.TimeUnit;

public interface OfficeVeriManager {

    public void setVeriInfo(String Ip, String mapString, long timeout, TimeUnit unit);

    public void removeVeriInfo(String Ip);

    public Boolean hasVeriInfo(String Ip);

    public String getVeriInfo(String Ip);

}
