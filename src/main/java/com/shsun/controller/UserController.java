package com.shsun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shsun.entity.User;
import com.shsun.service.UserService;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
    /**
     * 注入service
     */
    @Resource(name = "userServiceImpl")
    public UserService userService;

    /**
     * 获取用户列表
     * 
     * @return
     */
    @RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<User> list() {
        List<User> users = userService.getUser();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    /**
     * 保存用户操作
     * 
     * @parama user 用户实体
     * @return AjaxMessage 保存操作提示消息
     */
    @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public List<User> save(String datas) {
        try {
            List<User> users = JSON.parseArray(datas, User.class);
            for (User user : users) {
                this.userService.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.list();
    }
}
