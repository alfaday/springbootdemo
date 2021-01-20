package com.alfaday.application;

import com.alfaday.dao.dos.UserDO;
import com.alfaday.dao.mapper.UserDAO;

import org.junit.Test;
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
	private UserDAO userDAO;

	@Test
	public void getUser() {
		UserDO one = userDAO.getOne(1L);
		logger.info("name=" + one.getUsername());
	}

}
