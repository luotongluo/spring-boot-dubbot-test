package com.lt.dubboprovidermanage.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author tong.luo
 * @description DynamicDataSource
 * @date 2021/5/8 17:32
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
//        DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
//        return dataBaseType;
        return null;
    }
}
