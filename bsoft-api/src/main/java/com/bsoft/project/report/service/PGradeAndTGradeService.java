package com.bsoft.project.report.service;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-07 9:01
 * @Version 1.0
 * @Description
 */
public interface PGradeAndTGradeService {
    /**
      *@Description获取全部T等级
      *@param
      *@return List<Map<String,Object>>
      *@author zhanglf
      *@Time 2020-01-07 9:18
      */
    List<String> findAllTGrade();

    /**
      *@Description获取全部P等级
      *@param
      *@return List<Map<String,Object>>
      *@author zhanglf
      *@Time 2020-01-08 10:02
      */
    List<String> findAllPGrade();
}
