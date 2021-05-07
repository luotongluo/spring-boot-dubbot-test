package com.lt.dubboproviderquery.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.lt.dubboproviderquery.entity.TestSql;
import com.lt.dubboproviderquery.mapper.TestSqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author tong.luo
 * @description TestService
 * @date 2021/5/7 20:07
 */
@Component
public class TestService {
    @Autowired
    private TestSqlMapper testSqlMapper;

    public List<TestSql> queryAllByLimit(Integer begin, Integer end) {
        if (null == begin || null == end) {
            return null;
        }
        List<TestSql> list = this.testSqlMapper.queryAllByLimit(begin, end);
        return list;
    }

    public List<TestSql> queryAll(TestSql testSql) {
        if (null == testSql) {
            testSql = new TestSql();
        }
        List<TestSql> list = this.testSqlMapper.queryAll(testSql);
        return list;
    }

    public void update(TestSql testSql) {
        if (null == testSql) {
            return;
        }
        this.testSqlMapper.update(testSql);
    }

    public void deleteById(TestSql testSql) {
        if (null == testSql || testSql.getId() == null) {
            return;
        }
        this.testSqlMapper.deleteById(testSql.getId());
    }

    public void testInsert() {
        TestSql testSql = this.getTestSql();
        this.testSqlMapper.insert(testSql);
    }

    public void testBatchInsert(Integer loop) {
        List<TestSql> list = new ArrayList<>();
        if (null == loop) {
            loop = 50;
        }
        for (int i = 0; i < loop; i++) {
            TestSql testSql = this.getTestSql();
            list.add(testSql);
        }
        this.testSqlMapper.insertBatch(list);
    }

    private TestSql getTestSql() {
        TestSql testSql = new TestSql();
        testSql.setId(String.valueOf(System.nanoTime()));
        testSql.setUserName(UUID.randomUUID().toString());
        testSql.setUserAge((int) (Math.random() * 100));
        Date date = new Date();
        testSql.setUserBirthday(date);
        testSql.setDeleteInfo(0);
        testSql.setCreateTime(date);
        testSql.setUpdateTime(date);
        testSql.setBackup1("");
        testSql.setBackup2("");
        return testSql;
    }
}
