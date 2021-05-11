package com.lt.dubboproviderquery.test;

import com.lt.dubboproviderquery.mapper.TestSqlMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.bean.TestSql;
import test.query.QueryTestService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tong.luo
 * @description QueryTestServiceImpl
 * @date 2021/5/11 11:04
 */
@Component
@DubboService(retries = 2, timeout = 5000)
public class QueryTestServiceImpl implements QueryTestService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestSqlMapper testSqlMapper;

    /**
     * getTestSql
     *
     * @param testSql
     * @return
     */
    @Override
    public List<TestSql> getTestSql(TestSql testSql) {
        logger.info("Query getTestSql init ……");
        com.lt.dubboproviderquery.entity.TestSql testSqlUse = new com.lt.dubboproviderquery.entity.TestSql();
        BeanUtils.copyProperties(testSql, testSqlUse);
        List<com.lt.dubboproviderquery.entity.TestSql> list = this.testSqlMapper.queryAll(testSqlUse);
        List<TestSql> testSqlList = new ArrayList<>();
        for (com.lt.dubboproviderquery.entity.TestSql sql : list) {
            TestSql testSql1 = new TestSql();
            BeanUtils.copyProperties(sql, testSql1);
            testSqlList.add(testSql1);
        }
        return testSqlList;
    }

    /**
     * getTestSql
     *
     * @param limitbeg
     * @param limitSize
     * @return
     */
    @Override
    public List<TestSql> getTestSql(Integer limitbeg, Integer limitSize) {
        List<com.lt.dubboproviderquery.entity.TestSql> list = this.testSqlMapper.queryAllByLimit(limitbeg, limitSize);
        List<TestSql> testSqlList = new ArrayList<>();
        for (com.lt.dubboproviderquery.entity.TestSql sql : list) {
            TestSql testSql1 = new TestSql();
            BeanUtils.copyProperties(sql, testSql1);
            testSqlList.add(testSql1);
        }
        return testSqlList;
    }
}
