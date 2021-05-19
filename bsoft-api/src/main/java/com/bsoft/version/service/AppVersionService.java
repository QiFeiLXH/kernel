package com.bsoft.version.service;

import com.bsoft.version.dto.AppUpgradeVersionDTO;
import com.bsoft.version.dto.AppVersionDTO;

import java.util.List;

public interface AppVersionService {
    /**
     * @Description: 根据版本号获取IOS端版本信息，包含当前版本，最新版本，是否强制升级，升级备注
     * @param version 当前app版本号
     * @return AppUpgradeVersionDTO app版本升级信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public AppUpgradeVersionDTO getIosVersion(String version);

    /**
     * @Description: 根据版本号获取安卓端版本信息，包含当前版本，最新版本，是否强制升级，升级备注
     * @param version 当前app版本号
     * @return AppUpgradeVersionDTO app版本升级信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public AppUpgradeVersionDTO getAndroidVersion(String version);

    /**
     * @Description: 获取最新的安卓apk文件字节数组
     * @return byte[] apk字节数组
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public byte[] getLastestAndroidApp();

    /**
     * @Description: 获取安卓端所有版本升级记录
     * @return List<AppVersionDTO> app版本升级列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<AppVersionDTO> getAndroidAppVersionList();

    /**
     * @Description: 获取IOS所有版本升级记录
     * @return List<AppVersionDTO> app版本升级列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<AppVersionDTO> getIosAppVersionList();
}
