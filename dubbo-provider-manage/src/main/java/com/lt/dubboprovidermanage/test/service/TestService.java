package com.lt.dubboprovidermanage.test.service;

import com.lt.dubboprovidermanage.entity.TestSql;
import com.lt.dubboprovidermanage.test.data1.mapper.TestData1SqlMapper;
import com.lt.dubboprovidermanage.test.data2.mapper.TestData2SqlMapper;
import exception.BusinException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import test.GetTestSql;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tong.luo
 * @description TestService
 * @date 2021/5/8 17:48
 */
@Component
public class TestService {
    @Autowired
    private TestData1SqlMapper testData1SqlMapper;
    @Autowired
    private TestData2SqlMapper testData2SqlMapper;

    public List<TestSql> getData() {
        List<TestSql> testSqls = this.testData1SqlMapper.queryAllByLimit(10, 20);
        List<TestSql> testSqls1 = this.testData2SqlMapper.queryAllByLimit(20, 30);
        testSqls1.addAll(testSqls);
//        List<TestSql> collect = testSqls1.stream().sorted().collect(Collectors.toList());
        return testSqls1;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<TestSql> insertData() {
        TestSql testSql = new TestSql();
        BeanUtils.copyProperties(GetTestSql.getTestSql(), testSql);
        this.testData1SqlMapper.insert(testSql);
        BeanUtils.copyProperties(GetTestSql.getTestSql(), testSql);
        this.testData2SqlMapper.insert(testSql);
        throw new BusinException("test");
//        return null;
    }
}
