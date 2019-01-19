package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.JunkPhoneEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@RunWith(SpringRunner.class)
@SpringBootTest

public class JunkPhoneMapperTest {

    @Autowired
    public JunkPhoneMapper junkPhoneMapper;


    @Test
    public void testInsertJunkPhone(){
        int ret1 = junkPhoneMapper.insertJunkPhone(new JunkPhoneEntity(new BigDecimal("18918036180"), 1));
        Assert.assertEquals(1, ret1);
        int ret2 = junkPhoneMapper.insertJunkPhone(new JunkPhoneEntity(new BigDecimal("18943219368"), 1));
        Assert.assertEquals(1, ret2);
    }

    @Test
    public void testUpdateJunkTypeByNumber(){
        int ret = junkPhoneMapper.updateJunkTypeByNumber(new BigDecimal("18918036180"), 3);
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testSelectJunkPhone() {
        JunkPhoneEntity junkPhoneEntity = junkPhoneMapper.getJunkPhoneByNumber(new BigDecimal("18943219368"));
        Assert.assertEquals(1, junkPhoneEntity.getJunkType());

        List<JunkPhoneEntity> junkList = junkPhoneMapper.getAllJunkPhonesByType(3);
        Assert.assertEquals(new BigDecimal("18918036180"), junkList.get(0).getJunkNumber());

        List<JunkPhoneEntity> junkFullList = junkPhoneMapper.getAllJunkPhones();
        Assert.assertEquals(new BigDecimal("18943219368"), junkFullList.get(0).getJunkNumber());
        Assert.assertEquals(new BigDecimal("18918036180"), junkFullList.get(1).getJunkNumber());
    }


}
