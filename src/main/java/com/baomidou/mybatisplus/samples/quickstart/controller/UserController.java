package com.baomidou.mybatisplus.samples.quickstart.controller;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("save")
    public void save(@RequestBody User user) {
        userMapper.insert(user);
    }

    @GetMapping("get/{id}")
    public User getUser(@PathVariable String id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
