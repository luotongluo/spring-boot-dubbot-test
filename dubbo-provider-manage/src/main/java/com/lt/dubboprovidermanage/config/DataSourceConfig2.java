package com.lt.dubboprovidermanage.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author tong.luo
 * @description DataSourceConfig2
 * @date 2021/5/8 17:30
 */
@Configuration
@MapperScan(basePackages = {"com.lt.dubboprovidermanage.**.data2.mapper"},sqlSessionTemplateRef = "data2SqlSessionFactory")
public class DataSourceConfig2 {
    @Bean(name = "data2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.data2")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "data2SqlSessionFactory")
    public SqlSessionFactory data2SqlSessionFactory(@Qualifier("data2DataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/data2/*.xml"));
        return bean.getObject();
    }
    @Bean("data2SqlSessionTemplate")
    public SqlSessionTemplate data2sqlsessiontemplate(
            @Qualifier("data2SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
