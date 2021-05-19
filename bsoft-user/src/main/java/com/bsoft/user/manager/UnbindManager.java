package com.bsoft.user.manager;

import com.bsoft.user.condition.UnbindQueryCnd;
import com.bsoft.user.entity.primary.UnbindDO;
import com.bsoft.user.entity.primary.UnbindViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UnbindManager {
    void saveAll(List<UnbindDO> unbinds);
    public UnbindDO saveUnbind(UnbindDO unbindDO);
    public UnbindDO getUnbind(String personId);
    public UnbindDO getUnbind(Integer id);
    public void unBindApp(String personId);
    public Page<UnbindViewDO> getUnbind(String personId, Integer auditFlag, Integer page, Integer size);
    public UnbindViewDO getUnbindView(Integer id);
    Page<UnbindViewDO> getUnbindList(UnbindQueryCnd queryCnd);
}
