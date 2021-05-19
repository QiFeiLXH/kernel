package com.bsoft.word.repository.second;

import com.bsoft.word.condition.WordFileRecordQueryCnd;
import com.bsoft.word.entity.second.WordFileRecordDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WordFileRecordRepository {
    WordFileRecordDO selectById(@Param("id") Integer id);
    List<WordFileRecordDO> selectFileMenu();
    List<WordFileRecordDO> selectYearMenu(@Param("menuId") Integer menuId);
    List<WordFileRecordDO> selectMonthMenu(@Param("menuId") Integer menuId, @Param("fileYear") Integer fileYear);
    List<WordFileRecordDO> selectByLimit(@Param("recordCnd") WordFileRecordQueryCnd queryCnd);
    void deleteRecordById(@Param("id") Integer id);
    void updateFileRecord(@Param("recordDO") WordFileRecordDO recordDO);
}
