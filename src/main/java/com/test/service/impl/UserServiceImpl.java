package com.test.service.impl;

import com.test.dao.mapper.UserMapper;
import com.test.dao.vo.User;
import com.test.service.UserService;
import com.test.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result queryUserAll() {
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        List<User> users = userMapper.selectList(wrapper);
        List<User> users = userMapper.queryUserAll();
        return Result.success(users);
    }
}
