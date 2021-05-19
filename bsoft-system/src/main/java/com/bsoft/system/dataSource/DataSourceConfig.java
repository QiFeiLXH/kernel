package com.bsoft.system.dataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/*
 * @author  hy
 * @date  2020/3/30 11:26
 * @description 数据源配置
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "dataSourcePrimary")
    @Qualifier("dataSourcePrimary")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    @Primary
    public DataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "datasourceSecondary")
    @Qualifier("dataSourceSecondary")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
