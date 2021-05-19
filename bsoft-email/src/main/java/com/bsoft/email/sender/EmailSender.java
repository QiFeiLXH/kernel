package com.bsoft.email.sender;

import com.bsoft.email.manager.BaseEmailSenderManager;
import com.bsoft.email.manager.impl.EofficeEmailSenderManagerImpl;
import com.bsoft.email.manager.impl.HREmailSenderManagerImpl;

public class EmailSender {
    public static BaseEmailSenderManager getHrEmailSender(){
        return new HREmailSenderManagerImpl();
    }

    public static BaseEmailSenderManager getEofficeEmailSender(){
        return new EofficeEmailSenderManagerImpl();
    }
}
