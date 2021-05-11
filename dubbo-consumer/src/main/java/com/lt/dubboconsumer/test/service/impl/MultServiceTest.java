package com.lt.dubboconsumer.test.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import test.GetTestSql;
import test.TestSql;
import test.manage.ManageTestServicce;
import test.provider.ProviderTestService;
import test.query.QueryTestService;

import java.util.List;

/**
 * @author tong.luo
 * @description MultServiceTest
 * @date 2021/5/11 15:12
 */
@Service
public class MultServiceTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @DubboReference(retries = 0, timeout = 10000)
    private ManageTestServicce manageTestServicce;
    @DubboReference(retries = 0, timeout = 10000)
    private ProviderTestService providerTestService;
    @DubboReference(retries = 0, timeout = 10000)
    private QueryTestService queryTestService;

    public void testManageService() {
        TestSql testSql = GetTestSql.getTestSql();
        test.bean.TestSql testSql1 = new test.bean.TestSql();
        BeanUtils.copyProperties(testSql, testSql1);
        logger.info("insert value = [{}]", JSON.toJSONString(testSql1));
        this.manageTestServicce.insertTest(testSql1);
    }

    public void testQueryService() {
        List<test.bean.TestSql> testSql = this.queryTestService.getTestSql(new test.bean.TestSql());
        logger.info("testQueryService : res:[{}]", JSON.toJSONString(testSql.size() > 10 ? testSql.size() : testSql));
    }

    public void testProviderService() {
        List<test.bean.TestSql> testSql = this.providerTestService.getTestSql(new test.bean.TestSql());
        logger.info("testProviderService : res:[{}]", JSON.toJSONString(testSql.size() > 10 ? testSql.size() : testSql));

    }

    public void testProviderLimitService(Integer limitbeg, Integer limitSize) {
        logger.info("req : limitbeg ->[{}], limitSize -> [{}]", limitbeg, limitSize);
        List<test.bean.TestSql> testSqlLimit = this.providerTestService.getTestSqlLimit(limitbeg, limitSize);
        logger.info("testProviderService : res:[{}]", JSON.toJSONString(testSqlLimit));

    }
}
