package com.happybudui.callserver.mapper;

import com.happybudui.callserver.entity.WhiteListEntity;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Mapper
public interface WhiteListMapper {

    //增
    @Insert("insert into whitelist(whiteusernumber, whiteallowednumber, whitelevel) values" +
            "(#{whiteUserNumber},#{whiteAllowedNumber},#{whiteLevel})")
    Integer insertWhite(WhiteListEntity whiteListEntity);

    //删
    @Delete("delete from whitelist where whiteusernumber =#{whiteUserNumber} and whiteallowednumber =#{whiteAllowedNumber}")
    Integer deleteWhite(@Param("whiteUserNumber") BigDecimal whiteUserNumber, @Param("whiteAllowedNumber") BigDecimal whiteAllowedNumber);

    //改
    @Update("update whitelist set whitelevel = #{whiteLevel} where whiteusernumber =#{whiteUserNumber} and whiteallowednumber =#{whiteAllowedNumber}")
    Integer changeWhiteLevel(@Param("whiteUserNumber") BigDecimal whiteUserNumber, @Param("whiteAllowedNumber") BigDecimal whiteAllowedNumber, @Param("whiteLevel") int whiteLevel);

    //查
    @Select("select * from whitelist where whiteusernumber =#{whiteUserNumber}")
    List<WhiteListEntity> getWhiteList(@Param("whiteUserNumber") BigDecimal whiteUserNumber);
}
