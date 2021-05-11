package com.lt.dubboprovidermanage.test.service;

import com.lt.dubboprovidermanage.test.data1.mapper.TestData1SqlMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.bean.TestSql;
import test.manage.ManageTestServicce;

/**
 * @author tong.luo
 * @description ManageTestServicceImpl
 * @date 2021/5/11 11:14
 */
@Component
@DubboService
public class ManageTestServicceImpl implements ManageTestServicce {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestData1SqlMapper testData1SqlMapper;
    /**
     * insertTest
     *
     * @param testSql
     * @return
     */
    @Override
    public TestSql insertTest(TestSql testSql) {
        logger.info("insertTest init ……");
        com.lt.dubboprovidermanage.entity.TestSql testSql1 = new com.lt.dubboprovidermanage.entity.TestSql();
        BeanUtils.copyProperties(testSql,testSql1);
        this.testData1SqlMapper.insert(testSql1);
        return testSql;
    }
}
