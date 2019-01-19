package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.BlackListEntity;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Mapper
public interface BlackListMapper {

    //增
    @Insert("insert into blacklist(blackusernumber, blackbannednumber) values" +
            "(#{blackUserNumber},#{blackBannedNumber})")
    Integer insertBlack(BlackListEntity blackListEntity);

    //删
    @Delete("delete from blacklist where blackusernumber =#{blackUserNumber} and blackbannednumber =#{blackBannedNumber}")
    Integer deleteBlack(@Param("blackUserNumber") BigDecimal blackUserNumber, @Param("blackBannedNumber") BigDecimal blackBannedNumber);

    //查
    @Select("select * from blacklist where blackusernumber =#{blackUserNumber}")
    List<BlackListEntity> getBlackList(@Param("blackUserNumber") BigDecimal blackUserNumber);
}
