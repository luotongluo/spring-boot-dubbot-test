package com.lt.dubboprovider.test.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
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
    /**
     * getTestVo
     *
     * @return
     */
    @Override
    public TestVo getTestVo() {
        return new TestVo();
    }
}
