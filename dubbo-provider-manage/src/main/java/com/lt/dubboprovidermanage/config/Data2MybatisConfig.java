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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author tong.luo
 * @description Data2MybatisConfig
 * @date 2021/5/10 15:46
 */
@Configuration
@MapperScan(basePackages = { "com.lt.dubboprovidermanage.**.data2.mapper" }, sqlSessionTemplateRef = "data2SqlSessionTemplate")
public class Data2MybatisConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.data2")
    public DataSourceProperties data2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "data2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.data2")
    public DataSource data2DataSource() {
        return data2DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public SqlSessionFactory data2SqlSessionFactory(@Qualifier("data2DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:mapper/data2/**/*.xml"));

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
    public SqlSessionTemplate data2SqlSessionTemplate(@Qualifier("data2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
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
        return new DataSourceTransactionManager(data2DataSource());
    }
}
