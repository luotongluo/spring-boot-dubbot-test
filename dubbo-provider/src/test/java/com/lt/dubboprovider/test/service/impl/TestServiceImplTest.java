package com.lt.dubboprovider.test.service.impl;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.bean.TestVo;


/**
 * @author tong.luo
 * @description TestServiceImplTest
 * @date 2021/5/7 16:01
 */
@SpringBootTest
public class TestServiceImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImplTest.class);
    @Autowired
    private TestServiceImpl testService;

    @Test
    public void test() {
        TestVo testVo = this.testService.getTestVo();
        LOGGER.info("123123123:{}", JSON.toJSONString(testVo));
    }
}