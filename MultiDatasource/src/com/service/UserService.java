package com.service;

import java.util.List;
import java.util.UUID;

import com.app.domain.User;

public interface UserService {
	// 添加图书
	UUID addUser(User user);

	List<User> getAllUsers();

	void deleteUser(UUID id);
}
