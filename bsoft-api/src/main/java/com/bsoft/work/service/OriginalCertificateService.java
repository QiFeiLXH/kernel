package com.bsoft.work.service;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.work.dto.OriginalCertificateDTO;
import com.bsoft.work.dto.OriginalCertificateQueryCndDTO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/9/10
 * @description 证书原件管理
 */
public interface OriginalCertificateService {
    /**
     * 根据名字获取证书信息
     * @return com.bsoft.work.dto.OriginalCertificateDTO
     */
    OriginalCertificateDTO getByName(String userId, String name);

    /**
     * 获取证书原件列表
     * @param userId
     * @param queryCndDTO
     * @return Result<com.bsoft.work.dto.OriginalCertificateDTO>
     */
    Result<OriginalCertificateDTO> listByLimits(String userId, OriginalCertificateQueryCndDTO queryCndDTO);

    /**
     * 保存证书原件信息
     * @param userId
     * @param originalCertificateDTO
     */
    void save(String userId, OriginalCertificateDTO originalCertificateDTO);

    /**
     * 修改证书原件信息
     * @param userId
     * @param originalCertificateDTO
     */
    void update(String userId, OriginalCertificateDTO originalCertificateDTO);

    /**
     * 获取证书类别
     * @return List<import com.bsoft.common.dto.PublicDicDTO;>
     */
    List<PublicDicDTO> listCertType(String userId);
}
