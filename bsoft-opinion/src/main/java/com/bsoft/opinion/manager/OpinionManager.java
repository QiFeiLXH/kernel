package com.bsoft.opinion.manager;

import com.bsoft.opinion.condition.OpinionQueryCnd;
import com.bsoft.opinion.entity.primary.OpinionDO;
import com.bsoft.opinion.entity.primary.OpinionViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OpinionManager {
    public OpinionDO saveOpinion(OpinionDO opinion);

    public OpinionViewDO getOpinionView(Integer id);

    public Page<OpinionViewDO> getAppOpinionViews(String personId, Integer page, Integer size);

    public Page<OpinionViewDO> getWebOpinionViews(String personId,Integer status,Integer page,Integer size);

    public OpinionDO submitOpinion(OpinionDO opinion);

    public OpinionDO feedbackOpinion(OpinionDO opinion);

    public String writeOpinionImages(List<byte[]> images);

    public List<byte[]> readOpinionImages(String paths);

    public Page<OpinionViewDO> getOponions(OpinionQueryCnd cnd);

    OpinionViewDO getOpinionById(Integer id);

    byte[] getImageByte(Integer id);

    List<OpinionViewDO> findAllOpinion(OpinionQueryCnd cnd);
}
