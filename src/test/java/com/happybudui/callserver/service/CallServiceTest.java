package com.happybudui.callserver.service;

import com.happybudui.callserver.entity.CallRecordContentEntity;
import com.happybudui.callserver.entity.CallRecordEntity;
import com.happybudui.callserver.vo.LocationVo;
import com.happybudui.callserver.wrapper.ResponseResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallServiceTest {
    @Autowired
    public CallService callService;

    public Timestamp timeStamp;



    @Before
    public void init(){
        timeStamp=new Timestamp(new Date().getTime());
    }

    @Test
    public void testGetUserStatus(){
        ResponseResult<Integer> integerResponseResult=callService.getUserSceneStatus("15618352031");
        int res=integerResponseResult.getData();
        Assert.assertEquals(1,res);
    }

    @Test
    public void testGetUserScene(){
        ResponseResult<LocationVo> locationVoResponseResult=callService.getUserLocation("15618352031");
        double res1=locationVoResponseResult.getData().getUserLongitude();
        double res2=locationVoResponseResult.getData().getUserLatitude();
        Assert.assertEquals(1,res1,0.01);
        Assert.assertEquals(1,res2,0.01);
    }

    @Ignore
    public void test1PushCallRecord(){
        ResponseResult<Integer> res=callService.pushCallRecord("15618352021","18601860111","1",
                String.valueOf(timeStamp.getTime()),"100");
        Assert.assertTrue(res.isSuccess());
    }

    @Test
    public void test2GetCallRecord(){
        CallRecordEntity callRecordEntity;
        ResponseResult<List<CallRecordEntity>> res=callService.getCallRecord("18601860111",String.valueOf(timeStamp.getTime()-1000*3600));
        callRecordEntity=res.getData().get(0);
        Assert.assertEquals(1,(res.getData()).size());

        JSONObject jsonObject=new JSONObject();

        jsonObject.put("callRecordId",callRecordEntity.getCallRecordId());
        JSONArray jsonArray=new JSONArray();
        JSONObject jsobj=JSONObject.fromObject(new CallRecordContentEntity(callRecordEntity.getCallRecordId(),1,"text","audio"));
        jsonArray.add(jsobj);
        jsonObject.put("callRecord",jsonArray);
        ResponseResult<Integer> res2=callService.pushCallRecordContent(jsonObject);
        Assert.assertTrue(res2.isSuccess());

        List<CallRecordContentEntity> callRecordContentEntities=callService.getCallRecordContent(String.valueOf(callRecordEntity.getCallRecordId())).getData();
        Assert.assertEquals("text",callRecordContentEntities.get(0).getCallText());
    }

    @Test
    public void test3PushCallRecordDetails(){

    }

    @Test
    public void test4GetCallRecordDetails(){

    }
}
