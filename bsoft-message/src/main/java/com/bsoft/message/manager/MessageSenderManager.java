package com.bsoft.message.manager;

import com.bsoft.message.bean.EmailMessageBean;
import com.bsoft.project.dto.ProjectGroupDTO;
import com.bsoft.project.dto.ProjectGroupDetailDTO;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-03-10 9:29
 * @Version 1.0
 * @Description
 */
public interface MessageSenderManager {
    void sendEmailMessage(EmailMessageBean emailMessageBean);

    void sendProjectLogUpdate(String contractno);

    void senEmailMoreMessage(EmailMessageBean emailMessageBean);

    void sendHREmailMessage(EmailMessageBean emailMessageBean);
}
