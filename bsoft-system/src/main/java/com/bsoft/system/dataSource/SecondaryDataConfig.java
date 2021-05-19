package com.bsoft.system.dataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
/*
 * @author  hy
 * @date  2020/3/30 12:23
 * @description
 */
@Configuration
@MapperScan(basePackages = "com.bsoft.**.repository.second",
        sqlSessionFactoryRef = "secondarySqlSessionFactory")
public class SecondaryDataConfig {
    @Bean(name = "secondarySqlSessionFactory")
    public SqlSessionFactory SecondarySqlSessionFactory(@Qualifier("dataSourceSecondary") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:/mappers/second/*.xml"));
        bean.setTypeAliasesPackage("com.bsoft.**.entity.second");
        return bean.getObject();
    }

    @Bean("SecondarySqlSessionTemplate")
    public SqlSessionTemplate SecondarySqlsessiontemplate(
            @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

    //用来作为数据库事务回滚的限定词
    //@Transactional(rollbackFor = OAPMException.class, value = "transactionManagerSecondary")
    // 创建事务管理器
    @Bean("secondTransactionMangerMybatis")
    public PlatformTransactionManager secondTransactionManger(@Qualifier("dataSourceSecondary") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
