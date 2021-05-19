package com.bsoft.person.service;

import com.bsoft.common.result.Result;
import com.bsoft.person.dto.PersonTransferDTO;
import com.bsoft.person.dto.PersonTransferQueryCndDTO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:02
 * @Description:
 */
public interface PersonTransferService {
    Result<PersonTransferDTO> findPersonTransfer(PersonTransferQueryCndDTO cndDTO);

    void savePersonTransfer(List<PersonTransferDTO> personTransferDTOList, String personId);
}
