package com.baomidou.mybatisplus.samples.quickstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User getNameById(String id);

    List<User> getUsersByAge(int age);
}
