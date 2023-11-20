package com.hk.trip.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.hk.trip.mapper") // 매퍼 인터페이스가 있는 패키지 지정
public class MyBatisConfig {

}
