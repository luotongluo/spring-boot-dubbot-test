package com.lt.dubboconsumer.test.controller;

import com.lt.dubboconsumer.test.service.impl.MultServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tong.luo
 * @description MultController
 * @date 2021/5/11 15:23
 */
@RestController
@RequestMapping("mult")
public class MultController {
    @Autowired
    private MultServiceTest multServiceTest;

    /**
     * testManageService
     * mult/testManageService
     */
    @RequestMapping("testManageService")
    void testManageService() {
        this.multServiceTest.testManageService();
    }

    /**
     * testQueryService
     * mult/testQueryService
     */
    @RequestMapping("testQueryService")
    void testQueryService() {
        this.multServiceTest.testQueryService();
    }

    /**
     * testProviderService
     * mult/testProviderService
     */
    @RequestMapping("testProviderService")
    void testProviderService() {
        this.multServiceTest.testProviderService();

    }

    /**
     * testProviderService
     * mult/testProviderLimitService?begin=10&size=5
     */
    @RequestMapping("testProviderLimitService")
    void testProviderLimitService(Integer begin, Integer size) {
        this.multServiceTest.testProviderLimitService(begin, size);

    }
}
