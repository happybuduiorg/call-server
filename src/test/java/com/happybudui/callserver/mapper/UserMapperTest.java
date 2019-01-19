package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.UserEntity;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    public UserMapper userMapper;

    @Ignore
    public void testUserMapperInsert(){
        int res=userMapper.insertUser(new UserEntity(new BigDecimal("15618352031"),"123",
                0,0,0,0));
        Assert.assertEquals(1,res);
    }

    @Test
    @Transactional
    public void testUserMapperUpdate(){
        userMapper.updateUserSceneByNumber(new BigDecimal("15618352031"),1);
        userMapper.updateUserLocationByNumber(new BigDecimal("15618352031"),1.0,1.0);
        userMapper.updateUserStatusByNumber(new BigDecimal("15618352031"),1);

        UserEntity userEntity=userMapper.getUserInfoByNumber(new BigDecimal("15618352031"));

        Assert.assertEquals("123",userEntity.getUserPassword());
        Assert.assertEquals(1,userEntity.getUserScene());
        Assert.assertEquals(1,userEntity.getUserStatus());
        Assert.assertEquals(1.0,userEntity.getUserLatitude(),0.01);
        Assert.assertEquals(1.0,userEntity.getUserLongitude(),0.01);
    }
}
