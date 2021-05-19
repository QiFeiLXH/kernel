package com.bsoft.person.manager;

import com.bsoft.person.condition.PersonTransferQueryCnd;
import com.bsoft.person.entity.primary.PersonTransferDO;
import com.bsoft.person.entity.primary.PersonTransferSyncViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 10:43
 * @Description:
 */
public interface PersonTransferManager {
    Page<PersonTransferDO> findPersonTransfer(PersonTransferQueryCnd cnd);

    void savePersonTransfer(List<PersonTransferDO> personTransferDOS, String personId);

    PersonTransferDO getPersonTransfer(String personId);
    /**
     * 获取当天的前一天调动的员工集合
     */
    List<PersonTransferSyncViewDO> getTransferDateSync();

}
