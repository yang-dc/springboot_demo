package com.test.controller;

import com.test.service.UserService;
import com.test.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConterolller {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/queryUser")
    public Result queryUser() {
        return userService.queryUserAll();
    }

    @GetMapping("/queryGroupList")
    public Result queryGroupList() {
        return Result.success(null);
    }
}
