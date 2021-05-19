package com.bsoft.project.repository.second;


import com.bsoft.project.entity.second.ProjectWordDetailDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProjectWordDetailRepository {

   void saveDetail(@Param("detailDO") ProjectWordDetailDO projectWordDetailDO, @Param("tableName") String tableName);
   void updateDetail(@Param("detailDO") ProjectWordDetailDO projectWordDetailDO, @Param("tableName") String tableName);
   ProjectWordDetailDO selectDetailById(@Param("id") Integer id, @Param("tableName") String tableName);
   void deleteDetailById(@Param("tableName") String tableName, @Param("id") Integer id);
}
