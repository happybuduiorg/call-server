package com.happybudui.callserver.service;

import com.happybudui.callserver.entity.CallRecordContentEntity;
import com.happybudui.callserver.entity.CallRecordEntity;
import com.happybudui.callserver.entity.UserEntity;
import com.happybudui.callserver.mapper.CallRecordMapper;
import com.happybudui.callserver.mapper.UserMapper;
import com.happybudui.callserver.vo.LocationVo;
import com.happybudui.callserver.wrapper.ResponseResult;
import com.happybudui.callserver.wrapper.ResultGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@Service
public class CallService {
    private final UserMapper userMapper;
    private final CallRecordMapper callRecordMapper;

    public CallService(UserMapper userMapper,CallRecordMapper callRecordMapper){
        this.userMapper=userMapper;
        this.callRecordMapper=callRecordMapper;
    }

    //获取用户当前的场景
    ResponseResult<Integer> getUserSceneStatus(String userNumber){
        UserEntity userEntity=userMapper.getUserInfoByNumber(new BigDecimal(userNumber));
        if(userEntity==null){
            return ResultGenerator.error(400,"can't find the number!");
        }
        //定义一下SceneId的含义 0 正常 可以接通 1 开会 2 上课  3 开车
        int sceneId=userEntity.getUserScene();
        return  ResultGenerator.success(sceneId);
    }

    //获取用户当前的Location
    ResponseResult<LocationVo> getUserLocation(String userNumber){
        UserEntity userEntity=userMapper.getUserInfoByNumber(new BigDecimal(userNumber));
        if(userEntity==null){
            return ResultGenerator.error(400,"can't find the number!");
        }
        LocationVo locationVo=new LocationVo(userEntity.getUserLongitude(),userEntity.getUserLatitude());
        return ResultGenerator.success(locationVo);
    }

    //发送通话记录
    ResponseResult<Integer> pushCallRecord(String callFromNumber,String callToNumber,String callType,
            String callStartTime, String callLastedTime) {
        int res = callRecordMapper.insertCallRecord(new CallRecordEntity(new BigDecimal(callFromNumber), new BigDecimal(callToNumber),
                Integer.valueOf(callType), new Timestamp(Long.valueOf(callStartTime)), Integer.valueOf(callLastedTime)));

        if(res==1){
            return ResultGenerator.success("success!");
        }else{
            return ResultGenerator.error("error!");
        }
    }

    //查询自己的接听的通话记录
    ResponseResult<List<CallRecordEntity>> getCallRecord(String callNumber,String startTime){
        Timestamp callStartTime=new Timestamp(Long.valueOf(startTime));
        List<CallRecordEntity> callRecordEntities=callRecordMapper.getCallRecordsByToNumberAndStartTime(new BigDecimal(callNumber),callStartTime);
        return ResultGenerator.success(callRecordEntities);
    }

    //发送通话文本信息
    ResponseResult<Integer> pushCallRecordContent(JSONObject jsonObject){
        String recordIdJson=jsonObject.getString("callRecordId");
        int recordId=Integer.parseInt(recordIdJson);

        JSONArray jsonObjectList=jsonObject.getJSONArray("callRecord");
        if(jsonObjectList==null||jsonObjectList.isEmpty()){
            return ResultGenerator.error("Illegal Operation");
        }else{
            for(Object object:jsonObjectList){
                JSONObject jsonObj=(JSONObject)object;
                int callRecordIndex=jsonObj.getInt("callIndex");
                String callText=jsonObj.getString("callText");
                String callAudio=jsonObj.getString("callAudio");
                callRecordMapper.insertCallRecordContent(new CallRecordContentEntity(recordId,callRecordIndex,callText,callAudio));
            }
            return ResultGenerator.success();
        }
    }

    //获取通话详细信息
    ResponseResult<List<CallRecordContentEntity>> getCallRecordContent(String callRecordId){
        List<CallRecordContentEntity> callRecordContentEntities=callRecordMapper.getCallRecordContentById(Integer.parseInt(callRecordId));
        return ResultGenerator.success(callRecordContentEntities);
    }
}
