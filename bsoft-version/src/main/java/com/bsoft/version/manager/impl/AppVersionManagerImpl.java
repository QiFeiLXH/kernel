package com.bsoft.version.manager.impl;
import com.bsoft.exception.ServiceException;
import com.bsoft.version.dao.primary.AppVersionDao;
import com.bsoft.version.entity.primary.AppVersionDO;
import com.bsoft.version.manager.AppVersionManager;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class AppVersionManagerImpl implements AppVersionManager {
    private static final Logger logger = LoggerFactory.getLogger(AppVersionManagerImpl.class);

    private static final String DEFAULT_CACHENAME = "App";

    private static final String DEFAULT_CACHENAME_ANDROID = DEFAULT_CACHENAME + ":android";

    private static final String FILEPATH = "app/";
    private static final String FILENAME = "bsoftapp";
    private static final String FILESUFFIX = ".apk";
    @Autowired
    private AppVersionDao appVersionDao;

    @Override
    public AppVersionDO getLastestVersion(Integer type) {
        AppVersionDO appVersionDO = appVersionDao.getLastestVersion(type);
        if(appVersionDO == null) throw new ServiceException("无该版本号信息");
        return appVersionDO;
    }

    @Override
    public AppVersionDO getCurrentVersion(Integer type, String version) {
        return appVersionDao.findByTypeAndVersion(type,version);
    }

    @Override
    public Boolean isLastest(Integer type, String version) {
        AppVersionDO appVersion = appVersionDao.getLastestVersion(type);
        if(appVersion == null){
            throw new ServiceException("无该app版本号信息");
        }
        return appVersion.getVersion().equals(version);
    }

    @Override
    public Boolean isIosLastest(String version) {
        return isLastest(1,version);
    }

    @Override
    public Boolean isAndroidLastest(String version) {
        return isLastest(2,version);
    }

    @Override
    public byte[] getAndroidApp(String version) {
        String filename = getAppFileName(version);
        File file = new File(filename);
        byte[] app = null;
        try {
            app = Files.toByteArray(file);
        } catch (IOException e) {
            logger.error("找不到安卓app升级文件，文件名为：{}",filename);
            throw new ServiceException("找不到安卓app升级文件，文件名为:"+filename);
        }
        return app;
    }

    @Override
    public byte[] getLastestAndroidApp() {
        String version = getLastestVersion(2).getVersion();
        return getAndroidApp(version);
    }

    @Override
    public List<AppVersionDO> getAppVersionList(Integer type) {
        return appVersionDao.findByType(type);
    }

    @Override
    public List<AppVersionDO> getAndroidAppVersionList() {
        return getAppVersionList(2);
    }

    @Override
    public List<AppVersionDO> getIosAppVersionList() {
        return getAppVersionList(1);
    }

    private String getAppFileName(String version){
        return new StringBuffer(FILEPATH).append(FILENAME).append(version).append(FILESUFFIX).toString();
    }
}

