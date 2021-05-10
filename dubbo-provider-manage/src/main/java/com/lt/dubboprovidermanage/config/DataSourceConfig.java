package com.lt.dubboprovidermanage.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author tong.luo
 * @description DataSourceConfig
 * 多数据源配置
 * @date 2021/5/8 16:33
 */
//@Configuration
public class DataSourceConfig {
//    //主数据源配置 ds1数据源
//    @Primary
//    @Bean(name = "data1DataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.data1")
//    public DataSourceProperties data1DataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    //主数据源 ds1数据源
//    @Primary
//    @Bean(name = "data1DataSource")
//    public DataSource data1DataSource(@Qualifier("data1DataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    //第二个ds2数据源配置
//    @Bean(name = "data2DataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.data2")
//    public DataSourceProperties data2DataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    //第二个ds2数据源
//    @Bean("data2DataSource")
//    public DataSource data2DataSource(@Qualifier("data2DataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
}
