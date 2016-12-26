package com.shsun.service;

import java.util.List;

import com.shsun.entity.User;

public interface UserService {
	
	/**
	 * @param id
	 * @return
	 */
    public List<User> getUser();
	
    public void save(User user);
}
