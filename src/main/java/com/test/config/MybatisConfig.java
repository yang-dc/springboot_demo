package com.test.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描mapper文件
 */
@MapperScan("com.test.dao.mapper")
@Configuration
public class MybatisConfig {

}
