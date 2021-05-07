package com.lt.dubboconsumer.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.lt.dubboconsumer.test.service.TestConsuService;
import org.apache.dubbo.config.annotation.DubboReference;
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

    @DubboReference
    private TestService testService;

    public String reliable(){
        return "";
    }

    /**
     * 注解设置的 reliable 调用方法的里的参数要和 method 的参数保持一致。
     * @return
     */
//    @HystrixCommand(fallbackMethod = "reliable")
    public String getTestMethod(){
        TestVo testVo = this.testService.getTestVo();
        System.out.println(JSON.toJSONString(testVo));
        return null;
    }
}
