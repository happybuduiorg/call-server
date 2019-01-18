package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

public class UserMapperTest {

    private UserMapper userMapper;

    @Autowired
    public UserMapperTest(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @Test
    public void testUserMapper(){
        int res=userMapper.insertUser(new UserEntity(new BigInteger("15618352031"),"123",
                0,0,0,0));
        Assert.assertEquals(1,res);
    }
}
