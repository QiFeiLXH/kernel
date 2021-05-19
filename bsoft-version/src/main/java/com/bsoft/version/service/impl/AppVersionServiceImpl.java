package com.bsoft.version.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.version.dto.AppUpgradeVersionDTO;
import com.bsoft.version.dto.AppVersionDTO;
import com.bsoft.version.entity.primary.AppVersionDO;
import com.bsoft.version.manager.AppVersionManager;
import com.bsoft.version.service.AppVersionService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(protocol = {"hessian","dubbo"})
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionManager appVersionManager;

    @Autowired
    private IGenerator generator;

    @Override
    public AppUpgradeVersionDTO getIosVersion(String version) {
        AppVersionDO currentVersion = appVersionManager.getCurrentVersion(1,version);
        AppVersionDO lastestVersion = appVersionManager.getLastestVersion(1);
        if(lastestVersion != null && currentVersion != null){
            AppUpgradeVersionDTO appUpgradeVersion = new AppUpgradeVersionDTO();
            appUpgradeVersion.setCurrentVersion(currentVersion.getVersion());
            appUpgradeVersion.setLastestVersion(lastestVersion.getVersion());
            appUpgradeVersion.setUpgrade(currentVersion.getUpgrade());
            appUpgradeVersion.setRemark(lastestVersion.getRemark());
            return appUpgradeVersion;
        }
        return null;
    }

    @Override
    public AppUpgradeVersionDTO getAndroidVersion(String version) {
        AppVersionDO currentVersion = appVersionManager.getCurrentVersion(2,version);
        AppVersionDO lastestVersion = appVersionManager.getLastestVersion(2);
        if(lastestVersion != null && currentVersion != null){
            AppUpgradeVersionDTO appUpgradeVersion = new AppUpgradeVersionDTO();
            appUpgradeVersion.setCurrentVersion(currentVersion.getVersion());
            appUpgradeVersion.setLastestVersion(lastestVersion.getVersion());
            appUpgradeVersion.setUpgrade(currentVersion.getUpgrade());
            appUpgradeVersion.setRemark(lastestVersion.getRemark());
            return appUpgradeVersion;
        }
        return null;
    }

    @Override
    public byte[] getLastestAndroidApp() {
        return appVersionManager.getLastestAndroidApp();
    }

    @Override
    public List<AppVersionDTO> getAndroidAppVersionList() {
        List<AppVersionDO> result = appVersionManager.getAndroidAppVersionList();
        return generator.convert(result,AppVersionDTO.class);
    }

    @Override
    public List<AppVersionDTO> getIosAppVersionList() {
        List<AppVersionDO> result = appVersionManager.getIosAppVersionList();
        return generator.convert(result,AppVersionDTO.class);
    }
}
