package com.lt.dubboprovider.test.service.impl;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.bean.TestVo;
import com.lt.dubboprovider.utils.RedisUtils;

import javax.annotation.Resource;


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
    @Resource
    private RedisUtils redisUtils;

    @Test
    public void test() {
        TestVo testVo = this.testService.getTestVo();
        LOGGER.info("123123123:{}", JSON.toJSONString(testVo));
    }

    @Test
    public void testRedis() {
        String key = "test-key123";
        this.redisUtils.set(key, key, 60 * 5);
        Object o = this.redisUtils.get(key);
        LOGGER.info("value :{}", o);
    }
}