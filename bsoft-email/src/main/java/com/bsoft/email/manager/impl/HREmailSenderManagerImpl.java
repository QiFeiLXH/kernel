package com.bsoft.email.manager.impl;

public class HREmailSenderManagerImpl extends BaseEmailSenderManagerImpl {
    private static final String USERNAME = "hr@bsoft.com.cn";
    private static final String PASSWORD = "wpro7G1";
    public HREmailSenderManagerImpl() {
        super(USERNAME, PASSWORD);
    }
}
