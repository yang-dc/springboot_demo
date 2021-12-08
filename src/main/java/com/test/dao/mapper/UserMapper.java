package com.test.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.dao.vo.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> queryUserAll();
}
