package com.happybudui.callserver.service;

import com.happybudui.callserver.entity.BlackListEntity;
import com.happybudui.callserver.entity.JunkPhoneEntity;
import com.happybudui.callserver.entity.UserEntity;
import com.happybudui.callserver.entity.WhiteListEntity;
import com.happybudui.callserver.mapper.BlackListMapper;
import com.happybudui.callserver.mapper.JunkPhoneMapper;
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
    private final JunkPhoneMapper junkPhoneMapper;

    @Autowired
    public ListService(UserMapper userMapper, WhiteListMapper whiteListMapper, BlackListMapper blackListMapper, JunkPhoneMapper junkPhoneMapper) {
        this.userMapper = userMapper;
        this.whiteListMapper = whiteListMapper;
        this.blackListMapper = blackListMapper;
        this.junkPhoneMapper = junkPhoneMapper;
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

        BlackListEntity blackListEntity = blackListMapper.getBlack(new BigDecimal(blackUserNumber), new BigDecimal(blackBannedNumber));
        if (blackListEntity != null)
            return ResultGenerator.error("Black exists!");

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

        WhiteListEntity whiteListEntity = whiteListMapper.getWhite(new BigDecimal(whiteUserNumber), new BigDecimal(whiteAllowedNumber));
        if (whiteListEntity != null)
            return ResultGenerator.error("White exists!");

        int res = whiteListMapper.insertWhite(new WhiteListEntity(new BigDecimal(whiteUserNumber), new BigDecimal(whiteAllowedNumber), Integer.valueOf(whiteLevel)));
        if (res == 1)
            return ResultGenerator.success("Insert white successfully!");
        else
            return ResultGenerator.error("Insert white failed!");
    }

    //从黑名单中删除deleteFromBlackList
    @Transactional
    public ResponseResult<Integer> deleteFromBlackList(String blackUserNumber, String blackBannedNumber) {
        BlackListEntity blackListEntity = blackListMapper.getBlack(new BigDecimal(blackUserNumber), new BigDecimal(blackBannedNumber));
        if (blackListEntity == null)
            return ResultGenerator.error("Black doesn't exist!");

        int res = blackListMapper.deleteBlack(new BigDecimal(blackUserNumber), new BigDecimal(blackBannedNumber));
        if (res == 1)
            return ResultGenerator.success("Delete black successfully!");
        else
            return ResultGenerator.error("Delete black failed!");
    }

    //从白名单中删除deleteFromWhiteList
    @Transactional
    public ResponseResult<Integer> deleteFromWhiteList(String whiteUserNumber, String whiteAllowedNumber) {
        WhiteListEntity whiteListEntity = whiteListMapper.getWhite(new BigDecimal(whiteUserNumber), new BigDecimal(whiteAllowedNumber));
        if (whiteListEntity == null)
            return ResultGenerator.error("White doesn't exist!");


        int res = whiteListMapper.deleteWhite(new BigDecimal(whiteUserNumber), new BigDecimal(whiteAllowedNumber));
        if (res == 1)
            return ResultGenerator.success("Delete white successfully!");
        else
            return ResultGenerator.error("Delete white failed!");
    }

    //判断是否是骚扰电话checkIfJunk
    public ResponseResult<Boolean> checkIfJunk(String junkNumber) {
        JunkPhoneEntity junkPhoneEntity = junkPhoneMapper.getJunkPhoneByNumber(new BigDecimal(junkNumber));
        if (junkPhoneEntity == null)
            return ResultGenerator.success(false);
        else
            return ResultGenerator.success(true);
    }

    //添加至骚扰电话名单addToJunkList
    @Transactional
    public ResponseResult<Integer> addToJunkList(String junkNumber, String junkType) {
        JunkPhoneEntity junkUserEntity = junkPhoneMapper.getJunkPhoneByNumber(new BigDecimal(junkNumber));
        if (junkUserEntity != null) {
            return ResultGenerator.error("Junk exists!");
        }

        if (junkPhoneMapper.insertJunkPhone(new JunkPhoneEntity(new BigDecimal(junkNumber), Integer.valueOf(junkType))) == 1) {
            return ResultGenerator.success("Add junk successfully!");
        } else {
            return ResultGenerator.error("Add junk failed!");
        }
    }
}
