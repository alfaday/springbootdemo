package com.alfaday.application;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = "com.alfaday")
@MapperScan("com.alfaday.dao.mapper")
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
@EnableTransactionManagement
@EnableApolloConfig
public class SpringbootApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringbootApplication.class, args);
		logger.info("ok=======================================");

	}

}
