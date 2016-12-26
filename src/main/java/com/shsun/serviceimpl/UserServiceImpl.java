package com.shsun.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsun.dao.UserMapper;
import com.shsun.entity.User;
import com.shsun.service.UserService;

/**
 * 
 * @author shsun
 *
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    public List<User> getUser() {
        return this.userMapper.getUser();
    }

    public void save(User user) {
        this.userMapper.save(user);
    }

}
