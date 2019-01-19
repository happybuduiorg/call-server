package com.happybudui.callserver.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {
    @Autowired
    public RedisService redisService;

    @Test
    public void testRedisSet(){
        redisService.set("wanghao", "123");
        Assert.assertEquals("123", redisService.get("wanghao"));
        System.out.println(redisService.get("ODmiQxRu7VjMl1wF"));
    }
}
