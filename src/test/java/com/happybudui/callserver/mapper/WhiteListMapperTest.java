package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.WhiteListEntity;
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
public class WhiteListMapperTest {

    @Autowired
    public WhiteListMapper whiteListMapper;

    @Test
    @Ignore
    public void test01InsertWhite() {
        int res1 = whiteListMapper.insertWhite(new WhiteListEntity(new BigDecimal("15618352031"), new BigDecimal("18918031111"), 1));
        Assert.assertEquals(1, res1);
        int res2 = whiteListMapper.insertWhite(new WhiteListEntity(new BigDecimal("15618352031"), new BigDecimal("18918052222"), 2));
        Assert.assertEquals(1, res2);
    }

    @Test
    @Ignore
    public void test02ChangeWhiteLevel() {
        whiteListMapper.changeWhiteLevel(new BigDecimal("15618352031"), new BigDecimal("18918031111"), 3);
        whiteListMapper.changeWhiteLevel(new BigDecimal("15618352031"), new BigDecimal("18918052222"), 4);
    }

    @Test
    @Ignore
    public void test03GetWhiteList() {
        List<WhiteListEntity> blackList = whiteListMapper.getWhiteList(new BigDecimal("15618352031"));
        Assert.assertEquals(3, blackList.get(0).getWhiteLevel());
        Assert.assertEquals(4, blackList.get(1).getWhiteLevel());
    }

    @Test
    @Ignore
    public void test04DeleteWhite() {
        int res = whiteListMapper.deleteWhite(new BigDecimal("15618352031"), new BigDecimal("18918031111"));
        Assert.assertEquals(1, res);
        int res1 = whiteListMapper.deleteWhite(new BigDecimal("15618352031"), new BigDecimal("18918052222"));
        Assert.assertEquals(1, res1);
    }
}
