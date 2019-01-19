package com.happybudui.callserver.controller;

import com.happybudui.callserver.entity.UserEntity;
import com.happybudui.callserver.service.RedisService;
import com.happybudui.callserver.service.UserService;
import com.happybudui.callserver.wrapper.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/")
public class UserController {
    private final UserService userService;
    private final RedisService redisService;

    @Autowired
    public UserController(UserService userService, RedisService redisService){
        this.userService = userService;
        this.redisService = redisService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    ResponseResult<UserEntity> Login(@RequestParam(name = "usernumber") String userNumber, @RequestParam(name = "userpassword") String userPassword){
        return userService.Login(userNumber, userPassword);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    ResponseResult<Integer> Register(@RequestParam(name = "usernumber") String userNumber, @RequestParam(name = "userpassword") String userPassword){
        return userService.Register(userNumber, userPassword);
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    ResponseResult<Integer> Logout(@RequestParam(name = "usertoken") String userToken){
        return userService.Logout(userToken);
    }

    @RequestMapping(value = "islogin", method = RequestMethod.POST)
    ResponseResult<Integer> isLogin(@RequestParam(name = "usertoken") String userToken){
        return userService.isLogin(userToken);
    }

}
