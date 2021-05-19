package com.bsoft.project.report.repository.primary;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-06 17:44
 * @Version 1.0
 * @Description
 */
@Mapper
@Repository
public interface PGradeAndTGradeRepository {
    List<String> findAllTGrade();
    List<String> findAllPGrade();
}
