package com.bsoft.system.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/*
 * @author  hy
 * @date  2020/3/30 11:29
 * @description 主数据源jpa配置
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary",
        basePackages = {
                "com.bsoft.**.dao.primary"
        })//设置Repository所在位置
public class PrimaryConfig {
        @Autowired
        @Qualifier("dataSourcePrimary")
        private DataSource dataSourcePrimary;

        @Primary
        @Bean(name = "entityManagerPrimary")
        public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
                return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
        }

        @Primary
        @Bean(name = "entityManagerFactoryPrimary")
        public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
                return builder
                        .dataSource(dataSourcePrimary)
                        .properties(getVendorProperties())
                        .packages(
                                "com.bsoft.**.entity.primary"
                        ) //设置实体类所在位置
                        .persistenceUnit("primaryPersistenceUnit")
                        .build();
        }

        @Autowired
        private JpaProperties jpaProperties;

        @Autowired
        private HibernateProperties hibernateProperties;
        private Map<String, Object> getVendorProperties() {
                return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
        }

        @Primary
        @Bean(name = "transactionManagerPrimary")
        public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
                return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
        }
}
