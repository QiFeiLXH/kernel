package com.bsoft.project.report.manager;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-06 17:47
 * @Version 1.0
 * @Description
 */
public interface PGradeAndTGradeManager {
    List<String> findAllTGrade();
    List<String> findAllPGrade();
}
