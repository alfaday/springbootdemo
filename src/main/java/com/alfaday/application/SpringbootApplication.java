package com.alfaday.application;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.alfaday")
@MapperScan("com.alfaday.dao.mapper")
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class SpringbootApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringbootApplication.class, args);
		logger.info("ok=======================================");

	}

}
