package com.lt.dubboproviderquery.config;

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
import java.util.HashMap;

/**
 * @author tong.luo
 * @description DruidConfig
 * 配置druid需要的配置类，引入application.properties文件中以spring.datasource开头的信息
 *  * 因此需要在application.properties文件中配置相关信息
 * @date 2021/5/7 19:43
 */
@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
    //后台监控
    @Bean
    public ServletRegistrationBean startViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> initParameters = new HashMap<>();
        //设置后台的账号密码
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");
        //允许所有的人访问
        initParameters.put("allow", "");
        bean.setInitParameters(initParameters);
        return bean;
    }

    /**
     * 配置过滤器过滤哪些请求
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js,*.css,/druid/");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
