package com.bsoft.system.dataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
/*
 * @author  hy
 * @date  2020/3/30 11:38
 * @description 从数据源mybatis配置
 */
@Configuration
// 配置mybatis的接口类放的地方
@MapperScan(basePackages = "com.bsoft.**.repository.primary",
        sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDataConfig {
    // 创建SessionFactory
    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("dataSourcePrimary") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/mappers/primary/*.xml"));
        bean.setTypeAliasesPackage("com.bsoft.**.entity.primary");
        return  bean.getObject();
    }

    // 创建事务管理器
    @Bean("primaryTransactionMangerMybatis")
    public PlatformTransactionManager primaryTransactionManger(@Qualifier("dataSourcePrimary") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // 创建SqlSessionTemplate
    @Bean(name = "primarySqlSessionTemplate")
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
