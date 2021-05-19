package com.bsoft.version.dto;

import java.io.Serializable;

public class AppUpgradeVersionDTO implements Serializable {
    private String currentVersion; //当前APP版本号
    private String lastestVersion; //最新版本号
    private Integer upgrade;//是否强制升级标志：1代表强制升级 0代表不需要强制升级
    private String remark;//升级备注

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getLastestVersion() {
        return lastestVersion;
    }

    public void setLastestVersion(String lastestVersion) {
        this.lastestVersion = lastestVersion;
    }

    public Integer getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Integer upgrade) {
        this.upgrade = upgrade;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
