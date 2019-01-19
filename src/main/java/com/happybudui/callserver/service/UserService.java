package com.happybudui.callserver.service;

import com.happybudui.callserver.entity.UserEntity;
import com.happybudui.callserver.mapper.UserMapper;
import com.happybudui.callserver.wrapper.ResponseResult;
import com.happybudui.callserver.wrapper.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Random;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final RedisService redisService;

    @Autowired
    public UserService(UserMapper userMapper, RedisService redisService){
        this.userMapper = userMapper;
        this.redisService = redisService;
    }

    // 用户注册
    @Transactional
    public ResponseResult<Integer> Register(String userNumber, String userPassword){
        UserEntity testuserEntity = userMapper.getUserInfoByNumber(new BigDecimal(userNumber));
        if(testuserEntity != null){
            return ResultGenerator.error("userNumber has existed.");
        }
        UserEntity userEntity = new UserEntity(new BigDecimal(userNumber), userPassword, 0, 0, 0, 0, null);
        if(userMapper.insertUser(userEntity) == 1){
            return ResultGenerator.success("Register successfully!");
        } else{
            return ResultGenerator.error("Register failed!");
        }
    }

    // 用户登录
    @Transactional
    public ResponseResult<UserEntity> Login(String userNumber, String userPassword){
        UserEntity userEntity = userMapper.getUserInfoByNumber(new BigDecimal(userNumber));
        if(userEntity == null){
            return ResultGenerator.error("User doesn't exist!");
        }
        if(userEntity.getUserPassword().equals(userPassword)){
            if(userEntity.getUserStatus() == 1){       // 冻结状态
                return ResultGenerator.error("User has been frozen!");
            }
            String userToken = getRandomString(16);
            redisService.set(userToken, userNumber);
            userEntity.setUserToken(userToken);
            return ResultGenerator.success(userEntity);
        } else{
            return ResultGenerator.error("Wrong password!");
        }
    }

    // 用户注销
    @Transactional
    public ResponseResult<Integer> Logout(UserEntity userEntity){
        if(isLogin(userEntity).getData() == 1){
            userEntity.setUserToken(null);
            return ResultGenerator.success("Logout successfully!");
        }
        return ResultGenerator.error("Should login first!");
    }

    // 判断是否登录
    @Transactional
    public ResponseResult<Integer> isLogin(UserEntity userEntity){
        if(userEntity.getUserToken() == null){
            return ResultGenerator.success("false Login", 0);
        }
        return ResultGenerator.success("true Login", 1);
    }


    //生成随机字符串
    @org.jetbrains.annotations.NotNull
    public static String getRandomString(int length){
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

        Random random=new Random();
        StringBuffer sb=new StringBuffer();

        for(int i=0; i<length; ++i){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }

        return sb.toString();
    }
}
