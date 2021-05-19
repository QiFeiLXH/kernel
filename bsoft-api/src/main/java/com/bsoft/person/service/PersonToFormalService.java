package com.bsoft.person.service;

import com.bsoft.common.result.Result;
import com.bsoft.person.dto.PersonToFormalCountDTO;
import com.bsoft.person.dto.PersonToFormalDTO;
import com.bsoft.person.dto.PersonToFormalQueryCndDTO;
import com.bsoft.person.dto.PersonTurViewDTO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/29 17:21
 * @Description:
 */
public interface PersonToFormalService {

    List<PersonToFormalCountDTO> getMonthCount(Integer year);

    Result<PersonToFormalDTO> getMonthPersonToFormalList(PersonToFormalQueryCndDTO cndDTO);

    PersonTurViewDTO getPersonTur(Integer id);
}
