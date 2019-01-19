package com.happybudui.callserver.controller;

import com.happybudui.callserver.entity.BlackListEntity;
import com.happybudui.callserver.entity.WhiteListEntity;
import com.happybudui.callserver.wrapper.ResponseResult;
import com.happybudui.callserver.wrapper.ResultGenerator;
import com.happybudui.callserver.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@Controller
@RequestMapping("/list/")
public class ListController {

    private ListService listService;

    @Autowired
    public ListController(ListService listService){this.listService = listService;}

    //获取个人黑名单
    @RequestMapping(value = "getallblacklist", method = RequestMethod.POST)
    ResponseResult<List<BlackListEntity>> getAllBlackList(@RequestParam(name = "blackusernumber") String blackUserNumber){
        return listService.getAllBlackList(blackUserNumber);
    }

    //获取个人白名单
    @RequestMapping(value = "getallwhitelist", method = RequestMethod.POST)
    ResponseResult<List<WhiteListEntity>> getAllWhiteList(@RequestParam(name = "whiteusernumber") String whiteUserNumber){
        return listService.getAllWhiteList(whiteUserNumber);
    }

    // 删除黑名单
    @RequestMapping(value = "deletefromblacklist", method = RequestMethod.GET)
    ResponseResult<Integer> deleteFromBlackList(@RequestParam(name = "blackusernumber") String blackUserNumber,
                                                @RequestParam(name = "blackbannednumber") String blackBannedNumber){
        return listService.deleteFromBlackList(blackUserNumber,blackBannedNumber);
    }

    //删除白名单
    @RequestMapping(value = "deletefromwhitelist", method = RequestMethod.GET)
    ResponseResult<Integer>deleteFromWhiteList(@RequestParam(name="whiteusernumber")String whiteUserNumber,
                                               @RequestParam(name="whiteallowednumber")String whiteAllowedNumber) {
        return listService.deleteFromWhiteList(whiteUserNumber,whiteAllowedNumber);
    }

    //加入黑名单
    @RequestMapping(value = "addtoblacklist",method = RequestMethod.POST)
    ResponseResult<Integer>addToBlackList(@RequestParam(name="blackusernumber")String blackUserNumber,
                                          @RequestParam(name="blackbannednumber")String blackBannedNumber) {
        return listService.addToBlackList(blackUserNumber,blackBannedNumber);
    }

    //加入白名单
    @RequestMapping(value = "addtowhitelist",method = RequestMethod.POST)
    ResponseResult<Integer>addToWhiteList(@RequestParam(name="whiteusernumber")String whiteUserNumber,
                                          @RequestParam(name="whiteallowednumber")String whiteAllowedNumber) {
        return listService.addToBlackList(whiteUserNumber,whiteAllowedNumber);
    }

}