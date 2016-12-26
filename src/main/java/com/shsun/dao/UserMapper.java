package com.shsun.dao;

import java.util.List;

import com.shsun.entity.User;


public interface UserMapper {
	/**
	 * 返回用户列表
	 * @param id
	 * @return User
	 */
	List<User> getUser();
	
	void save(User user);
}
