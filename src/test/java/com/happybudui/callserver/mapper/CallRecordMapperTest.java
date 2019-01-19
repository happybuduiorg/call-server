package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.CallRecordEntity;
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
import java.sql.Timestamp;
import java.util.Date;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CallRecordMapperTest {

    @Autowired
    public CallRecordMapper callRecordMapper;

    //@Test
    @Ignore
    public void testRecordMapperInsert(){
        int res=callRecordMapper.insertCallRecord(new CallRecordEntity(new BigDecimal("18240050000"),new BigDecimal("18240051111"),
                1,new Timestamp(new Date().getTime()),12000));
        Assert.assertEquals(1,res);
    }

    @Test
    public void testRecordMapperUpdate(){
        CallRecordEntity callRecordEntity=callRecordMapper.getCallRecordByFromNumAndToNum(new BigDecimal("18240050000"),new BigDecimal("18240051111"));
        Assert.assertNotEquals(null,callRecordEntity);

        int recordId=callRecordEntity.getCallRecordId();

        callRecordMapper.updateCallStartTime(recordId,new Timestamp(new Date().getTime()));
        callRecordMapper.updateCallLastedTime(recordId,1300);
        callRecordMapper.updateCallType(recordId,2);

        callRecordEntity=callRecordMapper.getCallRecordId(recordId);

        Assert.assertEquals(1300,callRecordEntity.getCallLastedTime());
        Assert.assertEquals(2,callRecordEntity.getCallType());

    }
}
