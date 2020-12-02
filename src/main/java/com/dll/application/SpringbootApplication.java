package com.dll.application;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dll.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.dll")
public class SpringbootApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringbootApplication.class, args);
		logger.info("ok=======================================");

	}

}
