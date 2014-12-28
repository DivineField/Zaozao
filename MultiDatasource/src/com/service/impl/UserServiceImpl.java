package com.service.impl;

import java.util.List;
import java.util.UUID;
import com.app.dao.UserDao;
import com.app.domain.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	public UUID addUser(User user)
	{
		return (UUID)userDao.save(user);
	}

	public List<User> getAllUsers()
	{
		return userDao.findAll(User.class);
	}

	public void deleteUser(UUID id)
	{
		userDao.delete(User.class, id);
	}
}
