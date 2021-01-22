package com.alfaday.application;

import com.alfaday.dao.model.UserDO;
import com.alfaday.dao.mapper.UserDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootApplicationTests.class);


	@Autowired
	private UserDAO userDAO;

	@Test
	public void getUser() {
		UserDO one = userDAO.selectById(1L);
		logger.info("@@1@@  name=" + one.getUsername());

		one = userDAO.getOne(1L);
		logger.info("@@2@@  name=" + one.getUsername());
		List<UserDO> all = userDAO.getAll();
		logger.info("all size={}",all.size());
		logger.info("end $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	@Test
	public void insertUser(){
		UserDO one = new UserDO();
		one.setNickName("test");
		one.setPassword("ps");
		one.setUsername("xiaoming");
		one.setUserSex("male");
		int insert = userDAO.insert(one);
		logger.info("insert ok, id={}",one.getId());
	}

}
