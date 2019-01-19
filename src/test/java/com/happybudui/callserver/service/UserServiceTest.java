package com.happybudui.callserver.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    public UserService userService;
    public RedisService redisService;

    @Ignore
    public void testRegister(){
        Boolean retSuccess = userService.Register("12312344321", "www").isSuccess();
        Assert.assertEquals(true, retSuccess);
    }


    @Ignore
    public void testLogin(){
        String retToken = userService.Login("12312344321", "www").getData().getUserToken();
        Assert.assertNotEquals(null, retToken);
        System.out.println(retToken);
    }

    @Ignore
    public void testLogout(){
        Boolean retSuccess = userService.Logout("ODmiQxRu7VjMl1wF").isSuccess();
        Assert.assertEquals(true, retSuccess);
    }

    @Ignore
    public void testisLogin(){
        Integer retStatus = userService.isLogin("ODmiQxRu7VjMl1wF").getData();
        Assert.assertEquals(new Integer(0), retStatus);
    }


}
