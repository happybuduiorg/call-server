package com.happybudui.callserver.service;

import com.happybudui.callserver.entity.CallRecordContentEntity;
import com.happybudui.callserver.entity.CallRecordEntity;
import com.happybudui.callserver.wrapper.ResponseResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallServiceTest {
    @Autowired
    public CallService callService;

    public Timestamp timeStamp;
    public CallRecordEntity callRecordEntity;

    @Before
    public void init(){
        timeStamp=new Timestamp(new Date().getTime());
    }

    @Test
    public void testGetUserStatus(){

    }

    @Test
    public void testGetUserScene(){

    }

    @Test
    public void test1PushCallRecord(){
        ResponseResult<Integer> res=callService.pushCallRecord("15618352021","18601860111","1",
                String.valueOf(timeStamp.getTime()),"100");
        Assert.assertTrue(res.isSuccess());
    }

    @Test
    public void test2GetCallRecord(){
        ResponseResult<List<CallRecordEntity>> res=callService.getCallRecord("18601860111",String.valueOf(timeStamp.getTime()-1));
        Assert.assertEquals(1,((List<CallRecordEntity>)res.getData()).size());
        this.callRecordEntity=res.getData().get(0);
    }

    @Test
    public void test3PushCallRecordDetails(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("callRecordId",this.callRecordEntity.getCallRecordId());
        JSONArray jsonArray=new JSONArray();
        JSONObject jsobj=JSONObject.fromObject(new CallRecordContentEntity(callRecordEntity.getCallRecordId(),1,"text","audio"));
        jsonArray.add(jsobj);
        jsonObject.put("callRecord",jsonArray);
        ResponseResult<Integer> res=callService.pushCallRecordContent(jsonObject);
        Assert.assertTrue(res.isSuccess());
    }

    @Test
    public void test4GetCallRecordDetails(){

    }
}
