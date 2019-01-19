package com.happybudui.callserver.service;

import com.happybudui.callserver.entity.BlackListEntity;
import com.happybudui.callserver.entity.WhiteListEntity;
import com.happybudui.callserver.wrapper.ResponseResult;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListServiceTest {

    @Autowired
    public ListService listService;

    @Test
    @Ignore
    public void test01AddToBlackList() {
        ResponseResult<Integer> res1 = listService.addToBlackList("18918050352", "18918050000");
        ResponseResult<Integer> res2 = listService.addToBlackList("18918050352", "18918051111");
        Assert.assertEquals("Insert black successfully!", res1.getMessage());
        Assert.assertEquals("Black exists!", res2.getMessage());
    }

    @Test
    @Ignore
    public void test02AddToWhiteList() {
        ResponseResult<Integer> res1 = listService.addToWhiteList("18918050352", "18918052222", "1");
        ResponseResult<Integer> res2 = listService.addToWhiteList("18918050352", "18918053333", "2");
        Assert.assertEquals("Insert white successfully!", res1.getMessage());
        Assert.assertEquals("White exists!", res2.getMessage());
    }

    @Test
    @Ignore
    public void test03GetAllBlackList() {
        ResponseResult<List<BlackListEntity>> blackList = listService.getAllBlackList("18918050352");
        Assert.assertEquals(new BigDecimal("18918050000"), blackList.getData().get(1).getBlackBannedNumber());
        Assert.assertEquals(new BigDecimal("18918051111"), blackList.getData().get(0).getBlackBannedNumber());
    }

    @Test
    @Ignore
    public void test04GetAllWhiteList() {
        ResponseResult<List<WhiteListEntity>> whiteList = listService.getAllWhiteList("18918050352");
        Assert.assertEquals(new BigDecimal("18918052222"), whiteList.getData().get(1).getWhiteAllowedNumber());
        Assert.assertEquals(new BigDecimal("18918053333"), whiteList.getData().get(0).getWhiteAllowedNumber());
    }

    @Test
    @Ignore
    public void test05DeleteFromBlackList() {
        ResponseResult<Integer> res1 = listService.deleteFromBlackList("18918050352", "18918050000");
        Assert.assertEquals("Delete black successfully!", res1.getMessage());
        ResponseResult<Integer> res2 = listService.deleteFromBlackList("18918050352", "10129820192");
        Assert.assertEquals("Black doesn't exist!", res2.getMessage());
    }

    @Test
    @Ignore
    public void test06DeleteFromWhiteList() {
        ResponseResult<Integer> res1 = listService.deleteFromWhiteList("18918050352", "18918052222");
        Assert.assertEquals("Delete white successfully!", res1.getMessage());
        ResponseResult<Integer> res2 = listService.deleteFromWhiteList("18918050352", "17821039218");
        Assert.assertEquals("White doesn't exist!", res2.getMessage());
    }
}
