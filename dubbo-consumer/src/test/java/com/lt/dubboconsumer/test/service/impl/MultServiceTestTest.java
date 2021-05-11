package com.lt.dubboconsumer.test.service.impl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tong.luo
 * @description MultServiceTestTest
 * @date 2021/5/11 15:19
 */
@SpringBootTest
public class MultServiceTestTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MultServiceTest multServiceTest;

    @Test
    void testManageService() {
        this.multServiceTest.testManageService();
    }

    @Test
    void testQueryService() {
        this.multServiceTest.testQueryService();
    }

    @Test
    void testProviderService() {
        this.multServiceTest.testProviderService();

    }
}