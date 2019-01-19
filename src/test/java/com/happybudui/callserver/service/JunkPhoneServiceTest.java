package com.happybudui.callserver.service;


import com.happybudui.callserver.entity.JunkPhoneEntity;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunkPhoneServiceTest {
    @Autowired
    public JunkPhoneService junkPhoneService;

    @Ignore
    public void testInsertJunkPhone(){
        Boolean ret = junkPhoneService.insertJunkPhone("12312344321", "2").isSuccess();
        Assert.assertEquals(true, ret);
    }

    @Ignore
    public void testGetAllJunkPhones(){
        List<JunkPhoneEntity> junkPhoneEntityList = junkPhoneService.getAllJunkPhones().getData();
        for(int i = 0; i < junkPhoneEntityList.size(); i++){
            System.out.println(junkPhoneEntityList.get(i).getJunkNumber());
        }
    }

    @Ignore
    public void testGetAllJunkPhoneByType(){
        List<JunkPhoneEntity> junkPhoneEntityList = junkPhoneService.getAllJunkPhonesByType("1").getData();
        for(int i = 0; i < junkPhoneEntityList.size(); i++){
            System.out.println(junkPhoneEntityList.get(i).getJunkNumber());
        }
    }

    @Ignore
    public void testUpdateType(){
        Boolean ret = junkPhoneService.updateJunkTypeByPhone("18943219368", "3").isSuccess();
        Assert.assertEquals(true, ret);
    }

    @Ignore
    public void testDeletePhone(){
        Boolean ret = junkPhoneService.deleteJunkPhoneNumber("12312344321").isSuccess();
        Assert.assertEquals(true, ret);
    }

}
