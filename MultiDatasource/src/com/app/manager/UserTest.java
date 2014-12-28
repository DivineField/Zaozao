package com.app.manager;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.dao.UserDao;
import com.app.dao.impl.UserDaoImpl;
import com.app.domain.User;
import com.ds.DataSourceConstant;
import com.ds.DataSourceContextHolder;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = appContext.getBean("userDao", UserDaoImpl.class);
		//UserServiceImpl userService = new UserServiceImpl();
		
		//UserService userService = (UserService)appContext.getBean("userService", UserServiceImpl.class);
		
		//DataSourceContextHolder.setDataSourceType(DataSo.urceConstant.Admin);
		DataSourceContextHolder.setDataSourceType(DataSourceConstant.User);
		User user = new User();
		//user.setId(UUID.randomUUID().toString());org.hibernate.id.UUIDGenerator.
		user.setId(1);
		user.setName("User001");
		userDao.save(user);
		
		DataSourceContextHolder.setDataSourceType(DataSourceConstant.Admin);
		userDao.save(user);
	}
}
