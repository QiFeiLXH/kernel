package com.bsoft.version.manager;

import com.bsoft.version.entity.primary.AppVersionDO;

import java.util.List;

public interface AppVersionManager {
    public AppVersionDO getLastestVersion(Integer type);

    public AppVersionDO getCurrentVersion(Integer type,String version);

    public Boolean isLastest(Integer type,String version);

    public Boolean isIosLastest(String version);

    public Boolean isAndroidLastest(String version);

    public byte[] getAndroidApp(String version);

    public byte[] getLastestAndroidApp();

    public List<AppVersionDO> getAppVersionList(Integer type);

    public List<AppVersionDO> getAndroidAppVersionList();

    public List<AppVersionDO> getIosAppVersionList();
}
