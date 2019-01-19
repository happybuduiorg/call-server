package com.happybudui.callserver.controller;

import com.happybudui.callserver.entity.JunkPhoneEntity;
import com.happybudui.callserver.service.JunkPhoneService;
import com.happybudui.callserver.wrapper.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@RestController
@RequestMapping("/junk/")
public class JunkPhoneController {
    private final JunkPhoneService junkPhoneService;

    @Autowired
    public JunkPhoneController(JunkPhoneService junkPhoneService){
        this.junkPhoneService = junkPhoneService;
    }

    @RequestMapping(value = "getAllJunkPhones", method = RequestMethod.POST)
    ResponseResult<List<JunkPhoneEntity>> getAllJunkPhones(){
        return junkPhoneService.getAllJunkPhones();
    }

    @RequestMapping(value = "getAllJunkPhonesByType", method = RequestMethod.POST)
    ResponseResult<List<JunkPhoneEntity>> getAllJunkPhonesByType(@RequestParam(name = "junktype") String junkType){
        return junkPhoneService.getAllJunkPhonesByType(junkType);
    }

    @RequestMapping(value = "insertJunkPhone", method = RequestMethod.POST)
    ResponseResult<Integer> insertJunkPhone(@RequestParam(name = "junkphone") String junkPhone, @RequestParam(name = "junktype") String junkType){
        return junkPhoneService.insertJunkPhone(junkPhone,junkType);
    }

    @RequestMapping(value = "updateJunkPhoneType", method = RequestMethod.POST)
    ResponseResult<Integer> updateJunkPhoneType(@RequestParam(name = "junkphone") String junkPhone, @RequestParam(name = "newjunktype") String newJunkType){
        return junkPhoneService.updateJunkTypeByPhone(junkPhone,newJunkType);
    }

    @RequestMapping(value = "deleteJunkPhone", method = RequestMethod.POST)
    ResponseResult<Integer> deleteJunkPhone(@RequestParam(name = "junkphone") String junkPhone){
        return junkPhoneService.deleteJunkPhoneNumber(junkPhone);
    }

}
