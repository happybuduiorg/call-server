package com.happybudui.callserver.controller;

import com.happybudui.callserver.entity.CallRecordContentEntity;
import com.happybudui.callserver.entity.CallRecordEntity;
import com.happybudui.callserver.service.CallService;
import com.happybudui.callserver.vo.LocationVo;
import com.happybudui.callserver.wrapper.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/callrecord/")
public class CallController {

    private final CallService callService;

    @Autowired
    public CallController(CallService callService){this.callService = callService;}

    //获取用户当前的场景
    @RequestMapping(value = "getuserscenestatus", method = RequestMethod.POST)
    ResponseResult<Integer> getUserSceneStatus(@RequestParam(name = "usernumber") String userNumber){
        return callService.getUserSceneStatus(userNumber);
    }

    //获取用户当前的Location
    @RequestMapping(value = "getuserlocation", method = RequestMethod.POST)
    ResponseResult<LocationVo> getUserLocation(@RequestParam(name = "usernumber") String userNumber){
        return callService.getUserLocation(userNumber);
    }

    //发送通话记录
    @RequestMapping(value = "pushcallrecord",method = RequestMethod.POST)
    ResponseResult<Integer>pushCallRecord(@RequestParam(name="callfromnumber")String callFromNumber,
                                          @RequestParam(name="calltonumber")String callTonumber,
                                          @RequestParam(name="calltype")String callType,
                                          @RequestParam(name="callstarttime")String callStartTime,
                                          @RequestParam(name="calllastedtime")String callLastedTime) {
        return callService.pushCallRecord(callFromNumber,callTonumber,callType,callStartTime,callLastedTime);
    }

    //查询自己的接听的通话记录
    @RequestMapping(value = "getcallrecord", method = RequestMethod.POST)
    ResponseResult<List<CallRecordEntity>> getCallRecord(@RequestParam(name = "callnumber") String callNumber,
                                                         @RequestParam(name = "starttime")String stratTime){
        return callService.getCallRecord(callNumber,stratTime);
    }

    //发送通话文本信息
    @RequestMapping(value = "pushcallrecordcontent", method = RequestMethod.POST)
    ResponseResult<Integer> pushCallRecordContent(@RequestBody JSONObject jsonObject){
        return callService.pushCallRecordContent(jsonObject);
    }

    //获取通话详细信息
    @RequestMapping(value = "getcallrecordcontent", method = RequestMethod.POST)
    ResponseResult<List<CallRecordContentEntity>> getCallRecordContent(@RequestParam(name = "callrecordid") String callRecordId){
        return callService.getCallRecordContent(callRecordId);
    }

}
