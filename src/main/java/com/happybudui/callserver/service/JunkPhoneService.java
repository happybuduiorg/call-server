package com.happybudui.callserver.service;

import com.happybudui.callserver.entity.JunkPhoneEntity;
import com.happybudui.callserver.mapper.JunkPhoneMapper;
import com.happybudui.callserver.wrapper.ResponseResult;
import com.happybudui.callserver.wrapper.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class JunkPhoneService {
    private JunkPhoneMapper junkPhoneMapper;

    @Autowired
    public JunkPhoneService(JunkPhoneMapper junkPhoneMapper){
        this.junkPhoneMapper = junkPhoneMapper;
    }

    // 获取所有骚扰电话
    @Transactional
    public ResponseResult<List<JunkPhoneEntity>> getAllJunkPhones(){
        List<JunkPhoneEntity> junkPhoneEntityList = junkPhoneMapper.getAllJunkPhones();
        return ResultGenerator.success(junkPhoneEntityList);
    }

    // 插入骚扰电话
    public ResponseResult<Integer> insertJunkPhone(String junkPhoneNumber, String junkType){
        junkPhoneMapper.insertJunkPhone(new JunkPhoneEntity(new BigDecimal(junkPhoneNumber), Integer.parseInt(junkType)));
        return ResultGenerator.success("insert successfully!");
    }

    // 获取指定类型骚扰电话
    @Transactional
    public ResponseResult<List<JunkPhoneEntity>> getAllJunkPhonesByType(String junkType){
        List<JunkPhoneEntity> junkPhoneEntityList = junkPhoneMapper.getAllJunkPhonesByType(Integer.parseInt(junkType));
        return ResultGenerator.success(junkPhoneEntityList);
    }

    // 更改指定骚扰电话类型
    @Transactional
    public ResponseResult<Integer> updateJunkTypeByPhone(String junkPhoneNumber, String junkType){
        junkPhoneMapper.updateJunkTypeByNumber(new BigDecimal(junkPhoneNumber), Integer.parseInt(junkType));
        return ResultGenerator.success("update successfully!");
    }

    // 更改指定骚扰电话类型
    @Transactional
    public ResponseResult<Integer> deleteJunkPhoneNumber(String junkPhoneNumber){
        junkPhoneMapper.deleteJunkPhoneByNumber(new BigDecimal(junkPhoneNumber));
        return ResultGenerator.success("delete successfully!");
    }


}
