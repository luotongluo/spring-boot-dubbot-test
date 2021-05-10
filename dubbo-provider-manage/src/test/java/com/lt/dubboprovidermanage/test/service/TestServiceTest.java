package com.lt.dubboprovidermanage.test.service;

import com.alibaba.fastjson.JSON;
import com.lt.dubboprovidermanage.entity.TestSql;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tong.luo
 * @description TestServiceTest
 * @date 2021/5/8 17:50
 */

@SpringBootTest
public class TestServiceTest {
    @Autowired
    private TestService testService;

    @Test
    void getData() {
        List<TestSql> data = this.testService.getData();
        System.out.println(JSON.toJSONString(data));
    }
}