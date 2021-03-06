/*
package com.bsoft.system.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //把DruidDataSource添加到ioc容器中，并且prefix = "spring.datasource"，让application.yml里的数据源其他配置属性生效
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        DruidDataSource dataSource = new DruidDataSource();
        try {
            dataSource.setFilters("stat");
            dataSource.setMaxActive(100);
            dataSource.setMinIdle(20);
            dataSource.setInitialSize(20);
            dataSource.setValidationQuery("select 1 from dual");
            dataSource.setTestWhileIdle(true);
            dataSource.setTestOnBorrow(false);
            dataSource.setTestOnReturn(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    //配置druid监控

    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statviewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        //用户名
        map.put("loginUsername", "admin");
        //密码
        map.put("loginPassword", "123456");
        //IP白名单(没有配置或者为空，则允许所有访问)
        map.put("allow", "");
        //IP黑名单(存在共同时，deny优先于allow)
        map.put("deny", "192.168.15.109");
        map.put("resetEnable","false");
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }


    //2.配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webstatFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> map = new HashMap<>();
        map.put("exclusions", "*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(map);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;

    }

}
*/
