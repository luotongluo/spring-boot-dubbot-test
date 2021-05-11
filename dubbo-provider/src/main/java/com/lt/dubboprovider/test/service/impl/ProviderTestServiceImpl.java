package com.lt.dubboprovider.test.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import test.bean.TestSql;
import test.provider.ProviderTestService;
import test.query.QueryTestService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tong.luo
 * @description ProviderTestServiceImpl
 * @date 2021/5/11 15:09
 */
@Component
@DubboService(retries = 0, timeout = 10000)
public class ProviderTestServiceImpl implements ProviderTestService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @DubboReference(retries = 0, timeout = 10000)
    private QueryTestService queryTestService;

    /**
     * getTestSql
     *
     * @param testSql
     * @return
     */
    @Override
    public List<TestSql> getTestSql(TestSql testSql) {
        logger.info("Provider getTestSql init ……");
        if (null == testSql) {
            return new ArrayList<>();
        }
        return this.queryTestService.getTestSql(testSql);
    }

    /**
     * getTestSql
     *
     * @param limitbeg
     * @param limitSize
     * @return
     */
    @Override
    public List<TestSql> getTestSqlLimit(Integer limitbeg, Integer limitSize) {
        logger.info("Provider getTestSqlLimit init ……");
        return this.queryTestService.getTestSql(limitbeg, limitSize);
    }
}
