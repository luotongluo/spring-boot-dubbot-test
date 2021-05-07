package com.lt.dubboconsumer.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.lt.dubboconsumer.test.service.TestConsuService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import test.bean.TestVo;
import test.service.TestService;

/**
 * @author tong.luo
 * @description TestServiceImpl
 * @date 2021/5/7 15:43
 */
@Service
public class TestServiceImpl implements TestConsuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);
    @DubboReference
    private TestService testService;

    public String reliable() {
        return "";
    }

    /**
     * 注解设置的 reliable 调用方法的里的参数要和 method 的参数保持一致。
     *
     * @return
     */
//    @HystrixCommand(fallbackMethod = "reliable")
    public String getTestMethod() {
        TestVo testVo = this.testService.getTestVo();
        LOGGER.info("ret :{}"+JSON.toJSONString(testVo));
        return JSON.toJSONString(testVo);
    }
}
