package com.baomidou.mybatisplus.samples.quickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.nativex.MyBatisResourcesScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyBatisResourcesScan(mapperLocationPatterns = "mapper/**/*Mapper.xml")
@MapperScan(value = "com.baomidou.mybatisplus.samples.quickstart.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class QuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickstartApplication.class, args);
    }

}
