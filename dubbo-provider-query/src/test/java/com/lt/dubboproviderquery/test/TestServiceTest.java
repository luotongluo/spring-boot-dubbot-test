package com.lt.dubboproviderquery.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tong.luo
 * @description TestServiceTest
 * @date 2021/5/7 20:10
 */
@SpringBootTest
public class TestServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceTest.class);
    @Autowired
    private TestService testService;

    @Test
    void testInsert() {
        this.testService.testInsert();
    }

    @Test
    void testBatchInsert() {
        long start = System.currentTimeMillis();
        this.testService.testBatchInsert(1);
        LOGGER.info("cost:{}", (System.currentTimeMillis() - start));
    }
}