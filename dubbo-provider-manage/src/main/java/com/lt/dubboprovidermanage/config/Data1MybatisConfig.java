package com.lt.dubboprovidermanage.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author tong.luo
 * @description Data1MybatisConfig
 * @date 2021/5/10 15:42
 */
@Configuration
@MapperScan(basePackages = { "com.lt.dubboprovidermanage.**.data1.mapper" }, sqlSessionTemplateRef = "data1SqlSessionTemplate")

public class Data1MybatisConfig {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.data1")
    public DataSourceProperties newDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "data1DataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.data1")
    public DataSource data1DataSource() {
        return newDataSourceProperties().initializeDataSourceBuilder().build();
    }
    @Bean
    public SqlSessionFactory data1SqlSessionFactory(@Qualifier("data1DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:mapper/data1/**/*.xml"));

            // MyBatis 自动映射驼峰命名
            org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
            configuration.setMapUnderscoreToCamelCase(true);
            configuration.setDefaultStatementTimeout(30);
            bean.setConfiguration(configuration);

            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate data1SqlSessionTemplate(@Qualifier("data1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

    /**
     * 事务管理
     *
     * @return 事务管理实例
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(data1DataSource());
    }
}
