package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.PublicWordsViewDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Description
 */
@Repository
public interface PublicWordsViewDao extends JpaRepository<PublicWordsViewDO,Integer>, JpaSpecificationExecutor<PublicWordsViewDO> {
    Page<PublicWordsViewDO> findAllByMainIdAndMenuIdAndType(Integer mainId, Integer menuId, Integer type, Pageable pageable);
    Page<PublicWordsViewDO> findAllByMainIdAndTypeAndWordType(Integer mainId,Integer type, Integer wordType, Pageable pageable);
}
