package com.lt.dubboconsumer.test.controller;

import com.lt.dubboconsumer.test.service.TestConsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tong.luo
 * @description TestController
 * @date 2021/5/7 16:37
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestConsuService testConsuService;

    /**
     *
     * @return
     */
    @RequestMapping("getTest")
    public String getTest(){
        String testMethod = this.testConsuService.getTestMethod();
        return testMethod;
    }
}
