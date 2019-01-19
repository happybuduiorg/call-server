package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.BlackListEntity;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BlackListMapperTest {

    @Autowired
    public BlackListMapper blackListMapper;

    @Test
    @Ignore
    public void test01InsertBlack() {
        int res1 = blackListMapper.insertBlack(new BlackListEntity(new BigDecimal("15618352031"), new BigDecimal("18918036180")));
        Assert.assertEquals(1, res1);
        int res2 = blackListMapper.insertBlack(new BlackListEntity(new BigDecimal("15618352031"), new BigDecimal("18918050352")));
        Assert.assertEquals(1, res2);
    }

    @Test
    @Ignore
    @Transactional
    public void test02GetBlackList() {
        List<BlackListEntity> blackList = blackListMapper.getBlackList(new BigDecimal("15618352031"));
        Assert.assertEquals(new BigDecimal("18918036180"), blackList.get(0).getBlackBannedNumber());
        Assert.assertEquals(new BigDecimal("18918050352"), blackList.get(1).getBlackBannedNumber());
    }

    @Test
    @Ignore
    public void test03DeleteBlack() {
        int res = blackListMapper.deleteBlack(new BigDecimal("15618352031"), new BigDecimal("18918036180"));
        Assert.assertEquals(1, res);
        int res1 = blackListMapper.deleteBlack(new BigDecimal("15618352031"), new BigDecimal("18918050352"));
        Assert.assertEquals(1, res1);
    }
}
