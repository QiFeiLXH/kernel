package com.bsoft.person.manager;

import com.bsoft.common.schoolMessage.ResultJavaRegisterEntity;

import java.io.IOException;
import java.text.ParseException;

public interface CloudschoolSynManager {
    /**
     *入职：同步云学堂人员
     */

    void SyncSavePersonnel() throws IOException;

    /**
     *离职：禁用云学堂人员
     */
    void SyncQuitPersonnel() ;

    /**
     *调动：同步云学堂人员
     */
    void SyncTransferPersonnel();

    /**
     *账号：同步云学堂单点登录
     */
    ResultJavaRegisterEntity SyncRegisterPersonnel(String uname);

    /**
     *入职：同步所有用户到云学堂
     */
    void SyncOnePersonnel()  ;
}
