package com.happybudui.callserver.service;

import com.happybudui.callserver.entity.BlackListEntity;
import com.happybudui.callserver.entity.UserEntity;
import com.happybudui.callserver.entity.WhiteListEntity;
import com.happybudui.callserver.mapper.BlackListMapper;
import com.happybudui.callserver.mapper.UserMapper;
import com.happybudui.callserver.mapper.WhiteListMapper;
import com.happybudui.callserver.wrapper.ResponseResult;
import com.happybudui.callserver.wrapper.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ListService {

    private final UserMapper userMapper;
    private final WhiteListMapper whiteListMapper;
    private final BlackListMapper blackListMapper;

    @Autowired
    public ListService(UserMapper userMapper, WhiteListMapper whiteListMapper, BlackListMapper blackListMapper) {
        this.userMapper = userMapper;
        this.whiteListMapper = whiteListMapper;
        this.blackListMapper = blackListMapper;
    }

    //获取所有个人的黑名单getAllBlackList
    @Transactional
    public ResponseResult<List<BlackListEntity>> getAllBlackList(String blackUserNumber) {

        UserEntity blackUserEntity = userMapper.getUserInfoByNumber(new BigDecimal(blackUserNumber));
        if (blackUserEntity == null) {
            return ResultGenerator.error("User doesn't exist!");
        }
        if (blackUserEntity.getUserStatus() == 1) {       // 冻结状态
            return ResultGenerator.error("User has been frozen!");
        }

        List<BlackListEntity> allBlackList = blackListMapper.getBlackList(new BigDecimal(blackUserNumber));
        return ResultGenerator.success(allBlackList);
    }

    //获取所有的个人的白名单getAllWhiteList
    @Transactional
    public ResponseResult<List<WhiteListEntity>> getAllWhiteList(String whiteUserNumber) {

        UserEntity whiteUserEntity = userMapper.getUserInfoByNumber(new BigDecimal(whiteUserNumber));
        if (whiteUserEntity == null) {
            return ResultGenerator.error("User doesn't exist!");
        }
        if (whiteUserEntity.getUserStatus() == 1) {       // 冻结状态
            return ResultGenerator.error("User has been frozen!");
        }

        List<WhiteListEntity> allWhiteList = whiteListMapper.getWhiteList(new BigDecimal(whiteUserNumber));
        return ResultGenerator.success(allWhiteList);
    }

    //添加号码至黑名单addToBlackList
    @Transactional
    public ResponseResult<Integer> addToBlackList(String blackUserNumber, String blackBannedNumber) {

        UserEntity blackUserEntity = userMapper.getUserInfoByNumber(new BigDecimal(blackUserNumber));
        if (blackUserEntity == null) {
            return ResultGenerator.error("User doesn't exist!");
        }
        if (blackUserEntity.getUserStatus() == 1) {       // 冻结状态
            return ResultGenerator.error("User has been frozen!");
        }

        int res = blackListMapper.insertBlack(new BlackListEntity(new BigDecimal(blackUserNumber), new BigDecimal(blackBannedNumber)));
        if (res == 1)
            return ResultGenerator.success("Insert black successfully!");
        else
            return ResultGenerator.error("Insert black failed!");
    }

    //添加号码至白名单addToWhiteList
    @Transactional
    public ResponseResult<Integer> addToWhiteList(String whiteUserNumber, String whiteAllowedNumber, String whiteLevel) {

        UserEntity whiteUserEntity = userMapper.getUserInfoByNumber(new BigDecimal(whiteUserNumber));
        if (whiteUserEntity == null) {
            return ResultGenerator.error("User doesn't exist!");
        }
        if (whiteUserEntity.getUserStatus() == 1) {       // 冻结状态
            return ResultGenerator.error("User has been frozen!");
        }

        int res = whiteListMapper.insertWhite(new WhiteListEntity(new BigDecimal(whiteUserNumber), new BigDecimal(whiteAllowedNumber), Integer.valueOf(whiteLevel)));
        if (res == 1)
            return ResultGenerator.success("Insert white successfully!");
        else
            return ResultGenerator.error("Insert white failed!");
    }

    //从黑名单中删除deleteFromBlackList
    @Transactional
    public ResponseResult<Integer> deleteFromBlackList(String blackUserNumber, String blackBannedNumber) {
        int res = whiteListMapper.deleteWhite(new BigDecimal(blackUserNumber), new BigDecimal(blackBannedNumber));
        if (res == 1)
            return ResultGenerator.success("Delete black successfully!");
        else ResultGenerator.error("Delete black failed!");
    }

    //从白名单中删除deleteFromWhiteList
    @Transactional
    public ResponseResult<Integer> deleteFromWhiteList(String whiteUserNumber, String whiteAllowedNumber) {
        int res = blackListMapper.deleteBlack(new BigDecimal(whiteUserNumber), new BigDecimal(whiteAllowedNumber));
        if (res == 1)
            return ResultGenerator.success("Delete white successfully!");
        else
            return ResultGenerator.error("Delete white failed!");
    }
}
