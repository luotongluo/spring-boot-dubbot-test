package com.lt.dubboprovider.test.service.impl;
import java.util.Date;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import test.bean.TestVo;
import test.service.TestService;

/**
 * @author tong.luo
 * @description TestServiceImpl
 * @date 2021/5/7 15:09
 */
@DubboService
@Component
public class TestServiceImpl implements TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);
    /**
     * getTestVo
     *
     * @return
     */
    @Override
    public TestVo getTestVo() {
        TestVo testVo = new TestVo();
        testVo.setName("");
        testVo.setAge(0);
        testVo.setBirthday(new Date());

        return testVo;
    }
}
