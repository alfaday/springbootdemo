package com.alfaday.application;

import com.alfaday.dao.UserDao;
import com.alfaday.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootApplicationTests.class);


	@Autowired
	private UserMapper userMapper;

	@Test
	void getUser() {
		UserDao one = userMapper.getOne(1L);
		logger.info("name=" + one.getUserName());
	}

}
