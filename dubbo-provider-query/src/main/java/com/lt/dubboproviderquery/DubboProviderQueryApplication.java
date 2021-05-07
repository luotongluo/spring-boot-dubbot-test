package com.lt.dubboproviderquery;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@EnableDubbo
@SpringBootApplication
@MapperScan("com.lt.dubboproviderquery.mapper")
public class DubboProviderQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderQueryApplication.class, args);
    }

}
